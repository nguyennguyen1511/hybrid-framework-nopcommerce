package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@id='FirstName']")
	private WebElement firstNameTextbox;
	@FindBy (xpath="//input[@id='LastName']")
	private WebElement lastNameTextbox;
	@FindBy (xpath="//input[@id='Email']")
	private WebElement emailTextbox;
	@FindBy (xpath="//input[@id='Password']")
	private WebElement passwordTextbox;
	@FindBy (xpath="//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	@FindBy (xpath="//button[@id='register-button']")
	private WebElement registerButton;
	@FindBy (xpath="//span[@id='FirstName-error']")
	private WebElement firstNameError;
	@FindBy (xpath="//span[@id='LastName-error']")
	private WebElement lastNameError;
	@FindBy (xpath="//span[@id='Email-error']")
	private WebElement emailError;
	@FindBy (xpath="//span[@id='Password-error']")
	private WebElement passwordError;
	@FindBy (xpath="//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordError;
	@FindBy (xpath="//div[@class='result']")
	private WebElement registerSuccess;
	@FindBy (xpath="//a[@class='ico-logout']")
	private WebElement logoutLink;
	@FindBy (xpath="//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailError;
	
	
	public void clickToRegisterButton() {
		  waitForElementclickAbled(driver, registerButton);
		  clickToElement(driver, registerButton);
		
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameError);
		return getElementText(driver, firstNameError);
	}
	
	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameError);
		return getElementText(driver, lastNameError);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailError);
		return getElementText(driver, emailError);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordError);
		return getElementText(driver, passwordError);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordError);
		return getElementText(driver, confirmPasswordError);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeysToElement(driver, firstNameTextbox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendKeysToElement(driver, lastNameTextbox, lastName);
		
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendKeysToElement(driver, emailTextbox, emailAddress);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeysToElement(driver, passwordTextbox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeysToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}

	public String getSuccessRegisterMessage() {
		waitForElementVisible(driver, registerSuccess);
		return getElementText(driver, registerSuccess);
	}

	public void clickToLogoutLink() {
		waitForElementclickAbled(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailError);
		return getElementText(driver, existingEmailError);
	}



}
