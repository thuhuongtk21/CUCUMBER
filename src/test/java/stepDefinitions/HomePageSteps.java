package stepDefinitions;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import pages.HomePagePO;

public class HomePageSteps {
	private HomePagePO homePage;
	private AbstractTest abstractTest;
	
	@Then("^I verify homepage welcome message displayed$")
	public void iVerifyHomepageWelcomeMessageDisplayed()  {
	    abstractTest.verifyTrue(homePage.isWelcomeMessageDisplayed());
	}

}
