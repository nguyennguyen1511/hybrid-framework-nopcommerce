package javaOOP;

public class CarPop {
	//Nested class
	public class Head{
		
	}
	public interface ICar{
		
	}
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;
	

	public static void main(String[] args) {
		carCompany = "Honda";
		carType = "5C";
		fuelType = "N95";
		mileAge = 200f;
		carPrice = 50000d;
		System.out.println("Car company = " + carCompany);

	}

}
