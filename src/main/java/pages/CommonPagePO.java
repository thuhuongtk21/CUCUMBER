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
	
	public void clickToDynamicRadioButtonWithDynamicValue(String radioButtonName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonName, value);
		clickToElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonName, value);
	}
	
	public void inputToDynamicTextbox(String textboxName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		sendKeyToElement(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, value);
	}
	
	public void selectDynamicValueInDynamicDropdownList(String value, String dropdownListName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, dropdownListName);
		selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, dropdownListName, value);
	}
	
	public void inputToDynamicTextareaWithDynamicData(String textareaName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTAREA, textareaName);
		sendKeyToElement(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTAREA, textareaName, value);
	}
	
	public String getDynamicValueInDynamicTextbox(String textboxName, String attributeName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		return getAttributeValue(driver, AbstractPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, attributeName);
		 
	}
	
	public String getDynamicValueInDynamicTextAtTable(String textInTableName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXT_IN_TABLE, textInTableName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TEXT_IN_TABLE, textInTableName);
		 
	}
	
	public boolean isCreatedOrEditedSuccessMessageDisplayed(String messageName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MESSAGE, messageName);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MESSAGE, messageName);
	}
}
