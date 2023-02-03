package APIMavenProject.MavenProject;

import static io.restassured.RestAssured.*;  // * means all

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetRequestTC 
{
	public static void main(String[] args) 
	{
		Response r=
		given()    //what is the pre requisite before hitting the request
		.contentType(ContentType.JSON)  //response content type
		.when()    //which http method
		.get("http://localhost:3000/APIFolks/3");  //get method

		System.out.println("The Status code is: " + r.getStatusCode());
		System.out.println("The Response Data is:");
		System.out.println(r.asString());
		
		}
}
