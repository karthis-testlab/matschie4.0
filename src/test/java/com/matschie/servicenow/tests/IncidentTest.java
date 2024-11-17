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
	
	@Test
	public void shouldUserAbleToRetriveSingleIncident() {
		HashMap<String, String> pathParams = new HashMap<String, String>();
		pathParams.put("tableName", "incident");
		pathParams.put("sysId", "2b092de783719a10695bc7b6feaad331");
		getMethod(requestSpec, pathParams, "/{sysId}")
		  .then()
		  .spec(expectResponse(200, "OK", ContentType.JSON));
	}

}