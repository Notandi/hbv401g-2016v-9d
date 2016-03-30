package dayTrip;

public class Car {
	private String type;
	private String description;
	private	String picture;
	private int price;
	private String keywords;
	
	public Car(String type, String description, String picture, int price, String keywords) {
		
		this.type = type;
		this.setDescription(description);
		this.setPicture(picture);
		this.price = price;
		this.keywords = keywords;
	}
	
	public void changePrices(int price){
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
