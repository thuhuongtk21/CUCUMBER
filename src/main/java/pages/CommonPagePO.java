package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import interfaces.CommonPageUI;

public class CommonPagePO extends AbstractPage {
	WebDriver driver;
	
	public CommonPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void clickToDynamicButton(String buttonName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_BUTTON, buttonName);
		clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON, buttonName);
	}
	
	public void clickToDynamicRadioButtonWithDynamicValue(String radioButtonName, String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON, radioButtonName, value);
		clickToElement(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON, radioButtonName, value);
	}
	
	public void inputToDynamicTextbox(String textboxName, String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		sendKeyToElement(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, value);
	}
	
	public void clickToInDynamicDropdownListIcon(String dropdownListName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROPDOWN_LIST_ICON, dropdownListName);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROPDOWN_LIST_ICON, dropdownListName);
	}
	
	public void selectDynamicValueInDynamicDropdownList(String dropdownListName, String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_DROPDOWN_LIST_VALUE, dropdownListName);
		clickToElement(driver, CommonPageUI.DYNAMIC_DROPDOWN_LIST_VALUE, dropdownListName, value);
	}
	
	public void inputToDynamicTextareaWithDynamicData(String textareaName, String value) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTAREA, textareaName);
		sendKeyToElement(driver, CommonPageUI.DYNAMIC_INPUT_TEXTAREA, textareaName, value);
	}
	
	public String getDynamicValueInDynamicTextbox(String textboxName, String attributeName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName);
		return getAttributeValue(driver, CommonPageUI.DYNAMIC_INPUT_TEXTBOX, textboxName, attributeName);
		 
	}
	
	public String getDynamicValueInDynamicTextAtTable(String textInTableName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_TEXT_IN_TABLE, textInTableName);
		return getTextElement(driver, CommonPageUI.DYNAMIC_TEXT_IN_TABLE, textInTableName);
		 
	}
	
	public boolean isCreatedOrEditedSuccessMessageDisplayed(String messageName) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_MESSAGE, messageName);
		return isControlDisplayed(driver, CommonPageUI.DYNAMIC_MESSAGE, messageName);
	}
	
	/*Open Dynamic Page*/
	public HomePagePO openHomePage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Manager");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Manager");
		return PageFactoryManager.getHomePage(driver);
		
	}
	
	public NewCustomerPagePO openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		return PageFactoryManager.getNewCustomerPage(driver);
	}
	
	public EditCustomerPagePO openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		return PageFactoryManager.getEditCustomerPage(driver);
	}
	
	public DeleteCustomerPagePO openDeleteCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		return PageFactoryManager.getDeleteCustomerPage(driver);
	}
	
	public NewAccountPO openNewAccountPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "New Account");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "New Account");
		return PageFactoryManager.getNewAccountPage(driver);
	}
	
	public EditAccountPO openEditAccountPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Edit Account");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Edit Account");
		return PageFactoryManager.getEditAccountPage(driver);
	}
	
	public DeleteAccountPO openDeleteAccountPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Delete Account");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Delete Account");
		return PageFactoryManager.getDeleteAccountPage(driver);
	}
	
	public DepositPO openDepositPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Deposit");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Deposit");
		return PageFactoryManager.getDepositPage(driver);
	}
	
	public WithdrawalPO openWithdrawalPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		return PageFactoryManager.getWithdrawalPage(driver);
	}
	
	public FundTransferPO openFundTransferPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Fund Transfer");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Fund Transfer");
		return PageFactoryManager.getFundTransferPage(driver);
	}
	
	public ChangePasswordPO openChangePasswordPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Change Password");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Change Password");
		return PageFactoryManager.getChangePasswordPage(driver);
	}
	
	
	
	public MiniStatementPO openMiniStatementPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Mini Statement");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Mini Statement");
		return PageFactoryManager.getMiniStatementPage(driver);
	}
	
	public CustomisedStatementPO openCustomisedStatementPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Customised Statement");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Customised Statement");
		return PageFactoryManager.getCustomisedStatementPage(driver);
	}
	
	public LoginPagePO openLogOutPage(WebDriver driver) {
		waitForControlVisible(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Log out");
		clickToElement(driver, CommonPageUI.DYNAMIC_PAGE_LINK, "Log out");
		acceptAlert(driver);
		waitForControlVisible(driver, CommonPageUI.LOGIN_PAGE_FORM);
		return PageFactoryManager.getLoginPage(driver);
	}
}
