package dayTrip;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseInterfaceTest {
	private Attraction AttractionObj, TestAttraction;
	private Trip TripObj, TestTrip;
	private Car CarObj, TestCar;
	private Booking BookingObj,TestBooking;
	private Customer CustomerObj, TestCustomer;
	private int deletion, insertion;

	@Before
	public void setUp() throws Exception {
		DatabaseInterface databaseInterface = new DatabaseInterface();
		CarManager carmanager = new CarManager(databaseInterface,3);
		
		Query AttractionQuery = new Query (1, "Attraction", null);
		Query TripQuery = new Query(2,"Trip",null);
		Query CarQuery = new Query(3,"Car",null);
		Query BookingQuery = new Query(4,"Booking",null);
		Query CustomerQuery = new Query (5,"Customer", null);
		DataBlock AttractionRes = databaseInterface.select(AttractionQuery);
		AttractionObj = AttractionRes.getAttractions().get(0);
		DataBlock TripRes = databaseInterface.select(TripQuery);
		TripObj = TripRes.getTrips().get(0);
		DataBlock CarRes = databaseInterface.select(CarQuery);
		CarObj = CarRes.getCars().get(0);
		DataBlock BookingRes = databaseInterface.select(BookingQuery);
		BookingObj = BookingRes.getBookings().get(0); 
		DataBlock CustomerRes = databaseInterface.select(CustomerQuery);
		CustomerObj = CustomerRes.getCustomers().get(0);
		
		String [] fields = {"delete", "insert"};
		String [] values = {"insert","delete"};
		deletion = carmanager.removeObject(fields, values);
		insertion = carmanager.createObject(fields, values);
		
		TestAttraction =  new Attraction("Natural wonder","Grindavík", "Eðal bær, mjög fallegur.", "link");
		String[] keywords = {"Hvalfjörður", "göngutúr"};
		TestTrip = new Trip(0, "Hvalfjörður", 2, "Göngutúr um fallegt landsvæði.", 1500, "Bus", null, null, "link", null, keywords);
		String[] keywords2 = {"jeppi", "97"};
		TestCar = new Car("Ford 356", "97 model, jeppi, kemst hvert sem er.", "link", 30000, keywords2, true);
		TestBooking = new Booking("Jonathan Blake jr.", null, null, 14000, 6);
		TestCustomer = new Customer("Ósk Ólafsdóttir", 15, "Female", "Indian", "iamindian@india.in");
	}

	@After
	public void tearDown() throws Exception {
		AttractionObj = null;
		TestAttraction = null;
		TripObj = null; 
		TestTrip = null;
		CarObj = null; 
		TestCar = null;
		BookingObj = null;
		TestBooking = null;
		CustomerObj = null;
		TestCustomer = null;
	}
	@Test
	public void testDeletion() {
		assertEquals(deletion,1);
	}
	@Test
	public void testInsertion() {
		assertEquals(insertion,1);
	}

	@Test
	public void testAttractionQuery() {
		assertEquals(TestAttraction.getDescription(), AttractionObj.getDescription());
	}
	@Test
	public void testTripQuery() {
		assertEquals(TestTrip.getDescription() , TripObj.getDescription());
	}
	@Test
	public void testCarQuery() {
		assertEquals(TestCar.getDescription(), CarObj.getDescription());
	}
	@Test
	public void testBookingQuery() {
		assertEquals(TestBooking.getPrice(), BookingObj.getPrice());
	}@Test
	public void testCustomerQuery() {
		assertEquals(TestCustomer.getAge(), CustomerObj.getAge());
	}

}
