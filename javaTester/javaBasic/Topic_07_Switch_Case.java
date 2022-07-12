package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	@Parameters("browser")
	//@Test
	public void TC_01_Switch_Case(String browserName) {
		getBrowserDriver(browserName);
		System.out.println(browserName);
		driver.quit();
	}
	
	@Test
	public void TC_02_Month_In_Years() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("The years have 31 days");
			break;
		
	
		case 2:
			System.out.println("The years have 28 or 29 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("The years have 30 days");
			break;
			
		default:
			System.out.println("thang vua nhap khong dung, vui long nhap tu 1 den 12");
			break;
		}
		
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			new RuntimeException("browser name is not found");
			break;
			}
		return driver;
	}
	

}
