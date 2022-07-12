package javaBasic;

public class Topic_04_Operator {


	public static void main(String[] args) {
		int number =10;
		
		//in ra rồi mới cộng,in ra 10, rồi cộng lên thành 11
		System.out.println(number++);
		
		//cộng trước rồi mới in ra, công 11+1 =12 , rồi mới in ra số 12
		System.out.println(++number);
		
		int a =1;
		int b=4;
		if (!(a==2)) {
			System.out.println("cuga 1996");
		}
		
		// biểu thức tam nguyên
		boolean status = (b==4) ? true:false;
		System.out.println(status);
		
	}

}
