package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractTest;

import commons.PageFactoryManager;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.CommonPagePO;
import pages.DeleteAccountPO;
import pages.DeleteCustomerPagePO;
import pages.DepositPO;
import pages.EditAccountPO;
import pages.EditCustomerPagePO;
import pages.HomePagePO;
import pages.NewAccountPO;
import pages.NewCustomerPagePO;

public class CommonPageSteps {
	WebDriver driver;
	private CommonPagePO commonPage;
	private AbstractTest abstractTest;
	private HomePagePO homePage;
	private NewCustomerPagePO newCustomerPage;
	private EditCustomerPagePO editCustomerPage;
	private DeleteCustomerPagePO deleteCustomerPage;
	private NewAccountPO newAccountPage;
	private EditAccountPO editAccountPage;
	private DeleteAccountPO deleteAccountPage;
	private DepositPO depositPage;
	private AbstractPage abstractPage;

	public CommonPageSteps() {
		driver = Hooks.openBrowser();
		commonPage = PageFactoryManager.getCommonPage(driver);
		abstractTest = new AbstractTest();

	}

	@When("^I click to \"(.*?)\" button$")
	public void iClickToDynamicButton(String buttonName) {
		commonPage.clickToDynamicButton(buttonName);
	}
	
	@When("^I click to \"(.*?)\" radio button with data \"(.*?)\"$")
	public void iClickToDynamicRadioButtonWithDynamicValue(String radioButtonName, String value) {
	    
	    commonPage.clickToDynamicRadioButtonWithDynamicValue(radioButtonName, value);
	}

	@When("^I input to \"(.*?)\" textbox with data \"(.*?)\"$")
	public void iInputToDynamicTextboxWithDynamicData(String textboxName, String value) {
		commonPage.inputToDynamicTextbox(textboxName, value);
	}

	@When("^I verify expected data at \"(.*?)\" textbox with actual data \"(.*?)\"$")
	public void iVerifyExpectedDataWithActualData(String textboxName, String actualValue) {
		String expectedValue = commonPage.getDynamicValueInDynamicTextbox(textboxName, "value"); // "value" is in xpath
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@When("^I verify expected data at \"(.*?)\" text in table with actual data \"(.*?)\"$")
	public void iVerifyExpectedDataAtTextInTableWithActualData(String textInTableName, String actualValue) {
		String expectedValue = commonPage.getDynamicValueInDynamicTextAtTable(textInTableName); 
		abstractTest.verifyEquals(actualValue, expectedValue);
	}
	
	@When("^Verify created or edited successfully with message \"(.*?)\"$")
	public void iVerifyCreatedOrEditedSuccessfullyWithDynamicMessage(String messageName) {
		abstractTest.verifyTrue(commonPage.isCreatedOrEditedSuccessMessageDisplayed(messageName));
	}
	
	@When("^I input to \"(.*?)\" textbox with random data \"(.*?)\"$")
	public void iInputToDynamicTextboxWithRandomData(String textboxName, String value) {
		value = abstractTest.randomNumber() + value;
	    commonPage.inputToDynamicTextbox(textboxName, value);
	    
	}
	
	@When("^I input to \"(.*?)\" textarea with data \"(.*?)\"$")
	public void iInputToTextareaWithData(String textareaName, String value) {
	    commonPage.inputToDynamicTextareaWithDynamicData(textareaName, value);
	    
	}
	
	@When("^I select value is \"(.*?)\" in dropdown list \"(.*?)\"$")
	public void iSelectDynamicValueInDynamicDropdownList(String value, String dropdownListName) {
		commonPage.selectDynamicValueInDynamicDropdownList(value, dropdownListName);
	}

	@When("^I open \"(.*?)\" page$")
	public void iOpenDynamicPage(String dynamicPage) {
		switch (dynamicPage) {
		case "New Customer":
			newCustomerPage = abstractPage.openNewCustomerPage(driver);
			break;
		case "Edit Customer":
			editCustomerPage = abstractPage.openEditCustomerPage(driver);
			break;
		case "Delete Customer":
			deleteCustomerPage = abstractPage.openDeleteCustomerPage(driver);
			break;
		case "New Account":
			newAccountPage = abstractPage.openNewAccountPage(driver);
			break;
		case "Edit Account":
			editAccountPage = abstractPage.openEditAccountPage(driver);
			break;
		case "Delete Account":
			deleteAccountPage = abstractPage.openDeleteAccountPage(driver);
			break;
		case "Deposit":
			depositPage = abstractPage.openDepositPage(driver);
			break;
		default:
			homePage = abstractPage.openHomePage(driver);
			break;
		}

	}

}
