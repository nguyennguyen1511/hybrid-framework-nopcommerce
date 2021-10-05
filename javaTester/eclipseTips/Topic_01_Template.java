package eclipseTips;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Topic_01_Template {
	WebElement driver;
	
	
	public static void main (String[] arg) {
		Assert.assertEquals("","");
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		
		
	}
	public Object executeForBrowserElement(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

}
