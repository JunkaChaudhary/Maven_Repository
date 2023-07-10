package APIMavenProject.MavenProject;

import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

//purpose-----------hit the Post Request
//body data --------- simple json using org.json

public class PostRequestTC {

	public static void main(String[] args) 
	{
		JSONObject ob = new JSONObject();
		
		ob.put("firstname", "Manju");
		ob.put("lastname", "Rani");
		ob.put("Designation", "Engineer");
		ob.put("Course", "API");
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(ob.toString())
		.post("http://localhost:3000/APIFolks"); //POST method is used for adding key: value
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response Data is:");
		System.out.println(res.asString());
		
	}
}
