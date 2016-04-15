package dayTrip;

public class Attraction {
	
	private int id;
	private String name;
	private String type;
	private String location;
	private String description;
	
	public Attraction(int id,String type, String location, String description, String name) {
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setLocation(location);
		this.setDescription(description);
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
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
