package dayTrip;

import java.util.ArrayList;

public class DatabaseInterface {
	
	public ArrayList<?> select(Query query)
	{
		int manager = query.getType();
		switch(manager){
		case 1: ArrayList<Car> x1 = MockData.MockCar(query);
				return x1;
		case 2:	ArrayList<Attraction> z1 =  MockData.MockAttraction(query);
				return z1;
		case 3: ArrayList<Trip> q1 = MockData.MockTrip(query);
				return q1;
		case 4:	ArrayList<Booking> r1 = MockData.MockBooking(query);
				return r1;
		case 5: ArrayList<Customer> s1 =  MockData.MockCustomer(query);
				return s1;
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
