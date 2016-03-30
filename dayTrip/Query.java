package dayTrip;

import java.util.ArrayList;

public class Query {
	
	private ArrayList<String> keyWords;
	private ArrayList<String> filters;
	
	public Query(String searchString, ArrayList<String> filters) {
		
		this.filters = filters;		
		this.keyWords = this.generateKeyWords(searchString);
	}
	
	public ArrayList<String> generateKeyWords(String searchString) {
		
		ArrayList<String> words = new ArrayList<String>();
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
