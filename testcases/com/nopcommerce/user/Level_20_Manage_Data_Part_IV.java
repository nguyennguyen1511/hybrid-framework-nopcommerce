package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import data.nopcommerce.UserDataMapper;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;
import utilities.DataHelper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_20_Manage_Data_Part_IV extends BaseTest {
	private WebDriver driver;
	//declare (khai bao)
	private String lastName, firstName, emailAddress, password;
	private String date, month, year;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private DataHelper fakerData;
	private UserDataMapper userData;
	@Parameters({"browser","appUrl"})	
	@BeforeClass
  public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		fakerData = DataHelper.getDataHelper();
		userData = UserDataMapper.getUserData();
	
		emailAddress = userData.getEmailAddress() +generateFakeNumber() + "@fakemail.com";

		}
 
 @Test
	public void User_01_Register() {
	 	log.info("Register - Step 01: Navigate to 'Register' page");	 	
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Select Gender");
		registerPage.clickToRadioButtonByLabel(driver,"Female");
		
		log.info("Register - Step 02: enter to FirsName with value is '" + userData.getFirstName() + "'");		
		registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());
		
		log.info("Register - Step 03: enter to LastName with value is '" + userData.getLastName() + "'");
		registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());
		
		log.info("Register - Enter Birthday");
		registerPage.selectToDropdownByName(driver,"DateOfBirthDay", userData.getDate());
		registerPage.selectToDropdownByName(driver,"DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver,"DateOfBirthYear", userData.getYear());
		
		
		log.info("Register - Step 04: enter to Email with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Register - click to checkbox");
		registerPage.clickToCheckboxByLabel(driver,"Newsletter");
		
		log.info("Register - Step 05: enter to Password with value is '" + userData.getPassword() + "'");
		registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());
		
		log.info("Register - Step 06: enter to Confirm Pass with value is '" + password + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());
		
		log.info("Register - Step 07: click on 'Register' Button");
		registerPage.clickToButtonByText(driver,"Register");
		
		log.info("Register - Step 08: verify message register success");
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");

		
	}
@Test
	public void User_02_Login() {
	
		//log.info("Login - Step 01: click on 'Logout' Button");
		//homePage = registerPage.clickToLogoutLink();
		
		log.info("Login - Step 02: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 03: enter to Email with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login - Step 04: enter to Password with value is '" + userData.getPassword() + "'");
		loginPage.inputToTextboxByID(driver, "Password", userData.getPassword());
		
		log.info("Login - Step 05: click on 'Login' Button");
		loginPage.clickToButtonByText(driver,"Log in");
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 06: verify 'My Account' display");
		Assert.assertTrue(homePage.isMyAccountLinkedDisplayed());
		
		log.info("Login - Step 07: click on 'My Account' link");
		customerInfoPage = homePage.clickToMyAccountLink();
		
		log.info("Login - Step 08: verify 'Customer Info' display");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
}
 
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}