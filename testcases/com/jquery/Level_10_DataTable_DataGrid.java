// nhiều page có nhóm chức năng giống nhâu = 1 hàm, sử dụng tính đa hình, rest parameter
// chỉ cần 1 hàm để mở nhiều page có cùng screen or the same chức năng
package com.jquery;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;
import pageUIs.jQuery.dataTable.HomePageUI;

public class Level_10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	
	List<String> actualallCountryValue;
	List<String> expectedallCountryValue;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.maxWindow();
	}

	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActive("10"));
		homePage.sleepInSecond(4);
		homePage.openPagingByPageNumber("19");
		Assert.assertTrue(homePage.isPageNumberActive("19"));
		homePage.sleepInSecond(4);
		homePage.openPagingByPageNumber("21");
		Assert.assertTrue(homePage.isPageNumberActive("21"));
		homePage.sleepInSecond(4);

	}

	public void Table_02_Enter_To_Header() {
		// homePage.refreshCurrentPage(driver);
		homePage.EnterToHeaderTextboxByLabel("Females", "24128");
//		homePage.EnterToHeaderTextboxByLabel("Country", "Albania");
//		homePage.EnterToHeaderTextboxByLabel("Males", "25266");
//		homePage.EnterToHeaderTextboxByLabel("Total", "49397");
//
		homePage.sleepInSecond(5);
//
//		homePage.EnterToHeaderTextboxByLabel("Country", "Aruba");
//		homePage.EnterToHeaderTextboxByLabel("Males", "756");
//		homePage.EnterToHeaderTextboxByLabel("Females", "750");
//		homePage.EnterToHeaderTextboxByLabel("Total", "1504");
//		homePage.sleepInSecond(4);
	}

	public void Table_03() {
		actualallCountryValue = homePage.getvalueEachRowAtAllPage();
		Assert.assertEquals(actualallCountryValue, expectedallCountryValue);
	}

	@Test
	public void Table_04_Action_At_Any_row() {
		// value de nhap lieu
		// row number
		// column name
		homePage.enterToTextboxAtrowNumberColumnName("Company", "1", "LVCU 96");
		homePage.enterToTextboxAtrowNumberColumnName("Contact Person", "1", "LVCU");
		homePage.enterToTextboxAtrowNumberColumnName("Order Placed", "1", "96");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Japan");
		homePage.sleepInSecond(1);
		//using temp due to change data from UI
		driver.findElement(By.xpath("//button[@id='load']")).click();
		//end xai tam thoi
		
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","2");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","3");

		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?","1");
		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?","4");

		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("5","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("4","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("1","Remove Current Row");

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		int number = 100000;
		return rand.nextInt(number);
	}

	private WebDriver driver;
}
