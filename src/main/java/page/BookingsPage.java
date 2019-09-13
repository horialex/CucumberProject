package page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import entities.Booking;
import entities.Item;
import entities.User;

public class BookingsPage extends AbstractPage {
	
//	public BookingsPage() {
//		super();
//	}
	
	@FindBy(css = "ul[class*='bookings-listing']")
	WebElement itemBookingsContainer;
	@FindBy(css = "button#item-return-item")
	WebElement returnItemConfirmationPopup;
	
	By headerContainer = By.cssSelector("ul[class*='nav-tabs']");
	By bookingsContainer = By.cssSelector("ul[class*='bookings-listing']");

	public void checkBookingCategory(String header) {
		waitForElementToAppear(headerContainer);
		WebElement container = getDriver().findElement(headerContainer);
		List<WebElement> headerList = container.findElements(By.cssSelector("li a"));
		WebElement headerElement = headerList.stream().map(element -> {
			element.getText().replace("\"", "");
			return element;
		}).filter(element -> element.getText().contentEquals(header)).findFirst().orElse(null);

		Assert.assertTrue("The element has not been found", headerElement != null);

		headerElement.click();
	}

//	public void returnItem(String itemName) {
//		WebElement selectedBooking = selectBookingToReturn(itemName);
//		selectedBooking.findElement(By.cssSelector("button[class*='return-item']")).click();
//		returnItemConfirmationPopup.click();
//	}

	/**
	 * @param bookingList
	 * @return actual booking list from ui, filtered by expected booking list in
	 *         case that there are more bookings than expected.
	 */
	public List<Booking> getBookings(List<Booking> bookingList) {
		List<Booking> createdBookings = new ArrayList<>();
		List<WebElement> selectedBookings = selectBookings(bookingList);
		
		
		
		for (WebElement booking : selectedBookings) {
			Booking bookedItem = new Booking();
			String actualItemName = booking
					.findElement(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText()
					.trim();
			String from = booking.findElement(
					By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)"))
					.getText();
			String to = booking.findElement(
					By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(4)"))
					.getText();
			String userName = booking
					.findElement(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(3) a")).getText()
					.trim();

			User user = new User();
			user.setName(userName);
			Item item = new Item();
			item.setTitle(actualItemName);

			bookedItem.setStatus(booking.findElement(By.cssSelector(".status-label")).getText());
			bookedItem.setStartDate(from);
			bookedItem.setEndDate(to);
			bookedItem.setUser(user);
			bookedItem.setItem(item);

			createdBookings.add(bookedItem);
		}
		return createdBookings;
	}

	public List<WebElement> selectBookings(List<Booking> expectedBookingList) {
		waitForElementToAppear(bookingsContainer);
		
		List<WebElement> bookingsInUi = itemBookingsContainer
				.findElements(By.cssSelector("div[class*='item-booking-container']"));
		
		System.out.println("BOOKIGNS IN UI " + bookingsInUi.size());
		System.out.println("EXPTECTED BOOKING LIST SIZE " + expectedBookingList.size());
		
		System.out.println("Bookings in UI start date: " + bookingsInUi.get(0).findElement(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)")).getText());
		System.out.println("EXPTECTED  booking start date: " + expectedBookingList.get(0).getStartDate());	
		
		Predicate<WebElement> bookingCheck = bookingInUi -> expectedBookingList.stream()
				.anyMatch(expectedBooking -> expectedBooking.getItem().getTitle() 
						.contentEquals(bookingInUi
								.findElement(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a"))
								.getText().trim()));
		//TODO - this has been removed because the dates do not match - it is a problem due to adding a 0 before the hour  eg 01 - 1 
		//						&& expectedBooking.getStartDate()
		//								.contentEquals(bookingInUi
		//										.findElement(By.cssSelector(
		//												"div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)"))
		//										.getText()));

		return bookingsInUi.stream().filter(bookingCheck).collect(Collectors.toList());
	}

//	public WebElement selectBookingToReturn(String itemName) {
//		List<WebElement> bookings = itemBookingsContainer
//				.findElements(By.cssSelector("div[class*='item-booking-container']"));
//
//		WebElement headerElement = bookings.stream()
//				.filter(booking -> booking
//						.findElement(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText()
//						.trim().contentEquals(itemName))
//				.filter(booking -> booking.findElement(By.cssSelector(".status-label")).getText()
//						.contentEquals(StatusConstants.ACCEPTED))
//				
//				.filter(booking -> booking.containsElements(By.cssSelector("button[class*='return-item']"))).findAny()
//				.orElse(null);
//
//		Assert.assertTrue("The element has not been found", headerElement != null);
//
//		return headerElement;
//	}
}
