package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	 
	public WebDriver getDriverInstance() {
		return this.driver;
	}
	protected WebDriver getBrowserDriver(String browserName){
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
	  	if (browserList == BrowserList.FIREFOX){
	  		WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	  	}else if (browserList == BrowserList.H_FIREFOX){
	  		WebDriverManager.firefoxdriver().setup();
	  		FirefoxOptions options = new FirefoxOptions();
	  		options.addArguments("--headless");
	  		options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
	  	}else if (browserList == BrowserList.CHROME)  {
		  		WebDriverManager.chromedriver().setup();
		  		driver = new ChromeDriver();
		}else if (browserList == BrowserList.H_CHROME){
	  		WebDriverManager.firefoxdriver().setup();
	  		ChromeOptions options = new ChromeOptions();
	  		options.addArguments("--headless");
	  		options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
	  	}else if  (browserList == BrowserList.EDGE)  {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	  	}else if  (browserList == BrowserList.IE)  {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
	  	}else if  (browserList == BrowserList.OPERA) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
	  	}else if  (browserList == BrowserList.COCCOC) {
	  		//coc coc browser tru di 5-6 version ra chromedriver
			WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			ChromeOptions options = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith( "Windows")) {
				options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			}else {
				//duong dan tren mac
				options.setBinary("...");
			}driver = new ChromeDriver(options);
	  	}else if  (browserList == BrowserList.BRAVE)  {
	  		//brave brwoser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
	  	}
	  	else {
	  		throw new BrowserNotSupport(browserName);
	  	}
	  	
		 driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

		 driver.get(GlobalConstants.PORTAL_STAGING_URL);
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.equals("h_firefox")){
	  		WebDriverManager.firefoxdriver().setup();
	  		FirefoxOptions options = new FirefoxOptions();
	  		options.addArguments("--headless");
	  		options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}else if (browserName.equals("chrome"))  {
	  		WebDriverManager.chromedriver().setup();
	  		driver = new ChromeDriver();
		}else if (browserName.equals("h_chrome")){
			WebDriverManager.firefoxdriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}else if  (browserName.equals("edge"))  {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if  (browserName.equals("ie"))  {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}else if  (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
	  	}else if  (browserName.equals("coccoc"))  {
	  		//coc coc browser tru di 5-6 version ra chromedriver
			WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			ChromeOptions options = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith( "Windows")) {
				options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			}else {
				//duong dan tren mac
				options.setBinary("...");
			}driver = new ChromeDriver(options);
	  	}else if  (browserName.equals("brave"))  {
	  		//brave brwoser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
	  	}
	  	else {
	  		throw new RuntimeException("Browser Name invalid");
	  	}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT,TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}
	
	protected String getEnvironmentUlr (String severName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(severName.toUpperCase());
		
		if(environment == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com";
		}else if(environment == EnvironmentList.STAGING) {
			envUrl = "https://demo.nopcommerce.com";
		}else if (environment == EnvironmentList.PRODUCT) {
			envUrl = "https://demo.nopcommerce.com";
		}
			
		return envUrl;
		
	}
	
	protected int generateFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
				log.info(" -------------------------- PASSED -------------------------- ");

		} catch (Throwable e) {
			
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}


	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
				Assert.assertFalse(condition);
				log.info(" -------------------------- PASSED -------------------------- ");
			
		} catch (Throwable e) {
			
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}


	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

}
