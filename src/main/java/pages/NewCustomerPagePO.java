package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewCustomerPageUI;

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
