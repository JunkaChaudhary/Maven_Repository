package APIMavenProject.MavenProject;

import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

//purpose-----------hit the Post Request
//body data --------- complex json using org.jso

public class ComplexJson {

	public static void main(String[] args) 
	{
		JSONObject inner = new JSONObject();
		inner.put("Floor", "23");
		inner.put("Building", "Antriksh Heights");
		inner.put("Sector", "84");
		inner.put("City", "Gurgaon");
		
		JSONObject outer = new JSONObject();		
		outer.put("firstname", "Manju");
		outer.put("lastname", "Rani");
		outer.put("Designation", "Engineer");
		outer.put("Course", "API");
		outer.put("Address", inner);
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(outer.toString())
		.post("http://localhost:3000/APIFolks");
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response Data is:");
		System.out.println(res.asString());
		
	}
}
