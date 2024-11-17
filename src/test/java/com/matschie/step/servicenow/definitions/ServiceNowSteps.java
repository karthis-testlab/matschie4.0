package com.matschie.step.servicenow.definitions;

import com.google.gson.Gson;
import com.matschie.pojo.serialization.IncidentRequestPayload;
import com.matschie.servicenow.services.IncidentService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceNowSteps {
	
	IncidentService incidentService = new IncidentService();
	IncidentRequestPayload requestPayload = new IncidentRequestPayload();

	@Given("set the base path of the service now incident table")
	public void set_the_base_path_of_the_service_now_incident_table() {
		incidentService.setUp();
	}

	@When("/^send the post request for the incident service to create one record with (.*) short description$/")
	public void send_the_post_request_for_the_incident_service_to_create_one_record_with_restapisep2024_short_description(String arg) {
		requestPayload.setDescription(arg);
	}

	@When("/^send the post request for the incident service to create record with (.*) description$/")
	public void send_the_post_request_for_the_incident_service_to_create_record_with_rest_api_post_call_description(String arg) {
		requestPayload.setShort_description(arg);
		incidentService.createIncidentWithBody(new Gson().toJson(requestPayload));
	}

	@Then("ensure the record successfully create")
	public void ensure_the_record_successfully_create() {
		incidentService.validateIncidentIsCreated();
	}

}