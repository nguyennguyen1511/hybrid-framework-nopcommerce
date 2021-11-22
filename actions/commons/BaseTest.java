package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
	  	if (browserName.equals("firefox")){
			//System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
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
			options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
	  	}else if  (browserName.equals("brave"))  {
	  		//brave brwoser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("95.0.4638.17").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = new ChromeDriver(options);
	  	}
	  	else {
	  		throw new RuntimeException("Please input correct the browser name");
	  	}
	  	
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 driver.get(GlobalConstants.PORTAL_PAGE_URL);
		return driver;
	}
	
	  public int generateFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }

}
