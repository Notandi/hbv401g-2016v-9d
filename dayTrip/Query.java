package dayTrip;

import java.util.ArrayList;

public class Query {
	
	private ArrayList keyWords;
	private Boolean[] filters;
	
	public Query(String searchString, Boolean[] filters) {
		
		this.filters = filters;		
		this.keyWords = this.generateKeyWords(searchString);
	}
	
	public ArrayList generateKeyWords(String searchString) {
		
		ArrayList words = new ArrayList();
		int firstLetter = 0;
		
		for(int i = 0; i < searchString.length(); i++) {
			
			if(searchString.charAt(i) == '\0') {
				
				words.add(searchString.substring(firstLetter, i));				
				firstLetter++;
			}
		}
		
		return words;
	}
}
