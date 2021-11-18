package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	//declare (khai bao)
	private String lastName, firstName, invalidEmail, notFoundEmail, existingEmail, password;
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject myAccountPage;
	
	@Parameters("browser")	
	@BeforeClass
  public void beforeClass(String browserName) {
		System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName ="Automation";
		lastName = "FC";
		password ="123456";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		invalidEmail = "123";
		notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
			
		System.out.println("Pre-Condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		//Click register link > nhảy qua trang register
		registerPage = new RegisterPageObject(driver);
		  
		System.out.println("Pre-Condition - Step 02: input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		  
		System.out.println("Pre-Condition - Step 04: verify success message");
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(),"Your registration completed");

		System.out.println("Pre-Condition - Step 05: click to logout link");
		homePage = registerPage.clickToLogoutLink();

		}
 
 @Test
 public void Logic_01_Empty_Data() {
	 System.out.println("Logic_01 - Step 01: Click to Login link");
	 loginPage = homePage.clickToLoginLink();
	 System.out.println("Logic_01 - Step 02: Click to Login button");
	 loginPage.clickToLoginButton();
	 System.out.println("Logic_01 - Step 03: verify error message empty data");
	 Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
 }
 
 @Test
 public void Logic_02_Invalid_Email() {
	 System.out.println("Logic_02 - Step 01: Click to Login link");
	 loginPage = homePage.clickToLoginLink();

	 System.out.println("Logic_02 - Step 02: enter an invalid email into email field");
	 loginPage.inputToEmailTextbox(invalidEmail);
	 System.out.println("Logic_02 - Step 03: Click to Login button");
     loginPage.clickToLoginButton();
     System.out.println("Logic_02 - Step 04: verify error message invalid email");
	 Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
 }
 
 @Test
 public void Logic_03_Email_Not_Found() {
	 System.out.println("Logic_03 - Step 01: Click to Login link");
	 loginPage = homePage.clickToLoginLink();

	 System.out.println("Logic_03 - Step 02: enter an email is not existing into email field");
	 loginPage.inputToEmailTextbox(notFoundEmail);
	 System.out.println("Logic_03 - Step 03: Click to Login button");
     loginPage.clickToLoginButton();
     System.out.println("Logic_03 - Step 04: verify error message email not found");
	 Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
 }
 
 @Test
 public void Logic_04_Existing_Email_Not_Pass() {
	 System.out.println("Logic_04 - Step 01: Click to Login link");
	 loginPage = homePage.clickToLoginLink(); 

	 System.out.println("Logic_04 - Step 02: enter an existing email without password");
	 loginPage.inputToEmailTextbox(existingEmail);
	 loginPage.inputToPasswordTextbox("");
	 System.out.println("Logic_04 - Step 03: Click to Login button");
     loginPage.clickToLoginButton();
     System.out.println("Logic_04 - Step 04: verify error message with blank pass");
	 Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");	 
 }
 
 @Test
 public void Logic_05_Existing_Email_Wrong_Pass() {
	 System.out.println("Logic_05 - Step 01: Click to Login link");
	 loginPage = homePage.clickToLoginLink();
	 
	 System.out.println("Logic_05 - Step 02: enter an existing email with a wrong password");
	 loginPage.inputToEmailTextbox(existingEmail);
	 loginPage.inputToPasswordTextbox("123");
	 System.out.println("Logic_05 - Step 03: Click to Login button");
     loginPage.clickToLoginButton();
     System.out.println("Logic_05 - Step 04: verify error message with wrong pass");
	 Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");	 
 }
 
 @Test
 public void Logic_06_Valid_Email_Password() {
	 System.out.println("Logic_06 - Step 01: Click to Login link");
	 loginPage = homePage.clickToLoginLink();

	 System.out.println("Logic_06 - Step 02: enter an existing email and password");
	 loginPage.inputToEmailTextbox(existingEmail);
	 loginPage.inputToPasswordTextbox(password);
	 System.out.println("Logic_06 - Step 03: Click to Login button");
	 homePage = loginPage.clickToLoginButton();
     System.out.println("Logic_06 - Step 04: verify login successful by my account link is displayed at home page");
	 Assert.assertTrue(homePage.isMyAccountLinkedDisplayed());
	 
	 myAccountPage = homePage.clickToMyAccountLink();
 }

  

  


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
