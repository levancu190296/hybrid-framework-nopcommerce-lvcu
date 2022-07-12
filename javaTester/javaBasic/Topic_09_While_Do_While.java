package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class Topic_09_While_Do_While {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
//	public static void main(String[] args) {
//		int i=0;
//		while (i<5) {
//			System.out.println(i);
//			i=i+1;
//		}
//	}
	@Test
	public void TC_01() {
		int number = scanner.nextInt();
		while(number < 39) {
			if(number%3 == 0 && number%5 == 0) {
				System.out.println(number);
			}
			number++;
		}
		
	}
	
	
}





















