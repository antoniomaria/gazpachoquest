package net.sf.gazpachoquest.rest.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizationRequestContext {

    public static class Builder {
        private String authorizationToken;
        private String httpMethod;
        private String requestUrl;

        public Builder authorizationToken(final String authorizationToken) {
            this.authorizationToken = authorizationToken;
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

        public Builder httpMethod(final String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public Builder requestUrl(final String requestUrl) {
            this.requestUrl = requestUrl;
            return this;
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationRequestContext.class);

    public static Builder with() {
        return new Builder();
    }

    private String authorizationToken;

    /**
     * The Http method (POST, GET, DELETE, PUT)
     */
    private String httpMethod;

    /**
     * The relative url of the request which starts at the root of the requested resource
     */
    private String requestUrl;

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setAuthorizationToken(final String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public void setHttpMethod(final String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setRequestUrl(final String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
