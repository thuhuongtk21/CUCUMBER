package commons;

import java.util.Random;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.Reporter;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;


public class AbstractTest {
	WebDriver driver;
	
	
	
	  public synchronized WebDriver openMultiBrowser(String browser, String version, String url) {
		  if(browser.equals("firefox")) {
			  FirefoxDriverManager.getInstance().setup();
			  driver = new FirefoxDriver();
		  }else if(browser.equals("chrome")) {
			  ChromeDriverManager.getInstance().version(version).setup();
			  driver = new ChromeDriver();
		  }else {
			  InternetExplorerDriverManager.getInstance().version(version).setup();
			  driver = new InternetExplorerDriver();
		  }
		  
		  driver.manage().window().maximize();
		  driver.get(url);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  return driver;
	  }
	  public int randomNumber() {
			Random random = new Random();
			int number = random.nextInt(999999);
			return number;
		}
	  
	  public boolean verifyPassed(boolean condition, boolean flag) {
		  boolean pass = true;
		  if(flag == false) {
			  try {
				  Assert.assertTrue(condition);
			  }catch(Throwable e) {
				  pass = false;
				  Reporter.getCurrentTestResult().setThrowable(e);
			  }  
		  } else {
			  Assert.assertTrue(condition);
		  }
		  
		  return pass;
	  }
	  
	  public boolean verifyTrue(boolean condition) {
		  return verifyPassed(condition, false);
		  
	  }
	  
	  public boolean verifyFailed(boolean condition, boolean flag) {
		  boolean pass = true;
		  if(flag == false) {
			  try {
				  Assert.assertFalse(condition);
			  }catch(Throwable e) {
				  pass = false;
				  Reporter.getCurrentTestResult().setThrowable(e);
			  }  
		  } else {
			  Assert.assertFalse(condition);
		  }
		  
		  return pass;
	  }
	  
	  public boolean verifyEquals(Object actual, Object expected, boolean flag) {
		  boolean pass = true;
		  if(flag == false) {
			  try {
				  Assert.assertEquals(expected, actual);
			  }catch(Throwable e) {
				  pass = false;
				  Reporter.getCurrentTestResult().setThrowable(e);
			  }
			  
		  }else {
			  Assert.assertEquals(expected, actual);
		  }
		  return pass;
		  
	  }
	  
	  public boolean verifyEquals(Object actual, Object expected) {
		  return verifyEquals(actual, expected, false);
		  
	  }
	  
	  public void closeBrowser(WebDriver driver) {
		  try {
			  String osName = System.getProperty("os.name").toLowerCase();
			  String cmd = "";
			  driver.quit();
			  if(driver.toString().toLowerCase().contains("chrome")) {
				  if(osName.toLowerCase().contains("mac")) {
					  cmd = "pkill chromedriver";
				  }else {
					  cmd = "taskkill /IM chromerdriver.exe /F";
				  }
				  Process process = Runtime.getRuntime().exec(cmd);
				  process.waitFor();
			  }
			  if(driver.toString().toLowerCase().contains("internetexplorer")) {
				  cmd = "taskkill /IM IEDriverServer.exe /F";
				  Process process = Runtime.getRuntime().exec(cmd);
				  process.waitFor();
			  }
		  }catch(Exception e) {
			  System.out.println(e.getMessage());
		  }
		  
	  }

}
