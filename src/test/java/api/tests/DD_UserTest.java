package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DD_UserTest {

	
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userid,String username,String fname,String lname,String email,String pwd,String ph) {
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userid));
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testReadUser(String username) {
		
		Response response=UserEndPoints.readUser(username);
		response.then().log().all();
		
	}
	
	@Test(priority=3,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUser(String username) {
		Response response= UserEndPoints.deleteUser(username);
		response.then().log();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	
	}   
	
}
