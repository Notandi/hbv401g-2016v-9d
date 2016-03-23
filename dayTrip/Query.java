package dayTrip;

import java.util.ArrayList;

public class Query {
	
	private String[] keyWords;
	private Boolean[] filters;
	
	public Query(String searchString, Boolean[] filters) {
		
		this.filters = filters;		
		this.keyWords = this.generateKeyWords(searchString);
	}
	
	public ArrayList generateKeyWords(String searchString) {
		
		ArrayList words = new ArrayList();
		
		for(int i = 0; i < searchString.length(); i++) {
			
			if(ArrayList.le)
		}
		
		return words;
	}
}
