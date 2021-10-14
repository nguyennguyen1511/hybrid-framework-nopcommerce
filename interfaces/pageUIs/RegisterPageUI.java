package pageUIs;

import org.testng.Assert;

public class RegisterPageUI {
	
	public static final String FIRSTNAME_TEXTBOX ="//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX= "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX= "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX= "//input[@id='Password']";
	public static final String CONFIRMPASSWORD_TEXTBOX= "//input[@id='ConfirmPassword']";
	
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	
	public static final String FIRSTNAME_ERROR = "//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR = "//span[@id='ConfirmPassword-error']";
	
	public static final String REGISTER_SUCCESS = "//div[@class='result']";
	
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	
	public static final String EXISTING_EMAIL_ERROR = "//div[contains(@class,'message-error')]//li";
	
	

}
