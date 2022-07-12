package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class Topic_08_For_Foreach {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	
	public void TC_01() {
		String[] cityName = {"HCM","DN","QN","HN"};
		int length = cityName.length;
		System.out.println(length);
		//for: kết hợp với if , thõa mãn điều kiện mới thực hiện action
		for (int i = 0; i < length; i++) {
			if(cityName[i].equals(cityName[0])) {
				System.out.println(cityName[i]);
				break;
			}
			
		}
		//for earch: đùng để duyệt qua hết các phần tử trong mãng
		for (String string : cityName) {
			System.out.println(string);
		}
	}
	
	@Test
	public void TC_02() {
		String[] nameSinhVien = {"Hoa","Tuan","Lan","Na","Trinh","Linh"};
		for (int i = 0; i < nameSinhVien.length; i++) {
			System.out.println(nameSinhVien[i]);
		}
		//Java collection
		//Class: Arraylist/linkedlist/vertor
		//Interface: List/set/queue

		//ArrayList<String> hobbySinhVien = new ArrayList<>();
		// hoặc có thể khởi tạo theo tính kế thừa
		List<String> hobbySinhVien = new ArrayList<>();
		
		//compile (coding)
		hobbySinhVien.add("read");
		hobbySinhVien.add("sing");
		hobbySinhVien.add("sport");
		
		System.out.println("ban dau la:" + hobbySinhVien.size());
		//runtime (Running)
		for (String hobby : nameSinhVien) {
			hobbySinhVien.add(hobby);
			System.out.println("sau khi them lan luot la: " +hobbySinhVien.size());
		}
		System.out.println(hobbySinhVien.size()); 
		System.out.println(nameSinhVien.length); 
		//System.out.println(hobby SinhVien);
		for (String in : hobbySinhVien) {
			System.out.println(in);
		}	
	}
	
}





















