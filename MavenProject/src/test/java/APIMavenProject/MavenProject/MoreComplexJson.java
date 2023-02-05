package APIMavenProject.MavenProject;

//purpose-----------hit the Post Request
//body data --------- more complex json(array json) using org.json

import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class MoreComplexJson 
{
	public static void main(String[] args) {
		
		JSONObject innerobj1 = new JSONObject();
		innerobj1.put("Type", "Primary");
		innerobj1.put("Floor", "23");
		innerobj1.put("Building", "Antriksh Heights");
		innerobj1.put("Sector", "84");
		innerobj1.put("City", "Gurgaon");
		
		JSONObject innerobj2 = new JSONObject();
		innerobj2.put("Type", "Secondary");
		innerobj2.put("Floor", "12");
		innerobj2.put("Building", "Antriksh Homes");
		innerobj2.put("Sector", "25");
		innerobj2.put("City", "Chandigarh");
		
		JSONArray array = new JSONArray();
		array.put(0,innerobj1);
		array.put(1, innerobj2);
		
		JSONObject outerobj = new JSONObject();
		outerobj.put("firstname", "Mohan");
		outerobj.put("lastname", "Singh");
		outerobj.put("Designation", "Engineer");
		outerobj.put("Address", array);
		
		Response res = 
		given()
		.contentType(ContentType.JSON)
		.body(outerobj.toString())
		.when()
		.post("http://localhost:3000/APIFolks");
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response Data is:");
		System.out.println(res.asString());

	}

}
