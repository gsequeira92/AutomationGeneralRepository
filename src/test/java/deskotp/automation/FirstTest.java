package deskotp.automation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public WebDriver driver;

	@Before
	public void setUp() throws FindFailed {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https:\\www.google.com");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {

		driver.quit();
	}

	@Test
	public void test() throws Exception {

		Screen screen = new Screen();

		// Pattern class - Find images

		// Pattern image1 = new
		// Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\gmail-logo.png");
		Pattern image2 = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\username.png");
		Pattern image3 = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\password.png");
		Pattern image4 = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\signin.png");
		Pattern image5 = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\start.png");

		// TEST

		// screen.wait(image1, 10);
		screen.click(image5);
		screen.type(image2, "gibsgaston@gmail.com");
		screen.click(image4);
		screen.type(image3, "decuajo2019");
		screen.click(image4);

		Assert.assertTrue(true);
	}

}
