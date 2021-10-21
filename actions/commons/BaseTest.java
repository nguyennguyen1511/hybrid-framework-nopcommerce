package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
	  	if (browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
			driver = new FirefoxDriver();
	  	}else if (browserName.equals("chrome"))  {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browser/chromedriver.exe");
			driver = new ChromeDriver();
	  	}else if  (browserName.equals("edge"))  {
			System.setProperty("webdriver.edge.driver", projectPath + "/browser/msedgedriver.exe");
			driver = new EdgeDriver();
	  	}else {
	  		throw new RuntimeException("Please input correct the browser name");
	  	}
	  	
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 driver.get("https://demo.nopcommerce.com/");
		return driver;
	}

}
