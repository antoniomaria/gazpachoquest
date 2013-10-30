package net.sf.gazpachosurvey.rest.auth;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class HelloWorldTest {
    public static void main(String[] args) {
        Client client = Client.create();

        WebResource webResource = client
                .resource("http://localhost:8080/gazpachosurvey-rest/surveys");

        ClientResponse response = webResource.accept(MediaType.TEXT_HTML).get(
                ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);
    }
}
