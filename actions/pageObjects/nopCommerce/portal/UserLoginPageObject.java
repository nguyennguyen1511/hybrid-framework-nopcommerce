package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.LoginPageUI;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		  waitForElementclickAbled(driver, LoginPageUI.LOGIN_BUTTON);
		  clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		  // cach 2: return new HomePageObject(driver);
		  // cach 3
		  return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR);
	}
	
	@Step("Enter Email with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}
	@Step("Enter Pass with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, LoginPageUI.UNSCCESS_ERROR);
		return getElementText(driver, LoginPageUI.UNSCCESS_ERROR);
	}
	
	@Step("Login")
	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
		
	}
	

}
