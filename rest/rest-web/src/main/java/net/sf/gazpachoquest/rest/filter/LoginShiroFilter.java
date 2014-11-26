package net.sf.gazpachoquest.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import net.sf.gazpachoquest.security.shiro.HmacAuthToken;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginShiroFilter implements ContainerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoginShiroFilter.class);

    @Context
    private HttpHeaders headers;

    private UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        String method = requestContext.getMethod();
        String path = uriInfo.getPath();
        String query = uriInfo.getRequestUri().getQuery();
        logger.debug("New access to resource {}", path);
        if (path.startsWith("auth") || path.contains("api-docs")) {
            // Ignore the AuthenticationResource
            return;
        }

        Subject subject = SecurityUtils.getSubject();
       
        String dateUTC = requestContext.getHeaderString(HttpHeaders.DATE);
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null) {
            throw new AccountException("Hmac-SHA1 Authorization token is required");
        }
        String[] values = authorizationHeader.split(" ");
        String apiKeyAndSignature[] = StringUtils.split(values[1], ":");

        StringBuilder signedContent = new StringBuilder().append(method).append(" /").append(path);
        if (query != null) {
            signedContent.append("?").append(query);
        }

        if (dateUTC != null) {
            signedContent.append("\n").append(dateUTC);
        }
        /*-
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
        }*/
        String apiKey = apiKeyAndSignature[0];
        String signature = apiKeyAndSignature[1];
        AuthenticationToken token = new HmacAuthToken.Builder().apiKey(apiKey).message(signedContent.toString())
                .signature(signature).dateUTC(dateUTC).build();
        subject.login(token); //
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    @Context
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }
}
