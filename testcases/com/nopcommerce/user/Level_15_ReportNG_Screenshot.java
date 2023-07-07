package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_15_ReportNG_Screenshot extends BaseTest {
	private WebDriver driver;
	//declare (khai bao)
	private String lastName, firstName, emailAddress, password;
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	
	@Parameters("browser")	
	@BeforeClass
  public void beforeClass(String browserName) {
		System.setProperty("webdriver.chrome.driver", projectPath +"/browser/chromedriver");
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName ="Automation";
		lastName = "FC";
		password ="123456";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

		}
 
 @Test
	public void User_01_Register() {
	 	log.info("Register - Step 01: Navigate to 'Register' page");	 	
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: enter to FirsName with value is '" + firstName + "'");	
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 03: enter to LastName with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 04: enter to Email with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Register - Step 05: enter to Password with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 06: enter to Confirm Pass with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 07: click on 'Register' Button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08: verify message register success");
		verifyEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
		
		log.info("Register - Step 09: click on 'Logout' Button");
		homePage = registerPage.clickToLogoutLink();

		
	}
@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: enter to Email with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 03: enter to Password with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: click on 'Login' Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: verify 'My Account' display");
		verifyFalse(homePage.isMyAccountLinkedDisplayed());
		
		log.info("Login - Step 06: click on 'My Account' link");
		customerInfoPage = homePage.clickToMyAccountLink();
		
		log.info("Login - Step 07: verify 'Customer Info' display");
		verifyFalse(customerInfoPage.isCustomerInfoPageDisplayed());
}
 

 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
