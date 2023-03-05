package ParsingUsingJsonPath;

import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateOrPutRequest 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File f= new File("../MavenProject/target/JsonFile.json");
		FileReader fr= new FileReader(f);
		JSONTokener js = new JSONTokener(fr);
		JSONObject obj= new JSONObject(js);
		
		Response res =
		given()
		.contentType(ContentType.JSON)
		.body(obj.toString())
		.when()
		.put("http://localhost:3000/APIFolks/5");
		
		System.out.println("Status code is: "+res.statusCode());
		System.out.println("Response data is: "+res.asString());
		
	}

}
