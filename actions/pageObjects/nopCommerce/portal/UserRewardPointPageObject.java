package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInforPageUI;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserRewardPointPageObject extends BasePage {
	private WebDriver driver;
	public UserRewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}
//	public boolean isMyAccountPageDisplayed() {
//		waitForElementVisible(driver,CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
//		return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
//	}
	
	
}
