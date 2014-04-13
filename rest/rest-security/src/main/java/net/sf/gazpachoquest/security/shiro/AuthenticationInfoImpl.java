package net.sf.gazpachoquest.security.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

public class AuthenticationInfoImpl implements AuthenticationInfo {

    private static final long serialVersionUID = -395410491971643618L;

    private String apiKey;

    private Object principal;

    @Override
    public PrincipalCollection getPrincipals() {
        SimplePrincipalCollection collection = new SimplePrincipalCollection();
        collection.add(principal, "ApiKeyRealm");
        return collection;
    }

    @Override
    public Object getCredentials() {
        return apiKey;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String apiKey;
        private Object principal;

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder principal(Object principal) {
            this.principal = principal;
            return this;
        }

        public AuthenticationInfoImpl build() {
            AuthenticationInfoImpl authenticationInfoImpl = new AuthenticationInfoImpl();
            authenticationInfoImpl.apiKey = apiKey;
            authenticationInfoImpl.principal = principal;
            return authenticationInfoImpl;
        }
    }
}
