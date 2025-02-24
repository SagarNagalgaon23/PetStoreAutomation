package api.endpoints;

/*
 * Swagger URI ----> https://petstore.swagger.io
   [Base URL: petstore.swagger.io/v2 ]
 
 * Create User(Post): https://petstore.swagger.io/v2/user
 * Get USer (Get): https://petstore.swagger.io/v2/user/{username}
 * Update User(Put):https://petstore.swagger.io/v2/user/{username}
 * Delete User(Delete):https://petstore.swagger.io/v2/user/{username}
 * 
 * endpoints: /user/{username}
  
 */
public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module
	
	 public static String post_url=base_url+"/user";
	 public static String get_url=base_url+"/user/{username}";
	 public static String put_url=base_url+"/user/{username}";
	 public static String delete_url=base_url+"/user/{username}";
	 
	 //Store Module
	 
	 
	 //Pet Module
	 
	
}
