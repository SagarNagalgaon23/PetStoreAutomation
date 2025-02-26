package api.tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.PetEndPoints;
import api.endpoints.UserEndPoints;
import api.payloads.Pet;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DD_PetTest {
	
	@Test(priority=1,dataProvider="PetData",dataProviderClass=DataProviders.class)
	public void testPostUser(String Petid,String CatId,String CatName,String Name,String photourls,String tagId,String tagName,String status) {
		Pet petPayload=new Pet();
	
		
		HashMap <String,Object> categoryMap=new HashMap<String,Object>();
		categoryMap.put("id",Integer.parseInt(CatId));
		categoryMap.put("name",CatName);		
		
		HashMap <String,Object> tagsMap=new HashMap<String,Object>();
		tagsMap.put("id",tagId );
		tagsMap.put("name",tagName);
		ArrayList<HashMap> tagsListMap=new ArrayList<HashMap>();	
		tagsListMap.add(tagsMap);
		
		
		
		ArrayList<String> photoUrlsList=new ArrayList<String>();	
		petPayload.setId(Integer.parseInt(Petid));
		petPayload.setCategory(categoryMap);		
		petPayload.setName(Name);
		photoUrlsList.add(photourls);		
		petPayload.setTags(tagsListMap);
		petPayload.setStatus(status);
		
		
		Response response=PetEndPoints.addNewPet(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="Pet_id",dataProviderClass=DataProviders.class)
	public void get_Pet(String id) {
		
		Response response=PetEndPoints.displayPet(Integer.parseInt(id));
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3,dataProvider="Pet_id",dataProviderClass=DataProviders.class)
	public void delete_Pet(String id) {
		
		Response response=PetEndPoints.deletePet(Integer.parseInt(id));
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
