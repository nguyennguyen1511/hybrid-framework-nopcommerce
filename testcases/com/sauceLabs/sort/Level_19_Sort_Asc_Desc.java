package com.sauceLabs.sort;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import payObjects.sauceLabs.sort.LoginPageObject;
import payObjects.sauceLabs.sort.PageGeneratorManager;
import payObjects.sauceLabs.sort.ProductPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_19_Sort_Asc_Desc extends BaseTest {
	private WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;

	
	@Parameters({"browser","appUrl"})	
	@BeforeClass
	public void beforeClass(String browserName, String sauceLabsUrl) {

		driver = getBrowserDriver(browserName, sauceLabsUrl);		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		
		productPage= loginPage.clickToLoginButton();
	

		}
 
	@Test
	public void Sort_01_Name() {
		
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		//Assert.assertTrue(productPage.isProductNameSortByAscending());
		Assert.assertTrue(productPage.isProductSortedAsc());
		
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		//Assert.assertTrue(productPage.isProductNameSortByDescending());
		Assert.assertTrue(productPage.isProductSortedDesc());
		
	}


	@Test
	public void Sort_02_Price() {
 		
 		productPage.selectItemInProductSortDropdown("Price (low to high)");
 		Assert.assertTrue(productPage.isProductPriceSortByAscending());
 		
 		
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
		

	}
 
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
