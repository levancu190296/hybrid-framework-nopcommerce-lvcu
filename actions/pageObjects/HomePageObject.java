package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage{
	//bien global
	private WebDriver driver;
	
	// ham khoi tao: cung ten vs class , k co kieu tra ve(constructor)
	public HomePageObject(WebDriver driver) {
		// bien local, dung this để lấy biến global ra
		this.driver = driver;
	}
	
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver,HomePageUI.REGISTER_LINK);
		//02
		//return new RegisterPageObject(driver);
		
		//03
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public boolean isMyAccountDisplayed() {
		waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver,HomePageUI.LOGIN_LINK);
		//02
		//return new LoginPageObject(driver); 
		
		//03
		return PageGeneratorManager.getLoginPage(driver);
	}
	
	public MyAccountPageObject clicktoMyAccountLink() {
		waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
		//02
		//return new MyAccountPageObject(driver);
		
		//03
		return PageGeneratorManager.getMyAccountPage(driver);
	}
}
