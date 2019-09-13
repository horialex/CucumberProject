package validations;

import java.util.List;
import java.util.Objects;

import com.google.inject.Inject;

import dao.booking.BookingAbstractDao;
import entities.Booking;
import page.BookingsPage;

public class BookingValidation {

	@Inject
	private BookingsPage bookingsPage;

	@Inject
	private SoftValidation softValidation;

	@Inject
	private BookingAbstractDao bookingAbstractDao;

	public void validateBookedItems() {
		List<Booking> expectedBookings = bookingAbstractDao.getBookings();
		List<Booking> actualdBookings = bookingsPage.getBookings(expectedBookings);
		validateBookings(expectedBookings, actualdBookings);
	}

	public void validateBookings(List<Booking> expectedBookings, List<Booking> actualdBookings) {
		int counter = 0;
		for (Booking expectedBooking : expectedBookings) {
			
			Booking actualBooking = findBookingInList(expectedBooking, actualdBookings);
			if (Objects.nonNull(actualBooking)) {
				counter++;
			}
			
			SoftValidation.verifyStringValuesIgnoreCase("status", expectedBooking.getStatus(),
					actualBooking.getStatus());
			SoftValidation.verifyStringValues("user", expectedBooking.getUser().getName(),
					actualBooking.getUser().getName());
			SoftValidation.verifyStringValues("item", expectedBooking.getItem().getTitle(),
					actualBooking.getItem().getTitle());
		}

		SoftValidation.verifyIntValues("no. of validations vs booking list size:", counter, expectedBookings.size());
		SoftValidation.verifyIntValues("booking list size:", actualdBookings.size(), expectedBookings.size());
		softValidation.printErrors();
	}

	private Booking findBookingInList(Booking searchedBooking, List<Booking> bookings) {
		return bookings.stream()
				.filter(booking -> booking.getItem().getTitle().contentEquals(searchedBooking.getItem().getTitle())).findFirst()
				.orElse(null);
	}
}
