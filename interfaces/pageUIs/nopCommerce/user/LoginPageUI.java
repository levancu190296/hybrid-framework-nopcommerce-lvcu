package pageUIs.nopCommerce.user;

public class LoginPageUI {
	//static: để áp dụng cho homepageobject mà ko cần khởi tạo
	//final: không cho phép gán lại giá trị, vì nó là cố định
	// REGISTER_LINK là một contanst: hằng số là 1 giá trị không được phép thay đổi
	// convention: VIÊT HOA, và phân cách bằng gạch dưới
	

	public static final String EMAIL_TEXTBOX="//div/input[@name='Email']";
	public static final String PASSWORD_TEXTBOX="//div/input[@name='Password']";
	public static final String LOGIN_BUTTON="//div/button[@type='submit']";
	public static final String EMAIL_ERROR_MESSAGE="//span[@id='Email-error']";
	//public static final String EMAIL_ERROR_NOT_FOUND_MESSAGE="//a[@class='ico-login']";
	public static final String EMAIL_ERROR_NOT_FOUND_MESSAGE="//div[@class='message-error validation-summary-errors']";

	


}
