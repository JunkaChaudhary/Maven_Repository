package BDDConcept;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Class1 
{
	public static void main(String[] args) 
	{
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIFolks?firstname=Mohit");
		
		System.out.println("Response code is: " + res.statusCode());
		System.out.println("Response data is: " + res.asString());		
	}

}
