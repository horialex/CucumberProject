package dao.booking;

import java.util.List;

import com.google.inject.Inject;

import config.TestContext;
import constants.ContextKeyConstants;
import entities.Booking;

public class BookingDao implements BookingAbstractDao {
	
	@Inject
	TestContext testContext;

	@Override
	public void saveBooking(Booking booking) {
		System.out.println("Saving booking...");
		testContext.saveObjectInContextList(ContextKeyConstants.BOOKINGS, booking);

	}

	@Override
	public List<Booking> getBookings() {
		return testContext.get(ContextKeyConstants.BOOKINGS);
	}

}
