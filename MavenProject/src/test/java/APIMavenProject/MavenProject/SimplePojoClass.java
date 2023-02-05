package APIMavenProject.MavenProject;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimplePojoClass {
	
	public static void main(String[] args) 
	{
		BasicInfo basic = new BasicInfo();
		basic.setFirstName("Ekta");
		basic.setLastName("Kumari");
		basic.setDesignation("Accountant");
		basic.setId("1324");
		
		Response res =
		given()
		.contentType(ContentType.JSON)
		.body(basic)
		.when()
		.post("http://localhost:3000/APIFolks");
		
		System.out.println("Status code is: " + res.getStatusCode());
		System.out.println("Response Data is:");
		System.out.println(res.asString());
	}

}
