package stepDefinitions;

import org.openqa.selenium.WebDriver;


import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.RegisterPagePO;

public class RegisterPageSteps extends ShareData{
	WebDriver driver;	
	private RegisterPagePO registerPage;
	private AbstractTest abstractTest;
	
	public RegisterPageSteps() {
		driver = Hooks.openBrowser();
		registerPage = PageFactoryManager.getRegisterPage(driver);
		abstractTest = new AbstractTest();

	}
	
	@When("^I input to email textbox$")
	public void iInputToEmailTextbox()  {
		registerPage.inputToEmailIdTextbox("automation"+abstractTest.randomNumber()+"@gmail.com");
	}

	@When("^I click to submit button at register page$")
	public void iClickToSubmitButtonAtRegisterPage()  {
		registerPage.clickToSubmitButton();
	}

	@When("^I get infor of User ID$")
	public void iGetToUsernameInformation()  {
		
		ShareData.username = registerPage.getUserIdInfor();
	}

	@When("^I get infor of Password$")
	public void iGetToPasswordInformation()  {
		ShareData.password = registerPage.getPasswordInfor();
	}

	@When("^I open login page again$")
	public void iOpenToLoginPage()  {
	    registerPage.openLoginPage(ShareData.loginUrl);
	}

}
