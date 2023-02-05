package PojoPracticeTasks;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostArrayJsonRequestUsingPojo 
{
	public static void main(String[] args) 
	{
		AdditionalInfo[] address = new AdditionalInfo[2];
		address[0] = new AdditionalInfo();
		address[0].setBuilding("16");
		address[0].setSector("30");
		address[0].setCity("Mumbai");
		address[0].setAddresstype("Primary");
	
		address[1] = new AdditionalInfo();
		address[1].setBuilding("11");
		address[1].setSector("33");
		address[1].setCity("Pune");
		address[1].setAddresstype("Secondary");
		
		BasicInfo basic = new BasicInfo();
		basic.setFirstname("Sonika");
		basic.setLastname("Sinha");
		basic.setDesignation("Analyst");
		basic.setId("Sonika");
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
