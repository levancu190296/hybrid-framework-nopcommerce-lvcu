//Public(pham vi rong nhat): ở trong cùng pagekage hoặc ngoài pagekage thông qua kế thừa thì sử dụng được
//private: chỉ được sử dụng trong phạm vị class
//protected: khi kế thừa thì có thể truy cập được(trong cùng pagekage)
//default: sử dụng trong cùng pagekage

// static: sử dụng cho variable and method
//final:tránh viejc ghi đè, gán lại dữ liệu; variable,method,class
//final class: ko cho phep khoi tao, nhung cho phep new doi tuong(object)
// abstract class: nguoc lai vs final class, ko co abstract variable, sử dụng thông qua kế thừa
//enum = static final: đều đại diện cho hằng số, enum linh động hơn
//


package javaOOP;

public class Topic_04_Non_Access_Modifier_And_Enum {
	
	//static: variable/Method
	// dung cho tat ca cac instance/object
	//pham vi global
	//co the override được: gán lai gia tri moi cho no
	static String browser="Chrome";
	
	//non-static
	String browserName="firefox";
	
	
	//final variable: k dc phep gan lai gia tri
	//hang so
	final String colorcarString ="blue";
	final static float NUMBER_PI= 3.14114f;
	
	//final method
	public final void setCarName() {
		
	}
	
	public void clickToElement(String element) {
		System.out.println(element);
	}
	
	public static void sendKeys(String element) {
		System.out.println(element);
	}
	
	
	public static void main(String[] args){
		System.out.println(browser);
		
		Topic_04_Non_Access_Modifier_And_Enum topic = new Topic_04_Non_Access_Modifier_And_Enum();
		System.out.println(topic.browserName);
		
		sendKeys("lvcu");
		
		topic.clickToElement(browser);
	}
	
	
	

}


















