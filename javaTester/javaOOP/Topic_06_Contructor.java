// khi class con ke thua class cha ma class cha co ham contrutor 
//thi thang con cung phai co ham khoi tao va goi qua 1 contructor nao do cua class cha

package javaOOP;

import org.openqa.selenium.WebDriver;

public class Topic_06_Contructor extends ContructorOOP {
	private WebDriver driver;
	
	public Topic_06_Contructor() {
		super(6);
		System.out.println("contructr tai class con");
	}
	
	public static void main(String[] args) {
		Topic_06_Contructor topic = new Topic_06_Contructor();
	}

}
