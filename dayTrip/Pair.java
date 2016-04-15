package dayTrip;

import java.util.ArrayList;

public class Pair {
	
	private ArrayList<Integer> ids;
	private ArrayList<Attraction> attractions;
	
	public Pair(ArrayList<Integer> ids, ArrayList<Attraction> attractions) {
		
		this.setIds(ids);
		this.setAttractions(attractions);
	}

	public ArrayList<Integer> getIds() {
		return ids;
	}

	public void setIds(ArrayList<Integer> ids) {
		this.ids = ids;
	}

	public ArrayList<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(ArrayList<Attraction> attractions) {
		this.attractions = attractions;
	}
	
}
