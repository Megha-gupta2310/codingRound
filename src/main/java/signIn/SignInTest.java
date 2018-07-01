package signIn;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.TestBase;

public class SignInTest extends TestBase {

       
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		driver.findElement(By.linkText("Your trips")).click();
		driver.findElement(By.id("SignIn")).click();
		waitFor(6000);
		driver.switchTo().frame(4);
		boolean isModalDisplayed = false;
		try {
			isModalDisplayed = driver.findElement(By.cssSelector(".modal .col .submit #signInButton")).isDisplayed();
		} catch (Exception e1) {
			isModalDisplayed = false;
		}
		if (isModalDisplayed) {
			driver.findElement(By.id("signInButton")).click();
			String errors1 = driver.findElement(By.id("errors1")).getText();
			Assert.assertTrue(errors1.contains("There were errors in your submission"));
		}else{
			System.out.println("No Pop up found");
		}
		
		
	}
	
//	@AfterTest
//	public void afterTest() {
//		waitFor(2000);
//		driver.quit();
//	}
//
//	private void waitFor(int durationInMilliSeconds) {
//		try {
//			Thread.sleep(durationInMilliSeconds);
//		} catch (InterruptedException e) {
//			e.printStackTrace(); // To change body of catch statement use File |
//									// Settings | File Templates.
//		}
//	}
//
//	public void setDriverPath() {
//		String osName = System.getProperty("os.name");
//		if (osName.contains("Windows")) {
//			File file = new File("chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//			driver = new ChromeDriver();
//
//		} else if (osName.contains("mac")) {
//			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
//		} else if (osName.contains("Linux")) {
//			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
//		}
//	}
//
}
