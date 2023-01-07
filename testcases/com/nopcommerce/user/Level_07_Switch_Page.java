// những cái chung thì ko có viết thành hàm riêng ở class page object
//viết vào trong bagepase
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
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductViewPageObject;
import pageObjects.nopCommerce.portal.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		firstName  = "le";
	    lastName = "cu";
	    emailAddress = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    validPassword = "123abc";
	}	
	
	@Test
	public void User_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogout();
	}
	
	
	
	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(validPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountDisplayed());
	}
	
	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInforPage.isMyAccountPageDisplayed());
	}
	
	@Test
	public void User_04_Switch_Page() {
		// knowledge cua page objec thì một page a khi chuyển qua page b thì phải viết 1 hàm
		//(action:open/clikc/:L link/button/image) để mở page B lên)
		
		//customer infor -> address
		addressPage = customerInforPage.openAddressPage(driver);
		
		
		//address -> my product review
		myProductReviewPage =addressPage.openMyProductViewPage(driver);
		
		//my product review -> reward point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
				
		//reward point -> address
		addressPage = rewardPointPage.openAddressPage(driver);
		
		//address  -> reward point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		//reward point -> my product review
		myProductReviewPage = registerPage.openMyProductViewPage(driver);
		
		//my product review -> address
		addressPage = myProductReviewPage.openAddressPage(driver);
	}
	
	@Test
	public void User_05_Switch_Role() {
		
		//User -> admin
		
		//admin-> user 
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
	private String lastName,firstName,emailAddress,validPassword;
	private UserRegisterPageObject registerPage ;
	private UserHomePageObject homePage ;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserMyProductViewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	//###################-END-DECLARE-######################
}
