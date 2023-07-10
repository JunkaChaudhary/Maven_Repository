package JsonParsing;

//Extracting Single object value i.e. Id of 0th element

import static io.restassured.RestAssured.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingSingleObject 
{
	public static void main(String[] args) 
	{
		Response res =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIFolks");
		
		JSONArray array= new JSONArray();
		JSONObject obj= array.getJSONObject(3);
		System.out.println(obj.get("First Name"));
		
		
		/*JSONArray array = new JSONArray(res.asString());
		JSONObject obj = array.getJSONObject(0);
		System.out.println("Value of Id for 1st Json Object:");
		System.out.println(obj.get("id"));
		*/
	}

}
