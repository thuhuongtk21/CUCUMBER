package cucumberOptions;

import java.util.concurrent.TimeUnit;



import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import cucumber.api.java.Before;

public class Hooks {
	private static WebDriver driver;
	private static final Logger log = Logger.getLogger(Hooks.class.getName());

	@Before
	public synchronized static WebDriver openBrowser() {
		String browser = System.getProperty("BROWSER");
		//String browser = "firefox";
		if (driver == null) {
			try {
				
				 if(browser == null) { 
					 browser = System.getenv("BROWSER"); 
					 if(browser == null) { 
						 browser = "firefox"; 
						 } 
					 }switch (browser) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				case "ie":
					System.setProperty("webdriver.ie.driver", ".\\driver\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
				default:
					System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				}
			} catch (UnreachableBrowserException e) {
				driver = new ChromeDriver();
			} catch (WebDriverException e) {
				driver = new ChromeDriver();

			} finally {
				System.out.println("find error: OK");
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}

			driver.get("http://demo.guru99.com/v4/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			log.info("-----Start browser------");
		}
		return driver;

	}

	public static void close() {
		try {
			if (driver != null) {
				openBrowser().quit();
				log.info("-----Close browser-----");

			}
		} catch (UnreachableBrowserException e) {
			System.out.println("Can't close browser");
		}
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			close();
		}
	}

}
