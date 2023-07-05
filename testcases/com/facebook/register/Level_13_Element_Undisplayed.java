package com.facebook.register;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;


public class Level_13_Element_Undisplayed extends BaseTest {
	

	@Parameters({"browser","url"})	
	@BeforeClass
  public void beforeClass(String browserName, String appUrl) {
		
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
	}
	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateButton();
		verifyTrue(loginPage.isEmailAddressDisplayed());
	}
	@Test
	public void TC_02_Verify_Element_Undisplayed_IN_DOM() {
		loginPage.enterEmailToForm("automationfc@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isEmailConfirmAddressDisplayed());
		
		loginPage.enterEmailToForm("");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmAddressEmailUndisplayed());
	}
	@Test
	public void TC_03_Verify_Element_Undisplayed_NOT_IN_DOM() {

		loginPage.clickToCloseIcon();
		verifyTrue(loginPage.isConfirmAddressEmailUndisplayed());
		

	}


@AfterClass
  public void afterClass() {
	  driver.quit();
  }
  private WebDriver driver;
  private LoginPageObject loginPage;
}
