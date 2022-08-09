package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {

	private WebDriver driver;
	// ham khoi tao: cung ten vs class , k co kieu tra ve(constructor)
	
	public HomePageObject(WebDriver driver) {
		// bien local, dung this để lấy biến global ra
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page UI
	// nếu element này chỉ không cần tìm lại thì sử dụng anotation này để bỏ qua  việc tìm lại element
	@CacheLookup
	@FindBy(how = How.XPATH, using="//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	
	
	
	//page object / action
	public void clickToRegisterLink() {
		waitForElementClickable(driver,registerLink);
		clickToElement(driver,registerLink);
	}

	public boolean isMyAccountDisplayed() {
		waitForElementVisible(driver,myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver,loginLink);
		clickToElement(driver,loginLink);
	}
}
