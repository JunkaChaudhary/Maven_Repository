package BDDConcept;

import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostUsingOrgJson 
{
	
	public static void main(String[] args) 
	{
		JSONObject inner1= new JSONObject();
		inner1.put("house no.", "35");
		inner1.put("sector", "24");
		inner1.put("city", "Gurgaon");
		inner1.put("type", "Primary");
		
		JSONObject inner2= new JSONObject();
		inner2.put("type", "Secondary");
		inner2.put("house no.", "15");
		inner2.put("sector", "13");
		inner2.put("city", "Gurgaon");
		
		JSONArray address= new JSONArray();
		address.put(0, inner1);
		address.put(1, inner2);
		
		JSONObject js= new JSONObject();
		js.put("firstname", "Raghav");
		js.put("lastname", "Sharma");
		js.put("designation", "Actor");
		js.put("Course", "Acting");
		js.put("id", "14231");
		js.put("address", address);
		

		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(js.toString())
		.when()
		.post("http://localhost:3000/APIFolks");
		
		System.out.println("Response code is: " + res.statusCode());
		System.out.println("Response data is: " + res.asString());	
		
	}

}
