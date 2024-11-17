package com.matschie.testng.apis;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.matschie.general.utils.PropertiesHandler.*;
import com.matschie.rest.assured.common.RestAssuredBase;

import io.restassured.specification.RequestSpecification;

public class TestNGHooks extends RestAssuredBase {
	
	protected RequestSpecification requestSpec;
	
	@BeforeMethod
	public void beforeMethod() {
		requestSpec = requestSpec(config("service.now.instance.baseUri"), 
				                  config("service.now.instance.basePath"),
				                  config("service.now.instance.username"), 
				                  secret("service.now.instance.password"));
	}
	
	@AfterMethod
	public void afterMethod() {
		// This method will run after each every @Test method.		
	}

}