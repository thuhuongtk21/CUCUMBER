package stepDefinitions;

import java.util.List;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.PageFactoryManager;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pages.NewCustomerPagePO;
import interfaces.NewCustomerPageUI;

public class NewCustomerPageSteps {
	WebDriver driver;
	String emailUnique;
	private NewCustomerPagePO newCustomerPage;
	
	public NewCustomerPageSteps() {
		driver = Hooks.openBrowser();
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

	}
	
	@When("^I click to New Customer Page$")
	public void iClickToNewCustomerPage() {
		WebElement newCustomer = driver.findElement(By.xpath("//a[text()='New Customer']"));
		newCustomer.click();

	}

	@When("^I input all information to this page$")
	public void iInputAllInformationToThisPage(DataTable table) {
		WebElement nameTextbox = driver.findElement(By.xpath("//input[@name='name']"));
		WebElement genderRadiobutton = driver.findElement(By.xpath("//input[@value='m']"));
		WebElement dateOfBirthTextbox = driver.findElement(By.xpath("//*[@id='dob']"));
		WebElement addressTextbox = driver.findElement(By.xpath("//textarea[@name='addr']"));
		WebElement cityTextbox = driver.findElement(By.xpath("//input[@name='city']"));
		WebElement stateTextbox = driver.findElement(By.xpath("//input[@name ='state']"));
		WebElement pinTextbox = driver.findElement(By.xpath("//input[@name='pinno']"));
		WebElement phoneTextbox = driver.findElement(By.xpath("//input[@name='telephoneno']"));
		WebElement emailIdTextbox = driver.findElement(By.xpath("//input[@name='emailid']"));
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));

		List<Map<String, String>> customer = table.asMaps(String.class, String.class);

		nameTextbox.sendKeys(customer.get(0).get("CustomerName"));
		genderRadiobutton.click();
		dateOfBirthTextbox.sendKeys(customer.get(0).get("DateOfBirth"));
		addressTextbox.sendKeys(customer.get(0).get("Adress"));
		cityTextbox.sendKeys(customer.get(0).get("City"));
		stateTextbox.sendKeys(customer.get(0).get("State"));
		pinTextbox.sendKeys(customer.get(0).get("Pin"));
		phoneTextbox.sendKeys(customer.get(0).get("Phone"));
		emailIdTextbox.sendKeys(customer.get(0).get("Email") + emailUnique + "@gmail.com");
		passwordTextbox.sendKeys(customer.get(0).get("Password"));
		
	

	}

	@When("^I click to submit button$")
	public void iClickToSubmitButton() {
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='sub']"));
		submitButton.click();

	}

	@When("^I verify customer created success with information$")
	public void iVerifyCustomerCreatedSuccessWithInformation(DataTable table) {
		WebElement customerNameText = driver
				.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td"));
		WebElement genderText = driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td"));
		WebElement adressText = driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td"));
		WebElement cityText = driver.findElement(By.xpath("//td[text()='City']/following-sibling::td"));
		WebElement stateText = driver.findElement(By.xpath("//td[text()='State']/following-sibling::td"));
		WebElement pinText = driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td"));
		WebElement mobileText = driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td"));
		WebElement emailText = driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td"));

		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		Assert.assertEquals(customerNameText.getText(), customer.get(0).get("CustomerName"));
		Assert.assertEquals(genderText.getText(), customer.get(0).get("Gender"));
		Assert.assertEquals(adressText.getText(), customer.get(0).get("Adress"));
		Assert.assertEquals(cityText.getText(), customer.get(0).get("City"));
		Assert.assertEquals(stateText.getText(), customer.get(0).get("State"));
		Assert.assertEquals(pinText.getText(), customer.get(0).get("Pin"));
		Assert.assertEquals(mobileText.getText(), customer.get(0).get("Phone"));
		Assert.assertEquals(emailText.getText(), customer.get(0).get("Email") + emailUnique + "@gmail.com");

	}

}
