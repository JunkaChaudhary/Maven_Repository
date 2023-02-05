package PracticeTasks;

import static io.restassured.RestAssured.*;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestUsingOrgJson 
{
	public static void main(String[] args) 
	{
		JSONObject inner1 = new JSONObject();
		inner1.put("Building", "34");
		inner1.put("Sector", "10");
		inner1.put("City", "Gurgaon");
		inner1.put("Address type", "Primary");
		
		JSONObject inner2 = new JSONObject();
		inner2.put("Building", "14");
		inner2.put("Sector", "15");
		inner2.put("City", "Delhi");
		inner2.put("Address type", "Secondary");
		
		JSONArray arraydata = new JSONArray();
		arraydata.put(0, inner1);
		arraydata.put(1, inner2);
		
		JSONObject outer = new JSONObject();
		outer.put("firstname", "Ruhi");
		outer.put("lastname", "Chawla");
		outer.put("Designation", "API Tester");
		outer.put("Address", arraydata);
		
		Response res = 
		given()
		.contentType(ContentType.JSON)
		.body(outer.toString())
		.when()
		.post("http://localhost:3000/APIFolks");
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response code is: ");
		System.out.println(res.asString());
				
		
	}
	
		
		

}
