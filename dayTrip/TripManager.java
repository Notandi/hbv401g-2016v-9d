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

	public ArrayList<Trip> search(String location, Date date, int numberofpeople, Stirng type){
		
	}
	public void createTrip(){
		
	}
	public void removeTrip(){
		
	}
}
