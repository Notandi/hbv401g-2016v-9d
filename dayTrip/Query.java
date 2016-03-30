package dayTrip;

import java.util.ArrayList;

public class Query {
	
	private ArrayList<String> keyWords;
	private ArrayList<String> filters;
	private String[] ignoreWords = {"or", "and"};
	
	public Query(String searchString, ArrayList<String> filters) {
		
		this.filters = filters;		
		this.keyWords = this.generateKeyWords(searchString);
	}
	
	public ArrayList<String> generateKeyWords(String searchString) {
		
		ArrayList<String> words = new ArrayList<String>();
		int firstLetter = 0;
		
		for(int i = 0; i < searchString.length(); i++) {
			
			if(searchString.charAt(i) == '\0') {
				
				String word = searchString.substring(firstLetter, i);
				
				if(!isIgnoreWord(word))
					words.add(word);		
				
				firstLetter = i;
			}
		}
		
		return words;
	}
	
	public boolean isIgnoreWord(String word) {
		
		for(int i = 0; i < ignoreWords.length; i++) {
			
			if(word.equals(ignoreWords[i])) return true;
		}
		
		return false;
	}
}
