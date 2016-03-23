package dayTrip;

public class Car {
	private String type;
	private String description;
	private	String picture;
	private int price;
	private String keywords;
	
	public Car(String type, String description, String picture, int price, String keywords) {
		
		this.type = type;
		this.description = description;
		this.picture = picture;
		this.price = price;
		this.keywords = keywords;
	}
	
	public void changePrices(int price){
		this.price = price;
	}
}
