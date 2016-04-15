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
	
	public ArrayList<Integer> locateExistingAttractions(int id) {
		
		
	}
	
	/*public Attraction findAttractionById(int id){
		for (int i = 0; i < Attractions.size(); i++){
			Attraction atr = Attractions.get(i);
			if (atr.getId() == id){
				return atr;
			}
		}
		Attractions.add(databaseInterface.selectAttraction(id));
		return Attractions.get(Attractions.size());
		
	}*/
	public void createAttraction(){
		
	}
	public void removeAttraction(){
		
	}
}
