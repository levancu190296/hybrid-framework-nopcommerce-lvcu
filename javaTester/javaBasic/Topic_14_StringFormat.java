package javaBasic;
// rest parameter để sử lý khi nhiều tham số động truyền vào
// Tính đa hình oop: hàm cùng tên: khác số lượng tham số(k bắt buộc khác kiểu dữ liệu), cùng số lượng tham số(bắt buôc khác kieu dữ liệu)
public class Topic_14_StringFormat {
	//14 page can define 14 bien locator
	public static  String ADDRESS_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static  String REWARD_LINK = "div[@class='listbox']//a[text()='Reward points']";
	public static  String MY_PRODUCT_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
	
	//chi can define 1 bien duy nhat cho 14 hoac n page, có cùng format locator, chỉ khác pageName
	public static String DYNAMIC_LINK_BY_PAGE = "//div[@class='%s']//a[text()='%s']";
	
	
	 
	public static void main(String[] args) {
		clickToSlideBarLink(DYNAMIC_LINK_BY_PAGE,"listbox","Addresses");
		clickToSlideBarLink(DYNAMIC_LINK_BY_PAGE,"listbox","Reward points");
		clickToSlideBarLink(DYNAMIC_LINK_BY_PAGE,"listbox","My product reviews");
	}
	
//	public static void clickToSlideBarLink(String locator) {
//		System.out.println("click to:" + locator);
//	}
	
	public static void clickToSlideBarLink(String dynamicLocator,String pageName) {
		//dynamicLocator://div[@class='listbox']//a[text()='%s']
		//pageName:Addresses
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("click to:" + locator);
	}
	
	//2 tham so động truyen vao, or 1 tham so động
	public static void clickToSlideBarLink(String dynamicLocator,String pageName1,String pageName2) {
		//dynamicLocator://div[@class='%s']//a[text()='%s']
		//pageName:Addresses
		String locator = String.format(dynamicLocator, pageName1,pageName2);
		System.out.println("click to:" + locator);
	}
	// xữ lý các parameter
	// sử dung rest parameter
	// 1 den n tham so dong
	public static void clickToSlideBarLink(String dynamicLocator,String... params ) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("click to:" + locator);
	}
	
}









