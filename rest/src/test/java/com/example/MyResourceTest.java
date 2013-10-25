package com.example;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;

public class MyResourceTest {

    //private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // create the client
        //Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        //target = c.target(Main.BASE_URI);
    }


    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
       // String responseMsg = target.path("myresource").request().get(String.class);
        //assertEquals("Got it!", responseMsg);
    }
}
