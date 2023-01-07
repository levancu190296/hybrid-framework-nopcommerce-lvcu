package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void EnterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementClickable(driver, HomePageUI.HEADER_TEXTBOX_LABEL_NAME, headerLabel);
		sendKeytoElement(driver, HomePageUI.HEADER_TEXTBOX_LABEL_NAME, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_LABEL_NAME, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE, pageNumber);
	}

	public void maxWindow() {
		fullSite(driver);
	}

	public List<String> getvalueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINGNATION);
		System.out.println("tong page = " + totalPage);

		List<String> allRowValueAllPage = new ArrayList<String>();

		// duyet qua tat ca paging number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINGNATION_INDEX, String.valueOf(index));

			// get text cua tat ca row moi page dua vao array list
			List<WebElement> allRowElementOfPage = getListWebElement(driver, HomePageUI.ROW_Country_OF_PAGE);
			for (WebElement eachRow : allRowElementOfPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		// in tat ca value cua tat ca cac row ,cua tat ca cac page
		for (String value : allRowValueAllPage) {
			System.out.println(value);
		}
		return allRowValueAllPage;
	}

	public void enterToTextboxAtrowNumberColumnName(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		// senky vao dong nao
		waitForElementVisible(driver, HomePageUI.ROW_TEXBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		sendKeytoElement(driver, HomePageUI.ROW_TEXBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,String.valueOf(columnIndex));
	}
	
	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.DROPDOWM_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWM_BY_COLUMN_INDEX_AND_ROW_INDEX,valueToSelect, String.valueOf(columnIndex));
		
		
	}
}














