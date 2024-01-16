package mobileappapitestapi;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class customersignuploginverfication {
	
	public static HashMap map=new HashMap();
	
	
	@Test(enabled = false)
	public void customer_phoneverification()
	{
		
		
		given()
		.when()
		.get("https://dev.mantramedic.com/api/customer/PhoneVerification/8965412365")
		.then()
		.statusCode(200)
		.log().all();
	}
	@BeforeClass
	public void getdata()
	{
		
		 map.put("fullname",apiautomation.fullname());
		 map.put("dob",apiautomation.dob());
		 map.put("gender",apiautomation.gender());
		 map.put("email",apiautomation.email());
		 map.put("phone",apiautomation.phone());
		 map.put("pin",apiautomation.pin());
		 
		
		RestAssured.baseURI="https://dev.mantramedic.com";
		RestAssured.basePath="/api/customer/Signup";
		
	}
	
	@Test(priority = 2)
	public void customersignup()
	{
		
		
		given()
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(200)
		.log().all();
	}

}
