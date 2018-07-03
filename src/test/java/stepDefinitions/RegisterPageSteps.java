package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import commons.PageFactoryManager;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.RegisterPagePO;

public class RegisterPageSteps {
	WebDriver driver;
	String username, password, loginUrl = "http://www.demo.guru99.com/v4/";
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

	@When("^I get to username information$")
	public void iGetToUsernameInformation()  {
		
		username = registerPage.getUserIdInfor();
	}

	@When("^I get to password information$")
	public void iGetToPasswordInformation()  {
		password = registerPage.getPasswordInfor();
	}

	@When("^I open to login page$")
	public void iOpenToLoginPage()  {
	    registerPage.openLoginPage(loginUrl);
	}

}
