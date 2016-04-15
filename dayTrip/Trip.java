package dayTrip;

import java.util.ArrayList;

public class Trip {
	private Date date;
	private String title;
	private String departureTime;
	private String location;
	private int id;
	private String description;
	private int price;
	private String transportation;
	private ArrayList<Attraction> attractions;
	private int slots;

	public Trip(String title, String departureTime, String location, int id, String description, int price, String transportation, ArrayList<Attraction> attractions, int slots, Date date) 
	{
		this.init();
		this.setDate(date);
		this.setTitle(title);
		this.setDepartureTime(departureTime);
		this.setLocation(location);
		this.setId(id);
		this.setDescription(description);
		this.setPrice(price);
		this.setTransportation(transportation);
		this.setAttraction(attractions);
		this.setSlots(slots);
	}

	public void init() {

		//attractions = new ArrayList<Attraction>();
		//attractionIDs = 
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
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
	
	public ArrayList<Attraction> getAttraction() {
		return attractions;
	}

	public void setAttraction(ArrayList<Attraction> attractions) {
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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
