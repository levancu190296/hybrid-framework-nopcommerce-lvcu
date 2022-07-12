package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;



public class Topic_11_Array {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	String name;
	int age;
	
	//contructor: hàm khởi tạo
	public Topic_11_Array(String name ,int age) {
		this.name = name;
		this.age= age;
	}
	public void display() {
		System.out.println("name: " + name);
		System.out.println("age: "+age);
	}
	
	public static void main(String[] args) {
		Topic_11_Array[] students = new Topic_11_Array[3];
		students[0] = new Topic_11_Array("tuan",23); 
		students[1] = new Topic_11_Array("lan",22); 
		students[2] = new Topic_11_Array("hoa",25); 
		for (int i = 0; i < students.length; i++) {
			students[i].display();
		}
			
		}


}





















