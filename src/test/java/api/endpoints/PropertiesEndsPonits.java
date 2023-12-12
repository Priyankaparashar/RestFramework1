package api.endpoints;


import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.paylods.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PropertiesEndsPonits {
	
	
	static ResourceBundle getURL(){
		ResourceBundle resource =ResourceBundle.getBundle("roots");
		return resource;
	}
	
	public static Response createUser(UserPOJO payload){
		
		String postUrl =getURL().getString("postUrl");
		
		Response response= 
		given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when().post(postUrl);
		
		return response;
	}
	
	
	public static Response updateUser(UserPOJO payload,String username){
		
		String putUrl =getURL().getString("putUrl");
		Response response= 
		 given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		
		.when().put(putUrl);
		
		return response;
		
	}
	
	public static Response getUser(String username){
		
		String getUrl =getURL().getString("getUrl");
		
		Response response= 
		 given()
		.pathParam("username", username)
		
		.when().get(getUrl);
		
		return response;
		
	}
	
public static Response deleteUser(String username){
	
	String deleteUrl =getURL().getString("deleteUrl");
	
		
		Response response= 
		 given()
		.pathParam("username", username)
		
		.when().delete(deleteUrl);
		
		return response;
		
	}
	



}
