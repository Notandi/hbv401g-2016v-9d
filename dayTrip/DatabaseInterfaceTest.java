package dayTrip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseInterfaceTest {
	private DatabaseInterface databaseInterface;
	private TripManager carmanager;

	@Before
	public void setUp() throws Exception {
		databaseInterface = new DatabaseInterface();
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
		assertNull(FailedAttraction);
		assertNull(FailedTrip);
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

}
