package com.example;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
public class MyResourceTest {
 
    private HttpServer server;
    private WebTarget target;
 
    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
 
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }
 
    @After
    public void tearDown() throws Exception {
        server.stop();
    }
 
    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource/textplain").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }

    /**
     * Test to see that the message "{user:{name:Jesus,lastName:Valadez}}" is sent in the response.
     */
    @Test
    public void testgetJson() {
        String responseMsg = target.path("myresource/json").request().get(String.class);
        assertEquals("{user:{name:Jesus,lastName:Valadez}}", responseMsg);
    }
}
