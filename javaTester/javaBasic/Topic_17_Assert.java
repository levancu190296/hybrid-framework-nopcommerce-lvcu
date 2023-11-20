
package javaBasic;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
public class Topic_17_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	
	@BeforeClass
	public void beforeClass() {
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		System.out.println("Assert 01");
		log.info("verify equal 01");
		String loginPageUrl = driver.getCurrentUrl();
		assertEquals(loginPageUrl, "https://www.facebook.com/");
		
		System.out.println("Assert 02");
		log.info("verify equal 02");
		String loginPageTitle = driver.getTitle();
		assertEquals(loginPageTitle, "Facebook – log in or sign up"); 
		
		System.out.println("Assert 03");
		log.info("verify true 03");
		assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
		
		
//		System.out.println("Assert 04");
//		log.info("verify true 04");
//		assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
//		

		 
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}









