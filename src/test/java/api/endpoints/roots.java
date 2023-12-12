package api.endpoints;
/*
 Swagger ui: https://petstore.swagger.io/#/
 Swagger post: https://petstore.swagger.io/#/user/createUsersWithArrayInput
 Swagger put: https://petstore.swagger.io/#/user/updateUser
 Swagger get:https://petstore.swagger.io/#/user/getUserByName 
 Swagger delete : https://petstore.swagger.io/#/user/deleteUser
 
 */


public class roots {
	
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	// user module
	
	public static String postUrl = baseUrl+"/user";
	public static String getUrl = baseUrl+"/user/{username}";
	public static String putUrl = baseUrl+"/user/{username}";
	public static String deleteUrl = baseUrl+"/user/{username}";

}
