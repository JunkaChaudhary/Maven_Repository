package ParsingUsingJsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequest 
{
	public static void main(String[] args) 
	{
		Response res =
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete("http://localhost:3000/APIFolks/DzxPw14"); //provide the id for the record which you want to delete.
		
		System.out.println("Status code is: "+res.statusCode());
	}    
}
