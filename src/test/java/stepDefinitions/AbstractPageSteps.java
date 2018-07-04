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

public class AbstractPageSteps {
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

	public AbstractPageSteps() {
		driver = Hooks.openBrowser();
		commonPage = PageFactoryManager.getCommonPage(driver);
		abstractTest = new AbstractTest();

	}

	@When("^I click to \"(.*?)\" button$")
	public void iClickToDynamicButton(String buttonName) {
		commonPage.clickToDynamicButton(buttonName);
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
	
	@When("^I input to \"(.*?)\" textbox with random data \"(.*?)\"$")
	public void iInputToDynamicTextboxWithRandomData(String textboxName, String value) {
		value = value + abstractTest.randomNumber();
	    commonPage.inputToDynamicTextbox(textboxName, value);
	    
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
