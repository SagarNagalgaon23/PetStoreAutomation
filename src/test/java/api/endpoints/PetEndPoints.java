package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {

	
		public static Response addNewPet(Pet payload){
			Response response=	given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.post_pet_url);
			
				return response; 
		}
	
		public static Response displayPet(int id){
			Response response=	given()
					.pathParam("id", id)
				.when()
					.get(Routes.get_pet_url);
			
				return response; 
		}
		
		public static Response updatePetData(Pet payload) {
			Response response=	given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.put(Routes.put_pet_url);
			
				return response; 
			
		}
		
		public static Response deletePet(int id){
			Response response=	given()
					.pathParam("id", id)
				.when()
					.delete(Routes.delete_pet_url);
			
				return response; 
		}	
	
}
