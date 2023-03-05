package ParsingUsingJsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParseDataFromJsonFile 
{
	public static void main(String[] args) 
	{
		Response res =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIFolks");

		String city= res.jsonPath().get("[11].Address.City");
		System.out.println("City is: "+city);
		
		String sector = res.jsonPath().get("[11].Address.Sector");
		System.out.println("Sector is: "+sector);
	}	

}
