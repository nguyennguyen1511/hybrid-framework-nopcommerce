package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager{
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}
