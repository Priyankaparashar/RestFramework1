package api.endpoints;
import static io.restassured.RestAssured.*;
import io.restassured.response.*;
import io.restassured.http.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import api.paylods.UserPOJO;
import io.restassured.http.ContentType;


// it contains Curd operations (post,delete,get,put)

public class UserEndpoints {
	
	public static Response createUser(UserPOJO payload){
		Response response= 
		given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when().post(roots.postUrl);
		
		return response;
	}
	
	
	public static Response updateUser(UserPOJO payload,String username){
		Response response= 
		 given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		
		.when().put(roots.putUrl);
		
		return response;
		
	}
	
	public static Response getUser(String username){
		
		Response response= 
		 given()
		.pathParam("username", username)
		
		.when().get(roots.getUrl);
		
		return response;
		
	}
	
public static Response deleteUser(String username){
		
		Response response= 
		 given()
		.pathParam("username", username)
		
		.when().delete(roots.deleteUrl);
		
		return response;
		
	}
	

}
