package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void maxWindow() {
		fullSite(driver);
	}

	public boolean isfileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME, fileName);
	}
	
	public boolean isfileUploadByName(String fileName) {
		
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOAD, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButton = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement button : startButton) {
			button.click();
			sleepInSecond(1);
		}
	}

	public boolean isfileImageLoaded(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_NAME_IMAGE,fileName);
		
		
	}

	
}














