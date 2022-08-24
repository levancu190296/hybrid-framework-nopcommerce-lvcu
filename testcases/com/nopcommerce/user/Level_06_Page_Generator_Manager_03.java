// đưa việc khởi tạo vào trong chính hàm(action của page củ)
//che giấu đi việc khởi tạo escapculation
// có tính kết nối giữa 2 đối tượng
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
import pageObjects.CustomerInforPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_03 extends BaseTest{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	
		firstName  = "le";
	    lastName = "cu";
	    existingEmail = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    validPassword = "123abc";
	    incorrectPassword = "abc123";
	    invalidEmail = "invalidemail";
	    notFoundEmail="notfoundemail@gmail.com";
	    
		System.out.println("Pre-condition - Step 01: Click to Register link");
		
		registerPage = homePage.clickToRegisterLink();
		
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
		
		homePage = registerPage.clickToLogout();
	}	
	
	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextBox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email") ;
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextBox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"+"No customer account found");
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect") ;
	}
	
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(incorrectPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect") ;
	}
	
	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextBox(existingEmail);
		loginPage.inputToPasswordTextBox(validPassword);
		
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountDisplayed());
		
		accountPage = homePage.clicktoMyAccountLink();
		// thuc hien cac action tiep theo: verify firstname,lastname..v.v.
		
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

	//###################-START-DECLARE-######################
	private WebDriver driver;
	private String lastName,firstName,invalidEmail,notFoundEmail,existingEmail,validPassword,incorrectPassword;
	private RegisterPageObject registerPage ;
	private HomePageObject homePage ;
	private LoginPageObject loginPage;
	private CustomerInforPageObject accountPage;
	//###################-END-DECLARE-######################
}
