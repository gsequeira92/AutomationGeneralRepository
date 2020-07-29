package deskotp.automation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.Assert;

public class ExcelAutomation {

	WiniumDriver driver = null;
	static WiniumDriverService service = null;
	static DesktopOptions options = null;

	public static List<List<String>> traspose(List<List<String>> original) {
		List<List<String>> trasposed = new ArrayList<>();
		int rows = original.size();

		int cols = 0;
		for (List<String> originalRow : original) {
			cols = Math.max(cols, originalRow.size());
		}

		for (int col = 0; col < cols; ++col) {
			List<String> trasposedCol = new ArrayList<>(rows);
			for (int row = 0; row < rows; ++row) {
				List<String> originalRow = original.get(row);
				if (originalRow.size() > col) {
					trasposedCol.add(originalRow.get(col));
				} else {
					trasposedCol.add(null);
				}
			}
			trasposed.add(trasposedCol);
		}
		return trasposed;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		options = new DesktopOptions();
		// options.setDebugConnectToRunningApp(true);
		options.setApplicationPath("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE");
		File driverPath = new File(
				"C:\\Users\\gsequeira\\Desktop\\WindowsAutomation\\AutomationTools2\\UIautomationVerify\\Winium\\Winium.Desktop.Driver.exe");
		System.setProperty("webdriver.winium.desktop.driver",
				"C:\\Users\\gsequeira\\Desktop\\WindowsAutomation\\AutomationTools2\\UIautomationVerify\\Winium\\Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
				.withSilent(false).buildDesktopService();

		try {
			service.start();
		} catch (IOException e) {
			System.out.println("Exception while starting WINIUM service");
			e.printStackTrace();
		}

	}

	@Before
	public void startDriver() throws Exception {
		driver = new WiniumDriver(service, options);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() {

		Actions act = new Actions(driver);
		List<List<String>> matrix = Arrays.asList(Arrays.asList("a1", "b1", "c1", "d1"),
				Arrays.asList("a2", null, "c2", "d2"), Arrays.asList("a3", "b3", null, "d3"), Arrays.asList("a4"));

		driver.findElementByName("Blank workbook").click();
		WebElement formulaBar = driver.findElementByName("Formula Bar");

		System.out.println(traspose(matrix));

		List<List<String>> trasposed = traspose(matrix);
		for (int colN = 0; colN < trasposed.size(); ++colN) {
			List<String> col = trasposed.get(colN);
			driver.findElementByName("\"" + (char) (colN + 65) + "\" 1").click();
			for (int rowN = 0; rowN < col.size(); ++rowN) {
				String cel = col.get(rowN);
				if (cel == null) {
					formulaBar.sendKeys(Keys.ENTER);
				} else {

					act.sendKeys(formulaBar, cel).sendKeys(Keys.ENTER).build().perform();
				}
			}
		}

		Assert.assertTrue(true);
	}

}
