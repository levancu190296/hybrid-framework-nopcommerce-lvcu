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
import commons.GlobalConstants;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.portal.PageGeneratorManager;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;

public class Level_08_Switch_Role extends BaseTest{
	@Parameters({"browser","environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		driver = getBrowserDriver(browserName,environmentName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
	
		//userEmailAddress = "lvcu" + generateFakeNumber()+ "@gmail.com";
	    userEmailAddress = "a@gmail.com";
	    userPassword = "123123";
	    
	    adminEmailAddress = "admin@yourstore.com";
	    adminPassword= "admin";
	}	
	
	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.clickToLoginLink();
		
		//login user role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress,userPassword);
		Assert.assertTrue(userHomePage.isMyAccountDisplayed());
		
		//homepage -> customer infor
		userCustomerInforPage = userHomePage.openMyAccountPage();
		
		
		//customer infor click logout-> home page
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);
		
		
		//user home pagae -> open admin page -> login page admin
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		//login as admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplay());
		
		//dashboard page -> logout-> login admin
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}
	
	@Test
	public void Role_02_Admin_To_User() {
		
		//login page admin -> open pageURL -> home page
		 adminLoginPage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		 userHomePage = PageGeneratorManager.getUserHomePage(driver);
		 
		 //home page -> login user 
		 userLoginPage = userHomePage.clickToLoginLink();
		 
		//login user role
		 userHomePage = userLoginPage.loginAsUser(userEmailAddress,userPassword);
		 Assert.assertTrue(userHomePage.isMyAccountDisplayed());
		
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
	private String userEmailAddress,userPassword,adminEmailAddress,adminPassword;
	private UserHomePageObject userHomePage ;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	
	//###################-END-DECLARE-######################
}
