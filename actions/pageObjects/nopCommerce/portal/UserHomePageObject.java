package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage{
	//bien global
	private WebDriver driver;
	
	// ham khoi tao: cung ten vs class , k co kieu tra ve(constructor)
	public UserHomePageObject(WebDriver driver) {
		// bien local, dung this để lấy biến global ra
		this.driver = driver;
	}
	
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver,HomePageUI.REGISTER_LINK);
		//02
		//return new RegisterPageObject(driver);
		
		//03
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public boolean isMyAccountDisplayed() {
		waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver,HomePageUI.LOGIN_LINK);
		//02
		//return new LoginPageObject(driver); 
		
		//03
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	public UserCustomerInforPageObject openMyAccountPage() {
		waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
		//02
		//return new MyAccountPageObject(driver);
		
		//03
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}
	
	
}
