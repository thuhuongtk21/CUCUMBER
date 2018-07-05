package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUI;

public class HomePagePO extends AbstractPage {
	WebDriver driver;
	
	public HomePagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public boolean isWelcomeMessageDisplayed(String message) {
		
		waitForControlVisible(driver, HomePageUI.WELCOM_MESSAGE, message);
		return isControlDisplayed(driver, HomePageUI.WELCOM_MESSAGE, message);
	}

	

}
