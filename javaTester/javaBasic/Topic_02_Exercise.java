package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Exercise {
	
	@Test
	public void TC_01() {
		int a =6;
		int b =2;
		System.out.println("a + b =" + (a + b));
		System.out.println("a - b =" + (a - b));
		System.out.println("a x b =" + (a*b));
		System.out.println("a : b =" + (a/b));
	}
	
	@Test
	public void TC_02() {
		float width =7.5f;
		float height =3.8f;
		System.out.println("Area =" + (width*height));	
	}
	
	@Test
	public void TC_03() {
		String name ="Automation Testing";
		System.out.println("Hello " + name);
	}
	
	
}
