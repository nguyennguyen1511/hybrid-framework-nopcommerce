package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;
import pageUIs.nopCommerce.user.RewardPointPageUI;

public class BasePage {
	public static BasePage getBasePageObject() {
		return new BasePage();
	}
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);	
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		return explicitwait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void canceltAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	
	public void switchToWindowsByID(WebDriver driver, String parentID) {
		Set <String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
				if (!id.equals(parentID)) {
						driver.switchTo().window(id);
					}
				}
				
	}
	public void switchToWindowsByTitle(WebDriver driver, String expectedTitle) {
		Set <String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			driver.switchTo().window(id);
			String windowTitle = driver.getTitle();
				if (windowTitle.equals(expectedTitle)) {
						break;
					}
				}
				
	}
	public void closeAllWindowWithoutParent (WebDriver driver, String parentID) {
		Set <String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {		
				if (!id.equals(parentID)) {
					driver.switchTo().window(id);
					driver.close();
					}
				}
		driver.switchTo().window(parentID);
	}
	
	//private By getByLocator (String locatorType) {
		//return By.xpath(locatorType);
	//}
	
	
	private By getByLocator (String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=")|| locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("css=")|| locatorType.startsWith("Css=")|| locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("name=")|| locatorType.startsWith("Name=")|| locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("class=")|| locatorType.startsWith("Class=")|| locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("xpath=")|| locatorType.startsWith("Xpath=")|| locatorType.startsWith("XPath=")|| locatorType.startsWith("XPATH=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator type is not supported!");
		}
		
		return by;
	}
	
	private String getDynamicXpath(String locatorType, String...values) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || 
				locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		}
	return locatorType;
	}

	private WebElement getWebElement (WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	private List<WebElement> getListWebElement (WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
	
	public void clickToElement (WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	public void clickToElement (WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver,getDynamicXpath( locatorType,dynamicValues)).click();
	}
	
	public void sendKeysToElement (WebDriver driver, String locatorType, String valueText) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(valueText);
	}
	public void sendKeysToElement (WebDriver driver, String locatorType, String valueText, String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath (locatorType, dynamicValues));
		element.clear();
		element.sendKeys(valueText);
	}
	
	public void selectItemInDefaultDropdow(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textItem);
		
	}
	public void selectItemInDefaultDropdow(WebDriver driver, String locatorType, String textItem, String...dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)));
		select.selectByValue(textItem);
		
	}
	
	public String getSelectedItemInDefaultDropdow(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
		
	}
	
	public boolean isDropdowMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
		
	}
	
	public void selectItemInCustomDropdow (WebDriver driver, String parentXpath, String childXpath, String expectedItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(5);
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		List <WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		
		for (WebElement item : allItems ) {
			if (item.getText().trim().equals(expectedItem)){
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(1);
				item.click();
				break;
					
			}
		}
	}
	
    public void sleepInSecond(long timeoutInSecond){
    	try{
    		Thread.sleep(timeoutInSecond *1000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    
    public String getElementAttribute (WebDriver driver, String locatorType, String attributeName) {
    	return getWebElement(driver, locatorType).getAttribute(attributeName);
    }
    
    public String getElementText(WebDriver driver, String locatorType) {
    	return getWebElement(driver, locatorType).getText();
    }
    public String getElementText(WebDriver driver, String locatorType, String...dynamicValues) {
    	return getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).getText();
    }
    
    public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
    	return getWebElement(driver, locatorType).getCssValue(propertyName);
    }
    
    public String getHexaColorFromRGBA(WebDriver driver, String rgbaValue) {
    	return Color.fromString(rgbaValue).asHex();
    }
    
	public int getElementSize (WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}
	public int getElementSize (WebDriver driver, String locatorType,String...dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).size();
	}
	
	public void checkToDefaultCheckboxRadio (WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckbox (WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();	
	}
	public boolean isElementDisplayed(WebDriver driver, String locatorType,String...dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).isDisplayed();	
	}
	
	public boolean isElementEnbled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
		
	}
	
	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
		
	}
	
	public void switchToFrameIFrame(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions (driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		return status;
	}
	
	public boolean areJQueryLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return(window.jQuery!=null)&(jQuery.active===0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}
	
	public boolean isJQueryAndPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return((Long) jsExecutor.executeScript("return jQuery.active")==0);
				} catch (Exception e) {
					return true;
				}
			}
	};
	ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
			return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
		}
	};
	
	return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));	
	}
	public void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));	
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	public void waitForAllElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	public void waitForElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));	
	}
	
	public void waitForAllElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
		
	}
	
	public void waitForElementclickAbled(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
		
	}
	public void waitForElementclickAbled(WebDriver driver, String locatorType, String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait (driver, longTimeout); 
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
		
	}
	private long longTimeout = 30;
	
	//toi uu o bai hoc switch page
	
	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		waitForElementclickAbled(driver, BasePageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementclickAbled(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementclickAbled(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);

	}
	
	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementclickAbled(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);

	}
	
	// toi uu o bai hocj level_09_dynamic_locator
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementclickAbled(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My Account area.");
		}
	}
	public void openPagesAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForElementclickAbled(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	}
	//level_08_switch_role
	public UserLoginPageObject openLoginPage(WebDriver driver) {
		waitForElementclickAbled(driver, BasePageUI.LOGIN_LINK);
		clickToElement(driver, BasePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	public UserHomePageObject clickToLogOutLinkAtUserPage(WebDriver driver) {
		waitForElementclickAbled(driver, BasePageUI.LOGOUT_LINK_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogOutLinkAtAdminPage(WebDriver driver) {
		waitForElementclickAbled(driver, BasePageUI.LOGOUT_LINK_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
}
