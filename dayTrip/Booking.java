package dayTrip;

public class Booking {
	
	private String customer;
	private Trip[] trips;
	private Car[] cars;
	private int price;
	private int numOfPeople;
	
	public Booking(String customer, Trip[] trips, Car[] cars, int price, int numOfPeople) {
		
		this.setCustomer(customer);
		this.setTrips(trips);
		this.setCars(cars);
		this.setPrice(price);
		this.setNumOfPeople(numOfPeople);
	}
	
	public void pay() {
		
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Trip[] getTrips() {
		return trips;
	}

	public void setTrips(Trip[] trips) {
		this.trips = trips;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}
}
