package stepDefinitions;

import org.openqa.selenium.WebDriver;
import commons.PageFactoryManager;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.NewCustomerPagePO;

public class NewCustomerPageSteps extends ShareData{
	WebDriver driver;
	String emailUnique;
	private NewCustomerPagePO newCustomerPage;
	
	public NewCustomerPageSteps() {
		driver = Hooks.openBrowser();
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

	}
	
	@When("^I get infor of Customer ID$")
	public void iGetInforOfCustomerID()  {		
		ShareData.newCustomerID = newCustomerPage.getCustomerID();
	}
	

}
