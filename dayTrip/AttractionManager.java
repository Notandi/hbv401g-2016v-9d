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
	
	public Pair locateExistingAttractions(ArrayList<Integer> ids) {
		
		ArrayList <Attraction> foundAttractions = new ArrayList<Attraction>();
		
		for(int i = 0; i<ids.size(); i++)
		{
			for(int k = 0; k<Attractions.size(); k++)
			{
				Attraction attraction = Attractions.get(k);
				if(ids.get(i) == attraction.getId())
				{
					foundAttractions.add(attraction);		
					ids.remove(i);
					i--;					
				}
			}
		}
		
		Pair attractionsFound = new Pair(ids,foundAttractions);
		return attractionsFound;
		
	}
	public void addToArrayList(ArrayList<Attraction> databaseAttractions){
		Attractions.addAll(databaseAttractions);
	}
	public void createAttraction(){
		
	}
	public void removeAttraction(){
		
	}
}
