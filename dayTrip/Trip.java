package dayTrip;

import java.util.ArrayList;

public class Trip {
	private String location;
	private int id;
	private int difficulty;
	private String description;
	private int price;
	private String transportation;
	private String attractions;
	private int slots;

	public Trip(String location, int difficulty, String description, int price, String transportation, String attractions, String[] keywords) {
		this.init();
		this.setLocation(location);
		this.setDifficulty(difficulty);
		this.setDescription(description);
		this.setPrice(price);
		this.setTransportation(transportation);
		this.setAttraction(attractions);
		this.setKeywords(keywords);
	}

	public void init() {

		//attractions = new ArrayList<Attraction>();
	}
/*
	public void addAttratction(Attraction attraction) {
		this.attractions.add(attraction);
	}
*/
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
	
	public String getAttraction() {
		return attractions;
	}

	public void setAttraction(String attractions) {
		this.attractions = attractions;
	}
/*
	public ArrayList<Attraction> getAttraction() {
		return this.attractions;
	}

	public void setAttraction(Attraction[] attractions) {
		if (attractions == null)
			return;
		for (int i = 0; i < attractions.length; i++) {
			this.attractions.add(attractions[i]);
		}
	}
*/

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
}
