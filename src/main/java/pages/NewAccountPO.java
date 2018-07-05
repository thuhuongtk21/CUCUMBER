package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewAccountPageUI;

public class NewAccountPO extends AbstractPage {
	WebDriver driver;
	
	public NewAccountPO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void inputDataToCustomerID(String customerID) {
		waitForControlVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXT);
		sendKeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXT, customerID);
	}
	
	public String getAccountID() {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_ID_TEXT);
		return getTextElement(driver, NewAccountPageUI.ACCOUNT_ID_TEXT);
	}

}
