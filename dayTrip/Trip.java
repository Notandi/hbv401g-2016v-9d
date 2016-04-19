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
	private String type;

	public Trip(String title, String departureTime, String location, int id, String description, int price, String transportation, ArrayList<Attraction> attractions, int slots, Date date, String type) 
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
		this.setAttractions(attractions);
		this.setSlots(slots);
		this.setType(type);
	}

	public void init() {

		
	}

	
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
	
	public ArrayList<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(ArrayList<Attraction> attractions) {
		this.attractions = attractions;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
