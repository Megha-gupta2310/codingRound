package hotelBooking;

import java.io.File;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest{
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		setDriverPath();
		driver.get("https://www.cleartrip.com/");
		waitFor(2000);
		driver.manage().window().maximize();

	}

	@Test(description = "1. Click on hotel Link \n" + "2.Click on Locality text box \n" + "3. Enter Travellers Selection"
			+ "4. Click on search button")
	public void shouldBeAbleToSearchForHotels() throws Exception {
		_HotelBooking flightBooking = PageFactory.initElements(driver, _HotelBooking.class);
		flightBooking.clickOnhotelLink().enterLocalityTextBox().enterTraveleersSelection().clickOnSearchButton();
	}
	
	
	
	 @AfterTest
	 public void afterClass() {
	 driver.quit();
	
	 }

	protected void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void setDriverPath() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			File file = new File("chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();

		} else if (osName.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		} else if (osName.contains("Linux")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}

}
