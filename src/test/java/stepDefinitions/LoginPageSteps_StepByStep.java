package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps_StepByStep {
	WebDriver driver;
	WebDriverWait wait;
	String username, password, loginUrl, welcomeMessage;
	int emailUnique = randomEmail();
	
	@Given("^I open browser$")
	public void iOpenBrowser()  {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}

	@Given("^I get login url$")
	public void iGetLoginUrl()  {
		loginUrl = driver.getCurrentUrl();
	}

	@When("^I click to here link$")
	public void iClickToHereLink()  {
		driver.findElement(By.xpath("//a[text()='here']")).click();
	}

	@When("^I input to email textbox$")
	public void iInputToEmailTextbox()  {
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@name='emailid']"));
		waitForElementVisible(emailTextbox);
		emailTextbox.sendKeys("automation"+randomEmail()+"@gmail.com");
	}

	@When("^I click to submit button at register page$")
	public void iClickToSubmitButtonAtRegisterPage()  {
		WebElement submitButon = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		submitButon.click();
	}

	@When("^I get to username information$")
	public void iGetToUsernameInformation()  {
		WebElement usernameTextbox = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td"));
		waitForElementVisible(usernameTextbox);
		username = usernameTextbox.getText();
	}

	@When("^I get to password information$")
	public void iGetToPasswordInformation()  {
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();	
	}

	@When("^I open to login page$")
	public void iOpenToLoginPage()  {
	    driver.get(loginUrl);
	}

	@When("^I input to username textbox$")
	public void iInputToUsernameTextbox()  {
	    WebElement usernameTextbox = driver.findElement(By.xpath("//input[@name='uid']"));
	    waitForElementVisible(usernameTextbox);
	    usernameTextbox.sendKeys(username);
	}

	@When("^I input to password textbox$")
	public void iInputToPasswordTextbox()  {
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextbox.sendKeys(password);
	}

	@When("^I input to submit button at login page$")
	public void iInputToSubmitButtonAtLoginPage()  {
	    WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
	    submitButton.click();
	}

	@Then("^I verify homepage welcome message displayed$")
	public void iVerifyHomepageWelcomeMessageDisplayed()  {
	    WebElement homePageWelcomeMessage = driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
	    Assert.assertTrue(homePageWelcomeMessage.isDisplayed());
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
	    emailIdTextbox.sendKeys(customer.get(0).get("Email")+ emailUnique + "@gmail.com");
	    passwordTextbox.sendKeys(customer.get(0).get("Password"));
	    
	}

	@When("^I click to submit button$")
	public void iClickToSubmitButton() {
	   WebElement submitButton = driver.findElement(By.xpath("//input[@name='sub']"));
	   submitButton.click();
	    
	}
	
	@When("^I verify customer created success with information$")
	public void iVerifyCustomerCreatedSuccessWithInformation(DataTable table) {
	    WebElement customerNameText = driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td"));
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
	    Assert.assertEquals(emailText.getText(), customer.get(0).get("Email")+ emailUnique + "@gmail.com");
	    		
	}
	
	@Then("^I close browser$")
	public void iCloseBrowser()  {
	    driver.quit();
	   
	}
	
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public int randomEmail() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return number;
	}


}
