package com.matschi.booker.tests;

import org.testng.annotations.Test;

import com.matschie.pojo.serialization.BookingDates;
import com.matschie.pojo.serialization.BookingRequestPayload;
import com.matschie.testng.apis.BookerApiHooks;

public class BookingTest extends BookerApiHooks {
	
	@Test
	public void shouldUserAbleToFetchAllBookingIds() {
		booking.getBookingById();
		booking.validateGetBookingByIdEndpoint();
	}
	
	@Test
	public void shouldUserAbleToUpdateExistingBooking() {
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
		
		booking.updateBooking(token, "1104", payload);
		booking.validateUpdateBookingEndpoint();
	}

}