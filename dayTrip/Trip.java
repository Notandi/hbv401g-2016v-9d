package dayTrip;

import java.util.ArrayList;

public class Trip {
	private int  popularity;
	private String location;
	private int difficulty;
	private String description;
	private int price;
	private String transportation;
	private ArrayList<String> reviews;
	private ArrayList<Integer> ratings;
	private String picture; 
	private ArrayList<Attraction> attractions;
	private String[] keywords;
	private double rating;
	
	public Trip (int  popularity, String location, int difficulty, String description, int price, String transportation, String[] reviews, int[] ratings, String picture, Attraction[] attractions, String[] keywords) {
		this.init();
		this.setPopularity(popularity);
		this.setLocation(location);
		this.setDifficulty(difficulty);
		this.setDescription(description);
		this.setPrice(price);
		this.setTransportation(transportation);
		this.setReviews(reviews);
		this.setPicture(picture);
		this.setAttraction(attractions);
		this.setKeywords(keywords);
	}
	
	public void init()
	{
		reviews = new ArrayList<String>();
		ratings = new ArrayList<Integer>();
		attractions = new ArrayList<Attraction>();		
	}
	
	public void addReview(String review){this.reviews.add(review);}	
	public void addrating(int rating){this.ratings.add(rating);}
	public void addAttratction(Attraction attraction){this.attractions.add(attraction);}
	
	public void changePopularity(int difference){
		
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
	public ArrayList<String> getReviews() {
		return reviews;
	}
	public void setReviews(String[] reviews) {
		if(reviews == null) return;
		for(int i = 0; i<reviews.length; i++)
		{
			this.reviews.add(reviews[i]);
		}
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public ArrayList<Attraction> getAttraction() {
		return this.attractions;
	}
	public void setAttraction(Attraction[] attractions) {
		if(attractions == null) return;
		for(int i = 0; i<attractions.length; i++)
		{
			this.attractions.add(attractions[i]);
		}
	}
	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	public ArrayList<Integer> getRatings() {
		return ratings;
	}
	public void setRatings(int[] ratings) {
		if(ratings == null) return;
		for(int i = 0; i<ratings.length; i++)
		{
			this.ratings.add(ratings[i]);
		}
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
