package dayTrip;

import java.util.ArrayList;

public class AttractionManager {
	
	private ArrayList<Attraction> Attractions;
	 
	public AttractionManager()
	{		
		this.Attractions = new ArrayList<Attraction>();
	}
	
	public Pair locateExistingAttractions(ArrayList<Integer> ids) {
		
		ArrayList <Attraction> foundAttractions = new ArrayList<Attraction>();
		
		for(int i = ids.size()-1; i>=0; i--)
		{
			for(int k = 0; k<Attractions.size(); k++)
			{
				Attraction attraction = Attractions.get(k);
				if(ids.get(i) == attraction.getId())
				{
					foundAttractions.add(attraction);	
					ids.remove(i);	
					break;
				}
			}
		}
		
		Pair attractionsFound = new Pair(ids,foundAttractions);
		return attractionsFound;
		
	}
	public void addToArrayList(ArrayList<Attraction> databaseAttractions){
		if(databaseAttractions == null) return;
		Attractions.addAll(databaseAttractions);
	}
	public void createAttraction(){
		
	}
	public void removeAttraction(){
		
	}
}
