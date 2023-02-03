package APIMavenProject.MavenProject;

import static io.restassured.RestAssured.*;  // * means all
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllRequestTC 
{
	public static void main(String[] args) 
	{
		Response r=
		given()    
		.contentType(ContentType.JSON)  
		.when()   
		.get("http://localhost:3000/APIFolks/");  

		System.out.println("The Status code is= " + r.getStatusCode());
		System.out.println("The Response Data is:");
		System.out.println(r.asString());
		
		}
}
