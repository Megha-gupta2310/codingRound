package util;

import java.io.File;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
        public WebDriver driver;
	
        
        @BeforeTest
	public void beforeTest() {
		setDriverPath();
		driver.get("https://www.cleartrip.com/");
		waitFor(2000);
		driver.manage().window().maximize();

	}
	
	@AfterTest
	public void afterTest() {
		waitFor(2000);
		driver.quit();
	}
	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	protected void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
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



