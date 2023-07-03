package com.jquery;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import commons.BasePage;
import commons.BaseTest;
import payObjects.jQuery.UploadFile.HomePageObject;
import payObjects.jQuery.UploadFile.PageGeneratorManager;


public class Level_11_Upload_Files extends BaseTest {
	
	String image2 = "image2.png";
	String image3 ="image3.png";
	String[] multipleFileNames = {"image2.png","image3.png"};


	@Parameters({"browser","url"})	
	@BeforeClass
  public void beforeClass(String browserName, String appUrl) {
		
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}
	@Test
	public void Upload_01_One_File() {
		homePage.uploadMultipleFiles(driver, image2);
		Assert.assertTrue(homePage.isFileLoadByName(image2));
		
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUPLoadByName(image2));
		Assert.assertTrue(homePage.isFileImageUPLoadByName(image2));
	}
	@Test
	public void Upload_02_Multiple_Files() {
		homePage.refreshPage(driver);
		homePage.uploadMultipleFiles(driver, multipleFileNames);
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUPLoadByName(image2));
		Assert.assertTrue(homePage.isFileLinkUPLoadByName(image3));
		
		Assert.assertTrue(homePage.isFileImageUPLoadByName(image2));
		Assert.assertTrue(homePage.isFileImageUPLoadByName(image3));
		
	}
	

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  private WebDriver driver;
  private HomePageObject homePage;
}
