package PracticeTasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.json.JSONObject;
import org.json.JSONTokener;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostRequestUsingJsonFile 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File f = new File("../MavenProject/ExternalJsonFile.json");
		FileReader fr = new FileReader(f);
		JSONTokener jsonToken = new JSONTokener(fr);
		JSONObject j = new JSONObject(jsonToken);
	
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter first name:");
		String firstname = s.next();
		System.out.println("Please enter last name:");
		String lastname = s.next();
		System.out.println("Please enter id:");
		Integer idvalue = s.nextInt();
		
		String bodydata = j.toString();
		bodydata = bodydata.replaceAll(Pattern.quote("{{firstname}}"), firstname);
		bodydata = bodydata.replaceAll(Pattern.quote("{{lastname}}"), lastname);
		bodydata = bodydata.replaceAll(Pattern.quote("{{id}}"), idvalue.toString());		
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(bodydata)
		.when()
		.post("http://localhost:3000/APIFolks");
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response Data is:");
		System.out.println(res.asString());		
	}

}
