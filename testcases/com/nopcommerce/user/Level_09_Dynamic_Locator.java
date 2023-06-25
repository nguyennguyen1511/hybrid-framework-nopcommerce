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

public class Level_09_Dynamic_Locator extends BaseTest {
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
		System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver");
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName ="Automation";
		lastName = "FC";
		password ="123456";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

		}
 
 @Test
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkedDisplayed());

		customerInfoPage = homePage.clickToMyAccountLink();

		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}
 
 @Test
 public void User_02_Dynamic_Page() {
	 addressPage = customerInfoPage.openAddressPage(driver);
	 
	 myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	 
	 rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
	 
	 addressPage = rewardPointPage.openAddressPage(driver);
	 
	 rewardPointPage = addressPage.openRewardPointPage(driver);
	 
	 myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);

	 
 }
 

 public void User_03_Dynamic_Page_01() {
	 rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");
	 
	 addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
	 
	 rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");
	 
	 myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
	 
	 customerInfoPage = (UserCustomerInfoPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Customer info");
 }
 @Test
 public void User_03_Dynamic_Page_02() {
	 customerInfoPage.openPagesAtMyAccountByName(driver, "My product reviews");
	 myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
	 
	 myProductReviewPage.openPagesAtMyAccountByName(driver, "Addresses");
	 addressPage = PageGeneratorManager.getUserAddressPage(driver);
	 
	 addressPage.openPagesAtMyAccountByName(driver, "Reward points");
	 rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
	 
	 rewardPointPage.openPagesAtMyAccountByName(driver, "Customer info");
	 customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
 }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
