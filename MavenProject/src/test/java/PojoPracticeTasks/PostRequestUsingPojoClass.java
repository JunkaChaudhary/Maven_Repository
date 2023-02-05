package PojoPracticeTasks;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestUsingPojoClass 
{
	public static void main(String[] args) 
	{
		AdditionalInfo address = new AdditionalInfo();
		address.setBuilding("16");
		address.setSector("30");
		address.setCity("Mumbai");
		address.setAddresstype("Primary");
		
		BasicInfo1 basic = new BasicInfo1();
		basic.setFirstname("Aaravi");
		basic.setLastname("Sinha");
		basic.setDesignation("Analyst");
		basic.setId("Aarvi");
		basic.setAddress(address);
		
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
