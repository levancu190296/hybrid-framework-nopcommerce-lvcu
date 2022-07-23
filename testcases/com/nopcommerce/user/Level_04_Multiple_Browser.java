package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest{
	private WebDriver driver;
	private String lastName,firstName,emailName,password,confirmPassword;

	private HomePageObject homepage;
	private RegisterPageObject registerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//open url: nó đang đứng trang homePage
		driver.get("https://demo.nopcommerce.com/");
		homepage = new HomePageObject(driver);
		
		firstName  = "le";
	    lastName = "cu";
	    emailName = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    password = "123abc";
	    confirmPassword = "123abc";
	}	
	
	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 01: Click to Register link");
		homepage.clickToRegisterLink();
		
		//PageObject: nguyên tắc từ 1 trang A chuyển qua trang B thì phải khởi tạo trang B
		// thao tác click từ trang homepage sang trang registerpage
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_01 - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFisrtnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}
  
	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02 - Step 01: Click to Register link");
		homepage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_02 - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("ewewqesadsa");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
	  
		System.out.println("Register_02 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_02 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	  
	}
	
	@Test
	public void Register_03_Success() {
		System.out.println("Register_03 - Step 01: Click to Register link");
		homepage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_03 - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailName);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
	  
		System.out.println("Register_03 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_03 - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Register_03 - Step 05: Click to Logout button");
		registerPage.clickToLogout();
	  
	}
  
	@Test
	public void Register_04_Existing_Email() {
		homepage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailName);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	  
	}
	
	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Register_01 - Step 01: Click to register");
		homepage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		System.out.println("Register_01 - Step 01: Click to register");
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
	public void Register_06_Invalid_Confirm_Password() {
		homepage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
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
