package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInforPageUI;
import pageUIs.HomePageUI;

public class CustomerInforPageObject extends BasePage {
	private WebDriver driver;
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isMyAccountPageDisplayed() {
		waitForElementVisible(driver,CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
	
	
}
