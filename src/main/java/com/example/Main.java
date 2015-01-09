package com.example;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {

	public static final URI BASE_URI = UriBuilder.fromUri("http://localhost/").port(9000).build();;
	
    public static HttpServer startServer(){
    	HttpServer server = new HttpServer();
    	
    	ResourceConfig config = new ResourceConfig(MyResource.class);
    	server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);
    	
    	return server;
    }
    
    public static void main(String []args)throws IOException{
    	HttpServer server = startServer();
    	System.out.println("server running on "+BASE_URI);
    	System.in.read();
    	server.stop();
    }
}
