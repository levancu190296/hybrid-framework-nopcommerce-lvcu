
package com.jquery;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;


public class Level_11_Upload_File extends BaseTest {
	private HomePageObject homePage;
	String separatorChar = File.separator;
	String IU = "IU.jpg";
	String Jennie = "jennie.jpg";
	String Rose = "rose.jpg";
	String[] mutipleFileNameStrings = {IU,Jennie,Rose};
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage =PageGeneratorManager.getHomePage(driver) ;
		homePage.maxWindow();
		
		
	}

	@Test
	public void Upload_01_File_Per_Time() {
		log.info("step 01 - load single file");
		homePage.uploadMutipleFiles(driver, Jennie);
		
		log.info("step 02 - verify loaded success");
		Assert.assertTrue(homePage.isfileLoadedByName(Jennie));
		
		log.info("step 03 - click to start button");
		homePage.clickToStartButton();
		
		log.info("step 04 - Verify single file link uploaded success");
		Assert.assertTrue(homePage.isfileUploadByName(Jennie));
		
		log.info("step 05 - Verify image uploaded success");
		Assert.assertTrue(homePage.isfileImageLoaded(Jennie));
		homePage.sleepInSecond(1);
	}
	
	
	public void Upload_Mutiple_File_Per_Time() {
		homePage.uploadMutipleFiles(driver, mutipleFileNameStrings);
		Assert.assertTrue(homePage.isfileLoadedByName(IU));
		Assert.assertTrue(homePage.isfileLoadedByName(Jennie));
		Assert.assertTrue(homePage.isfileLoadedByName(Rose));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isfileUploadByName(IU));
		Assert.assertTrue(homePage.isfileUploadByName(Jennie));
		Assert.assertTrue(homePage.isfileUploadByName(Rose));
		
		homePage.sleepInSecond(3);
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




















