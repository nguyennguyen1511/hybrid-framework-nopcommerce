package pageUIs;

import org.testng.Assert;

public class LoginPageUI {
	
	public static final String EMAIL_TEXTBOX= "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX= "//input[@id='Password']";
	
	public static final String LOGIN_BUTTON = "//button[contains(@class,'login-button')]";
	
	public static final String EMAIL_ERROR = "//span[@id='Email-error']";
	
	public static final String UNSCCESS_ERROR = "//div[contains(@class,'validation-summary-errors')]";
	
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
}
