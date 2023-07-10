package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import com.relevantcodes.extentreports.LogStatus;

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
import reportConfig.ExtentTestManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_15_ExtentV5_Screenshot extends BaseTest {
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
	public void User_01_Register(Method method) {
		
		  ExtentTestManager.startTest(method.getName(), "User_01_Register");
		  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 01: Navigate to 'Register' page"); 
		  registerPage =homePage.clickToRegisterLink();
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 02: enter to FirsName with value is '" + firstName + "'");
		  registerPage.inputToFirstNameTextbox(firstName);
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 03: enter to LastName with value is '" + lastName + "'");
		  registerPage.inputToLastNameTextbox(lastName);
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 04: enter to Email with value is '" + emailAddress + "'");
		  registerPage.inputToEmailTextbox(emailAddress);
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 05: enter to Password with value is '" + password + "'");
		  registerPage.inputToPasswordTextbox(password);
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 06: enter to Confirm Pass with value is '" + password +
		  "'"); registerPage.inputToConfirmPasswordTextbox(password);
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 07: click on 'Register' Button");
		  registerPage.clickToRegisterButton();
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Register - Step 08: verify message register success");
		  Assert.assertEquals(registerPage.getSuccessRegisterMessage(),
		  "Your registration completed");
		  
		 
		 
		
	}
@Test
	public void User_02_Login() {
	
		
		  //ExtentTestManager.getTest().log(Status.INFO,"Login - Step 01: click on 'Logout' Button"); 
		  //homePage = registerPage.clickToLogoutLink();
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 02: Navigate to 'Login' page"); loginPage =
		  homePage.clickToLoginLink();
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 03: enter to Email with value is '" + emailAddress + "'");
		  loginPage.inputToEmailTextbox(emailAddress);
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 04: enter to Password with value is '" + password + "'");
		  loginPage.inputToPasswordTextbox(password);
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 05: click on 'Login' Button"); homePage =
		  loginPage.clickToLoginButton();
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 06: verify 'My Account' display");
		  Assert.assertFalse(homePage.isMyAccountLinkedDisplayed());
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 07: click on 'My Account' link"); customerInfoPage =
		  homePage.clickToMyAccountLink();
		  
		  ExtentTestManager.getTest().log(Status.INFO,"Login - Step 08: verify 'Customer Info' display");
		  Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
		  
		 
}
 

 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
