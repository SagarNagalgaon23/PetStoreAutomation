package api.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.endpoints.UserEndPoints;
import api.payloads.Pet;
import io.restassured.response.Response;

public class PetTests {
	Faker faker;
	Pet petPayload;
	Logger logger;
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		petPayload=new Pet(); 
		
		HashMap <String,Object> categoryMap=new HashMap<String,Object>();
		categoryMap.put("id",faker.idNumber().hashCode());
		categoryMap.put("name",faker.animal().name());
		HashMap <String,Object> tagsMap=new HashMap<String,Object>();
		//tagsMap.put("name",faker.animal().name());
		ArrayList<HashMap> tagsListMap=new ArrayList<HashMap>();
		tagsMap.put("id", faker.idNumber().hashCode());
		tagsMap.put("name", faker.animal().name());
		tagsListMap.add(tagsMap);
		ArrayList<String> photoUrlsList=new ArrayList<String>();
		
		photoUrlsList.add("https://string");

		//logs
		logger=LogManager.getLogger(this.getClass());
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setCategory(categoryMap);		
		petPayload.setName(faker.animal().name());
		petPayload.setPhotoUrls(photoUrlsList);
		petPayload.setTags(tagsListMap);
		petPayload.setStatus("");
	}
	
	@Test(priority=1)
	public void testCreateUser() {
		logger.info("*********Creating Pet**********");
		Response response=PetEndPoints.addNewPet(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********Pet Created**********");
	}
	@Test(priority=2)
	public void testDisplayPet() {
		Response response=PetEndPoints.displayPet(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void testUpdatePet() {
		petPayload.setName(faker.animal().name());
		petPayload.setStatus("sold");
		Response response=PetEndPoints.updatePetData(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testDeletePet() {
		Response response=PetEndPoints.deletePet(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=5)
	public void testDisplayPetafterDelete() {
		Response response=PetEndPoints.displayPet(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404);
	}
	
}
