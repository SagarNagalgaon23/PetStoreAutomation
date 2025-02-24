package api.tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User userPayload;
	Logger logger;
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void testCreateUser() {
		logger.info("*********Creating User**********");
		Response response=UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********User Created**********");
	}
	
	@Test(priority=2)
	public void testReadUser() {
		logger.info("*********Reading User**********");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		logger.info("*********User info is displayed**********");
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		logger.info("*********Updating User**********");
		//userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.info("********* User is updated**********");
			
		}
	
	@Test(priority=4)
	public void testReadUpdatedUser() {
		logger.info("*********Reading Updated User**********");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		logger.info("*********Updated User is displayed**********");
	}
	
	@Test(priority=5)
	public void testDeleteUser() {
		logger.info("*********Deleting User**********");
		Response response= UserEndPoints2.deleteUser(this.userPayload.getUsername());
		response.then().log();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********User Deleted**********");
	
	}   
	
}
