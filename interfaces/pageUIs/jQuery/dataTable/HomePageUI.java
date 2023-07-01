package pageUIs.jQuery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER="xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE="xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_LABEL_NAME="xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINGNATION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINGNATION_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ROW_OF_PAGE = "xpath=//tbody/tr";
	public static final String ROW_Country_OF_PAGE = "xpath=//tr/td[@data-key='country']";
	
	//index cot minh can enter/click/select
	public static final String COLUMN_INDEX_BY_NAME="xpath=//tr/th[text()='%s']/preceding-sibling::th";
	
	//senkey
	public static final String ROW_TEXBOX_BY_COLUMN_INDEX_AND_ROW_INDEX="xpath=//tbody/tr[%s]/td[%s]/input";
	
	public static final String DROPDOWM_BY_COLUMN_INDEX_AND_ROW_INDEX="xpath=//tbody/tr[1]/td[4]/div/select";
	
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX="xpath=//tbody//tr[%s]//td[%s]//input[@type='checkbox']";
	
	public static final String ICON_BY_ROW_NUMBER ="xpath=//tbody/tr[%s]//button[@title='%s']//i";
	
}