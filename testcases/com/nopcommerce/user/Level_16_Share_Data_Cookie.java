package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.common.Common_01_Register_End_User;

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

public class Level_16_Share_Data_Cookie extends BaseTest {
	private WebDriver driver;
	//declare (khai bao)
	private String  emailAddress, password;

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")	
	@BeforeClass
  public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);	
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register_End_User.emailAddress;
		password = Common_01_Register_End_User.password;
		
		log.info("Login - Step 02: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("set cookie");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookie);
		
		loginPage.refreshPage(driver);

		}
		
	@Test
	public void Search_01_EmptyData() {

}
 

 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
