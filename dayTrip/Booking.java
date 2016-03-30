package dayTrip;
import java.util.ArrayList;

public class Booking {
	
	private String customer;
	private ArrayList<Trip> trips;
	private ArrayList<Car> cars;
	private int price;
	private int numOfPeople;
	
	public Booking(String customer, Trip trips, Car cars, int price, int numOfPeople) {
		
		this.trips = new ArrayList<Trip>();
		this.cars = new ArrayList<Car>();
		
		this.setCustomer(customer);
		this.addTrip(trips);
		this.addCar(cars);
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

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public void addTrip(Trip trip) {
		if(trip != null) this.trips.add(trip);
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void addCar(Car car) {
		if(car != null) this.cars.add(car);
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
