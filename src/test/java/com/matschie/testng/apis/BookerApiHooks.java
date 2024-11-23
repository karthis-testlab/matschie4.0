package com.matschie.testng.apis;

import org.testng.annotations.BeforeMethod;

import com.matschie.booker.services.AuthService;
import com.matschie.booker.services.BookingService;
import com.matschie.general.utils.PropertiesHandler;

public class BookerApiHooks {
	
	protected AuthService auth;
	protected BookingService booking;
	protected String token;
	
	@BeforeMethod
	public void beforeMethod() {
		auth = new AuthService();
		booking = new BookingService();
		token = auth.createToken(PropertiesHandler.config("booker.username"),
				                 PropertiesHandler.secret("booker.password"));
	}
	

}