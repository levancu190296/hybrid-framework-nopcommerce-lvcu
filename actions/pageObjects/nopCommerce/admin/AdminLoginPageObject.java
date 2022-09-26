package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.nopCommerce.portal.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserNameTextBox(String email) {
		waitForElementVisible(driver,AdminLoginPageUI.EMAIL_TEXTBOX);
		sendKeytoElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX,email );
	}
	
	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver,AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendKeytoElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX,password );
		
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver,AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
	
	public AdminDashboardPageObject loginAsAdmin(String email,String passwpord) {
		inputToUserNameTextBox(email);
		inputToPasswordTextBox(passwpord);
		return clickToLoginButton();
	}
}
