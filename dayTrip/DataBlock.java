package dayTrip;

import java.util.ArrayList;

public class DataBlock {
	
	private ArrayList<Attraction> attractions;
	private ArrayList<Trip> trips;
	private int type;
	
	public DataBlock(int type) {
		
		this.setAttractions(null);
		this.setTrips(null);
		this.setType(type);
	}

	public ArrayList<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(ArrayList<Attraction> attractions) {
		this.attractions = attractions;
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