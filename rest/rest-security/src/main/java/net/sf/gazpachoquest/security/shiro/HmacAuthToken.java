package net.sf.gazpachoquest.security.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class HmacAuthToken implements AuthenticationToken {

    private static final long serialVersionUID = 9072622512169076764L;

    private String apiKey;

    private String signature;

    private String message;

    private String dateUTC;

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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getDateUTC() {
        return dateUTC;
    }

    public void setDateUTC(String dateUTC) {
        this.dateUTC = dateUTC;
    }

    public static class Builder {
        private String apiKey;
        private String signature;
        private String message;
        private String dateUTC;

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder signature(String signature) {
            this.signature = signature;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder dateUTC(String dateUTC) {
            this.dateUTC = dateUTC;
            return this;
        }

        public HmacAuthToken build() {
            HmacAuthToken hmacAuthToken = new HmacAuthToken();
            hmacAuthToken.apiKey = apiKey;
            hmacAuthToken.signature = signature;
            hmacAuthToken.message = message;
            hmacAuthToken.dateUTC = dateUTC;
            return hmacAuthToken;
        }
    }
}
