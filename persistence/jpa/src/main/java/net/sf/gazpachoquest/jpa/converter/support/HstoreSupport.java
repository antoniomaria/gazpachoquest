/*
 * This file has been copied from the following location:
 * https://github.com/phstudy/jpa-converter-sample/blob/master/src/main/java/net/backtothefront/HstoreHelper.java
 * 
 */
package net.sf.gazpachoquest.jpa.converter.support;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class HstoreSupport {

    private static final String K_V_SEPARATOR = "=>";

    public static String toString(Map<String, String> m) {
        if (m.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int n = m.size();
        for (String key : m.keySet()) {
            sb.append(key + K_V_SEPARATOR + m.get(key));
            if (n > 1) {
                sb.append(", ");
                n--;
            }
        }
        return sb.toString();
    }

    public static Map<String, String> toMap(String s) {
        Map<String, String> m = new HashMap<String, String>();
        if (StringUtils.isBlank(s)) {
            return m;
        }
        String[] tokens = s.split(", ");
        for (String token : tokens) {
            String[] kv = token.split(K_V_SEPARATOR);
            String k = kv[0];
            k = k.trim().substring(1, k.length() - 2);
            String v = kv[1];
            v = v.trim().substring(1, v.length() - 2);
            m.put(k, v);
        }
        return m;
    }
}
