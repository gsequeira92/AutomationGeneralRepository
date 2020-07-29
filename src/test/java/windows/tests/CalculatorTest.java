package windows.tests;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.appium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.*;

import io.appium.java_client.windows.WindowsDriver;

public class CalculatorTest {

	private static WindowsDriver driver = null;
	private static WebElement CalculatorResult = null;

	@Before
	public void setUp() {
		try {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			CalculatorResult = driver.findElementByAccessibilityId("CalculatorResults");
			Assert.assertNotNull(CalculatorResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		CalculatorResult = null;
		if (driver != null) {
			driver.quit();
		}
		driver = null;
	}

	// Addition with 3 + 7
	@Test
	public void addition() {
		System.out.println("-----Addition test----");
		driver.findElementByName("Three").click();
		driver.findElementByName("Plus").click();
		driver.findElementByName("Seven").click();
		driver.findElementByName("Equals").click();

		Assert.assertEquals("10", getCalculatorResult());
	}

	private String getCalculatorResult() {

		String result = CalculatorResult.getText().replace("Display is", "").trim();
		System.out.println("Final result is-------------" + result);

		return result;
	}

}
