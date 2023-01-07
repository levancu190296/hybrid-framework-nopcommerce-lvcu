package javaOOP;

public class Topic_02_Variable_Property_Method {
	
	static int studentNumber;
	static String studentCountry;
	static boolean studentStatus;
	
	//access modifier
	//data type
	//variable name
	//variable value
	private String studentID= "Rose";//global variable
	
	
	//static variable: dung va gan lai duoc gia tri
	public static String studentName = "Jenny"; 
	//dung trong pham vi class nay (cho tat ca instance/object)
	private static String studentName2 = "Lisa";
	//final variable: bien co dinh,ko thay the/ghi de,
	final String country ="Vn";
	//Static final variable: duoc coi la hang so co dinh(constant)
	//ko ghi de, co quyen truy cap cho cac instance/thread
	static final float PI_NUMBER = 3.1415f;
	
	public static void main(String[] args) {
		System.out.println(studentNumber);
		System.out.println(studentCountry);
		System.out.println(studentStatus);
	}
}
