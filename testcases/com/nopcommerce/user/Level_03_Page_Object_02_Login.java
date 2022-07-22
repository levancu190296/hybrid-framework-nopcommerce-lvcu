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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_02_Login{
	//declare
	private WebDriver driver;
	private String lastName,firstName,invalidEmail,notFoundEmail,existingEmail,validPassword,incorrectPassword;
	private RegisterPageObject registerPage ;
	private HomePageObject homePage ;
	private LoginPageObject loginPage;
	private BasePage basepage;
	
	
	//declare + init
	private String projectPath=System.getProperty("user.dir");
	

	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver",  projectPath +"\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		basepage = new BasePage();
	
		firstName  = "le";
	    lastName = "cu";
	    existingEmail = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    validPassword = "123abc";
	    incorrectPassword = "abc123";
	    invalidEmail = "invalidemail";
	    notFoundEmail="notfoundemail@gmail.com";
	    
		System.out.println("Pre-condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
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
		homePage = new HomePageObject(driver);
	    //click logout -> quay về home
	}	
	
	@Test
	public void Login_01_Empty_Data() {
		// from home screen, navigate to login screen
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver); 
		loginPage.clickToLoginButton();
		//Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Please enter your email");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver); 
		loginPage.inputToEmailTextBox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email") ;
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver); 
		loginPage.inputToEmailTextBox(notFoundEmail);
		loginPage.clickToLoginButton();
		//System.out.println(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText());
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"+"No customer account found");
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();
		
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
		
		loginPage = new LoginPageObject(driver); 
		loginPage.inputToEmailTextBox(existingEmail);
		//basepage.sleepInSecond(5);
		loginPage.inputToPasswordTextBox(validPassword);
		loginPage.clickToLoginButton();
		
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
