package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.When;
import interfaces.AbstractPageUI;
import interfaces.NewCustomerPageUI;
import stepDefinitions.ShareData;

public class NewCustomerPagePO extends AbstractPage {
	WebDriver driver;
	
	public NewCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public String getCustomerID() {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID_TEXTBOX);
	}
	
	
	


	

}
