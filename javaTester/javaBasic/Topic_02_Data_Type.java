package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	//Primitive type / value type: Nguyên thủy
	byte bNumber;
	short sNumber;
	int iNumber;
	long lNumber;
	float fNumber;
	double dNumber;
	char cChar ='A';
	boolean bStatus;
	

	
	//Reference type: Tham Chiếu
	
	//String
	String address = "ho chi minh";
	
	//array
	String[] cityNumber = {"hcm", "da nang", "quang nam"};
	Integer[] studenNumber = {12, 33, 44};
	
	//class
	//Topic_02_Data_Type: là class
	//topic1: là đối tượng đại diện cho class trên,gọi là variable/instance/object, muốn sử dụng phải new class lên
	
	Topic_02_Data_Type topic1;
	
	//interface
	WebDriver driver;
	
	//Object: có thể convert quá kiểu dữ liệu khác
	Object object;
	
	//collection
	//Set,List,Map,Queue
	List<WebElement> homePageLink= driver.findElements(By.tagName("a"));
	Set<String> allWindowns = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>() ;
	
	public static void main(String[] lvcu) {
		Topic_02_Data_Type call = new Topic_02_Data_Type();
		System.out.print(call.cChar);
		//vd convert từ Object qua kieu du lieu khác

		
		
	}

}
