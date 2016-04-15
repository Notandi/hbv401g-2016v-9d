package dayTrip;

import java.util.ArrayList;

public class Query {
	
	private String type;
	private String location;
	private Date date;
	private int numOfPeople;
	
	
	public Query(String location, Date date, int numOfPeople, String type) {
		setType(type);
		setLocation(location);
		setDate(date);	
		setNumOfPeople(numOfPeople);
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getNumOfPeople() {
		return numOfPeople;
	}


	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}
	
	
}
