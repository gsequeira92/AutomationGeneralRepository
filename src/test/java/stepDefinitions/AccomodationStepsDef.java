package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Test.Olenick.AlMundo.AlMundoAccommodationPage;
import Test.Olenick.AlMundo.AlMundoHotelResultsPage;
import Test.Olenick.AlMundo.HotelBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccomodationStepsDef {

	public WebDriver driver;
	AlMundoAccommodationPage accomodationPage;
	AlMundoHotelResultsPage hotelResultsPage;
	HotelBuilder createdHotel = new HotelBuilder();

	@Given("^the user is at AlMundo hotel page$")
	public void the_user_is_at_AlMundo_hotel_page() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://almundo.com.ar/hoteles");
		accomodationPage = new AlMundoAccommodationPage(driver);

	}

	@Given("^the location \"([^\"]+)\" is set to \"([^\"]+)\"$")
	public void the_location_is_set_to(String type, String destination) {

		createdHotel.hotelTypeFrom(type).hotelLocation(destination);

	}

	@Given("^the entire date for arrival is \"([^\"]+)\"$")
	public void the_entire_date_for_arrival_is(String date) {

		createdHotel.hotelMonthFrom(date);

	}

	@Given("^the stay starts day \"([^\"]+)\"$")
	public void the_stay_starts_day(String day) {

		createdHotel.dateFrom(day);

	}

	@Given("^the entire date for leaving is \"([^\"]+)\"$")
	public void the_entire_date_for_leaving_is(String date) {

		createdHotel.hotelMonthTo(date);

	}

	@Given("^the stay ends day \"([^\"]+)\"$")
	public void the_stay_ends_day(String day) {
		createdHotel.dateTo(day);

	}

	@Given("^the room number is set to \"(\\d+)\"$")
	public void the_room_number_is_set_to(int rooms) {

		createdHotel.numberOfRooms(rooms);

	}

	@Given("^the adult guests are \"(\\d+)\"$")
	public void the_adult_guests_are(int adults) {
		createdHotel.adultNumber(adults);

	}

	@Given("^the children guests are \"(\\d+)\"$")
	public void the_children_guests_are(int children) {
		createdHotel.childNumber(children);

	}

	@Given("^the child age option is \"(\\d+)\"$")
	public void the_child_age_option_is(int option) {
		createdHotel.childAgeOption(option);
	}

	@When("^the search button is clicked$")
	public void the_search_button_is_clicked() {

		accomodationPage.searchForAccommodation(createdHotel.build());

	}

	@Then("^the hotel results page is displayed$")
	public void the_hotel_results_page_is_displayed() {

		hotelResultsPage = new AlMundoHotelResultsPage(driver);
		assertTrue(hotelResultsPage.isDisplayed());
		driver.quit();

	}

}
