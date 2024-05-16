package sit707_week2;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation
 * https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {
	static WebDriver driver;

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SeleniumOperations() {

		System.setProperty("webdriver.chrome.driver",
				"D:/Deakin/Uni/2024 Tri 1/SIT707 - Software Quality And Testing/chromedriver-win64/chromedriver.exe");
		System.out.println("Fire up chrome browser.");
		driver = new ChromeDriver();
	}

	public static String bunnings_registration_page(String email, String password) {
		System.out.println("Driver info: " + driver);
		String url = "https://www.bunnings.com.au/login";
		// Load a webpage in chromium browser.
		driver.get(url);
		sleep(2);
		// Find first input field which is Email
		WebElement emailelement = driver.findElement(By.id("okta-signin-username"));
		System.out.println("Found element: " + emailelement);
		// Enter Email
		emailelement.sendKeys(email);

		// Find input field Password
		WebElement pass = driver.findElement(By.id("okta-signin-password"));
		System.out.println("Found element: " + pass);
		// Enter Password name
		pass.sendKeys(password);

		WebElement signin = driver.findElement(By.id("okta-signin-submit"));
		System.out.println("Found element: " + signin);
		// Click Signin Button
		signin.click();
		sleep(2);

		if (driver.getCurrentUrl().contains(url)) {
			return "Login fails";

		} else {

			return "Login succeed";

		}

	}

	public void driverclose() {
		driver.close();
	}

	public static void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				"D:\\Deakin\\Uni\\2024 Tri 1\\SIT707 - Software Quality And Testing\\OnTrack\\2.1P - Pass Task - Selenium test case\\2.1P-resources\\office_works_login.png"));

	}
}
