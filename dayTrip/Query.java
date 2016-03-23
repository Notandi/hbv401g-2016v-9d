package dayTrip;

public class Query {
	
	private String[] keyWords;
	private Boolean[] filters;
	
	public Query(String searchString, Boolean[] filters) {
		
		this.filters = filters;		
		this.keyWords = this.generateKeyWords(searchString);
	}
	
	public String[] generateKeyWords(String searchString) {
		
		String[] bla = new String[2];
		return bla;
	}
}
