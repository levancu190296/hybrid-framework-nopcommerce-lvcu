package javaBasic;

import java.io.InputStream;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Excercise {

    public static void main(String[] args) {
    	// bai 1
    	String name ="Tuan";
    	//luu giu lieu nhap tu ban phim
        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        System.out.println("Tuoi:");
        int input = scanner.nextInt();
        System.out.println("age of " + name + " after 15 years is "  + (input + 15));

        
        
        //bai 3
        System.out.println("a va b lan luot la");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        boolean status = (a>b)?true:false;
        System.out.println(status);
        
        scanner.close();

    }
    
}
