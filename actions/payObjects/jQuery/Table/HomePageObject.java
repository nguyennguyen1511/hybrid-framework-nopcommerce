package payObjects.jQuery.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.Table.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void openPagingByNumber(String pageNumber) {
		waitForElementclickAbled(driver,HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver,HomePageUI.PAGINATION_PAGE_BY_NUMBER,pageNumber);
		
	}
	public void enterToHeaderTextboxByLable(String headerLable, String value) {
		waitForElementVisible(driver,HomePageUI.HEADER_TEXTBOX_BY_LABLE,headerLable);
		sendKeysToElement(driver,HomePageUI.HEADER_TEXTBOX_BY_LABLE, value,headerLable);
		pressKeyToElement(driver,HomePageUI.HEADER_TEXTBOX_BY_LABLE, Keys.ENTER,headerLable);
		
	}
	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver,HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER,pageNumber);
		return isElementDisplayed(driver,HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER,pageNumber);
		
	}
	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver,HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total zie ="+ totalPage);
		
		List<String> allRowValueAllPage = new ArrayList<String>();
		
		Set<String> allRowValueUniqueAllPage = new HashSet<String>();
		
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver,HomePageUI.PAGINATION_BY_INDEX, String.valueOf(index));
			sleepInSecond(1);
			
			List<WebElement> allRowElementEachPage = getListWebElement(driver,HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
			
		}
		for (String value : allRowValueAllPage) {
			System.out.println(value);
			
		}
		return allRowValueAllPage;
		
		
	}
	public void enterToTextboxByColumNameAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1;
		
		waitForElementVisible(driver,HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		sendKeysToElement(driver,HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,value, rowNumber,String.valueOf(columnIndex));
		
	}
	public void selectDropdownByColumNameAtRowNumber(String columnName, String rowNumber, String valueSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1;
		
		waitForElementclickAbled(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueSelect,rowNumber,String.valueOf(columnIndex));
		
	}
	public void clickLoadDataButton() {
		waitForElementVisible(driver,HomePageUI.BUTTON_LOAD_DATA);
		clickToElement(driver,HomePageUI.BUTTON_LOAD_DATA);
		
	}
	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1;
		
		waitForElementclickAbled(driver,HomePageUI.CHECKBOX_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver,HomePageUI.CHECKBOX_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
	}
	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1;
		
		waitForElementclickAbled(driver,HomePageUI.CHECKBOX_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver,HomePageUI.CHECKBOX_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
	}
	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementVisible(driver,HomePageUI.ICON_BY_ROW_INDEX,rowNumber,iconName);
		clickToElement(driver,HomePageUI.ICON_BY_ROW_INDEX,rowNumber,iconName);
		
	}
	

}
