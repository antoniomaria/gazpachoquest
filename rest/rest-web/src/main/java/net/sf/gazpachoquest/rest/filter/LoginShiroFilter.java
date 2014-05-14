package net.sf.gazpachoquest.rest.filter;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import net.sf.gazpachoquest.security.shiro.HmacAuthToken;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.DelegatingInputStream;
import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginShiroFilter implements RequestHandler {

    private static final Logger logger = LoggerFactory.getLogger(LoginShiroFilter.class);

    @Context
    private HttpHeaders headers;

    private UriInfo uriInfo;

    @Override
    public Response handleRequest(Message message, ClassResourceInfo resourceClass) {
        String path = uriInfo.getPath();

        logger.debug("New access to resource {}", path);
        if (path.startsWith("auth") || path.contains("api-docs")) {
            // Ignore the AuthenticationResource
            return null;
        }

        Subject subject = SecurityUtils.getSubject();
        String method = (String) message.get(Message.HTTP_REQUEST_METHOD);
        String dateUTC = getRequestHeaderAsString(HttpHeaders.DATE);
        String authorizationHeader = getRequestHeaderAsString(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null) {
            throw new AccountException("Hmac-SHA1 Authorization token is required");
        }
        String[] values = authorizationHeader.split(" ");
        String apiKeyAndSignature[] = StringUtils.split(values[1], ":");

        StringBuilder signedContent = new StringBuilder().append(method).append(" /").append(path);
        if (dateUTC != null) {
            signedContent.append("\n").append(dateUTC);
        }
        if ("POST".equals(method)) {
            DelegatingInputStream input = message.getContent(DelegatingInputStream.class);
            if (input != null) {
                input.cacheInput();
                try {
                    signedContent.append("\n").append(IOUtils.toString(input));
                } catch (IOException e) {
                    throw new IllegalStateException("Errors when reading POST content", e);
                }
            }
        }
        String apiKey = apiKeyAndSignature[0];
        String signature = apiKeyAndSignature[1];
        AuthenticationToken token = new HmacAuthToken.Builder().apiKey(apiKey).message(signedContent.toString())
                .signature(signature).dateUTC(dateUTC).build();
        subject.login(token); //
        return null;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    @Context
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    protected String getRequestHeaderAsString(String name) {
        List<String> header = headers.getRequestHeader(name);
        String value = null;
        if (header != null && header.size() > 0) {
            value = header.get(0);
        }
        return value;
    }

    protected String resolveApiKey() {
        List<String> authValues = headers.getRequestHeader("Authorization");
        if (authValues.size() == 0) {
            return null;
        }
        String[] values = authValues.get(0).split(" ");
        if (values.length != 2 || !"GZQ".equals(values[0])) {
            return null;
        }
        return values[1];
    }
}
