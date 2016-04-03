package dayTrip;

import java.util.ArrayList;

public class MockData {
	
	public static ArrayList<Car> MockCar(Query query){
		String[] keywords = {"jeppi", "97"};
		Car mockcar = new Car("Ford 356", "97 model, jeppi, kemst hvert sem er.", "link", 30000, keywords, true);
		ArrayList<Car> carArray = new ArrayList<Car>();
		carArray.add(mockcar);
		return carArray;
	}
	public static ArrayList<Attraction> MockAttraction(Query query){
		Attraction mockattraction = new Attraction("Natural wonder","Grindav�k", "E�al b�r, mj�g fallegur.", "link");
		ArrayList<Attraction> attractionArray = new ArrayList<Attraction>();
		attractionArray.add(mockattraction);
		return attractionArray;
	}
	public static ArrayList<Booking> MockBooking(Query query){
		Booking mockbooking = new Booking("Jonathan Blake jr.", null, null, 14000, 6);
		ArrayList<Booking> bookingArray = new ArrayList<Booking>();
		bookingArray.add(mockbooking);
		return bookingArray;
	}
	public  static ArrayList<Trip> MockTrip (Query query ){
		String[] keywords = {"Hvalfj�r�ur", "g�ngut�r"};
		Trip mocktrip = new Trip(0, "Hvalfj�r�ur", 2, "G�ngut�r um fallegt landsv��i.", 1500, "Bus", null, null, "link", null, keywords);
		ArrayList<Trip> tripArray = new ArrayList<Trip>();
		tripArray.add(mocktrip);
		return tripArray; 
	}
	public  static ArrayList<Customer> MockCustomer (Query query){
		Customer mockcustomer = new Customer("�sk �lafsd�ttir", 15, "Female", "Indian", "iamindian@india.in");
		ArrayList<Customer> customerArray = new ArrayList<Customer>();
		customerArray.add(mockcustomer);
		return customerArray;
	}
	public static int insert(Pair[] query) {
		return 1;
	}
	public static int delete(Pair[] query) {
		return 2;
	}
	

}
