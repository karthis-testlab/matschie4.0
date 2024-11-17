package com.matschie.servicenow.services;

import java.util.HashMap;
import java.util.Map;

import com.matschie.rest.assured.common.RestAssuredBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.matschie.general.utils.PropertiesHandler.*;

public class IncidentService extends RestAssuredBase {
	
	// Service Object Model
	private static final String table_name = "incident";
	private Map<String, String> pathParams = new HashMap<>();
	private Response response;	
	private RequestSpecification requestSpecification;
	
	public IncidentService() {
		pathParams.put("tableName", table_name);
	}
	
	public void setUp() {
		requestSpecification = requestSpec(
			       config("service.now.instance.baseUri"), 
			       config("service.now.instance.basePath"), 
			       config("service.now.instance.username"), 
			       secret("service.now.instance.password"));
	}
	
	public void createIncidentWithoutBody() {		
		response = postMethod(requestSpec(
				       config("service.now.instance.baseUri"), 
				       config("service.now.instance.basePath"), 
				       config("service.now.instance.username"), 
				       secret("service.now.instance.password")), pathParams);
	}
	
	public void createIncidentWithBody(Object requestPayload) {
		response = postMethod(requestSpecification, pathParams, requestPayload);
	}
	
	public void validateIncidentIsCreated() {
		response.then()
		        .spec(expectResponse(201, "Created", ContentType.JSON));
	}

}