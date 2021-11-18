package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementclickAbled(driver, HomePageUI.RIGISTER_LINK);
		clickToElement(driver, HomePageUI.RIGISTER_LINK);
		// cach 2
		//return new RegisterPageObject(driver);
		//cach 3
		return PageGeneratorManager.getRegisterPage(driver);
		
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementclickAbled(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return new LoginPageObject (driver); cach 2
		// cach 3
		return PageGeneratorManager.getLoginPage(driver);
		
		
	}

	public boolean isMyAccountLinkedDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementclickAbled(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

}
