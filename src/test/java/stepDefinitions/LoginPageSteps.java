package stepDefinitions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	WebDriver driver;
	WebDriverWait wait;
	String username, password, loginUrl, welcomeMessage;
	
	@Given("^I open browser$")
	public void iOpenBrowser()  {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	    
	    ;
	}

	@Given("^I get login url$")
	public void iGetLoginUrl()  {
		loginUrl = driver.getCurrentUrl();
	    
	    ;
	}

	@When("^I click to here link$")
	public void iClickToHereLink()  {
		driver.findElement(By.xpath("//a[text()='here']")).click();
	    
	    ;
	}

	@When("^I input to email textbox$")
	public void iInputToEmailTextbox()  {
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@name='emailid']"));
		waitForElementVisible(emailTextbox);
		emailTextbox.sendKeys("automation"+randomEmail()+"@gmail.com");
	    
	    ;
	}

	@When("^I click to submit button at register page$")
	public void iClickToSubmitButtonAtRegisterPage()  {
		WebElement submitButon = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		submitButon.click();
	    
	    ;
	}

	@When("^I get to username information$")
	public void iGetToUsernameInformation()  {
		WebElement usernameTextbox = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td"));
		waitForElementVisible(usernameTextbox);
		username = usernameTextbox.getText();
		
	    
	    ;
	}

	@When("^I get to password information$")
	public void iGetToPasswordInformation()  {
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();	
	    
	    ;
	}

	@When("^I open to login page$")
	public void iOpenToLoginPage()  {
	    driver.get(loginUrl);
	    ;
	}

	@When("^I input to username textbox$")
	public void iInputToUsernameTextbox()  {
	    WebElement usernameTextbox = driver.findElement(By.xpath("//input[@name='uid']"));
	    waitForElementVisible(usernameTextbox);
	    usernameTextbox.sendKeys(username);
	    ;
	}

	@When("^I input to password textbox$")
	public void iInputToPasswordTextbox()  {
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextbox.sendKeys(password);
	    
	    ;
	}

	@When("^I input to submit button at login page$")
	public void iInputToSubmitButtonAtLoginPage()  {
	    WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
	    submitButton.click();
	    ;
	}

	@Then("^I verify homepage welcome message displayed$")
	public void iVerifyHomepageWelcomeMessageDisplayed()  {
	    WebElement homePageWelcomeMessage = driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
	    Assert.assertTrue(homePageWelcomeMessage.isDisplayed());
	    ;
	}
	
	@Then("^I close browser$")
	public void iCloseBrowser()  {
	    driver.quit();
	    ;
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
