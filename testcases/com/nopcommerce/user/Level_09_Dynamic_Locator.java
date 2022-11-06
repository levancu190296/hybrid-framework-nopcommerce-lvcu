// nhiều page có nhóm chức năng giống nhâu = 1 hàm, sử dụng tính đa hình, rest parameter
// chỉ cần 1 hàm để mở nhiều page có cùng screen or the same chức năng
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

public class Level_09_Dynamic_Locator extends BaseTest{
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
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(validPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountDisplayed());
		
		customerInforPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInforPage.isMyAccountPageDisplayed());
	}
	
	
	@Test
	public void User_02_Dynamic_Page() {
		// knowledge cua page objec thì một page a khi chuyển qua page b thì phải viết 1 hàm
		//(action:open/clikc/:L link/button/image) để mở page B lên)
		
		//customer infor -> address page 1
		addressPage = customerInforPage.openAddressPage(driver);
		
		//address -> my product review page 2
		myProductReviewPage =addressPage.openMyProductViewPage(driver);
		
		//my product review -> reward point page 3
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		
		//reward point -> address page 1
		addressPage = rewardPointPage.openAddressPage(driver);
		
		//address  -> reward point page 3
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		//reward point -> my product review page 2
		myProductReviewPage = registerPage.openMyProductViewPage(driver);
		
		//my product review -> address page 1
		addressPage = myProductReviewPage.openAddressPage(driver);
	}
	@Test
	public void User_03_Dynamic_Page_01() {
		//customer infor -> address page 1
		addressPage = (UserAddressPageObject) customerInforPage.openPageAtAccountByName(driver, "Addresses");
		
		//address -> my product review page 2
		myProductReviewPage =(UserMyProductViewPageObject) addressPage.openPageAtAccountByName(driver, "My product reviews");
		
		//my product review -> reward point page 3
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPageAtAccountByName(driver, "Reward points");
		
		//reward point -> address page 1
		addressPage = (UserAddressPageObject) rewardPointPage.openPageAtAccountByName(driver, "Addresses");
		
		//address  -> reward point page 3
		rewardPointPage =(UserRewardPointPageObject) addressPage.openPageAtAccountByName(driver, "Reward points");
		
		//reward point -> my product review page 2
		myProductReviewPage = (UserMyProductViewPageObject) registerPage.openPageAtAccountByName(driver, "My product reviews");
		
		//my product review -> address page 1
		addressPage = (UserAddressPageObject) myProductReviewPage.openPageAtAccountByName(driver, "Addresses");
	}
	
	@Test
	public void User_03_Dynamic_Page_02() {
		//address-> my product review
		addressPage.openPageAtAccountByName_02(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductViewPage(driver);
		
		//my product review-> reward Point Page
		myProductReviewPage.openPageAtAccountByName_02(driver, "Reward points");
		rewardPointPage =PageGeneratorManager.getUserRewardPointPage(driver);
		
		//reward Point Page-> address Page
		rewardPointPage.openPageAtAccountByName_02(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
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
