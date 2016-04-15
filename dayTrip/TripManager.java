package dayTrip;

import java.util.ArrayList;

public class TripManager{

	
	private ArrayList<Trip> Trips;
	private DatabaseInterface databaseInterface; 
	public TripManager(DatabaseInterface databaseInterface)
	{
		this.databaseInterface = databaseInterface;
		this.Trips = new ArrayList<Trip>();		
	}

	public ArrayList<Trip> search(Query query){
		return new ArrayList<Trip>();
	}
	
	public void addTrip(Trip trip)
	{
		Trips.add(trip);
	}
	
	public void createTrip(){
		
	}
	public void removeTrip(){
		
	}
	
	public void bookTrip(Trip trip, int numOfSlots) {
		databaseInterface.updateSlots(trip,  numOfSlots);
	}
}
