package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_01 extends BaseTest{
	//declare
	private WebDriver driver;
	private String lastName,firstName,invalidEmail,notFoundEmail,existingEmail,validPassword,incorrectPassword;
	
	private RegisterPageObject registerPage ;
	private HomePageObject homePage ;
	private LoginPageObject loginPage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		//1: khởi tạo page object trực tiếp trên test case
		homePage = new HomePageObject(driver);
	
		firstName  = "le";
	    lastName = "cu";
	    existingEmail = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    validPassword = "123abc";
	    incorrectPassword = "abc123";
	    invalidEmail = "invalidemail";
	    notFoundEmail="notfoundemail@gmail.com";
	    
		System.out.println("Pre-condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		//2
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
		//3
		homePage = new HomePageObject(driver);
	    //click logout -> quay về home
	}	
	
	@Test
	public void Login_01_Empty_Data() {
		// from home screen, navigate to login screen
		homePage.clickToLoginLink();
		//4
		loginPage = new LoginPageObject(driver); 
		loginPage.clickToLoginButton();
		//Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Please enter your email");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		//5
		loginPage = new LoginPageObject(driver); 
		loginPage.inputToEmailTextBox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email") ;
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		//6
		loginPage = new LoginPageObject(driver); 
		loginPage.inputToEmailTextBox(notFoundEmail);
		loginPage.clickToLoginButton();
		//System.out.println(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText());
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"+"No customer account found");
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();
		//7
		loginPage = new LoginPageObject(driver); 
		loginPage.inputToEmailTextBox(existingEmail);
		
		loginPage.inputToPasswordTextBox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect") ;
	}
	
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();
		//8
		loginPage = new LoginPageObject(driver); 
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect") ;
	}
	
	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginLink();
		//9
		loginPage = new LoginPageObject(driver); 
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(validPassword);
		loginPage.clickToLoginButton();
		//10 lần khởi tạo page object kết nối giữa 2 page với nhau: home page và login page
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyAccountDisplayed());
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
