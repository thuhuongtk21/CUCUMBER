package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewCustomerPageUI;

public class NewCustomerPagePO extends AbstractPage {
	WebDriver driver;
	
	public NewCustomerPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void inputDataForName(String value) {
		waitForControlVisible(driver, NewCustomerPageUI.NAME_TXT);
		sendKeyToElement(driver, NewCustomerPageUI.NAME_TXT, value);
	}
	
	public void inputDataForGender() {
		
	}
	
	public void inputDataForDateOfBirth() {
		
	}
	
	public void inputDataForAddress() {
		
	}
	
	public void inputDataForCity() {
		
	}
	
	public void inputDataForState() {
		
	}
	
	public void inputDataForPin() {
		
	}
	
	public void inputDataForPhone() {
		
	}
	

}
