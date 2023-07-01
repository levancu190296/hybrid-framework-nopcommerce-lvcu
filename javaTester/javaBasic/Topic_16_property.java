package javaBasic;

import java.io.File;

public class Topic_16_property {
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	//windows /mac /linux
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	
	public static final String OS_NAME =  System.getProperty("os.name") ;
	
	public static void main(String[] args) {
		System.out.println(PROJECT_PATH);
		System.out.println(UPLOAD_FILE_FOLDER);
		
	}
}
