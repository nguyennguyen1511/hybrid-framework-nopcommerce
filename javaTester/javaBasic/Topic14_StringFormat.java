package javaBasic;

public class Topic14_StringFormat {
	
	public static String CUSTOMER_INFO_LINK ="//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static String ADDRESS_LINK ="//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String MY_PRODUCT_REVIEW_LINK ="//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static String REWARD_POINT_LINK ="//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	
	public static String DYNAMIC_LINK_SIDEBAR = "//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";
	
	public static void main (String[] args){
		clickToLink(CUSTOMER_INFO_LINK);
		
		clickToLink(DYNAMIC_LINK_SIDEBAR,"Customer info");
		
		clickToLink(DYNAMIC_LINK_SIDEBAR,"account-navigation","Customer info");
		
	}
/*
	private static void clickToLink(String locator) {
		System.out.println("Click To "+ locator);
		
	}
	private static void clickToLink(String dynamicLocator, String pageName) {
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("Click To "+ locator);
	}
	private static void clickToLink(String dynamicLocator, String areaName, String pageName) {
		String locator = String.format(dynamicLocator, areaName, pageName);
		System.out.println("Click To "+ locator);
	}
	*/
	private static void clickToLink(String dynamicLocator, String...params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click To "+ locator);
	}
}
