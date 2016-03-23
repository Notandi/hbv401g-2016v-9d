package dayTrip;

public class Booking {
	
	private String customer;
	private Trip[] trips;
	private Car[] cars;
	private int price;
	private int numOfPeople;
	
	public Booking(String customer, Trip[] trips, Car[] cars, int price, int numOfPeople) {
		
		this.customer = customer;
		this.trips = trips;
		this.cars = cars;
		this.price = price;
		this.numOfPeople = numOfPeople;
	}
	
	public void pay() {
		
	}
}
