package dayTrip;

import java.util.ArrayList;

public class DatabaseInterface {
	
	public ArrayList<?> select(Query query)
	{
		int manager = query.getType();
		switch(manager){
		case 1:	ArrayList<Attraction> mockresultAttraction =  MockData.MockAttraction(query);
				return mockresultAttraction;
		case 2: ArrayList<Trip> mockresultTrip = MockData.MockTrip(query);
				return mockresultTrip;
		case 3: ArrayList<Car> mockresultCar = MockData.MockCar(query);
				return mockresultCar;
		case 4:	ArrayList<Booking> mockresultBooking = MockData.MockBooking(query);
				return mockresultBooking;
		case 5: ArrayList<Customer> mockresultCustomer = MockData.MockCustomer(query);
				return mockresultCustomer;
		}
		return null;
	}
	
	public int insert(Pair[] query)
	{		
		return -1;
	}
	
	public int delete(Pair[] query)
	{
		return -1;
	}

}
