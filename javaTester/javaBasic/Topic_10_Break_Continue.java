package javaBasic;

import java.util.Iterator;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;



public class Topic_10_Break_Continue {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			//loại trừ 1 điều kiện
			if (i==5) {
				continue;
			}
			System.out.println(i);		
		}
	}

}





















