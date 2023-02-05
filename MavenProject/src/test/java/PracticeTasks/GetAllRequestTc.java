package PracticeTasks;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllRequestTc 
{
	public static void main(String[] args) 
	{
		Response res =
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIFolks");
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response code is: ");
		System.out.println(res.asString());
		
	}

}
