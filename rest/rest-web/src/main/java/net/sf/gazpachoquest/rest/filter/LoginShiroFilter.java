package net.sf.gazpachoquest.rest.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

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

        Set<Class<?>> formats = message.getContentFormats();
        message.getContent(InputStream.class);
        for (Class<?> class1 : formats) {
            System.out.println(class1);
        }


        DelegatingInputStream input = (DelegatingInputStream) message.getContent(DelegatingInputStream.class);
        input.cacheInput();

        String content = null;
        if (input != null) {
            try {
                content = IOUtils.toString(input);
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
        }
        System.out.println("content: " + content);
        /*-
        MultivaluedMap<String, String> values = headers.getRequestHeaders();
        if (values != null) {
            Set<String> keys = values.keySet();
            for (String string : keys) {
                System.out.println(string + " " + values.get(string));
            }
        }*/

        logger.debug("New access to resource {}", path);
        if (path.startsWith("auth") || path.contains("api-docs")) {
            // Ignore the AuthenticationResource
            return null;
        }

        Subject subject = SecurityUtils.getSubject();
        String apiKey = null;

        String method = (String) message.get(Message.HTTP_REQUEST_METHOD);
        String dateUTC = getRequestHeaderAsString(HttpHeaders.DATE);
        String authorizationHeader = getRequestHeaderAsString(HttpHeaders.AUTHORIZATION);

        String[] values = authorizationHeader.split(" ");
        String authSchema = values[0];
        String apiKeyAndSignature[] = StringUtils.split(values[1], ":");

        System.out.println("path: " + path);
        System.out.println("dateUTC: " + dateUTC);
        System.out.println("apikey and signature: " + apiKeyAndSignature);

        AuthenticationToken token = new HmacAuthToken.Builder().apiKey(apiKey).build();
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
