package stepDefinitions;

import org.openqa.selenium.WebDriver;
import commons.AbstractTest;


import commons.PageFactoryManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.HomePagePO;

public class HomePageSteps {
	WebDriver driver;
	private HomePagePO homePage;
	private AbstractTest abstractTest;
	
	public HomePageSteps() {
		driver = Hooks.openBrowser();
		homePage = PageFactoryManager.getHomePage(driver);
		abstractTest = new AbstractTest();

	}
	
	@Then("^I verify homepage welcome message displayed$")
	public void iVerifyHomepageWelcomeMessageDisplayed()  {
	    abstractTest.verifyTrue(homePage.isWelcomeMessageDisplayed());
	}
	
	@When("^I input (first|second|third) Account ID$")
	public void iInputAccountID(String account) {
		if(account.equalsIgnoreCase("first")) {
			//transactionPage.inputAccountNo(ShareData.firstAccount);
		}else if(account.equalsIgnoreCase("second")) {
			//transactionPage.inputAccountNo(ShareData.secondAccount);
		}else {
			//transactionPage.inputAccountNo(ShareData.thirdAccount);
		}
	}
	
	@When("^I (?:transfer|withdraw) to \"(.*?)\" USD$")
	public void iTransferToSothingUSD(String amount) {
		//transactionPage.inputAmount(amount);
	}

}
