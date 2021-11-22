package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserMyProductReviewPageObject extends BasePage{
	private WebDriver driver;
	
	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
		
	}


}
