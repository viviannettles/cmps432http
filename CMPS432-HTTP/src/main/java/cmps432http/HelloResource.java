package cmps432http;

import java.io.*;
import java.net.URL;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

@Path("/http")
public class HelloResource {
	
	//specify the library index file.
    //public static String indexFileLocation = ".." + File.separator + "index";
    public static String indexFileName = "./Index.txt";
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String direBonjour() {
		return "nice cock!";
	}*/
	
	/*@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello() {
		return "<html><title> HELLO REST </title><body> <h1>Bonjour, coochieman!</h1><body></html>";
	}*/
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON) //can't see this in browser must use curl or postman
	public Student sayJsonHello() {
		return new Student(123, "Sami Kumar", "India");
	}*/
	
	//@SuppressWarnings("resource")
	@GET
	@Path("/{searchKeyword}")
	@Produces(MediaType.TEXT_PLAIN)
	public static String searchTermInIndex(@PathParam("searchKeyword") String searchKeyword){
        //File file = new File(indexFileName);
        
		URL url = HelloResource.class.getResource(indexFileName);
		File file = new File(url.getPath());
        //System.out.println(file.exists());
        //System.out.println(file.getAbsolutePath());
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = br.readLine()) != null) {

                String [] spiltWords =  st.split("\\|.\\|");
                if(spiltWords[0].equals(searchKeyword)){
                    System.out.println("Match Find on Index File!");
                    System.out.println("Sending following result to the client side:");
                    System.out.println(st);
                    return st;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
	
}

/* DO NOT BE DECEIVED BY THE TUTORIAL. THE URL YOU SHOULD TYPE INTO CHROME IS:
		http://localhost:8080/cmps432http/rest/http
	I believe his browser is set to automatically recognize the default 8080 port, 
	but we won't do that because it's not required. Also because he doesn't show how.
*/