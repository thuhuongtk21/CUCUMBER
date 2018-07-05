package stepDefinitions;

import org.openqa.selenium.WebDriver;
import commons.PageFactoryManager;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.NewAccountPO;

public class NewAccountPageSteps extends ShareData{
	WebDriver driver;
	String emailUnique;
	private NewAccountPO newAccountPage;
	
	public NewAccountPageSteps() {
		driver = Hooks.openBrowser();
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

	}
	
	@When("^I input to Customer ID$")
	public void iInputToCustomerID()  {		
		newAccountPage.inputDataToCustomerID(ShareData.newCustomerID);
	}
	
	@When("^I get infor of (first|second) account$")
	public void iGetInforOfFirstAccount(String account)  {		
		if(account.equalsIgnoreCase("first")) {
			ShareData.firstAccount = newAccountPage.getAccountID();
		}
		else {
			ShareData.secondAccount = newAccountPage.getAccountID();
		}
	}
	

}
