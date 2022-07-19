// các hàm dùng chung cho PageObjects
package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		// driver.switchTo().alert().accept();(cach 1:thiếu thời gian chờ cho allert
		// xuất hiện)
		// waitForAlertPresence(driver).accept();(tương tự cách 3, gọn hơn)
		// cách 3
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindownID(WebDriver driver, String currentWindowID) {
		// ham switch to new page/tab, new tim dc id nao khac id hien tai thi switch to
		// den page id do
		Set<String> allWindownId = driver.getWindowHandles();
		for (String id : allWindownId) {
			if (!id.equals(currentWindowID)) {
				driver.switchTo().window(id);
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
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
	public boolean closeAllWindowWithoutParent(WebDriver driver, String parentID) {
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
	
	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	
	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(By.xpath(xpathLocator));
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver,xpathLocator).click();
	}
	
	public void sendKeytoElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver,xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver,xpathLocator).getText();
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	
	public String getSelectItemInDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	public void slectItemCustomDropdownList(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		clickToElement(driver,parentXpath);
		sleepInSecond(2);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> getAllItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));;
		for (WebElement item : getAllItem) {
			String actualText = item.getText();
			if (actualText.equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
		sleepInSecond(1);
	}
	
	public void sleepInSecond (long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getElementAttribute(WebDriver driver, String xpathLocator,String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String xpathLocator,String cssName) {
		return getWebElement(driver, xpathLocator).getCssValue(cssName);
	}
	
	public String getHexaColorFromRGBA(String rgbValue) {
		return Color.fromString(rgbValue).asHex();
	}
	
	public void getElementSize(WebDriver driver,String xpathLocator) {
		getListWebElement(driver, xpathLocator).size();
	}
	
	public void checkToDefaultCheckBoxRadio(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckBoxRadio(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver,String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver,String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
	//function javascript

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	public void waitForElementInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	private long longTimeout = 30;
	
	private long shortTimeout = 5;
}





















