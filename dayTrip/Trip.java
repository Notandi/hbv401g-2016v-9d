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
		this.setPopularity(popularity);
		this.location = location;
		this.difficulty = difficulty;
		this.setDescription(description);
		this.setPrice(price);
		this.setTransportation(transportation);
		this.setReviews(reviews);
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String[] getReviews() {
		return reviews;
	}
	public void setReviews(String[] reviews) {
		this.reviews = reviews;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
}
