package BDDConcept;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.JSONTokener;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostJsonUsingJsonFile
{
	public String readJsonData() throws FileNotFoundException
	{
		File f= new File("../MavenProject/RequestBodyData.json");
		FileReader fr= new FileReader(f);
		JSONTokener jt= new JSONTokener(fr);
		JSONObject js= new JSONObject(jt);
		return js.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		PostJsonUsingJsonFile obj= new PostJsonUsingJsonFile();
		String jsonRequestData=obj.readJsonData();
		Random r= new Random();
		Integer idValue= r.nextInt();
		jsonRequestData=jsonRequestData.replaceAll(Pattern.quote("{{id}}"), idValue.toString());
		Response res=
				given()
				.contentType(ContentType.JSON)
				.body(jsonRequestData)
				.when()
				.post("http://localhost:3000/APIFolks");
				
				System.out.println("Response code is: " + res.statusCode());
				System.out.println("Response data is: " + res.asString());	
	}

}
