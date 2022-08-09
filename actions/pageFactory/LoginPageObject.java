package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePageFactory {

	private WebDriver driver;
	// ham khoi tao: cung ten vs class , k co kieu tra ve(constructor)
	
	public LoginPageObject(WebDriver driver) {
		// bien local, dung this để lấy biến global ra
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Page UI
	@FindBy(xpath = "//div/input[@name='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//div/input[@name='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//div/button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement emailErrorNotFound;
	
	//page object / action
	
	public void clickToLoginButton() {
		waitForElementClickable(driver,loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver,emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver,emailTextbox);
		sendKeytoElement(driver, emailTextbox,email );
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver,emailErrorNotFound);
		return getElementText(driver, emailErrorNotFound);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver,passwordTextbox);
		sendKeytoElement(driver, passwordTextbox,password );
		
	}

	
}
