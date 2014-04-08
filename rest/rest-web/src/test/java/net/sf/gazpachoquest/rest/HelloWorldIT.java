package net.sf.gazpachoquest.rest;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
// import org.codehaus.jackson.JsonParser;
// import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class HelloWorldIT {
    private static String endpointUrl;

    @BeforeClass
    public static void beforeClass() {
        endpointUrl = "http://localhost:8081/gazpachoquest-rest-web";
    }

    @Test
    public void testPing() throws Exception {
        WebClient client = WebClient.create(endpointUrl + "/hello/echo/SierraTangoNevada");
        Response r = client.accept("text/plain").get();
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        String value = IOUtils.toString((InputStream) r.getEntity());
        assertEquals("SierraTangoNevada", value);
    }

    @Test
    public void testJsonRoundtrip() throws Exception {
        List<Object> providers = new ArrayList<Object>();
        providers.add(new JacksonJaxbJsonProvider());
        //JsonBean inputBean = new JsonBean();
        //inputBean.setVal1("Maple");
        WebClient client = WebClient.create(endpointUrl + "/hello/jsonBean", providers);
        Response r = client.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE)
                .post(null);
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        /*-
        MappingJsonFactory factory = new MappingJsonFactory();
        JsonParser parser = factory.createParser((InputStream) r.getEntity());
        JsonBean output = parser.readValueAs(JsonBean.class);
        assertEquals("Maple", output.getVal2());*/
    }
}
