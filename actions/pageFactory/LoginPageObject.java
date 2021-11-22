package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.user.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath ="//input[@id='Email']")
	private WebElement emailTextbox;
	@FindBy (xpath ="//input[@id='Password']")
	private WebElement passwordTextbox;
	@FindBy (xpath ="//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	@FindBy (xpath ="//span[@id='Email-error']")
	private WebElement emailError;
	@FindBy (xpath ="//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessError;
	@FindBy (xpath ="//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	public void clickToLoginButton() {
		  waitForElementclickAbled(driver, loginButton);
		  clickToElement(driver, loginButton);
		
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailError);
		return getElementText(driver, emailError);
	}
	
	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, emailTextbox);
		sendKeysToElement(driver, emailTextbox, invalidEmail);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeysToElement(driver, passwordTextbox, password);
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, unsuccessError);
		return getElementText(driver, unsuccessError);
	}


}
