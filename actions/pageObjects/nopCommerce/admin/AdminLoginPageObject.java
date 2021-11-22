package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;
import pageUIs.nopCommerce.user.LoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		  waitForElementclickAbled(driver, AdminLoginPageUI.LOGIN_BUTTON);
		  clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		  return PageGeneratorManager.getAdminDashboardPage(driver);
		
	}
	
	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
		
	}

}
