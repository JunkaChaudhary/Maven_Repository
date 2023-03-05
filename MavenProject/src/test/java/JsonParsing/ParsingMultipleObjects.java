package JsonParsing;

//Extracting multiple value of same object from different elements 
//i.e. all ids from 0 to 15th object. 

import static io.restassured.RestAssured.given;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingMultipleObjects 
{
	public static void main(String[] args) 
	{
		Response res =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIFolks");
		
		JSONArray array = new JSONArray(res.asString());
		//int L= array.length();    //to execute the loop till the length of array
		for(int i=0; i<=15; i++)
		{
			JSONObject obj = array.getJSONObject(i);
			System.out.println("Value of Id for "+i+ "th Json Object:");
			System.out.println(obj.get("id"));	
		}
		
	}

}
