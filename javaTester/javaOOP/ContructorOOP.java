package javaOOP;

import org.openqa.selenium.WebDriver;

public class ContructorOOP {
	
	private WebDriver driver;
	
	public ContructorOOP() {
		System.out.println("contructr tai class cha");
	}
	
	protected ContructorOOP(String name) {
		System.out.println("contructr tai class cha la " + name);
	}
	public ContructorOOP(int number) {
		System.out.println("contructr tai class cha co so thu tu la " + number);
	}

}
