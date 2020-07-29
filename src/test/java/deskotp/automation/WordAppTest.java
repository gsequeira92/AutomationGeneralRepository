package deskotp.automation;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.appium.*;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.sikuli.basics.Settings;
import org.sikuli.basics.proxies.OCRText;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.OCR;
import org.sikuli.script.OCR.Options;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.TextRecognizer;
import org.openqa.selenium.winium.DesktopOptions;

public class WordAppTest {

	WiniumDriver driver = null;
	static WiniumDriverService service = null;
	static DesktopOptions options = null;
	Screen myScreen;
	public XpathReceiver tool;

	@BeforeClass
	public static void setUp() throws MalformedURLException {

		options = new DesktopOptions();
		// options.setDebugConnectToRunningApp(true);
		options.setApplicationPath("C:\\Users\\gsequeira\\Desktop\\fullImage.jpeg");
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
	public void startDriver() {
		driver = new WiniumDriver(service, options);
		// driver.manage().window().maximize();
		myScreen = new Screen();

	}

	public void takeScreenshot(WiniumDriver driver, String name) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\gsequeira\\Desktop\\Screenshots\\Others\\" + name + ""));
	}

	@After
	public void stopDriver() throws Exception {
		// driver.close();

	}

	@AfterClass
	public static void tearDown() {
		service.stop();
	}

//	@Test
//	public void testLocalSave() throws FindFailed {
//
//		boolean testResult = false;
//		Pattern wordOpenButton = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\wordOpenButton.png");
//		Screen myScreen = new Screen();
//
//		driver.findElementByName("Open").click();
//		driver.findElementByName("Browse").click();
//		driver.findElementByName("File name:").sendKeys("Test local save");
//		myScreen.click(wordOpenButton);
//		driver.findElementByName("Page 1 content").sendKeys("This is another test!");
//		driver.findElementByName("Save").click();
//		driver.findElementByName("File Tab").click();
//		driver.findElementByXPath("//*[@AutomationId='NavBarMenu']//*[@Name='Close']").click();
//		driver.findElementByName("File Tab").click();
//		driver.findElementByName("Open").click();
//		driver.findElementByName("Browse").click();
//		driver.findElementByName("File name:").sendKeys("Test local save");
//		myScreen.click(wordOpenButton);
//
//		if (driver.findElementByName("Page 1 content").getText().equals("This is another test!")) {
//			testResult = true;
//
//		}
//
//		Assert.assertTrue(testResult);
//
//	}

//	@Test
//	public void testLocalSaveAs() throws FindFailed, IOException {
//
//		// Patterns
//		Screen myScreen = new Screen();
//		Pattern wordOpenButton = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\wordOpenButton.png");
//
//		// Word app elements with actions
//		driver.findElementByName("Blank document").click();
//		driver.findElementByName("Page 1 content").sendKeys("Gastón Sequeira");
//		driver.findElementByName("File Tab").click();
//		driver.findElementByName("Save As").click();
//		driver.findElementByName("Browse").click();
//		driver.findElementByName("File name:").sendKeys("Test local saveAs");
//		driver.findElementByName("Save").click();
//
//		// If saved file already exists:
//		WebElement modal = driver.findElementByName("Microsoft Word");
//		if (modal.isDisplayed()) {
//			driver.findElementByName("OK").click();
//		}
//
//		driver.findElementByName("File Tab").click();
//		driver.findElementByXPath("//*[@AutomationId='NavBarMenu']//*[@Name='Close']").click();
//		driver.findElementByName("File Tab").click();
//		driver.findElementByName("Open").click();
//		driver.findElementByName("Browse").click();
//		driver.findElementByName("File name:").sendKeys("Test local saveAs");
//		// driver.findElementByXPath("//*[@LocalizedControlType='dialog']//*[@Name='Open']").click();
//		takeScreenshot(driver, "testLocalSaveAs.png");
//		myScreen.click(wordOpenButton);
//		driver.findElementByName("Page 1 content").sendKeys("This test is finished!");
//		driver.findElementByName("Save").click();
//		Assert.assertEquals("This test is finished!", driver.findElementByName("Page 1 content").getText().trim());
//
//	}

//	@Test
//	public void testInsertAnHyperlink() throws FindFailed {
//
//		Actions act = new Actions(driver);
//		Screen myScreen = new Screen();
//		Pattern lookIn = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\lookInComboBox.png");
//		Pattern desktop = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\desktopIcon.png");
//		Pattern downArrow = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\downArrow.png");
//		Pattern document = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\hyperLinkDocument.png");
//		Pattern textBoxToDisplay = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\textToDisplay.png");
//		Region textBoxToDisplay1;
//
//		// textBoxToDisplay1;
//
//		driver.findElementByName("Blank document").click();
//		driver.findElementByName("Insert").click();
//		driver.findElementByName("Link").click();
//		myScreen.click(lookIn);
//		myScreen.click(desktop);
//		for (int e = 0; e <= 8; e++) {
//			myScreen.click(downArrow);
//		}
//		myScreen.doubleClick(document);
//		Assert.assertEquals("Hey, this is an hyperlink test!",
//				driver.findElementByName("Page 1 content").getText().trim());
//
//	}

	@Test
	public void openSpecificFile() throws Exception {

		// SCREEN METHODS AND USES
		// Screen myScreen = new Screen(0);
		// Screen myScreen = new Screen();

//		Region sc = new Screen(0);
//		sc.findText("CLIP");

//		System.out.println(OCR.readLine(thisThing));
//		System.out.println(OCR.readText(thisThing));
//		// Settings.SwitchToText = true;
//
//		System.out.println(thisThing);
//		System.out.println(thisThing.text());
		// thisThing.findText("");

		// Match readText = null;

//
//		Region fullRegion = myScreen;
//
//		try {
//
//			Match readText = null;
//
//			List<Match> matchedIterate = fullRegion.findAllText("CLIP");
//			if (matchedIterate != null) {
//
//			}
//
//		} catch (Exception e) {
//
//		}

		// PATTERN METHODS AND USES

		// Pattern class is used for match tests and data
		// Seteado de similaridad
		Screen myScreen = new Screen(0);
		Settings.MinSimilarity = 0.50;// 0.7 Default
		Settings.WaitScanRate = 0.3f; // Default
		Settings.ObserveScanRate = 0.3f; // Default
		Settings.OcrTextRead = true;
		Settings.OcrTextSearch = true;

		try {

			Pattern cuttedImage = new Pattern("C:\\Users\\gsequeira\\Desktop\\cuttedImageModified.png");
			Pattern infoButton = new Pattern("C:\\Users\\gsequeira\\Desktop\\fileInfoButton.png");
			Pattern newTab = new Pattern("C:\\Users\\gsequeira\\Desktop\\secondRegion.png");

			Region expectedRegion = myScreen.exists(cuttedImage);

			if (null != expectedRegion) {

				expectedRegion.rightClick(cuttedImage);
				myScreen.click(infoButton);
				System.out.println("Matching score is:" + expectedRegion.find(new Pattern(cuttedImage)).getScore());

				Region leftTab = myScreen.exists(newTab);

				if (null != leftTab) {

					System.out.println(leftTab.text());
					Match matchSaver = myScreen.find("This");

					Region newRegion = matchSaver;
					// Region newRegion1= new Region(newRegion.getX(), newRegion.getY(),
					// newRegion.getH(), newRegion.getW());

					// System.out.println(matchSaver);
					myScreen.doubleClick(newRegion);
					System.out.println("Punto X:" + matchSaver.getX());
					System.out.println("High:" + matchSaver.getH());
					System.out.println("Punto Y:" + matchSaver.getY());
					System.out.println("Width:" + matchSaver.getW());

					System.out.println(leftTab.getX());
					System.out.println(leftTab.getY());
					System.out.println(leftTab.getH());
					System.out.println(leftTab.getW());

				}

			} else {
				System.out.println("Error with similarity or image doesn't exists");
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	// REGION METHODS AND USES

//		int h = 0;
//		int w = 0;
//		int x = 0;
//		int y = 0;
//
//		// Toma toda la pantalla y la coloca en una variable "FullRegion"
//		Region fullRegion = new Screen(0);
//
//		try {
//
//			Match singleMatch = null;
//
//			List<Match> matchedIterate = fullRegion.findAllText("Hey this is a test!");
//			if (matchedIterate.size() > 0) {
//				singleMatch = matchedIterate.get(0);
//				System.out.println(singleMatch.getX());
//				System.out.println(singleMatch.getY());
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		// Captura de pantalla y salvado usando region
//		Region currentRegion = new Screen(0);
//		// Por parametro se pasa una carpeta contenedora o un path
//		currentRegion.saveCapture("captured_image");
//
//		// Seteado de coordenadas
//		currentRegion = new Screen(0).setRect(50, 60, 200, 100);
//
//		// Seteado de coordenadas para tomar un screenshot especifico
//		currentRegion.setSize(300, 400);
//		currentRegion.saveCapture("captured_image");
//
//		// Drag and drop usando region
//		// Se setean las regiones
//		Region oneRegion = new Screen(0).setRect(100, 200, 50, 50);
//		Region otherRegion = new Screen(0).setRect(300, 400, 90, 90);
//
//		try {
//			currentRegion.dragDrop(oneRegion, otherRegion);
//		} catch (Exception e) {
//		}
//
//		// Capturar screenshots por columnas
//
//		Region currentNewRegion = new Screen(0);
//
//		try {
//			int totalColn = 7;
//
//			for (int i = 0; i < totalColn; i++) {
//
//				Region tempRegion = currentRegion.getCol(i, totalColn);
//				tempRegion.saveCapture("captured_image");
//			}
//
//		} catch (Exception e) {
//		}
//
//		// Getters de los 4 puntos de la pantalla completa
//
//		h = fullRegion.getH();
//		w = fullRegion.getW();
//		x = fullRegion.getX();
//		y = fullRegion.getY();
//
//		// Envia la pantalla de seleccion y asigna la seleccion a una variable "region"
//		Region region = myScreen.selectRegion();
//
//		// Enviar una pantalla especificando los 4 puntos por parametro.
//		Region smallRegion = new Screen(0).setRect(1, 1, 1, 1);

//		region.click();
//		region.doubleClick();
//		region.highlight(2);

//		Pattern wordOpenButton = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\wordOpenButton.png");
//		Pattern title = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\Title.png");
//		Pattern heading1 = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\heading1.png");
//		Pattern heading2 = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\heading2.png");
//		Pattern normalText = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\normalText.png");
//		Pattern wordScreen = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\wordScreen.png");
//		String file = "First test title.docx";
//		driver.findElementByName("Open").click();
//		driver.findElementByName("Browse").click();
//		driver.findElementByName("File name:").sendKeys(file);
//		myScreen.click(wordOpenButton);
//		Thread.sleep(4);

}

//	@Test
//	public void testVersionCheck() throws FindFailed, IOException {
//
//		driver.findElementByName("Account").click();
//// 51-64
//		Assert.assertEquals("Version 1908 (Build 11929.20562 Click-to-Run)",
//				driver.findElementByName("Version 1908 (Build 11929.20562 Click-to-Run)"));
