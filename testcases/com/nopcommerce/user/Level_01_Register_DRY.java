package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_01_Register_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	BasePage basepage = new BasePage();
	
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://demo.nopcommerce.com/");
		basepage.openPageUrl(driver, "https://demo.nopcommerce.com/");
	
		
		firstName  = "le";
	    lastName = "cu";
	    emailName = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    password = "123abc";
	    confirmPassword = "123abc";
  
	}	
	
	
	@Test
	public void TC_01_Register_Empty_Data() {
		driver.findElement(By.xpath("//li//a[text()='Register']")).click();
		driver.findElement(By.id("register-button")).click();
		  
		Assert.assertEquals(driver.findElement(By.id("FirstName-error")).getText(), "First name is required.");Assert.assertEquals(driver.findElement(By.id("LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.id("Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Password is required.");
	}
  
	
	public void TC_02_Register_Invalid_Email() {
		driver.findElement(By.xpath("//li//a[text()='Register']")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input#Email")).sendKeys("ewewqesadsa");
		driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(confirmPassword);
	  
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	  
	}
	
	
	public void TC_03_Register_Success() {
		driver.findElement(By.xpath("//li//a[text()='Register']")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailName);
		driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(confirmPassword);
	  
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		driver.findElement(By.cssSelector("a.ico-logout")).click();
	  
	}
  
	public void TC_04_Register_Existing_Email() {
		driver.findElement(By.xpath("//li//a[text()='Register']")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input#Email")).sendKeys("lvcu@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(confirmPassword);
	  
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");
	  
	}
	
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		driver.findElement(By.xpath("//li//a[text()='Register']")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input#Email")).sendKeys("lvcu@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("1");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("1");
	  
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");
	  
	}
  
	public void TC_06_Register_Invalid_Confirm_Password() {
		driver.findElement(By.xpath("//li//a[text()='Register']")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input#Email")).sendKeys("lvcu@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("1234567");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("1");
	  
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
	  
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	  
	}
  //###################--FIRST--FUNCTION--########################
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(4);
	}
  //##########################--LAST--FUNCTION--##################
}
