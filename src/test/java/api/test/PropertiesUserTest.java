package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PropertiesEndsPonits;
import api.paylods.UserPOJO;
import io.restassured.response.Response;

public class PropertiesUserTest {
	
	
Faker fake;
	
	UserPOJO userpojo;
	
	
	@BeforeClass
	
	public void setupData() {
		
		fake= new Faker();
		userpojo = new UserPOJO();
		
		userpojo.setId(fake.idNumber().hashCode());
		userpojo.setUsername(fake.name().username());
		userpojo.setFirstName(fake.name().firstName());
		userpojo.setLastName(fake.name().lastName());
		userpojo.setPassword(fake.internet().password());
		userpojo.setPhone(fake.phoneNumber().cellPhone());
		
		}
	
	@Test(priority= 1)
	public void testpostRequest() {
		
		Response response = PropertiesEndsPonits.createUser(userpojo);
		response.then().statusCode(200).log().cookies();		
	}
	
	@Test(priority=2)
	public void testgetRequest() {
		
		Response response= PropertiesEndsPonits.getUser(this.userpojo.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/json");
		
	}
	@Test(priority =3)
	public void testputRequest() {
		
		userpojo.setFirstName(fake.name().firstName());
		userpojo.setLastName(fake.name().lastName());
		userpojo.setPassword(fake.internet().password());
		userpojo.setPhone(fake.phoneNumber().cellPhone());
		
		Response response =  PropertiesEndsPonits.updateUser(userpojo, this.userpojo.getUsername());
		
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response afterResponse= PropertiesEndsPonits.getUser(this.userpojo.getUsername());
		afterResponse.then().log().all();
		Assert.assertEquals(afterResponse.getStatusCode(), 200);
		
		
	}
	
	

}



