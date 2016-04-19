package dayTrip;

import java.util.ArrayList;

public class Interface {
	private  AttractionManager attractionManager;
	private  TripManager tripManager;
	private  DatabaseInterface databaseInterface;
	
	public Interface()
	{
		this.setDatabaseInterface(new DatabaseInterface());
		this.setAttractionManager(new AttractionManager());
		this.setTripManager(new TripManager(databaseInterface));
		databaseInterface.addManagers(attractionManager,tripManager);

	}
	
	public boolean book(Trip trip, int numOfPeople){
		if(trip.getSlots() < numOfPeople) return false;
		return tripManager.BookTrip(trip, numOfPeople);
	}

	public AttractionManager getAttractionManager() {
		return attractionManager;
	}

	public void setAttractionManager(AttractionManager attractionManager) {
		this.attractionManager = attractionManager;
	}

	public TripManager getTripManager() {
		return tripManager;
	}

	public void setTripManager(TripManager tripManager) {
		this.tripManager = tripManager;
	}

	public DatabaseInterface getDatabaseInterface() {
		return databaseInterface;
	}

	public void setDatabaseInterface(DatabaseInterface databaseInterface) {
		this.databaseInterface = databaseInterface;
	}
	
	public ArrayList<Trip> search(String location, Date startDate,Date endDate, int numberofpeople, String type){
		Query query = new Query(location,startDate,endDate,numberofpeople,type);
		
		return tripManager.search(query);
	}
	public void createTrip(){
		tripManager.createTrip();
	}
	public void removeTrip(){
		tripManager.removeTrip();
	}
	public void createAttraction(){
		attractionManager.createAttraction();
	}
	public void removeAttraction(){
		attractionManager.removeAttraction();
	}
	
	
}
