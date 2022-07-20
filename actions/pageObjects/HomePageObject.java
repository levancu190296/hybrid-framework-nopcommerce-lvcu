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
	
	public void clickToRegisterLink() {
		waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver,HomePageUI.REGISTER_LINK);
	}
}
