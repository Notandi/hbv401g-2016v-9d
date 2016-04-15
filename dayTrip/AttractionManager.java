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
	public ArrayList<Attraction> search(String type, String location){
		
		ArrayList<Attraction> x = new ArrayList<Attraction>();
		return x;
	}
	public void createAttraction(){
		
	}
	public void removeAttraction(){
		
	}
}
