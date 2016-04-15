package dayTrip;

import java.util.ArrayList;

public class MockData {
	
	// The five following functions create and return mock data of various types.
	
	// Returns an ArrayList containing a single Attraction object.
	public static ArrayList<Attraction> MockAttraction(Query query){
		Attraction mockattraction = new Attraction("Natural wonder","Grindav�k", "E�al b�r, mj�g fallegur.", "link");
		ArrayList<Attraction> attractionArray = new ArrayList<Attraction>();
		attractionArray.add(mockattraction);
		return attractionArray;
	}
	
	// Returns an ArrayList containing a single Trip object.
	public  static ArrayList<Trip> MockTrip (Query query ){
		String[] keywords = {"Hvalfj�r�ur", "g�ngut�r"};
		Trip mocktrip = new Trip(0, "Hvalfj�r�ur", 2, "G�ngut�r um fallegt landsv��i.", 1500, "Bus", null, null, "link", null, keywords);
		ArrayList<Trip> tripArray = new ArrayList<Trip>();
		tripArray.add(mocktrip);
		return tripArray; 
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
