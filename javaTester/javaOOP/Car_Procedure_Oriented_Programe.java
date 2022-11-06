package javaOOP;

public class Car_Procedure_Oriented_Programe {
	
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice; 
	
	public static void main(String[] args) {
		carCompany ="Honda";
		carType="City";
		fuelType = "Petrol";
		mileAge =200f;
		carPrice=50000d;
		System.out.println(carCompany);
		System.out.println(carType);
		System.out.println(fuelType);
		System.out.println(mileAge);
		System.out.println(carPrice);
		
		carCompany ="Yamaha";
		carType="Exciter";
		fuelType = "Petrols";
		mileAge =400f;
		carPrice=30000d;
		System.out.println(carCompany);
		System.out.println(carType);
		System.out.println(fuelType);
		System.out.println(mileAge);
		System.out.println(carPrice);
	}

}
