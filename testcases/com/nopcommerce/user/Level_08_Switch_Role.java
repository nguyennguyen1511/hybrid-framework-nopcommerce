package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
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

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	//declare (khai bao)
	private String  userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	@Parameters("browser")	
	@BeforeClass
  public void beforeClass(String browserName) {
//		System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
		driver = getBrowserDriver(browserName);
		
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		

		userPassword ="123456";
		userEmailAddress = "donaldtrump1611@gmail.com";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

		}
 
 @Test
 public void Role_01_User_To_Admin() {
	 userLoginPage = userHomePage.openLoginPage(driver);
	 
	 userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
	 Assert.assertTrue(userHomePage.isMyAccountLinkedDisplayed());
	 userCustomerInfoPage = userHomePage.openCustomerInfoPage(driver);
	 
	 userHomePage = userCustomerInfoPage.clickToLogOutLinkAtUserPage(driver);
	 
	 userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_STAGING_URL);
	 adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	 
	 adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
	 
	 Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	 adminLoginPage = adminDashboardPage.clickToLogOutLinkAtAdminPage(driver);
 }
 
 @Test
 public void Role_02_Admin_To_User() {

	 userHomePage.openPageUrl(driver, GlobalConstants.PORTAL_STAGING_URL);
	 userHomePage = PageGeneratorManager.getUserHomePage(driver);
	 userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
	 Assert.assertTrue(userHomePage.isMyAccountLinkedDisplayed());
	 
 }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
