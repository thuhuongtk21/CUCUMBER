package stepDefinitions;

import commons.AbstractTest;
import cucumber.api.java.en.When;
import pages.RegisterPagePO;

public class RegisterPageSteps {
	String username, password, loginUrl;
	private RegisterPagePO registerPage;
	private AbstractTest abstractTest;
	
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
