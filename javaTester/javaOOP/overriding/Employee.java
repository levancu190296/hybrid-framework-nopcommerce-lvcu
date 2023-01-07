package javaOOP.overriding;

public class Employee extends Person implements IWork {
	@Override
	public void eat() {
		System.out.println("an 25k cho bua trua");
	}
	
	@Override
	public void sleep() {
		System.out.println("ngu 8 tieng");
	}
	
	@Override
	public void workingTime() {
		System.out.println("lam 8 tieng");
	}
}
