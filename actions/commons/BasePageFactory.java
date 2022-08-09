// các hàm dùng chung cho PageObjects
package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	protected static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
	}
	
	///function with browser 
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		// driver.switchTo().alert().accept();(cach 1:thiếu thời gian chờ cho allert
		// xuất hiện)
		// waitForAlertPresence(driver).accept();(tương tự cách 3, gọn hơn)
		// cách 3
		alert.accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	protected void switchToWindownID(WebDriver driver, String currentWindowID) {
		// ham switch to new page/tab, new tim dc id nao khac id hien tai thi switch to
		// den page id do
		Set<String> allWindownId = driver.getWindowHandles();
		for (String id : allWindownId) {
			if (!id.equals(currentWindowID)) {
				driver.switchTo().window(id);
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			// switch qua page bất kỳ trước sau đó kiểm tra điều kiện
			driver.switchTo().window(id);
			// lấy title của page đó ra
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	// close all tab/window ngoai trừ tab đang đứng
	protected boolean closeAllWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	//function with Element
	
	// ##################### Bage page Factory ########

	private long longTimeout = 30;
	
	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}	
	
	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
		//getWebElement(driver,xpathLocator).click();
	}
	
	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
		
		//explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
		//explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
		//return getWebElement(driver,xpathLocator).getText();
	}
	
	protected void sendKeytoElement(WebDriver driver, WebElement element, String textValue) {
		//WebElement element = getWebElement(driver,xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected boolean isElementDisplayed(WebDriver driver,WebElement element) {
		return element.isDisplayed();
		//return getWebElement(driver, xpathLocator).isDisplayed();
		
	}
	
	public void sleepInSecond (long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//##########################	
	//private long shortTimeout = 5;
	

}





















