package service;

import java.util.List;

import com.google.inject.Inject;

import config.TestContext;
import constants.ContextKeyConstants;
import dao.booking.BookingAbstractDao;
import dao.category.CategoryAbstractDao;
import dao.item.ItemAbstractDao;
import entities.Booking;
import entities.Item;
import page.BookingsPage;
import page.CategoriesPage;
import page.HeaderPage;
import page.ItemsPage;
import tools.factories.BookingFactory;
import validations.BookingValidation;

public class BookingService {
	
	@Inject
	private TestContext context;
	@Inject
	private HeaderPage headerPage;
	@Inject 
	private CategoriesPage categoryPage;
	@Inject
	private ItemsPage itemsPage;
	@Inject 
	private BookingFactory bookingFactory;
	@Inject
	private BookingAbstractDao bookingAbstractDao;
	@Inject
	private ItemAbstractDao itemAbstractDao;
	@Inject
	private CategoryAbstractDao categoryAbstractDao;
	@Inject 
	private BookingsPage bookingsPage;
	@Inject
	private BookingValidation bookingValidations;
	
	
	public void bookItemFromLastCategory() {
		List<Item> itemsFromLastCategory = itemAbstractDao
				.getItemsByCategoryId(String.valueOf(categoryAbstractDao.getLastCreatedCategory().getId()));
		this.bookItems(itemsFromLastCategory);
	}
	
	public void bookItems(List<Item> items) {
		for (Item item : items) {
			//TODO - debatable - poate ar trebui aici sa adugam prin ItemAbstractDao - sa nu folosim
			//clasa de context direct aici - debatalbe...
			context.set(ContextKeyConstants.ITEM, item);
			headerPage.selectHeader("ITEMS");
			categoryPage.selectCategory(item.getCategory().getName());
			bookItem(item.getTitle());
		}
	}
	
	public void bookItem(String itemTitle){
		Booking booking = bookingFactory.getBookingInstance();
		
		itemsPage.clickBookItem(itemTitle);
		itemsPage.selectStartDate(booking.getStartDate());
		itemsPage.selectStartHour(booking.getStartDate());
		itemsPage.selectEndDate(booking.getEndDate());
		itemsPage.selectEndHour(booking.getEndDate());
		itemsPage.saveBooking();
		
		bookingAbstractDao.saveBooking(booking);
	}
	
	public void validateBookedItems() {
		
		List<Booking> expectedBookings = bookingAbstractDao.getBookings();
		List<Booking> actualdBookings = bookingsPage.getBookings(expectedBookings);
	
		bookingValidations.validateBookings(expectedBookings, actualdBookings);
	}
	
	public void goToMyBookings() {
		headerPage.refresh();
		headerPage.selectHeader("BOOKINGS");
		bookingsPage.checkBookingCategory("My Bookings");
	}

}
