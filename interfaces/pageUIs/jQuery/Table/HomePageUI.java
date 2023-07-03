package pageUIs.jQuery.Table;

public class HomePageUI {
	//https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
	public static final String PAGINATION_PAGE_BY_NUMBER ="xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER ="xpath=//li[@class=\"qgrd-pagination-page\"]/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABLE = "xpath=//div[@class='qgrd-header-text' and text()='Females']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";
	
	//https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
	public static final String COLUMN_INDEX_BY_NAME="xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX="xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX="xpath=//tbody/tr[%s]/td[%s]/div/select";
	public static final String BUTTON_LOAD_DATA ="xpath=//button[@id='load']";
	public static final String CHECKBOX_COLUMN_INDEX_AND_ROW_INDEX="xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	public static final String ICON_BY_ROW_INDEX="xpath=//tbody/tr[%s]//button[@title='%s']";

}
