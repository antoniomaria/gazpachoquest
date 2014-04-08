package net.sf.gazpachoquest.rest.auth;

import javax.xml.bind.DatatypeConverter;

public class BasicAuthHelper {

    public static String[] decode(String auth) {
        // Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
        auth = auth.replaceFirst("[B|b]asic ", "");

        // Decode the Base64 into byte[]
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);

        // If the decode fails in any case
        if (decodedBytes == null || decodedBytes.length == 0) {
            return null;
        }

        // Now we can convert the byte[] into a splitted array :
        // - the first one is login,
        // - the second one password
        return new String(decodedBytes).split(":", 2);
    }
}
