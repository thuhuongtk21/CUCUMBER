package stepDefinitions;

import org.openqa.selenium.WebDriver;
import commons.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.LoginPagePO;

public class LoginPageSteps {
	WebDriver driver;
	String username = "mngr134681", password = "mudUhaj", loginUrl, welcomeMessage;
	

	private LoginPagePO loginPage;

	public LoginPageSteps() {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManager.getLoginPage(driver);

	}

	/*@Given("^I open browser$")
	public void iOpenBrowser() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}*/

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
