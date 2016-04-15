package dayTrip;

import java.util.ArrayList;

public class AttractionManager {
	
	private ArrayList<Attraction> Attractions;
	private DatabaseInterface databaseInterface; 
	public AttractionManager(DatabaseInterface databaseInterface)
	{
		this.databaseInterface = databaseInterface;
		this.Attractions = new ArrayList<Attraction>();
	}
}
