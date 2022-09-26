package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		//cach 02
		//return new HomePageObject(driver);
		
		//cach 03
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);
		sendKeytoElement(driver, LoginPageUI.EMAIL_TEXTBOX,email );
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR_NOT_FOUND_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_NOT_FOUND_MESSAGE);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
		sendKeytoElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password );
		
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextBox(emailAddress);
		inputToPasswordTextBox(password);
		return clickToLoginButton();
	}

}
