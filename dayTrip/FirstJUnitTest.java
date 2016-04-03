package dayTrip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FirstJUnitTest {

	@Test
	public void test() {
		DatabaseInterface databaseInterface = new DatabaseInterface();
		Query query = new Query(1, "what", null);
		ArrayList<?> testDeida = databaseInterface.select(query);
		System.out.println(testDeida.get(0));
		assertEquals(testDeida.get(0).getClass(), MockData.MockAttraction(query).get(0).getClass());
	}

}
