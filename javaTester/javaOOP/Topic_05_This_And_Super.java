package javaOOP;

public class Topic_05_This_And_Super extends Super {

	private int firstNumber;
	private int secondNumber;
	int maxSpeed = 100;

	public Topic_05_This_And_Super(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public void sumNumber() {
		System.out.println(firstNumber + secondNumber);// c1
		System.out.println(this.firstNumber + this.secondNumber);// c2
		System.out.println(this.firstNumber + secondNumber);// c3
		System.out.println(firstNumber + this.secondNumber);// c4
	}

	public void showNumber() {
		this.sumNumber();
		sumNumber();
	}

	void display() {
		System.out.println("have" + super.maxSpeed);
		System.out.println("does not have" + maxSpeed);
		super.showSpeed();
		showSpeed();
	}

	public static void main(String[] args) {
		Topic_05_This_And_Super topic = new Topic_05_This_And_Super(14, 15);
		topic.sumNumber();
		topic.display();
	}

}
