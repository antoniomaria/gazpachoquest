package net.sf.gazpachoquest.cxf.interceptor;

import java.util.Arrays;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.jaxrs.impl.HttpHeadersImpl;
import org.apache.cxf.jaxrs.impl.MetadataMap;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HmacAuthInterceptor extends AbstractPhaseInterceptor<Message> {

    private static Logger logger = LoggerFactory.getLogger(HmacAuthInterceptor.class);

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    private String apiKey;

    private String secret;

    public HmacAuthInterceptor(String apiKey, String secret) {
        super(Phase.PRE_STREAM);
        this.apiKey = apiKey;
        this.secret = secret;
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        // http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html
        String requestUri = (String) message.get(Message.REQUEST_URI);
        String basePath = (String) message.get(Message.BASE_PATH);
        String method = (String) message.get(Message.HTTP_REQUEST_METHOD);
        String date = DateFormatUtils.SMTP_DATETIME_FORMAT.format(new Date());

        String resource = requestUri.substring(basePath.length());
        if (!resource.startsWith("/")) { // In localhost the / is missing
            resource = "/" + resource;
        }

        String stringToSign = new StringBuilder().append(method).append(" ").append(resource).append("\n").append(date)
                .toString();
        addHeader(message, HttpHeaders.DATE, date);

        String signature = calculateSignature(stringToSign, secret);
        String authToken = generateAuth(apiKey, signature);
        addHeader(message, HttpHeaders.AUTHORIZATION, authToken);

        /*-
        if (!"POST".equals(method)) {
            String signature = calculateSignature(stringToSign, secret);
            String authToken = generateAuth(apiKey, signature);
            addHeader(message, HttpHeaders.AUTHORIZATION, authToken);
        } else {
            final OutputStream os = message.getContent(OutputStream.class);
            final CacheAndWriteOutputStream newOut = new CacheAndWriteOutputStream(os);
            message.setContent(OutputStream.class, newOut);
            newOut.registerCallback(new HmacAuthCallBack(message, stringToSign));
        }*/
    }

    public String generateAuth(String apiKey, String signature) {
        StringBuilder auth = new StringBuilder();
        auth.append("hmac ");
        auth.append(apiKey);
        auth.append(":");
        auth.append(signature);
        return auth.toString();
    }

    public static String calculateSignature(String data, String key) {
        logger.debug("Signing with algorithm {} the string: {} ", HMAC_SHA1_ALGORITHM, data);
        String result;
        try {
            // get an hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);

            // get an hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes());

            // base64-encode the hmac
            result = Base64Utility.encode(rawHmac);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    public void addHeader(Message message, String name, String value) {
        HttpHeaders requestHeaders = new HttpHeadersImpl(message);
        MultivaluedMap<String, String> newHeaders = new MetadataMap<String, String>();
        newHeaders.putAll(requestHeaders.getRequestHeaders());
        newHeaders.put(name, Arrays.asList(value));
        message.put(Message.PROTOCOL_HEADERS, newHeaders);
    }

    public class HmacAuthCallBack implements CachedOutputStreamCallback {
        private Message message;
        private String stringToSign;

        public HmacAuthCallBack(Message message, String stringToSign) {
            this.message = message;
            this.stringToSign = stringToSign;
        }

        public void onFlush(CachedOutputStream cos) {
        }

        public void onClose(CachedOutputStream cos) {
            try {
                StringBuilder builder = new StringBuilder();
                cos.writeCacheTo(builder, "utf-8");
                // here comes my xml:
                String postContent = builder.toString();
                stringToSign = new StringBuilder(stringToSign).append("\n").append(postContent).toString();

                String signature = calculateSignature(stringToSign, secret);
                String authToken = generateAuth(apiKey, signature);
                addHeader(message, HttpHeaders.AUTHORIZATION, authToken);
            } catch (Exception e) {
            }
        }
    }

}
