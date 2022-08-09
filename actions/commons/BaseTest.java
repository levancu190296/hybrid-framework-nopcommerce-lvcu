package commons;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	private String projectPath=System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("firefox")) {
			System.out.println("run on " + browserName);
			//System.setProperty("webdriver.gecko.driver",  projectPath +"\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equals("h_firefox")) {
			System.out.println("run on " + browserName);
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless"); 
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}else if(browserName.equals("chrome")) {
			System.out.println("run on " + browserName);
			//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("h_chrome")) {
			System.out.println("run on " + browserName);
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}else if(browserName.equals("edge")) {
			System.out.println("run on " + browserName);
			WebDriverManager.edgedriver().setup();
			
			//System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
		// de truyen 1 version minh mon muon
		//WebDriverManager.chromedriver().browserVersion("94.5.7").setup();
		
	}
	
}
