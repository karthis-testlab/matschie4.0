package com.matschie.booker.services;

import com.matschie.general.utils.PropertiesHandler;
import com.matschie.pojo.serialization.Token;
import com.matschie.rest.assured.common.RestAssuredBase;

import io.restassured.specification.RequestSpecification;

public class AuthService extends RestAssuredBase {
	
	private RequestSpecification setUp() {
		return requestSpec(PropertiesHandler.config("booker.base.uri"), 
				    PropertiesHandler.config("booker.auth.base.path"));
	}
	
	public String createToken(String userName, String password) {
		Token token = new Token();
		token.setUsername(userName);
		token.setPassword(password);
		return postMethod(setUp(), token).jsonPath().getString("token");
	}

}