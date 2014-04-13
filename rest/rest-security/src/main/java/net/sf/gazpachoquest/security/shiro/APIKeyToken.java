package net.sf.gazpachoquest.security.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class APIKeyToken implements AuthenticationToken {

    private static final long serialVersionUID = 9072622512169076764L;

    private String apiKey;

    @Override
    public Object getPrincipal() {
        return apiKey;
    }

    @Override
    public Object getCredentials() {
        return apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public static class Builder {
        private String apiKey;

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public APIKeyToken build() {
            APIKeyToken aPIKeyToken = new APIKeyToken();
            aPIKeyToken.apiKey = apiKey;
            return aPIKeyToken;
        }
    }
}
