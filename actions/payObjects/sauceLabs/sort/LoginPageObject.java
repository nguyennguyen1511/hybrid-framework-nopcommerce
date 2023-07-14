package payObjects.sauceLabs.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.UploadFile.HomePageUI;
import pageUIs.sauceLabs.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToUsernameTextbox(String userName) {
		waitForElementVisible(driver,LoginPageUI.USERNAME_TEXTBOX);
		sendKeysToElement(driver,LoginPageUI.USERNAME_TEXTBOX, userName);
		
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	public ProductPageObject clickToLoginButton() {
		waitForElementclickAbled(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}

}
