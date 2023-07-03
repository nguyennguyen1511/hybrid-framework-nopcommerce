package com.jquery;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import commons.BasePage;
import commons.BaseTest;
import payObjects.jQuery.Table.HomePageObject;
import payObjects.jQuery.Table.PageGeneratorManager;


public class Level_10_DataTable_DataGrid extends BaseTest {

	HomePageObject homePage;
	List<String> actualAllCountryValue;
	List<String> expectedAllCountryValue;
	@Parameters({"browser","url"})	
	@BeforeClass
  public void beforeClass(String browserName, String appUrl) {
		
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}
	
	public void Table_01_Paging() {
		homePage.openPagingByNumber("10");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActive("10"));
		
		homePage.openPagingByNumber("12");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActive("12"));
		
		homePage.openPagingByNumber("4");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActive("4"));
		
		homePage.openPagingByNumber("6");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.isPageNumberActive("6"));
	}
	
	public void Table_02_Enter_To_Header() {
		homePage.refreshPage(driver);
		
		homePage.enterToHeaderTextboxByLable("Country", "Argentina");
		homePage.enterToHeaderTextboxByLable("Females", "338282");
		homePage.enterToHeaderTextboxByLable("Males", "349238");
		homePage.enterToHeaderTextboxByLable("Total", "687522");
		homePage.sleepInSecond(3);
		homePage.enterToHeaderTextboxByLable("Country", "Angola");
		homePage.enterToHeaderTextboxByLable("Females", "276880");
		homePage.enterToHeaderTextboxByLable("Males", "276472");
		homePage.enterToHeaderTextboxByLable("Total", "553353");
		homePage.sleepInSecond(3);
	}
	
	
	public void Table_03_get_Value_Each_Page() {
		//Doc du lieu cua fiel country.txt ra
		//Luu vao 1 list string = expected value = expectedAllCountryValue
		
		actualAllCountryValue = homePage.getValueEachRowAtAllPage();
		
		Assert.assertEquals(expectedAllCountryValue, actualAllCountryValue);
	}
	
	@Test
	public void Table_04_Action_At_AnyRow() {
		homePage.clickLoadDataButton();
		homePage.sleepInSecond(1);
		homePage.enterToTextboxByColumNameAtRowNumber("Company","1","ABC");
		homePage.enterToTextboxByColumNameAtRowNumber("Contact Person","1","Nguyen");
		
		
		homePage.selectDropdownByColumNameAtRowNumber("Country","1","Japan");
		homePage.sleepInSecond(1);
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","2");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","5");
		homePage.sleepInSecond(1);
		
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.sleepInSecond(3);
	}

 
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
