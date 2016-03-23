package dayTrip;

public class Attraction {
	
	private String type;
	private String location;
	private String description;
	private String picture;
	
	public Attraction(String type, String location, String description, String picture) {
		
		this.type = type;
		this.location = location;
		this.description = description;
		this.picture = picture;
	}
	
	public void changePicture(String picture) {
		
		this.picture = picture;
	}
	
	public void changeDescription(String description) {
		
		this.description = description;
	}
}
