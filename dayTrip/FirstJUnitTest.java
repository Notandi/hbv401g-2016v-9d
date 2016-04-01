package dayTrip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FirstJUnitTest {

	@Test
	public void test() {
		fail("Not yet implemented");
		DatabaseInterface databaseInterface = new DatabaseInterface();
		Query query = new Query(1, null, null);
		ArrayList<?> testDeida = databaseInterface.select(query);
		assertEquals(testDeida, null);
		
	}

}
