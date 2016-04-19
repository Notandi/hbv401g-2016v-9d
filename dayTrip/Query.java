package dayTrip;

public class Query {
	
	private String type;
	private String location;
	private Date startDate;
	private Date endDate;
	private int numOfPeople;
	
	
	public Query(String location, Date startDate, Date endDate, int numOfPeople, String type) {
		setType(type);
		setLocation(location);
		setStartDate(startDate);
		setEndDate(endDate);
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


	public int getNumOfPeople() {
		return numOfPeople;
	}


	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
}
