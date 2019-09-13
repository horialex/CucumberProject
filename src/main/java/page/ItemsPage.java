package page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tools.utils.StringHelpers;

public class ItemsPage extends AbstractPage {
	
	public ItemsPage() {
		super();
	}
	
	@FindBy(css = "div[class*='list-container']")
	WebElement itemsContainer;
	@FindBy(css = "input#booking_start_date1")
	WebElement startDate;
	@FindBy(css = "input#booking_start_date2")
	WebElement endDate;
	@FindBy(css = "input[class*='booking_start_hour']")
	WebElement startHour;
	@FindBy(css = "input[class*='booking_end_hour']")
	WebElement endHour;
	@FindBy(css = "div[class*='picker-open']")
	WebElement datePickerContainer;
	@FindBy(css = "button#create-booking-action")
	WebElement save;
	@FindBy(css = "div.ui-timepicker-wrapper")
	WebElement hourContainer;
	@FindBy(css = "div[class*='picker-open'] div.datepicker-months thead th.next")
	WebElement nextYear;

	By container = By.cssSelector("div[class*='list-container']");
	
	public void saveBooking() {
		save.click();
	}

	public void clickBookItem(String itemName) {
		
		WebElement itemElement = selectItemForBooking(itemName);
		WebElement bookButton = itemElement.findElement(By.cssSelector("button"));
		bookButton.click();
	}

	public WebElement selectItemForBooking(String itemName) {
		waitForElementToAppear(container);
		List<WebElement> itemList = itemsContainer
				.findElements(By.cssSelector("div[class='white-box clearfix single-item']"));
		for (WebElement item : itemList) {
			String it = item.findElement(By.cssSelector("h3 a")).getText().trim();
			if (it.contentEquals(itemName)) {
				System.out.println("Item found " + itemName);
				return item;
			}
		}

		return null;
	}

	public void selectStartDate(String date) {
		startDate.click();
		selectYear(date);
		selectMonth(date);
		selectDay(date);
	}

	public void selectEndDate(String date) {
		endDate.click();
		selectYear(date);
		selectMonth(date);
		selectDay(date);
	}

	public void selectStartHour(String date) {
		startHour.click();
		selectHour(date.split(",")[1].trim());
	}

	public void selectEndHour(String date) {
		endHour.click();
		
	
		selectHour(date.split(",")[1].trim());
	}

	public void selectMonth(String date) {
		String m = date.split(",")[0].split(" ")[0];
		List<WebElement> monthList = datePickerContainer
				.findElements(By.cssSelector("div.datepicker-months tbody span"));
		for (WebElement month : monthList) {
			if (month.getText().contentEquals(m)) {
				month.click();
				break;
			}
		}
	}

	public void selectYear(String date) {
		datePickerContainer.findElement(By.cssSelector("div.datepicker-days thead th.picker-switch")).click();
		String providedYear = date.split(",")[0].split(" ")[2];
		String displayedYear = datePickerContainer
				.findElement(By.cssSelector("div.datepicker-months thead th.picker-switch")).getText();
		int noOfNext = Integer.valueOf(providedYear) - Integer.valueOf(displayedYear);

		for (int i = 0; i < noOfNext; i++) {
			displayedYear = datePickerContainer
					.findElement(By.cssSelector("div.datepicker-months thead th.picker-switch")).getText();
			if (!displayedYear.contentEquals(providedYear)) {
				nextYear.click();
			}
		}
	}

	public void selectDay(String date) {
		String d = date.split(",")[0].split(" ")[1];
		List<WebElement> dayList = datePickerContainer
				.findElements(By.cssSelector("div.datepicker-days tbody tr td[class*='day']"));
		for (WebElement day : dayList) {
			if (day.getText().contentEquals(StringHelpers.cleanZeroLeadingStrings(d))
					&& !(day.getAttribute("class").contains("disabled"))) {
				day.click();
				break;
			}
		}
	}

	public void selectHour(String hour) {
		List<WebElement> hourList = hourContainer.findElements(By.cssSelector("ul li"));
		for (WebElement h : hourList) {
			if (h.getText().contains(hour)) {
				h.click();
				break;
			}
		}
	}

	public WebElement getItem(String itemName) {
		List<WebElement> itemList = itemsContainer
				.findElements(By.cssSelector("div[class='white-box clearfix single-item']"));
		for (WebElement item : itemList) {
			String it = item.findElement(By.cssSelector("h3 a")).getText().trim();
			if (it.contentEquals(itemName)) {
				return item;
			}
		}
		return null;
	}

	public void itemExists(String itemName, boolean expected) {
		if (expected) {
			Assert.assertNotNull("Item " + itemName + " was not found", getItem(itemName));
		} else {
			Assert.assertNull("Item " + itemName + " was found", getItem(itemName));
		}
	}
}
