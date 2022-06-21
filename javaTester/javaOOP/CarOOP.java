package javaOOP;

public class CarOOP {
	//Thuộc tính
	private String carCompany;
	private String carType;
	private String fuelType;
	private Float mileAge;
	private Double carPrice;
	

	public CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
		super();
		this.carCompany = carCompany;
		this.carType = carType;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}


	protected String getCarCompany() {
		return carCompany;
	}


	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}


	protected String getCarType() {
		return carType;
	}


	protected void setCarType(String carType) {
		this.carType = carType;
	}


	protected String getFuelType() {
		return fuelType;
	}


	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}


	protected Float getMileAge() {
		return mileAge;
	}


	protected void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}


	protected Double getCarPrice() {
		return carPrice;
	}


	protected void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}
	protected void showCarInfo() {
		System.out.println("Car company = "+ getCarCompany());
		System.out.println("Car Type = "+ getCarType());
		System.out.println("Fuel Type = "+ getFuelType());
		System.out.println("MileAge = "+ getMileAge());
		System.out.println("Price = "+ getCarPrice());
	}
	
	public static void main(String[] args) {
		// Honda
		CarOOP honda = new CarOOP("Honda","Cit","Petrol",150f, 5000d);
		honda.showCarInfo();
		
		//toyota
		CarOOP toyota = new CarOOP("toyota","Cit","Petrol",150f, 5000d);

		toyota.showCarInfo();

	}

}
