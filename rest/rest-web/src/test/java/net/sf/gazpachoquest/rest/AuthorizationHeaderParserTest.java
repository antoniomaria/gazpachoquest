package net.sf.gazpachoquest.rest;

import java.util.Arrays;

import org.apache.shiro.authc.AuthenticationException;
import org.junit.Test;

public class AuthorizationHeaderParserTest {

    @Test
    public void parseTest() {
        String authValues = "hmac johndoe:[digest]";

        String[] values = authValues.split(" ");

        if (values == null || values.length != 2) {
            throw new AuthenticationException("Authorization Header empty");
        }

        System.out.println(Arrays.toString(values));

        String authSchema = values[0];

        if (!"hmac".equalsIgnoreCase(authSchema)) {
            throw new AuthenticationException("Invalid authentication schema. Only HMAC is supported");
        }

        String messageAndSignature = values[1];
        String authParameters[] = messageAndSignature.split(":");

        if (authParameters == null || authParameters.length != 2) {
            throw new AuthenticationException("Missing authentication parameters");
        }

        String apiKey = authParameters[0];
        String signature = authParameters[1];

        System.out.println("apiKey" + apiKey);
        System.out.println("digest" + signature);

    }
}
