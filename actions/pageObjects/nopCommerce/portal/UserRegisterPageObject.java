package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	
	@Step("Click Register Button")
	public void clickToRegisterButton() {
		  waitForElementclickAbled(driver, RegisterPageUI.REGISTER_BUTTON);
		  clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR);
	}
	
	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
	}
	
	@Step("Enter to First Name with value is {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}
	
	@Step("Enter to Last Name with value is {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}
	
	@Step("Enter to Email with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}
	
	@Step("Enter to Password with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	@Step("Enter to Confirm Password with value is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);
		
	}
	
	@Step("Verify Message successful")
	public String getSuccessRegisterMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS);
	}
	
	@Step("Click Logout button")
	public UserHomePageObject clickToLogoutLink() {
		waitForElementclickAbled(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		// cach 2
		//return new HomePageObject(driver);
		// cach 3
		return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR);
	}





}
