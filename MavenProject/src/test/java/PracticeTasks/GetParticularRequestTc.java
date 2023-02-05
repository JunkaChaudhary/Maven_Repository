package PracticeTasks;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetParticularRequestTc 
{
	public static void main(String[] args) 
	{
		Response res =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIFolks/Sonika");
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response code is: ");
		System.out.println(res.asString());
		
	}

}
