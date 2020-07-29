package mercado.libre.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercadoLibreHomePage extends Base {

	public MercadoLibreHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(css = "input.nav-search-input")
	WebElement searchBarInput;

	@FindBy(css = "i.nav-icon-cart")
	WebElement myCartIcon;

	@FindBy(css = "div.nav-icon-search")
	WebElement goTosearchIcon;

	@FindBy(css = "a#registration")
	WebElement createAccount;

	@FindBy(css = "a#login")
	WebElement loginAccount;

	@FindBy(xpath = "//a[@class='nav-menu-item-link'][.='Historial']")
	WebElement goToHistory;

	// Test methods

	public void searchForProduct(String product) {

		searchBarInput.click();
		searchBarInput.sendKeys(product);
		goTosearchIcon.click();

	}

	public void goToMyCart() {
		myCartIcon.click();
	}

	public void goToHistoryRecord() {
		goToHistory.click();
	}

	@Override
	public void getUrl() {

	}

}
