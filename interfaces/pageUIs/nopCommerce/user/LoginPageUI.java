package pageUIs.nopCommerce.user;

import org.testng.Assert;

public class LoginPageUI {
	
	public static final String EMAIL_TEXTBOX= "xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX= "xpath=//input[@id='Password']";
	
	public static final String LOGIN_BUTTON = "xpath=//button[contains(@class,'login-button')]";
	
	public static final String EMAIL_ERROR = "xpath=//span[@id='Email-error']";
	
	public static final String UNSCCESS_ERROR = "xpath=//div[contains(@class,'validation-summary-errors')]";
	
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
}
