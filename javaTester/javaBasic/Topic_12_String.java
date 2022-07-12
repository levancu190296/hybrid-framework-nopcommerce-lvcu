package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Topic_12_String {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	String name;
	int age;
	
	public static void main(String[] args) {
//		System.setProperty("webdriver.gecko.driver",  ".\\browserDrivers\\geckodriver.exe");
//		WebDriver driver;
//		driver = new FirefoxDriver();
		
		
		String chuoi = "le van cu";
		String noichuoi = "https://www.persica.com/";
		char kitu = chuoi.charAt(0);
		System.out.println(kitu);
		System.out.println(chuoi.length());
		System.out.println(chuoi.concat(" "+noichuoi));
		System.out.println(chuoi.indexOf("u"));
		
		//substring: de tach chuoi
		String domain = noichuoi.substring(12,19);
		System.out.println(domain);
		//split: tach chuoi
		String[] domain1 = noichuoi.split("\\.");
		for (int i = 0; i < domain1.length; i++) {
			System.out.println(domain1[i]);
		}
		
		System.out.println(domain1[1]);
		
		//replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);
		
//		String osName = System.getProperty("os.name");
//		System.out.println(osName);
		// giup handle multiple OS: MAC/Windows(Action - keys- Ctrl/Command)
		//toLowerCase(): chuyen viet hoa thanh viet thuong
		//toUperCase: nguoc lai
//		if(osName.toLowerCase().contains("windows")) {
//			Keys key = Keys.CONTROL;
//		}else {
//			Keys key = Keys.COMMAND;
//		}
//		
//		String driverInstanceName = driver.toString();
//		System.out.println(driverInstanceName);
		// xu ly close browser/ driver
		
		//Trim(): loai bỏ khoảng trắng đầu và cuối dòng
//		String a = "       lvcu         ";
//		String b = a.trim();
//		
//		System.out.println(a);
//		System.out.println(b);
//		
		//dynamic locator
		//dai dien cho 1 chuoi: %s
		//%b %t %d
		
		String dymamicButtonXpath = "//button[@id='%s']";	
		System.out.println("click Login"+ dymamicButtonXpath.format(dymamicButtonXpath, "login"));
		System.out.println("click Search"+ dymamicButtonXpath.format(dymamicButtonXpath, "search"));
		System.out.println("click Register"+ dymamicButtonXpath.format(dymamicButtonXpath, "register"));
	}

}





















