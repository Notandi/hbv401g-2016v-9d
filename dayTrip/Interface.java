package dayTrip;

import java.util.ArrayList;

public class Interface {
	private static AttractionManager attractionManager;
	private static TripManager tripManager;
	private static DatabaseInterface databaseInterface;
	
	public Interface()
	{
		this.setDatabaseInterface(new DatabaseInterface());
		this.setAttractionManager(new AttractionManager(databaseInterface));
		this.setTripManager(new TripManager(databaseInterface));
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
	
	public ArrayList<Trip> search(String location, Date date, int numberofpeople, Stirng type){
		tripManager.search(location, date , numberofpeople, type);
	}
	
	/*
	public static class UserInterface {
		private int manager;
		private ArrayList<String> filters;
		
		public UserInterface()
		{
			setFilters(new ArrayList<String>());
		}
		
		public DataBlock search(String searchString)
		{
			Query query = new Query(manager, searchString, this.filters);
			DataBlock res;
			switch (manager){
			case 1:
				res = attractionManager.search(query);				
				break;
			case 2:
				res = tripManager.search(query);
				break;	
			default:
				res = null;
			}
		
			return res;
		}
		
		public void removeFilter(String filter){
			this.filters.remove(filter);			
		};
		
		public int getManager() {return manager;}
		
		public void setManager(int newManager){this.manager = newManager;}

		public ArrayList<String> getFilters() {
			return filters;
		}

		public void addFilter(String filter){
			this.filters.add(filter);
		}
		
		public void setFilters(ArrayList<String> filters) {
			this.filters = filters;
		}

	}*/
	
}
