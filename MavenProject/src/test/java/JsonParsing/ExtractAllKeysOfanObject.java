package JsonParsing;

//Parse all the keys of an object
// Value of FirstName, LastName, Id, Course, Designation etc.

import static io.restassured.RestAssured.*;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractAllKeysOfanObject 
{
	public static void main(String[] args) 
	{
		Response res =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIFolks");
		
		JSONArray array=new JSONArray(res.asString());
		JSONObject obj=array.getJSONObject(2);
		Set<String> allkeys=obj.keySet();
		
		for(String keyname : allkeys)  //strong the key name in the keyname variable 
		{
			System.out.println("Key name is "+keyname);
			System.out.println("Key value is: "+obj.get(keyname));
		}
		
	}

}
