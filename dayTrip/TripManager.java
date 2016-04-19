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
	
	public boolean BookTrip(Trip trip, int numOfPeople){
		for (int i = 0;i < Trips.size(); i++ ){
			Trip managedTrip = Trips.get(i);
			if(trip.getId() == managedTrip.getId()){
				return(databaseInterface.updateSlots( managedTrip, numOfPeople));
			}
		}
		return false;
	}

	public ArrayList<Trip> search(Query query){
		return this.databaseInterface.select(query);
	}
	
	public void addTrip(Trip trip)
	{
		Trips.add(trip);
	}
	
	public ArrayList<Trip> findMatchingTrips(Query query)
	{
		ArrayList<Trip> res = new ArrayList<Trip>();
		boolean match;
		for(int i = 0; i<Trips.size(); i++)
		{
			int date = dateToInt(Trips.get(i).getDate());
			match = ((query.getType() == Trips.get(i).getType()) && (query.getLocation() == Trips.get(i).getLocation()) &&
					 (query.getNumOfPeople() < Trips.get(i).getSlots()) && 
					 ((dateToInt(query.getStartDate()) < date) && (dateToInt(query.getEndDate())) > date));
					 
			if(match) res.add(Trips.get(i));  					
						
		}
		
		return res;
	}
	
	public int dateToInt (Date date){
		int intDate;
		intDate = date.getDay();
		intDate += date.getMonth()*100;
		intDate += date.getYear()*10000;
		return intDate;
	}
	
	public void createTrip(){
		
	}
	public void removeTrip(){
		
	}
	
	public void bookTrip(Trip trip, int numOfSlots) {
		databaseInterface.updateSlots(trip,  numOfSlots);
	}
}
