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
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation
 * https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void officeworks_registration_page(String url) throws IOException {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver",
				"D:\\Deakin\\Uni\\2024 Tri 1\\SIT707 - Software Quality And Testing\\chromedriver-win64\\chromedriver.exe");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load a webpage in chromium browser.
		driver.get(url);

		// Find and fill input fields using Relative Locators
		WebElement fName = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("lastname")));
		System.out.println("Found element: " + fName);
		fName.sendKeys("Vishuddha");

		WebElement lastname1 = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("firstname")));
		System.out.println("Found element: " + lastname1);
		lastname1.sendKeys("Samarasekara");

		WebElement phoneNumber = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("lastname")));
		System.out.println("Found element: " + phoneNumber);
		phoneNumber.sendKeys("0478244505");

		WebElement email = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("phoneNumber")));
		System.out.println("Found element: " + email);
		email.sendKeys("svishuddha@gmail.com");

		WebElement password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("email")));
		System.out.println("Found element: " + password);
		password.sendKeys("Ww2#444");

		WebElement confirmPassword = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("password")));
		System.out.println("Found element: " + confirmPassword);
		confirmPassword.sendKeys("Ww2#4444");
			
		WebElement Createaccount = driver.findElement(RelativeLocator.with(By.tagName("button")).below(By.id("confirmPassword")));
		System.out.println("Found element: " + Createaccount);
		// Click Create Account Button
		Createaccount.click();

		/*
		 * Take screenshot using selenium API.
		 */
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				"D:\\Deakin\\Uni\\2024 Tri 1\\SIT707 - Software Quality And Testing\\OnTrack\\2.2C - Credit Task - Selenium relative locator API\\office_works_login.png"));

		// Sleep a while
		sleep(2);

		// close chrome driver
		driver.close();
	}

}
