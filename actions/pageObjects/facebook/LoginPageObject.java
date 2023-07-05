package pageObjects.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;
import pageUIs.jQuery.Table.HomePageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToCreateButton() {
		waitForElementclickAbled(driver,LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver,LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}
	
	
	public boolean isEmailAddressDisplayed() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver,LoginPageUI.EMAIL_TEXTBOX);
	}
	public void enterEmailToForm(String emailAddress) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver,LoginPageUI.EMAIL_TEXTBOX,emailAddress);
		
	}
	public boolean isEmailConfirmAddressDisplayed() {
		
		return isElementDisplayed(driver,LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}
	
	public void clickToCloseIcon() {
		waitForElementclickAbled(driver,LoginPageUI.CLOSE_ICON);
		clickToElement(driver,LoginPageUI.CLOSE_ICON);
		
	}
	public boolean isConfirmAddressEmailUndisplayed() {
		// TODO Auto-generated method stub
		return isElementUndisplayed(driver,LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}
	

}
