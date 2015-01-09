package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("textplain")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "application/json" media type.
	 *
	 * @return String that will be returned as a application/json response.
	 */
	@GET
	@Path("json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getJson() {
		return "{regards:Got it!}";
	}
}
