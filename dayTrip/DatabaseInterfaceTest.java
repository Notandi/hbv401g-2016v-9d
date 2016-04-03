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
		Query Booking = new Query(4,"Booking",null);
		Query Customer = new Query (5,"Customer", null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
