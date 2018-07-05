package stepDefinitions;

import org.openqa.selenium.WebDriver;
import commons.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.DepositPO;
import pages.LoginPagePO;

public class DepositPageSteps extends ShareData{
	WebDriver driver;
	

	private DepositPO depositPage;

	public DepositPageSteps(){
		driver = Hooks.openBrowser();
		depositPage = PageFactoryManager.getDepositPage(driver);

	}

	@When("^I input to (first|second) account number$")
	public void iInputToAccountNumberTextbox(String account) {
		
		if(account.equalsIgnoreCase("first")) {
			depositPage.inputDataToAccountNumber(ShareData.firstAccount);
			System.out.println("First Account = "+ ShareData.firstAccount);
		}
		else {
			depositPage.inputDataToAccountNumber(ShareData.secondAccount);
		}
	}

}
