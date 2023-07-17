package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(commons.MethodListener.class)
public class Topic_17_Check_Environment extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	
	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		log.info("verify equal 01");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl,"https://www.facebook.com/");
		
		
		log.info("verify equal 02");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "Facebook – log in or sign up");
		
		log.info("verify true 03");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}









