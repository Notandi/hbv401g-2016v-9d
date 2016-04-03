package dayTrip;

import java.util.ArrayList;

public class MockData {
	
	// The five following functions create and return mock data of various types.
	
	// Returns an ArrayList containing a single Car object.
	public static ArrayList<Car> MockCar(Query query){
		String[] keywords = {"jeppi", "97"};
		Car mockcar = new Car("Ford 356", "97 model, jeppi, kemst hvert sem er.", "link", 30000, keywords, true);
		ArrayList<Car> carArray = new ArrayList<Car>();
		carArray.add(mockcar);
		return carArray;
	}
	// Returns an ArrayList containing a single Attraction object.
	public static ArrayList<Attraction> MockAttraction(Query query){
		Attraction mockattraction = new Attraction("Natural wonder","Grindavík", "Eðal bær, mjög fallegur.", "link");
		ArrayList<Attraction> attractionArray = new ArrayList<Attraction>();
		attractionArray.add(mockattraction);
		return attractionArray;
	}
	// Returns an ArrayList containing a single Booking object.
	public static ArrayList<Booking> MockBooking(Query query){
		Booking mockbooking = new Booking("Jonathan Blake jr.", null, null, 14000, 6);
		ArrayList<Booking> bookingArray = new ArrayList<Booking>();
		bookingArray.add(mockbooking);
		return bookingArray;
	}
	// Returns an ArrayList containing a single Trip object.
	public  static ArrayList<Trip> MockTrip (Query query ){
		String[] keywords = {"Hvalfjörður", "göngutúr"};
		Trip mocktrip = new Trip(0, "Hvalfjörður", 2, "Göngutúr um fallegt landsvæði.", 1500, "Bus", null, null, "link", null, keywords);
		ArrayList<Trip> tripArray = new ArrayList<Trip>();
		tripArray.add(mocktrip);
		return tripArray; 
	}
	// Returns an ArrayList containing a single Customer object.
	public  static ArrayList<Customer> MockCustomer (Query query){
		Customer mockcustomer = new Customer("Gunnþórunn Kona Rafnsdóttir", 15, "Female", "Indian", "iamindian@india.in");
		ArrayList<Customer> customerArray = new ArrayList<Customer>();
		customerArray.add(mockcustomer);
		return customerArray;
	}
	
	// These functions should delete or insert data in the database, 
	// currently they return the integer 1 if the function call was successful.
	public static int insert(Pair[] query) {
		return 1;
	}
	public static int delete(Pair[] query) {
		return 1;
	}
	

}
