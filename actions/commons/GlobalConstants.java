package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_DEV_URL="https://demo.nopcommerce.com/";
	public static final String ADMIN_DEV_URL="https://admin-demo.nopcommerce.com/";
	public static final String PORTAL_TEST_URL="https://demo.nopcommerce.com/";
	public static final String ADMIN_TEST_URL="https://admin-demo.nopcommerce.com/";
	//lấy ra đường dẫn tương đối của project, đang đứng ở đâu thì lấy ở đó
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	//windown /mac / linux
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	//database account/user/pass/port 
	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_USER = "cuga1996";
	public static final String DB_DEV_PASS = "123456x@X";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 20;
	public static final long RETRY_TEST_FAIL = 3;
}

