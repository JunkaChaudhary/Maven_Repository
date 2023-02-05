package APIMavenProject.MavenProject;

//purpose-----------hit the Post Request
//body data --------- complex json(obj inside obj) using org.json

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.JSONTokener;

import groovyjarjarantlr4.v4.parse.ANTLRParser.id_return;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostUsingJsonFile {
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		File f = new File("../MavenProject/ExternalJsonFile.json"); //connection establishment with json file
		FileReader fr = new FileReader(f);   //for reading streams of characters or character files
		JSONTokener jtokener = new JSONTokener(fr); // for reading json data from stream created in above step
		JSONObject j = new JSONObject(jtokener); 
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id: ");
		Integer idvalue = s.nextInt();
		System.out.println("Enter the First Name: ");
		String firstname = s.next();
		
		System.out.println("Enter the Last Name: ");
		String lasttname = s.next();
		
		String bodyData = j.toString();
		bodyData = bodyData.replaceAll(Pattern.quote("{{id}}"), idvalue.toString());
		bodyData = bodyData.replaceAll(Pattern.quote("{{firstname}}"), firstname);
		bodyData = bodyData.replaceAll(Pattern.quote("{{lastname}}"), lasttname);
		
		Response res = 
		given()
		.contentType(ContentType.JSON)
		.body(bodyData.toString())
		.when()
		.post("http://localhost:3000/APIFolks");
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response Data is:");
		System.out.println(res.asString());
	}

}
