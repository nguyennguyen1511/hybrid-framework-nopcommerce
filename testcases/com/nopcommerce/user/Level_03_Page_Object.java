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

public class Level_03_Page_Object {
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
  public void TC_01_Register_Empty_Data() { 
	  homePage.clickToRegisterLink();
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");

  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox("123");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
		 
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
  }
  
  @Test
  public void TC_03_Register_Success() {
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);

	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getSuccessRegisterMessage(),"Your registration completed");

	  registerPage.clickToLogoutLink();
  }
  
  @Test
  public void TC_04_Register_Existing_Email() {
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  

	  registerPage.clickToRegisterButton();
	  Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  homePage.clickToRegisterLink();

	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("123");
	  registerPage.inputToConfirmPasswordTextbox("123");
	  
	  registerPage.clickToRegisterButton();
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\n" + "must have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_Invalid_ConfirmPassword() {
	  homePage.clickToRegisterLink();
	  
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox("123");
	  
	  registerPage.clickToRegisterButton();
	  
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
