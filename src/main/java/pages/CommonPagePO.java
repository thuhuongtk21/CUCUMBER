package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;
import interfaces.HomePageUI;

public class CommonPagePO extends AbstractPage {
	WebDriver driver;
	
	public CommonPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickToDynamicButton(String buttonName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonName);
	}
	
	public void inputToDynamicTextbox(String textboxName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		sendKeyToElement(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, value);
	}
	
	public String getDynamicValueInDynamicTextbox(String textboxName, String attributeName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		return getAttributeValue(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, attributeName);
		 
	}
}
