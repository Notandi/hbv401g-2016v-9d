package dayTrip;

import java.util.ArrayList;

public class Query {
	
	private ArrayList<String> keyWords;
	private ArrayList<String> filters;
	private int type;
	private String[] ignoreWords = {"or", "and"};
	
	public Query(int type, String searchString, ArrayList<String> filters) {
		
		this.keyWords = new ArrayList<String>();
		this.filters = new ArrayList<String>();
		
		this.setType(type);
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
