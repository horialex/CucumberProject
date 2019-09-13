package dao.booking;

import java.util.List;

import com.google.inject.ImplementedBy;

import entities.Booking;

@ImplementedBy(BookingDao.class)
public interface BookingAbstractDao {
	
	public void saveBooking(Booking booking);
	
	public List<Booking> getBookings();

}
