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
import pageFactory.HomePageObject;
import pageFactory.LoginPageObject;
import pageFactory.RegisterPageObject;


public class Level_05_Page_Factory extends BaseTest{
	//declare
	private WebDriver driver;
	private String lastName,firstName,invalidEmail,notFoundEmail,existingEmail,validPassword,incorrectPassword;
	private RegisterPageObject registerPage ;
	private HomePageObject homepage ;
	private LoginPageObject loginpage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		homepage = new HomePageObject(driver);
		

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homepage = new HomePageObject(driver);
	
		firstName  = "le";
	    lastName = "cu";
	    existingEmail = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    validPassword = "123abc";
	    incorrectPassword = "abc123";
	    invalidEmail = "invalidemail";
	    notFoundEmail="notfoundemail@gmail.com";
	    
		System.out.println("Pre-condition - Step 01: Click to Register link");
		homepage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		System.out.println("Pre-condition - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(existingEmail);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox(validPassword);
		System.out.println("Pre-condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Pre-condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println("Pre-condition - Step 05: Click to Logout button");
		registerPage.clickToLogout();
		homepage = new HomePageObject(driver);
	}	

	
	
	@Test
	public void Login_01_Empty_Data() {
		homepage.clickToLoginLink();
		loginpage = new LoginPageObject(driver); 
		loginpage.clickToLoginButton();
		Assert.assertEquals(loginpage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		homepage.clickToLoginLink();
		loginpage = new LoginPageObject(driver); 
		loginpage.inputToEmailTextBox(invalidEmail);
		loginpage.clickToLoginButton();
		Assert.assertEquals(loginpage.getErrorMessageAtEmailTextBox(), "Wrong email") ;
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		homepage.clickToLoginLink();
		loginpage = new LoginPageObject(driver); 
		loginpage.inputToEmailTextBox(notFoundEmail);
		loginpage.clickToLoginButton();
		Assert.assertEquals(loginpage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"+"No customer account found");
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homepage.clickToLoginLink();
		loginpage = new LoginPageObject(driver); 
		loginpage.inputToEmailTextBox(existingEmail);
		loginpage.inputToPasswordTextBox("");
		loginpage.clickToLoginButton();
		Assert.assertEquals(loginpage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect") ;
	}
	
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homepage.clickToLoginLink();
		loginpage = new LoginPageObject(driver); 
		loginpage.inputToEmailTextBox(existingEmail);
		loginpage.inputToPasswordTextBox(incorrectPassword);
		loginpage.clickToLoginButton();
		Assert.assertEquals(loginpage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect") ;
	}
	
	@Test
	public void Login_06_Valid_Email_Password() {
		homepage.clickToLoginLink();
		
		loginpage = new LoginPageObject(driver); 
		loginpage.inputToEmailTextBox(existingEmail);
		loginpage.inputToPasswordTextBox(validPassword);
		loginpage.clickToLoginButton();
		homepage = new HomePageObject(driver);
		Assert.assertTrue(homepage.isMyAccountDisplayed());
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
