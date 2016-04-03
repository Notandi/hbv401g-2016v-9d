package dayTrip;

import java.util.ArrayList;

public class DatabaseInterface {
	
	public DataBlock select(Query query)
	{
		int type = query.getType();
		DataBlock res = new DataBlock(type);
		
		switch(type){
		case 1:	ArrayList<Attraction> mockresultAttraction =  MockData.MockAttraction(query);
				res.setAttractions(mockresultAttraction);
				break;
		case 2: ArrayList<Trip> mockresultTrip = MockData.MockTrip(query);
				res.setTrips(mockresultTrip);
				break;
		case 3: ArrayList<Car> mockresultCar = MockData.MockCar(query);
				res.setCars(mockresultCar);
				break;
		case 4:	ArrayList<Booking> mockresultBooking = MockData.MockBooking(query);
				res.setBookings(mockresultBooking);
				break;
		case 5: ArrayList<Customer> mockresultCustomer = MockData.MockCustomer(query);
				res.setCustomers(mockresultCustomer);
				break;
		}
		return res;
	}
	
	public int insert(Pair[] query)
	{		
		return MockData.insert(query);
	}
	
	public int delete(Pair[] query)
	{
		return MockData.delete(query);
	}

}
