//package com.nopcommerce.user;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.server.handler.GetElementText;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//public class Level_02_Apply_BasePage_01 {
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	//declare : khai bao
//	BasePage basepage;
//	
//	//variable
//	String confirmPassword;
//	String password;
//	String emailName;
//	String lastName;
//	String firstName;
//	
//	@BeforeClass
//	public void beforeClass() {
//		
//		System.setProperty("webdriver.gecko.driver",  projectPath +"\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		//initial : khoi tao
//		basepage = new BasePage();
//		//basepage: Object
//		//BasePage: Class
//		
//		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		basepage.openPageUrl(driver, "https://demo.nopcommerce.com/");
//	
//		
//		firstName  = "le";
//	    lastName = "cu";
//	    emailName = "lvcu" + generateFakeNumber()+ "@gmail.com";
//	    password = "123abc";
//	    confirmPassword = "123abc";
//  
//	}	
//	
//	@Test
//	public void TC_01_Register_Empty_Data() {
//		basepage.waitForElementClickable(driver, "//li//a[text()='Register']");
//		basepage.clickToElement(driver, "//li//a[text()='Register']");
//		
//		basepage.waitForElementClickable(driver, "//div//button[@id='register-button']");
//		basepage.clickToElement(driver, "//div//button[@id='register-button']");
//		
//		Assert.assertEquals(basepage.getElementText(driver,"//span[@id='FirstName-error']"), "First name is required.");
//		Assert.assertEquals(basepage.getElementText(driver,"//span[@id='LastName-error']"), "Last name is required.");
//		Assert.assertEquals(basepage.getElementText(driver,"//span[@id='Email-error']"), "Email is required.");
//		Assert.assertEquals(basepage.getElementText(driver,"//span[@id='Password-error']"), "Password is required.");
//		Assert.assertEquals(basepage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");
//	}
//  
//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		basepage.waitForElementClickable(driver, "//li//a[text()='Register']");
//		basepage.clickToElement(driver, "//li//a[text()='Register']");
//		
//		basepage.sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
//		basepage.sendKeytoElement(driver, "//input[@id='LastName']", lastName);
//		basepage.sendKeytoElement(driver, "//input[@id='Email']", "ewewqesadsa");
//		basepage.sendKeytoElement(driver, "//input[@id='Password']", password);
//		basepage.sendKeytoElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
//	  
//		basepage.waitForElementClickable(driver, "//div//button[@id='register-button']");
//		basepage.clickToElement(driver, "//div//button[@id='register-button']");
//		
//		Assert.assertEquals(basepage.getElementText(driver,"//span[@id='Email-error']"), "Wrong email");
//	  
//	}
//	
//	@Test
//	public void TC_03_Register_Success() {
//		basepage.waitForElementClickable(driver, "//li//a[text()='Register']");
//		basepage.clickToElement(driver, "//li//a[text()='Register']");
//		
//		basepage.sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
//		basepage.sendKeytoElement(driver, "//input[@id='LastName']", lastName);
//		basepage.sendKeytoElement(driver, "//input[@id='Email']", emailName);
//		basepage.sendKeytoElement(driver, "//input[@id='Password']", password);
//		basepage.sendKeytoElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
//	  
//		basepage.waitForElementClickable(driver, "//div//button[@id='register-button']");
//		basepage.clickToElement(driver, "//div//button[@id='register-button']");
//		
//		Assert.assertEquals(basepage.getElementText(driver,"//div//div[@class='result']"), "Your registration completed");
//		
//		basepage.waitForElementClickable(driver, "//a[@class='ico-logout']");
//		basepage.clickToElement(driver, "//a[@class='ico-logout']");
//	  
//	}
//  
//	@Test
//	public void TC_04_Register_Existing_Email() {
//		basepage.waitForElementClickable(driver, "//li//a[text()='Register']");
//		basepage.clickToElement(driver, "//li//a[text()='Register']");
//		
//		basepage.sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
//		basepage.sendKeytoElement(driver, "//input[@id='LastName']", lastName);
//		basepage.sendKeytoElement(driver, "//input[@id='Email']", "lvcu@gmail.com");
//		basepage.sendKeytoElement(driver, "//input[@id='Password']", password);
//		basepage.sendKeytoElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
//	  
//		basepage.waitForElementClickable(driver, "//div//button[@id='register-button']");
//		basepage.clickToElement(driver, "//div//button[@id='register-button']");
//		
//		Assert.assertEquals(basepage.getElementText(driver,"//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");
//	  
//	}
//	
//	@Test
//	public void TC_05_Register_Password_Less_Than_6_Chars() {
//		basepage.waitForElementClickable(driver, "//li//a[text()='Register']");
//		basepage.clickToElement(driver, "//li//a[text()='Register']");
//		
//		basepage.sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
//		basepage.sendKeytoElement(driver, "//input[@id='LastName']", lastName);
//		basepage.sendKeytoElement(driver, "//input[@id='Email']", emailName);
//		basepage.sendKeytoElement(driver, "//input[@id='Password']", "1");
//		basepage.sendKeytoElement(driver, "//input[@id='ConfirmPassword']", "1");
//	  
//		basepage.waitForElementClickable(driver, "//div//button[@id='register-button']");
//		basepage.clickToElement(driver, "//div//button[@id='register-button']");
//		
//		Assert.assertEquals(basepage.getElementText(driver,"//span[@id='Password-error']"), "Password must meet the following rules:\n"
//				+ "must have at least 6 characters");
//	  
//	}
//  
//	@Test
//	public void TC_06_Register_Invalid_Confirm_Password() {
//		basepage.waitForElementClickable(driver, "//li//a[text()='Register']");
//		basepage.clickToElement(driver, "//li//a[text()='Register']");
//		
//		basepage.sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
//		basepage.sendKeytoElement(driver, "//input[@id='LastName']", lastName);
//		basepage.sendKeytoElement(driver, "//input[@id='Email']", "lvcu@gmail.com");
//		basepage.sendKeytoElement(driver, "//input[@id='Password']", password);
//		basepage.sendKeytoElement(driver, "//input[@id='ConfirmPassword']", "ddfgsad");
//	  
//		basepage.waitForElementClickable(driver, "//div//button[@id='register-button']");
//		basepage.clickToElement(driver, "//div//button[@id='register-button']");
//		
//		Assert.assertEquals(basepage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//	  
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	  
//	}
//  //###################--FIRST--FUNCTION--########################
//	public int generateFakeNumber() {
//		Random rand = new Random();
//		return rand.nextInt(4);
//	}
//  //##########################--LAST--FUNCTION--##################
//}
