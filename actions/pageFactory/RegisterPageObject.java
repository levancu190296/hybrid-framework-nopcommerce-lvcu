package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {

	private WebDriver driver;
	// ham khoi tao: cung ten vs class , k co kieu tra ve(constructor)
	
	public RegisterPageObject(WebDriver driver) {
		// bien local, dung this để lấy biến global ra
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page UI
	
	@FindBy(xpath ="//input[@id='FirstName']" )
	private WebElement lastNameTextBox;
	
	@FindBy(xpath ="//input[@id='LastName']" )
	private WebElement firstNameTextBox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath ="//input[@id='ConfirmPassword']" )
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = "//div//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	
	
	
	//Page object / action
	
	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendKeytoElement(driver, firstNameTextBox, firstName);
	}
	
	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, lastNameTextBox);
		sendKeytoElement(driver, lastNameTextBox, lastName);
	}
	
	public void inputToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, emailTextBox);
		sendKeytoElement(driver, emailTextBox, emailAddress);
	}
	
	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendKeytoElement(driver, passwordTextBox, password);
	}
	
	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendKeytoElement(driver, confirmPasswordTextBox, confirmPassword);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver,registerButton);
		clickToElement(driver,registerButton);		
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}
	
	public void clickToLogout() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}
	
	
}
