package net.sf.gazpachosurvey.rest.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizationRequestContext {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationRequestContext.class);

    private String authorizationToken;

    /**
     * The relative url of the request which starts at the root of the requested resource
     */
    private String requestUrl;

    /**
     * The Http method (POST, GET, DELETE, PUT)
     */
    private String httpMethod;

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String authorizationToken;
        private String requestUrl;
        private String httpMethod;

        public Builder authorizationToken(String authorizationToken) {
            this.authorizationToken = authorizationToken;
            return this;
        }

        public Builder requestUrl(String requestUrl) {
            this.requestUrl = requestUrl;
            return this;
        }

        public Builder httpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public AuthorizationRequestContext build() {
            AuthorizationRequestContext authorizationRequestContext = new AuthorizationRequestContext();
            authorizationRequestContext.authorizationToken = authorizationToken;
            authorizationRequestContext.requestUrl = requestUrl;
            authorizationRequestContext.httpMethod = httpMethod;
            logger.info("New {} petition again {} url", httpMethod, requestUrl);
            return authorizationRequestContext;
        }
    }
}
