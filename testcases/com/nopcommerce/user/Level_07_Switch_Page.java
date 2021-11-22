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

public class Level_07_Switch_Page extends BaseTest {
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
		System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName ="Automation";
		lastName = "FC";
		password ="123456";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

		}
 
 @Test
 public void User_01_Register() {
	    registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(),"Your registration completed");

		homePage = registerPage.clickToLogoutLink();

 }
 
 @Test
 public void User_02_Login() {
	 loginPage = homePage.clickToLoginLink();

	 loginPage.inputToEmailTextbox(emailAddress);
	 loginPage.inputToPasswordTextbox(password);
	 homePage = loginPage.clickToLoginButton();
	 Assert.assertTrue(homePage.isMyAccountLinkedDisplayed());
	 
	 customerInfoPage = homePage.clickToMyAccountLink();
 }
 
 @Test
 public void User_03_My_Account() {
	 customerInfoPage = homePage.clickToMyAccountLink();
	 Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
 }
 
 @Test
 public void User_04_Switch_Page() {
	 addressPage = customerInfoPage.openAddressPage(driver);
	 
	 myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	 
	 rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
	 
	 addressPage = rewardPointPage.openAddressPage(driver);
	 
	 rewardPointPage = addressPage.openRewardPointPage(driver);
	 
	 myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	 
	 customerInfoPage = myProductReviewPage.openCustomerInfoPage(driver);
	 
 }
 
 @Test
 public void User_04_Switch_Role() {
 }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
