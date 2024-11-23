package com.matschie.servicenow.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.matschie.pojo.serialization.BookingDates;
import com.matschie.pojo.serialization.BookingRequestPayload;
import com.matschie.servicenow.services.IncidentService;
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
	
	@Test
	public void shouldAbleToCreateIncidentWithoutBody1() {
		IncidentService incidentService = new IncidentService();
		incidentService.createIncidentWithoutBody(requestSpec);
		incidentService.validateIncidentIsCreated();
		
		BookingRequestPayload payload = new BookingRequestPayload();
		BookingDates dates = new BookingDates();
		dates.setCheckin("2024-12-01");
		dates.setCheckout("2024-12-10");
		
		payload.setFirstname("Karthi");
		payload.setLastname("Keyan");
		payload.setTotalprice(1000);
		payload.setDepositpaid(false);
		payload.setBookingdates(dates);
		payload.setAdditionalneeds("Breakfast");
		
		incidentService.createIncidentWithBody(requestSpec, payload);
		incidentService.validateIncidentIsCreated();
		
	}
	
	

}