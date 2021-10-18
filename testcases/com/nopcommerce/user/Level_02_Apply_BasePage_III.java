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

public class Level_02_Apply_BasePage_III extends BasePage {
	WebDriver driver;
	//declare (khai bao)
	String emailAddress;
	String projectPath = System.getProperty("user.dir");
	
 @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath +"/browser/geckodriver.exe");
		driver = new FirefoxDriver();

		//che giau di viec khoi tao
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
 }
 
 @Test
  public void TC_01_Register_Empty_Data() {
	  waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  waitForElementclickAbled(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");

	  Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),"Password is required.");
	  Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  sendKeysToElement(driver, "//input[@id='Email']", "123");
	  sendKeysToElement(driver, "//input[@id='Password']", "123456");
	  sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");

	  waitForElementclickAbled(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),"Wrong email");
  }
  
  @Test
  public void TC_03_Register_Success() {
	  waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	  sendKeysToElement(driver, "//input[@id='Password']", "123456");
	  sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");

	  waitForElementclickAbled(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[@class='result']"),"Your registration completed");
	  
	  waitForElementclickAbled(driver, "//a[@class='ico-logout']");
	  clickToElement(driver, "//a[@class='ico-logout']");
  }
  
  @Test
  public void TC_04_Register_Existing_Email() {
	  waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	  sendKeysToElement(driver, "//input[@id='Password']", "123456");
	  sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456"); 

	  waitForElementclickAbled(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]//li"),"The specified email already exists");
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	  sendKeysToElement(driver, "//input[@id='Password']", "123");
	  sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123"); 

	  waitForElementclickAbled(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver,"//span[@id='Password-error']"),"Password must meet the following rules:\n" + "must have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_Invalid_ConfirmPassword() {
	  waitForElementclickAbled(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
	  sendKeysToElement(driver, "//input[@id='LastName']", "FC");
	  sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	  sendKeysToElement(driver, "//input[@id='Password']", "123456");
	  sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123"); 

	  waitForElementclickAbled(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");
	  
	  
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
