package Day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import  org.testng.annotations.Test;

import io.restassured.response.Response;

public class HTTPRequest {

	
	
	@Test(priority=1)
	void getUsers() {
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().body();
	}
	Response res; //global variable
	int id;
	@Test(priority=2)
	void createUser() {
		HashMap data=new HashMap();
		data.put("name", "magnet");
		data.put("job", "Manager");
	
		
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//		.statusCode(201)
//		.log().all();
		
	System.out.println("Creataed id is:"+id);
	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser() {
		HashMap data=new HashMap();
		data.put("name", "Marco");
		data.put("job", "Lead");
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users/"+id)
				
		.then()
			.statusCode(201)
		    .log().body();
	
	}
	 @Test(priority=4)
	 void deleteUser() {
		 given()
		 
		 .when()
		 	.delete("https://reqres.in/api/users/"+id)
		 .then()
		    .statusCode(204)
		    .log().all();
	 }
}
