package payObjects.jQuery.Table;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager{
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
