package dayTrip;

public class Attraction {
	
	private String type;
	private String location;
	private String description;
	private String picture;
	
	public Attraction(String type, String location, String description, String picture) {
		
		this.setType(type);
		this.setLocation(location);
		this.setDescription(description);
		this.setPicture(picture);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
