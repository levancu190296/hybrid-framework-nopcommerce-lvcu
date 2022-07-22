package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Excercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
//	public static void main(String[] args) {
//		//InputStream stream = System.in;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhap so nguyen:");
//        int input = scanner.nextInt();
//        
//        if (input % 2 ==0) {	
//        	System.out.println(input + " la so chan");
//		}else {
//			System.out.println(input + " la so le");
//		}
//        
//        System.out.println("so nguyen a va b lan luot la: ");
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        if (a>b) {
//        	System.out.println(a+" lon hon "+b+" cho nen a lon hon b ");
//			
//		}else {
//			if (a<b) {
//				System.out.println("a be hon b");
//			}else
//				{
//				System.out.println("a=b");
//				}	
//		} 
//        scanner.close();
//        	
//	}
	
	public void TC_03() {
		String firstResident = scanner.nextLine();
		String secondResident = scanner.nextLine();
		if (firstResident.equals(secondResident)) {
			System.out.println("2 resident nay trung ten");
		}else {
			System.out.println("2 resident nay khac ten");
		}
	}
	@Test
	public void TC_04() {
		System.out.println("nhap 3 so nguyen lan luot la: ");
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();
		int thirdNumber = scanner.nextInt();
		if (firstNumber > secondNumber && firstNumber > thirdNumber) {
			System.out.println(firstNumber +" is a bigest ");
		}else if (secondNumber  > firstNumber && secondNumber > thirdNumber) {
			System.out.println(secondNumber +" is a bigest ");
		}else {
			System.out.println(thirdNumber +" is a bigest ");
		}
	}

}
























