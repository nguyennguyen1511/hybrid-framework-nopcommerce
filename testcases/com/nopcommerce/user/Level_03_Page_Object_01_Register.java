package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	//declare (khai bao)
	private String lastName, firstName, emailAddress, password;
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	
 @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		firstName ="Automation";
		lastName = "FC";
		password ="123456";

		//che giau di viec khoi tao
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);

 }
 
 @Test
  public void Register_01_Empty_Data() { 
	  System.out.println("Register_01 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_01 - Step 02: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_01 - Step 03: Verify error message when entering empty data");
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");

  }
  
  @Test
  public void Register_02_Invalid_Email() {
	  System.out.println("Register_02 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_02 - Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox("123");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	
	  System.out.println("Register_02 - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_02 - Step 04: verify error wrong message");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
  }
  
  @Test
  public void Register_03_Success() {
	  System.out.println("Register_03 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_03 - Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);

	  System.out.println("Register_03 - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_03 - Step 04: verify success message");
	  Assert.assertEquals(registerPage.getSuccessRegisterMessage(),"Your registration completed");

	  System.out.println("Register_03 - Step 05: click to logout link");
	  registerPage.clickToLogoutLink();
  }
  
  @Test
  public void Register_04_Existing_Email() {
	  System.out.println("Register_04 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_04 - Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  
	  System.out.println("Register_04 - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_04 - Step 04: verify error message");
	  Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
  }
  
  @Test
  public void Register_05_Password_Less_Than_6_Chars() {
	  System.out.println("Register_05 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();

	  System.out.println("Register_05 - Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("123");
	  registerPage.inputToConfirmPasswordTextbox("123");
	  
	  System.out.println("Register_05 - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_05 - Step 04: verify error message");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\n" + "must have at least 6 characters");
  }
  
  @Test
  public void Register_06_Invalid_ConfirmPassword() {	  
	  System.out.println("Register_06 - Step 01: Click to Register link");
	  homePage.clickToRegisterLink();

	  System.out.println("Register_06 - Step 02: input to required fields");
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox("123");
	  
	  System.out.println("Register_06 - Step 03: Click to Register button");
	  registerPage.clickToRegisterButton();
	  
	  System.out.println("Register_06 - Step 04: verify error message");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
	  
  }
  
  public int generateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
  }
  


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
