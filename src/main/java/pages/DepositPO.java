package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DepositPageUI;

public class DepositPO extends AbstractPage {
	WebDriver driver;
	
	public DepositPO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void inputDataToAccountNumber(String accountID) {
		waitForControlVisible(driver, DepositPageUI.ACCOUNT_NO);
		sendKeyToElement(driver, DepositPageUI.ACCOUNT_NO, accountID);
	}
	

}
