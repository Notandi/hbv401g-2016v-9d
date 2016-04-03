package dayTrip;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseInterfaceTest {

	@Before
	public void setUp() throws Exception {
		DatabaseInterface databaseInterface = new DatabaseInterface();
		Query AttractionQuery = new Query (1, "Attraction", null);
		Query TripQuery = new Query(2,"Trip",null);
		Query CarQuery = new Query(3,"Car",null);
		Query BookingQuery = new Query(4,"Booking",null);
		Query CustomerQuery = new Query (5,"Customer", null);
		DataBlock AttractionRes = databaseInterface.select(AttractionQuery);
		Attraction AttractionObj = AttractionRes.getAttractions().get(0);
		DataBlock TripRes = databaseInterface.select(TripQuery);
		Trip TripObj = TripRes.getTrips().get(0);
		DataBlock CarRes = databaseInterface.select(CarQuery);
		Car CarObj = CarRes.getCars().get(0);
		DataBlock BookingRes = databaseInterface.select(BookingQuery);
		Booking BookingObj = BookingRes.getBookings().get(0); 
		DataBlock CustomerRes = databaseInterface.select(CustomerQuery);
		Customer CustomerObj = CustomerRes.getCustomers().get(0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
