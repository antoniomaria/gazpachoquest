package net.sf.gazpachoquest.security.support;

import static org.fest.assertions.api.Assertions.assertThat;

import java.security.SignatureException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

public class HMACSignatureTest {
    @Test
    public void calculateRFC2104HMACTest() throws SignatureException{
        String date = "Tue, 13 May 2014 20:10:38 +0200";

        String resource = "/questionnairs/58";
        String method = "GET";
        String stringToSign = new StringBuilder().append(method).append(" ").append(resource).append("\n").append(date)
                .toString();
        String apiKey = "PKCC00D3YH83KEP";
        String secret = "L0LTMJ1XAMEY13FT27MWZMQX1LWK8I1L";
        String signature = HMACSignature.calculateRFC2104HMAC(stringToSign, secret);
       assertThat(signature).isEqualTo("KddAO6eohOuFsko10gQ7cZjx/dI=");
        System.out.println(date);
        System.out.println(signature);
        
    }
}
