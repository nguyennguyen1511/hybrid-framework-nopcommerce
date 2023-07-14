package payObjects.sauceLabs.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.UploadFile.HomePageUI;
import pageUIs.sauceLabs.ProductPageUI;

public class ProductPageObject extends BasePage{
	WebDriver driver;
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void selectItemInProductSortDropdown(String itemDropdown) {
		waitForElementclickAbled(driver,ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver,ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, itemDropdown);
		
	}
	public boolean isProductNameSortByAscending() {
		ArrayList<String> productUIList = new ArrayList<String>();
		
		List <WebElement> productNameList = getListWebElement(driver,ProductPageUI.PRODUCT_NAME_TEXT);
		
		for (WebElement productNameText: productNameList) {
			productUIList.add(productNameText.getText());
		}
		
		ArrayList <String> productSortList = new ArrayList<String>();
		
		for(String product: productUIList) {
			productSortList.add(product);
		}
		
		Collections.sort(productSortList);
		
		return productSortList.equals(productUIList);
	}
	public boolean isProductNameSortByDescending() {
		ArrayList<String> productUIList = new ArrayList<String>();
		
		List <WebElement> productNameList = getListWebElement(driver,ProductPageUI.PRODUCT_NAME_TEXT);
		
		for (WebElement productNameText: productNameList) {
			productUIList.add(productNameText.getText());
		}
		
		ArrayList <String> productSortList = new ArrayList<String>();
		
		for(String product: productUIList) {
			productSortList.add(product);
		}
		
		Collections.sort(productSortList);
		
		Collections.reverse(productSortList);
		
		return productSortList.equals(productUIList);
	}
	public boolean isProductPriceSortByAscending() {
		ArrayList <Float> productUIList = new ArrayList<Float>();
		List <WebElement> productPriceList = getListWebElement(driver,ProductPageUI.PRODUCT_PRICE);
		
		for (WebElement productPrice: productPriceList) {
			/*String priceText = productPrice.getText();
			priceText.replace("$", "");
			Float priceTextFloat = Float.parseFloat(priceText);*/
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$","")));
		}
		ArrayList <Float> productSortList = new ArrayList<Float>();
		for(Float product: productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		return productSortList.equals(productUIList);
	}
	public boolean isProductPriceSortByDescending() {
		ArrayList <Float> productUIList = new ArrayList<Float>();
		List <WebElement> productPriceList = getListWebElement(driver,ProductPageUI.PRODUCT_PRICE);
		
		for (WebElement productPrice: productPriceList) {
			/*String priceText = productPrice.getText();
			priceText.replace("$", "");
			Float priceTextFloat = Float.parseFloat(priceText);*/
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$","")));
		}
		ArrayList <Float> productSortList = new ArrayList<Float>();
		for(Float product: productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		Collections.reverse(productSortList);
		return productSortList.equals(productUIList);
	}
	
	public boolean isProductSortedAsc() {
		List <WebElement> elementLists = getListWebElement(driver,ProductPageUI.PRODUCT_NAME_TEXT);
		List <String> names = elementLists.stream().map(n ->n.getText()).collect(Collectors.toList());
		List <String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		return names.equals(sortedNames);
	}
	public boolean isProductSortedDesc() {
		List <WebElement> elementLists = getListWebElement(driver,ProductPageUI.PRODUCT_NAME_TEXT);
		List <String> names = elementLists.stream().map(n ->n.getText()).collect(Collectors.toList());
		List <String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		Collections.reverse(sortedNames);
		return names.equals(sortedNames);
	}

}
