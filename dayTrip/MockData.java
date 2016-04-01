package dayTrip;

import java.util.ArrayList;

public class MockData {
	
	public static ArrayList<Car> MockCar(Query query){
		Car mockcar = new Car(null, null, null, 0, null, false);
		ArrayList<Car> carArray = new ArrayList<Car>();
		carArray.add(mockcar);
		return carArray;
	}
	public static ArrayList<Attraction> MockAttraction(Query query){
		Attraction mockattraction = new Attraction(null, null, null, null);
		ArrayList<Attraction> attractionArray = new ArrayList<Attraction>();
		attractionArray.add(mockattraction);
		return attractionArray;
	}
	public static ArrayList<Booking> MockBooking(Query query){
		Booking mockbooking = new Booking(null, null, null, 0, 0);
		ArrayList<Booking> bookingArray = new ArrayList<Booking>();
		bookingArray.add(mockbooking);
		return bookingArray;
	}
	public  static ArrayList<Trip> MockTrip (Query query ){
		Trip mocktrip = new Trip(0, null, 0, null, 0, null, null, null, null, null, null);
		ArrayList<Trip> tripArray = new ArrayList<Trip>();
		tripArray.add(mocktrip);
		return tripArray; 
	}
	public  static ArrayList<Customer> MockCustomer (Query query){
		Customer mockcustomer = new Customer(null, 0, null, null, null);
		ArrayList<Customer> customerArray = new ArrayList<Customer>();
		customerArray.add(mockcustomer);
		return customerArray;
	}

}
