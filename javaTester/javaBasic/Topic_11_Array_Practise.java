package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commons.GlobalConstants;



public class Topic_11_Array_Practise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	int arrayNumber[] = {-2,11,1,2,3,5,6};
	int id,age,score;
	String name;
	
	@Test
	public void TC_01_Max() {
		int max =arrayNumber[0];
		for (int i = 1; i < arrayNumber.length; i++) {
			if(arrayNumber[i]> max) {
				max = arrayNumber[i];
			}
		}
		System.out.println("max is: "+max);

	}
	
	@Test
	public void TC_02_Sum_first_And_Last() {
		for (int i = 0; i < arrayNumber.length;) {
			int sum = arrayNumber[0] + arrayNumber[arrayNumber.length-1];
			System.out.println("sum is: "+ sum );
			break;
		}
	}
	
	@Test
	public void TC_03_Even_Number() {
		int sum = 0;
		for (int i = 0; i < arrayNumber.length; i++) {
			if(arrayNumber[i] > 0 && arrayNumber[i]%2 != 0) {
				sum = sum +arrayNumber[i];
			}
		}
		System.out.println(sum);
	}
	
	@Test
	public void TC_06_Sum_Average() {
		int sum = 0;
		float average= 0.000f;
		for (int i = 0; i < arrayNumber.length; i++) {
			sum =sum + arrayNumber[i];
		}
		average = sum/arrayNumber.length;
		System.out.println(sum);
		System.out.println(average);
	}
	
	
	@Test
	public void TC_07_Info_Student() {
		int sum = 0;
		float average= 0.000f;
		for (int i = 0; i < arrayNumber.length; i++) {
			sum =sum + arrayNumber[i];
		}
		average = sum/arrayNumber.length;
		System.out.println(sum);
		System.out.println(average);
	}
	
	@Test
	public void TC_08() {
		String fileNames [] = {"IU.jpg","jennie.jpg"};
		String filepath = GlobalConstants.UPLOAD_FILE;
		
		String fullFileName = "";
		for( String file : fileNames) {
			fullFileName = fullFileName + filepath + file + "\n";
		}
		fullFileName  = fullFileName.trim();
		System.out.println(fullFileName);
	}

	
	//contructor: hàm khởi tạo
//	public Topic_11_Array_Practise(String name ,int age,int id,int score) {
//		this.name = name;
//		this.id= id;
//		this.score= score;
//		this.age= age;
//	}
//	public void display() {
//		System.out.println("name: " + name);
//		System.out.println("age: "+age);
//		System.out.println("id: " + id);
//		System.out.println("score: "+score);
//	}
//	
//	public static void main(String[] args) {
//		Topic_11_Array_Practise[] students = new Topic_11_Array_Practise[2];
//		students[0] = new Topic_11_Array_Practise("lvcu",12,123,9);  
//		students[0].display();
//		}
}





















