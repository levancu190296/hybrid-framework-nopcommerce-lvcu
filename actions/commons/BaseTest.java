package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	WebDriver driver;
	private String projectPath=System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if(browserName.equals("firefox")) {
			System.out.println("run on " + browserName);
			System.setProperty("webdriver.gecko.driver",  projectPath +"\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("chrome")) {
			System.out.println("run on " + browserName);
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equals("edge")) {
			System.out.println("run on " + browserName);
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}else {
			throw new RuntimeException("Browser name invalid");
		}
		return driver;
	}
	
}
