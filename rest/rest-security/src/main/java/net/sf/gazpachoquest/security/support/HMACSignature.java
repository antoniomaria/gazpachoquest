package net.sf.gazpachoquest.security.support;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.shiro.codec.Base64;

public class HMACSignature {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    /**
     * Computes RFC 2104-compliant HMAC signature.
     * * @param data
     * The data to be signed.
     * 
     * @param key
     *            The signing key.
     * @return
     *         The Base64-encoded RFC 2104-compliant HMAC signature.
     * @throws java.security.SignatureException
     *             when signature generation fails
     */
    public static String calculateRFC2104HMAC(String data, String key) throws java.security.SignatureException {
        String result = null;
        try {
            Charset utf8ChartSet = Charset.forName("UTF-8");
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(utf8ChartSet), HMAC_SHA1_ALGORITHM);

            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes(utf8ChartSet));

            // base64-encode the hmac
            result = Base64.encodeToString(rawHmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }
}
