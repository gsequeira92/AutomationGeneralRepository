package deskotp.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WordAutomation {

	public static void main(String[] args) throws Exception {

		// Screen class - Focus on screen

		Screen screen = new Screen();

		// Pattern class - Find images

		Pattern wordIcon = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\word.png");
		Pattern blankDocument = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\blankDocument.png");
		Pattern documentPage = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\blankPage.png");
		Pattern saveIcon = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\saveIcon.png");
		Pattern fileNameTextBox = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\fileNameBox.png");
		Pattern saveDocumentConfirmBtn = new Pattern(
				"C:\\Users\\gsequeira\\Desktop\\Screenshots\\saveDocumentConfirm.png");
		Pattern closeWindowsBtn = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\closeWindowButton.png");
		Pattern okButtonReplaceModal = new Pattern("C:\\Users\\gsequeira\\Desktop\\Screenshots\\okReplaceFile.png");

		// TEST

		screen.wait(wordIcon, 10);
		screen.click(wordIcon);
		screen.wait(blankDocument, 20);
		screen.click(blankDocument);
		screen.wait(documentPage, 5);
		screen.type(documentPage, "this is a test!!!");
		screen.click(saveIcon);
		//screen.doubleClick(fileNameTextBox);
		screen.type(fileNameTextBox, "testDocument");
		screen.click(saveDocumentConfirmBtn);
		screen.wait(closeWindowsBtn, 10);
		screen.click(okButtonReplaceModal);
		screen.click(closeWindowsBtn);

	}

}
