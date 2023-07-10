package com.nopcommerce.user;

import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;


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

public class Level_15_Allure extends BaseTest {
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
@Description("User_01_Register")	
 @Severity(SeverityLevel.NORMAL)
 @Test
	public void User_01_Register() {
	 	registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.inputToEmailTextbox(emailAddress);
		
		registerPage.inputToPasswordTextbox(password);
		
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getSuccessRegisterMessage(), "Your registration completed");
		
		
		
	}
@Test
	public void User_02_Login() {

		//homePage = registerPage.clickToLogoutLink();
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(emailAddress);
		
		loginPage.inputToPasswordTextbox(password);
		
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertFalse(homePage.isMyAccountLinkedDisplayed());
		
		customerInfoPage = homePage.clickToMyAccountLink();
		
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
		
}
 

 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
