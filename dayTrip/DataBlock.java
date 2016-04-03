package dayTrip;

import java.util.ArrayList;

public class DataBlock {
	
	private ArrayList<Attraction> attractions;
	private ArrayList<Booking> bookings;
	private ArrayList<Car> cars;
	private ArrayList<Customer> customers;
	private ArrayList<Trip> trips;
	private int type;
	
	public DataBlock(int type) {
		
		this.setAttractions(new ArrayList<Attraction>());
		this.setBookings(new ArrayList<Booking>());
		this.setCars(new ArrayList<Car>());
		this.setCustomers(new ArrayList<Customer>());
		this.setTrips(new ArrayList<Trip>());
		this.setType(type);
	}

	public ArrayList<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(ArrayList<Attraction> attractions) {
		this.attractions = attractions;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}