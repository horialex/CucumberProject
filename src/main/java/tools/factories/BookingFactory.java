package tools.factories;

import com.google.inject.Inject;

import config.TestContext;
import constants.ContextKeyConstants;
import constants.DateConstants;
import constants.StatusConstants;
import entities.Booking;
import entities.Item;
import entities.User;
import tools.utils.DateUtils;

public class BookingFactory {

	@Inject
	private TestContext testContext;
	
	public Booking getBookingInstance() {
		User sessionUser = testContext.get(ContextKeyConstants.USER);
		Item item = testContext.get(ContextKeyConstants.ITEM);
		Booking booking = new Booking();

		booking.setStatus(StatusConstants.ACCEPTED);
		booking.setStartDate(
				DateUtils.convertLocalDateTimeToString(DateUtils.addHoursToCurrentDate(2), DateConstants.WW_PATTERN));
		booking.setEndDate(
				DateUtils.convertLocalDateTimeToString(DateUtils.addHoursToCurrentDate(3), DateConstants.WW_PATTERN));
		booking.setItem(item);
		booking.setUser(sessionUser);

		return booking;
	}

	public Booking getApiBookingInstance() {
		Item item = testContext.get(ContextKeyConstants.ITEM);
		User userRequest = testContext.get(ContextKeyConstants.USER);
		Booking booking = new Booking();
		booking.setItemId(item.getId());
		booking.setUserId(userRequest.getId());
		booking.setItem(item);
		booking.setUser(userRequest);
		booking.setStartDate(
				DateUtils.convertLocalDateTimeToString(DateUtils.getCurrentDate(), DateConstants.WW_PATTERN));
		booking.setEndDate(
				DateUtils.convertLocalDateTimeToString(DateUtils.addHoursToCurrentDate(1), DateConstants.WW_PATTERN));
		booking.setClientTime(
				DateUtils.convertLocalDateTimeToString(DateUtils.getCurrentDate(), DateConstants.WW_PATTERN));

		return booking;
	}

	public Booking getApiBookingReturnInstance() {
		Booking booking = testContext.get(ContextKeyConstants.BOOKING);
		booking.setReturnItem(true);

		return booking;
	}
}
