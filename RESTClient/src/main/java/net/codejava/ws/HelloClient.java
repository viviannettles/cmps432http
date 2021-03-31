package net.codejava.ws;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.ClientConfig;


public class HelloClient {

	public static void main(String[] args) {
		String uri = "http://localhost:8080/cmps432http/rest/http";
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(uri);
		//String response = target.request().accept(MediaType.TEXT_HTML).get(String.class);
		String response = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		//String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.println(response);
	}

}
