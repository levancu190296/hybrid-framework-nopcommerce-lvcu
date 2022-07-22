package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_03 extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	//declare : khai bao
	//BasePage basepage;
	
	//variable
	String confirmPassword;
	String password;
	String emailName;
	String lastName;
	String firstName;
	
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.gecko.driver",  projectPath +"\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//initial : khoi tao, che giau viec khoi tao mot doi tuong
		//basepage =  getBasePageObject();
		//basepage: Object
		//BasePage: Class
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		openPageUrl(driver, "https://demo.nopcommerce.com/");
	
		
		firstName  = "le";
	    lastName = "cu";
	    emailName = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    password = "123abc";
	    confirmPassword = "123abc";
  
	}	
	
	@Test
	public void TC_01_Register_Empty_Data() {
		waitForElementClickable(driver, "//li//a[text()='Register']");
		clickToElement(driver, "//li//a[text()='Register']");
		
		waitForElementClickable(driver, "//div//button[@id='register-button']");
		clickToElement(driver, "//div//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver,"//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals( getElementText(driver,"//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals( getElementText(driver,"//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals( getElementText(driver,"//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals( getElementText(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");
		System.out.println(generateFakeNumber());
	}
  
	@Test
	public void TC_02_Register_Invalid_Email() {
		 waitForElementClickable(driver, "//li//a[text()='Register']");
		 clickToElement(driver, "//li//a[text()='Register']");
		
		 sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
		 sendKeytoElement(driver, "//input[@id='LastName']", lastName);
		 sendKeytoElement(driver, "//input[@id='Email']", "ewewqesadsa");
		 sendKeytoElement(driver, "//input[@id='Password']", password);
		 sendKeytoElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
	  
		 waitForElementClickable(driver, "//div//button[@id='register-button']");
		 clickToElement(driver, "//div//button[@id='register-button']");
		
		Assert.assertEquals( getElementText(driver,"//span[@id='Email-error']"), "Wrong email");
	  
	}
	
	@Test
	public void TC_03_Register_Success() {
		 
		 waitForElementClickable(driver, "//li//a[text()='Register']");
		 clickToElement(driver, "//li//a[text()='Register']");
		
		 sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
		 sendKeytoElement(driver, "//input[@id='LastName']", lastName);
		 sendKeytoElement(driver, "//input[@id='Email']", emailName);
		 sendKeytoElement(driver, "//input[@id='Password']", password);
		 sendKeytoElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
	  
		 waitForElementClickable(driver, "//div//button[@id='register-button']");
		 clickToElement(driver, "//div//button[@id='register-button']");
		
		Assert.assertEquals( getElementText(driver,"//div//div[@class='result']"), "Your registration completed");
		
		 waitForElementClickable(driver, "//a[@class='ico-logout']");
		 clickToElement(driver, "//a[@class='ico-logout']");
	  
	}
  
	@Test
	public void TC_04_Register_Existing_Email() {
		 waitForElementClickable(driver, "//li//a[text()='Register']");
		 clickToElement(driver, "//li//a[text()='Register']");
		
		 sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
		 sendKeytoElement(driver, "//input[@id='LastName']", lastName);
		 sendKeytoElement(driver, "//input[@id='Email']", "lvcu@gmail.com");
		 sendKeytoElement(driver, "//input[@id='Password']", password);
		 sendKeytoElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
	  
		 waitForElementClickable(driver, "//div//button[@id='register-button']");
		 clickToElement(driver, "//div//button[@id='register-button']");
		
		Assert.assertEquals( getElementText(driver,"//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");
	  
	}
	
	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		 waitForElementClickable(driver, "//li//a[text()='Register']");
		 clickToElement(driver, "//li//a[text()='Register']");
		
		 sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
		 sendKeytoElement(driver, "//input[@id='LastName']", lastName);
		 sendKeytoElement(driver, "//input[@id='Email']", emailName);
		 sendKeytoElement(driver, "//input[@id='Password']", "1");
		 sendKeytoElement(driver, "//input[@id='ConfirmPassword']", "1");
	  
		 waitForElementClickable(driver, "//div//button[@id='register-button']");
		 clickToElement(driver, "//div//button[@id='register-button']");
		
		Assert.assertEquals( getElementText(driver,"//span[@id='Password-error']"), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");
	  
	}
  
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		 waitForElementClickable(driver, "//li//a[text()='Register']");
		 clickToElement(driver, "//li//a[text()='Register']");
		
		 sendKeytoElement(driver, "//input[@id='FirstName']", firstName);
		 sendKeytoElement(driver, "//input[@id='LastName']", lastName);
		 sendKeytoElement(driver, "//input[@id='Email']", "lvcu@gmail.com");
		 sendKeytoElement(driver, "//input[@id='Password']", password);
		 sendKeytoElement(driver, "//input[@id='ConfirmPassword']", "ddfgsad");
	  
		 waitForElementClickable(driver, "//div//button[@id='register-button']");
		 clickToElement(driver, "//div//button[@id='register-button']");
		
		Assert.assertEquals( getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	  
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	  
	}
  //###################--FIRST--FUNCTION--########################
	public int generateFakeNumber() {
		Random rand = new Random();
		int number = 100000;
		return rand.nextInt(number);
	}
  //##########################--LAST--FUNCTION--##################
}
