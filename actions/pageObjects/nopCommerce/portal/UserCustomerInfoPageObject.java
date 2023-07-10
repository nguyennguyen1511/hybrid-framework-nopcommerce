package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserCustomerInfoPageObject extends BasePage{
	private WebDriver driver;
	
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
		
	}


	@Step("Verify customer Info page displayed")
	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}





}
