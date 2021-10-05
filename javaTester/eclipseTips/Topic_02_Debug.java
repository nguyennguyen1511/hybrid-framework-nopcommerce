package eclipseTips;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Debug {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
		

	@Test
	public void TC_01() {
		System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("https://www.facebook.com/");
		
		String headerText = driver.findElement(By.xpath("//img[@alt='Facebook']/parent::div/following-sibling::h2")).getText();
		Assert.assertEquals(headerText, "Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn.");
		
		boolean loginStatus = driver.findElement(By.name("login")).isDisplayed();
		Assert.assertTrue(loginStatus);

	}

}
