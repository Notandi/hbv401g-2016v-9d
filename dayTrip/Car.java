package dayTrip;

public class Car {
	private String type;
	private String description;
	private	String picture;
	private int price;
	private String keywords;
	
	public Car(String type, String description, String picture, int price, String keywords) {
		
		this.setType(type);
		this.setDescription(description);
		this.setPicture(picture);
		this.setPrice(price);
		this.setKeywords(keywords);
	}
	
	public void changePrices(int price){
		this.setPrice(price);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
