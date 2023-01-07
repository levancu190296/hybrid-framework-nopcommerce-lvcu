package javaOOP;
//vd: tính đa hình thái overloading của oop:Polymorphism:
// 1 hàm củng tên nhưng khác số lượng tham số truyền vào, ko quan tâm khác hay giống kiểu dữ liệu
// có thể cùng tên, cùng số lượng tham số nhưng phải khác kiểu dữ liệu


public class Topic_08_Overloading {
	private int firstNumber;
	private int secondNumber;
	
	public void sumNumer() {
		System.out.println(this.firstNumber + this.secondNumber);
	}
	
	public void sumNumber(int firstNumber, int secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}
	
	public void sumNumber(float firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}
	
	public void sumNumber(int firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}
	
	public static void main(String[] args) {
		
	}

}
