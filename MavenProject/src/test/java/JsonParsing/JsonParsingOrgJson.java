package JsonParsing;

import static io.restassured.RestAssured.*;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonParsingOrgJson 
{
	public static void main(String[] args) 
	{
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIFolks");
		
/*		System.out.println("Status code is: " + res.statusCode());
		System.out.println("Response data is:");
		System.out.println(res.asString());
	*/	
		JSONArray array= new JSONArray(res.asString());
		int L= array.length();
		for(int i=0; i<=L; i++)
		{
		JSONObject obj= array.getJSONObject(i);
		Set<String> allKeys = obj.keySet();
		for(String s: allKeys)
		{
			System.out.println("Key name is: " + s);
			System.out.println("Key value is:" + obj.get(s));
		}		
		}
	}

}
