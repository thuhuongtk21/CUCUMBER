package stepDefinitions;

import org.openqa.selenium.WebDriver;
import commons.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.LoginPagePO;

public class LoginPageSteps extends ShareData{
	WebDriver driver;
	

	private LoginPagePO loginPage;

	public LoginPageSteps(){
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);

	}

	@Given("^I get login url$")
	public void iGetLoginUrl() {
		ShareData.loginUrl = loginPage.getLoginPageUrl();
	}

	@When("^I click to here link$")
	public void iClickToHereLink() {
		loginPage.clickToHereLink();
	}

	@When("^I input to username textbox$")
	public void iInputToUsernameTextbox() {
		loginPage.inputToUsernameTextbox(ShareData.username);
	}

	@When("^I input to password textbox$")
	public void iInputToPasswordTextbox() {
		loginPage.inputToPasswordTextbox(ShareData.password);
	}

	@When("^I input to submit button at login page$")
	public void iInputToSubmitButtonAtLoginPage() {
		loginPage.clickToSubmitButton();
	}

	

	

}
