package com.matschie.servicenow.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.matschie.testng.apis.TestNGHooks;

import io.restassured.http.ContentType;

public class IncidentTest extends TestNGHooks {	
	
	@Test
	public void shouldAbleToCreateIncidentWithoutBody() {
		HashMap<String, String> pathParams = new HashMap<String, String>();
		pathParams.put("tableName", "incident");
		postMethod(requestSpec, pathParams)
		 .then()
		 .spec(expectResponse(201, "Created", ContentType.JSON));
	}

}