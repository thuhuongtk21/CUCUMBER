package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LoginPagePO;

public class LoginPageSteps {
	WebDriver driver;
	String username, password, loginUrl, welcomeMessage;
	

	private LoginPagePO loginPage;

	public LoginPageSteps() {

	}

	@Given("^I open browser$")
	public void iOpenBrowser() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^I get login url$")
	public void iGetLoginUrl() {
		loginUrl = loginPage.getLoginPageUrl();
	}

	@When("^I click to here link$")
	public void iClickToHereLink() {
		loginPage.clickToHereLink();
	}

	@When("^I input to username textbox$")
	public void iInputToUsernameTextbox() {
		loginPage.inputToUsernameTextbox(username);
	}

	@When("^I input to password textbox$")
	public void iInputToPasswordTextbox() {
		loginPage.inputToPasswordTextbox(password);
	}

	@When("^I input to submit button at login page$")
	public void iInputToSubmitButtonAtLoginPage() {
		loginPage.clickToSubmitButton();
	}

	

	

}
