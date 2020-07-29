package deskotp.automation;

import static org.junit.Assert.*;

import java.awt.RenderingHints.Key;
import java.net.*;
import java.util.concurrent.TimeUnit;

import io.appium.*;

import org.apache.tools.ant.taskdefs.Input;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.windows.WindowsDriver;

public class SkypeForBusinessAutomation {

	public WindowsDriver driver = null;

	@Before
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "C:/Program Files/Microsoft Office/root/Office16/lync.exe");
		driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		Actions act = new Actions(driver);

		act.doubleClick(driver.findElementByName("Elia, Ignacio")).build().perform();
		act.sendKeys("testing text").build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		// Screen screen = new Screen();
		// Pattern send = new
		// Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\sendMessage.png");

		// screen.click(send);

		// act.sendKeys(driver.findElementByAccessibilityId("idAutomationChatInput"),
		// "Chichoooo").build().perform();
		// ;
		// driver.findElementByName("Send").click();

	}

}
