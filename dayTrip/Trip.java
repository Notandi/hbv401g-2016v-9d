package dayTrip;

public class Trip {
	private int  popularity;
	private String location;
	private int difficulty;
	private String description;
	private int price;
	private String transportation;
	private String[] reviews;
	private int[] ratings;
	private String picture;
	private Attraction[] attraction;
	private String keywords;
	
	public Trip (int  popularity, String location, int difficulty, String description, int price, String transportation, String[] reviews, int[] ratings, String picture, Attraction[] attraction, String keywords) {
		this.popularity = popularity;
		this.location = location;
		this.difficulty = difficulty;
		this.description = description;
		this.price = price;
		this.transportation = transportation;
		this.reviews = reviews;
		this.picture = picture;
		this.attraction = attraction;
		this.keywords = keywords;
	}
	public void addReview(String review){
		
	}
	
	public void changePopularity(int difference){
		
	}
	
	public void changePrice(int price){
		
	}
	
	public void rate(int rating){
		
	}
}
