package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	
	@Step("Navigate to Register page")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementclickAbled(driver, HomePageUI.RIGISTER_LINK);
		clickToElement(driver, HomePageUI.RIGISTER_LINK);
		// cach 2
		//return new RegisterPageObject(driver);
		//cach 3
		return PageGeneratorManager.getUserRegisterPage(driver);
		
	}
	
	@Step("Navigate to Login page")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementclickAbled(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return new LoginPageObject (driver); cach 2
		// cach 3
		return PageGeneratorManager.getUserLoginPage(driver);
		
		
	}
	
	@Step("Verify My Account Link displayed")
	public boolean isMyAccountLinkedDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Navigate to Customer Info page")
	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementclickAbled(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}



}
