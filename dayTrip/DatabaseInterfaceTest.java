package dayTrip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseInterfaceTest {
	private DatabaseInterface databaseInterface;
	private CarManager carmanager;

	@Before
	public void setUp() throws Exception {
		databaseInterface = new DatabaseInterface();
		carmanager = new CarManager(databaseInterface,3);
	}

	@After
	public void tearDown() throws Exception {
		databaseInterface = null;
		carmanager = null;
	}
	
	@Test
	public void testSearchFailure() {
		Query FailedQuery = new Query (6,"Failed",null);
		DataBlock FailedRes = databaseInterface.select(FailedQuery);
		ArrayList<Attraction> FailedAttraction = FailedRes.getAttractions();
		ArrayList<Trip> FailedTrip = FailedRes.getTrips(); 
		ArrayList<Car> FailedCar = FailedRes.getCars();
		ArrayList<Booking> FailedBooking = FailedRes.getBookings();
		ArrayList<Customer> FailedCustomer = FailedRes.getCustomers();
		assertNull(FailedAttraction);
		assertNull(FailedTrip);
		assertNull(FailedCar);
		assertNull(FailedBooking);
		assertNull(FailedCustomer);
	}
	
	@Test
	public void testDeletionFailure() {
		String [] fields = null;
		String [] values = null;
		int failedDeletion = carmanager.removeObject(fields, values);
		assertEquals(failedDeletion,1);
	}
	
	@Test
	public void testDeletion() {
		String [] fields = {"delete", "insert"};
		String [] values = {"insert","delete"};
		int deletion = carmanager.removeObject(fields, values);
		assertEquals(deletion,1);
	}
	
	@Test
	public void testInsertionFailure() {
		String [] fields = null;
		String [] values = null;
		int failedInsertion = carmanager.createObject(fields, values);
		assertEquals(failedInsertion,1);
	}
	
	@Test
	public void testInsertion() {
		String [] fields = {"delete", "insert"};
		String [] values = {"insert","delete"};
		int insertion = carmanager.createObject(fields, values);
		assertEquals(insertion,1);
	}

	@Test
	public void testAttractionQuery() {
		Attraction TestAttraction =  new Attraction("Natural wonder","Grindavík", "Eðal bær, mjög fallegur.", "link");
		Query AttractionQuery = new Query (1, "Attraction", null);
		DataBlock AttractionRes = databaseInterface.select(AttractionQuery);
		Attraction AttractionObj = AttractionRes.getAttractions().get(0);
		assertEquals(TestAttraction.getDescription(), AttractionObj.getDescription());
	}
	
	@Test
	public void testTripQuery() {
		String[] keywords = {"Hvalfjörður", "göngutúr"};
		Trip TestTrip = new Trip(0, "Hvalfjörður", 2, "Göngutúr um fallegt landsvæði.", 1500, "Bus", null, null, "link", null, keywords);
		Query TripQuery = new Query(2,"Trip",null);
		DataBlock TripRes = databaseInterface.select(TripQuery);
		Trip TripObj = TripRes.getTrips().get(0);
		assertEquals(TestTrip.getDescription() , TripObj.getDescription());
	}
	
	@Test
	public void testCarQuery() {
		String[] keywords2 = {"jeppi", "97"};
		Car TestCar = new Car("Ford 356", "97 model, jeppi, kemst hvert sem er.", "link", 30000, keywords2, true);
		Query CarQuery = new Query(3,"Car",null);
		DataBlock CarRes = databaseInterface.select(CarQuery);
		Car CarObj = CarRes.getCars().get(0);
		assertEquals(TestCar.getDescription(), CarObj.getDescription());
	}
	
	@Test
	public void testBookingQuery() {
		Booking TestBooking = new Booking("Jonathan Blake jr.", null, null, 14000, 6);
		Query BookingQuery = new Query(4,"Booking",null);
		DataBlock BookingRes = databaseInterface.select(BookingQuery);
		Booking BookingObj = BookingRes.getBookings().get(0); 
		assertEquals(TestBooking.getPrice(), BookingObj.getPrice());
	}
	
	@Test
	public void testCustomerQuery() {
		Customer TestCustomer = new Customer("Gunnþórunn Kona Rafnsdóttir", 15, "Female", "Indian", "iamindian@india.in");
		Query CustomerQuery = new Query (5,"Customer", null);
		DataBlock CustomerRes = databaseInterface.select(CustomerQuery);
		Customer CustomerObj = CustomerRes.getCustomers().get(0);
		assertEquals(TestCustomer.getAge(), CustomerObj.getAge());
	}

}
