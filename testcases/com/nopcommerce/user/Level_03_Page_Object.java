package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object{
	//declare
	private WebDriver driver;
	private String lastName,firstName,emailName,password,confirmPassword;
	//declare + init
	private String projectPath=System.getProperty("user.dir");;
	private HomePageObject homepage;
	private RegisterPageObject registerPage;
	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver",  projectPath +"\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homepage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
	
		firstName  = "le";
	    lastName = "cu";
	    emailName = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    password = "123abc";
	    confirmPassword = "123abc";
	}	
	
	@Test
	public void TC_01_Register_Empty_Data() {
		homepage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtFisrtnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}
  
	@Test
	public void TC_02_Register_Invalid_Email() {
		homepage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("ewewqesadsa");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
	  
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	  
	}
	
	@Test
	public void TC_03_Register_Success() {
		homepage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailName);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
	  
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		registerPage.clickToLogout();
	  
	}
  
	@Test
	public void TC_04_Register_Existing_Email() {
		homepage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailName);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	  
	}
	
	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		homepage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailName);
		registerPage.inputToPasswordTextBox("1");
		registerPage.inputToConfirmPasswordTextBox("1");
	  
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");
	  
	}
  
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		homepage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailName);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox("321543");
  
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	  
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

}
