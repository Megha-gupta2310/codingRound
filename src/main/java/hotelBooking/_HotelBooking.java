package hotelBooking;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class _HotelBooking {
	WebDriver driver;

	public _HotelBooking(WebDriver driver) {
		this.driver = driver;
	}

	private static final String HOTELLINK = "//a[text()='Hotels']";
	private static final String LOCALITYTEXTBOX = "Tags";
	private static final String SEARCHBUTTON = "SearchHotelsButton";
	private static final String TRAVELLERSHOME = "travellersOnhome";

	@FindBy(xpath = HOTELLINK)
	private WebElement hotelLink;

	@FindBy(id = LOCALITYTEXTBOX)
	private WebElement localityTextBox;

	@FindBy(id = SEARCHBUTTON)
	private WebElement searchButton;

	@FindBy(id = TRAVELLERSHOME)
	private WebElement travellerSelection;

	public _HotelBooking clickOnhotelLink() {
		waitFor(5000);
		hotelLink.click();
		return this;
	}

	public _HotelBooking enterLocalityTextBox() throws InterruptedException {
		WebElement element = localityTextBox;
		element.sendKeys("Indiranagar, Bangalore");
		waitFor(2000);
		element.sendKeys(Keys.TAB);
		return this;
	}

	public _HotelBooking enterTraveleersSelection() {
		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		return this;
	}

	public _HotelBooking clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}
	
	

}