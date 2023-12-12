package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.paylods.UserPOJO;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDriven {
	
	@Test(priority=1, dataProvider= "Data", dataProviderClass= DataProviders.class)
	public void userPostRequest(String userid, String Username, String fname, String lname, String password, String phone) {
		
		Faker fake = new Faker();
		
		UserPOJO userpojo = new UserPOJO();
		
		userpojo.setId(fake.idNumber().hashCode());
		userpojo.setUsername(Username);
		userpojo.setFirstName(fname);
		userpojo.setLastName(lname);
		userpojo.setPassword(password);
		userpojo.setPhone(phone);
		
		Response response = UserEndpoints.createUser(userpojo);
		response.then().statusCode(200).log().all();	
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority = 2, dataProvider = "UserNames",dataProviderClass= DataProviders.class)
	public void userGetRequest(String username) {
		
		Response response= UserEndpoints.getUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	

	@Test(priority = 3, dataProvider = "UserNames",dataProviderClass= DataProviders.class)
	public void userDeleteRequest(String username) {
		
		Response response= UserEndpoints.deleteUser(username);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
