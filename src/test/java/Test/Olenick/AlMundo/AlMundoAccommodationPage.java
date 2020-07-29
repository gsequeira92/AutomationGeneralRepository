package Test.Olenick.AlMundo;

import org.openqa.selenium.By;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AlMundoAccommodationPage extends Base {

	public AlMundoAccommodationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	// Destination and date elements

	@FindBy(css = "input[formcontrolname='origin']")
	WebElement originInput;

	@FindBy(xpath = "//div[@class='options-container']")
	WebElement hotelSubMenu;

	@FindBy(css = "am-icon[icon='arrow-left']")
	WebElement previousMonthButton;

	@FindBy(css = "button.next")
	WebElement nextMonthButton;

	@FindBy(xpath = "//div[@class='nav-title']")
	WebElement calendarTitleLocator;

	@FindBy(css = "input[data-au='checkin']")
	WebElement checkinDateSelector;

	@FindBy(css = "input[data-au='checkout']")
	WebElement checkoutDateSelector;

	@FindBy(css = "table[class='calendar-table']")
	WebElement calendarLocator;

	// Room and passenger elements

	@FindBy(css = "input[data-au='guests']")
	WebElement guestInputDropdown;

	@FindBy(css = "am-passengers-dialog-selector[data-au='adults-0'] div.selector-content am-icon[data-au='plus']")
	WebElement addAdultButton;

	@FindBy(css = "am-passengers-dialog-selector[data-au='children-0'] div.selector-content am-icon[data-au='plus']")
	WebElement addMinorButton;

	@FindBy(css = "am-passengers-dialog-selector[data-au='adults-0'] div.selector-content am-icon[data-au='minus'")
	WebElement subAdultButton;

	@FindBy(css = "button.done-button")
	WebElement childDoneButton;

	@FindBy(css = "select[data-au='age-child-0']:nth-of-type(0)")
	WebElement childAgeSelector;

	@FindBy(css = "am-icon[data-au='minus']")
	WebElement subRoomButton;

	@FindBy(css = "am-icon[data-au='plus']")
	WebElement addRoomButton;

	// Submit search btn element

	@FindBy(css = "button.search-box-button")
	WebElement submitSearchButton;

	// Test Method

	public void searchForAccommodation(Hotel hotel) {

		searchHotel(hotel.getHotelLocation(), hotel.getTypeFrom(), hotel.getHotelLocation());
		checkinDateSelector.click();
		searchForDate(hotel.getMonthFrom(), hotel.getDateFrom(), hotel.getDateTo());
		setPassengersAndRooms(hotel.getAdultNumber(), hotel.getChildrenNumber(), hotel.getChildIndex(),
				hotel.getRooms());
		submmitSearch();

	}

	// Search and set methods
	// There're 3 types for search: City,neighborhood and Hotel
	public void searchHotel(String destination, String locationType, String option) {

		originInput.click();
		originInput.sendKeys(destination);
		waitForHotelSuboption();
		selectHotelSubmenuOption(locationType, option);

	}

	public void searchForDate(String month, String dateFrom, String dateTo) {

		selectSpecificMonthFrom(month);
		selectSpecificDate(dateFrom, dateTo);

	}

	public void setPassengersAndRooms(int adults, int minors, int option, int rooms) {

		openPassengersDropdown();
		addRooms(rooms);
		addAdultPassengers(adults);
		addMinorPassengers(minors);
		waitForMinorSubmenu();
		selectChildOption(minors, option);

	}

	public void submmitSearch() {

		submitSearchButton.click();

	}

	// Other methods

	public void waitForHotelSuboption() {
		wait(hotelSubMenu);
	}

	public void selectHotelSubmenuOption(String type, String location) {

		WebElement newOptionSelector = driver.findElement(
				By.xpath("//div[@data-au='" + type + "']/div[@data-au='entity'][contains(.,'" + location + "')]"));
		newOptionSelector.click();

	}

	public void selectSpecificMonthFrom(String month) {

		while (!calendarTitleLocator.getText().equals(month)) {

			nextMonthButton.click();
		}
	}

	public void selectSpecificMonthTo(String month) {

		// checkoutDateSelector.click();

		while (!calendarTitleLocator.getText().equals(month)) {
			nextMonthButton.click();

		}
	}

	// On accomodation calendar both dates should be selected in the same method
	public void selectSpecificDate(String dateFrom, String dateTo) {

		driver.findElement(
				By.xpath("//table[@class='calendar-table']//button[@class='calendar-button']/*[.='" + dateFrom + "']"))
				.click();

		driver.findElement(
				By.xpath("//table[@class='calendar-table']//button[@class='calendar-button']/*[.='" + dateTo + "']"))
				.click();

	}

	public void openPassengersDropdown() {

		guestInputDropdown.click();
		this.wait(guestInputDropdown);
	}

	public void addAdultPassengers(int adults) {

		int controlNumber = 0;

		if (adults == 1) {

			subAdultButton.click();

		} else {

			while (controlNumber != adults - 2) {
				addAdultButton.click();
				controlNumber++;
			}

		}

	}

	public void addMinorPassengers(int minors) {
		int controlNumber = 0;

		if (minors != 0) {
			while (controlNumber != minors) {
				addMinorButton.click();
				controlNumber++;
			}

		}

	}

	public void addRooms(int rooms) {

		int controlNumber = 0;

		while (controlNumber != rooms - 1) {
			addRoomButton.click();
			controlNumber++;
		}

	}

	public void selectChildOption(int childNumber, int option) {

		for (int i = 1; i <= childNumber; i++) {

			WebElement newChildDropdown = driver
					.findElement(By.cssSelector("select[data-au='age-child-0']:nth-of-type(" + i + ")"));
			Select dropDown = new Select(newChildDropdown);
			newChildDropdown.click();
			dropDown.selectByIndex(option);
		}

		childDoneButton.click();

	}

	public void waitForMinorSubmenu() {
		this.wait(childDoneButton);
	}

	@Override
	public void getUrl() {
		// TODO Auto-generated method stub

	}

}
