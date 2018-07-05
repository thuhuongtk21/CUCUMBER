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
	
	@Then("^I verify Homepage displayed with message \"(.*?)\"$")
	public void iVerifyHomepageWelcomeMessageDisplayed(String homepageMessage)  {
	    abstractTest.verifyTrue(homePage.isWelcomeMessageDisplayed(homepageMessage));
	}
	
	

}
