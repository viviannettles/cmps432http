package cmps432http;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

@Path("/bonjour")
public class HelloResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String direBonjour() {
		return "nice cock!";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello() {
		return "<html><title> HELLO REST </title><body> <h1>Bonjour, coochieman!</h1><body></html>";
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //can't see this in browser must use curl or postman
	public Student sayJsonHello() {
		return new Student(123, "Sami Kumar", "India");
	}
}

/* DO NOT BE DECEIVED BY THE TUTORIAL. THE URL YOU SHOULD TYPE INTO CHROME IS:
		http://localhost:8080/cmps432http/rest/bonjour
	I believe his browser is set to automatically recognize the default 8080 port, 
	but we won't do that because it's not required. Also because he doesn't show how
*/