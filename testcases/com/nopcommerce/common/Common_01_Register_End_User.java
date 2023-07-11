package com.nopcommerce.common;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	//declare (khai bao)
	private String lastName, firstName;
	public static String emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	
		
	@Parameters("browser")
	@BeforeTest
	public void User_01_Register(String browserName) {

		driver = getBrowserDriver(browserName);		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName ="Automation";
		lastName = "FC";
		password ="123456";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		
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
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
		
		driver.quit();
	}

}
