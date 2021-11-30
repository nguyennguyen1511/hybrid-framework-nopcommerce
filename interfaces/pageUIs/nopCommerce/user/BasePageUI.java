package pageUIs.nopCommerce.user;

import org.testng.Assert;

public class BasePageUI {
	
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String CUSTOMER_INFO_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String ADDRESS_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK ="xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String LOGOUT_LINK_USER ="xpath=//a[@class=''ico-logout']";
	public static final String LOGOUT_LINK_ADMIN ="xpath=//a[text()='Logout']";
	
}

