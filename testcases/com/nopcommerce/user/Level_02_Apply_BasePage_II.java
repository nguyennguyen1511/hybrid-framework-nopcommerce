package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_II {
	WebDriver driver;
	//declare (khai bao)
	BasePage basePage;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");
	
 @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
		driver = new FirefoxDriver();

		//che giau di viec khoi tao
		basePage = BasePage.getBasePageObject();
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
 }
 
 @Test
  public void TC_01_Register_Empty_Data() {
	  basePage.waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.waitForElementclickAbled(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");

	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),"Password is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  basePage.waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.sendKeysToElement(driver, "//input[@id='Email']", "123");
	  basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456");
	  basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");

	  basePage.waitForElementclickAbled(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Wrong email");
  }
  
  @Test
  public void TC_03_Register_Success() {
	  basePage.waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456");
	  basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");

	  basePage.waitForElementclickAbled(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"),"Your registration completed");
	  
	  basePage.waitForElementclickAbled(driver, "//a[@class='ico-logout']");
	  basePage.clickToElement(driver, "//a[@class='ico-logout']");
  }
  
  @Test
  public void TC_04_Register_Existing_Email() {
	  basePage.waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456");
	  basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456"); 

	  basePage.waitForElementclickAbled(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"),"The specified email already exists");
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  basePage.waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.sendKeysToElement(driver, "//input[@id='Password']", "123");
	  basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123"); 

	  basePage.waitForElementclickAbled(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"),"Password must meet the following rules:\n" + "must have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_Invalid_ConfirmPassword() {
	  basePage.waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456");
	  basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123"); 

	  basePage.waitForElementclickAbled(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");
	  
	  
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
