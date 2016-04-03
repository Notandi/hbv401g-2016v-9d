package dayTrip;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FirstJUnitTest {

	@Test
	public void test() {
		DatabaseInterface databaseInterface = new DatabaseInterface();
		Query query = new Query(1, "what", null);
		DataBlock testDeida = databaseInterface.select(query);
		Attraction testDeidaDeida = testDeida.getAttractions().get(0);
		assertEquals(testDeidaDeida.getType(), "epli");
		assertEquals(testDeidaDeida.getLocation(), "banani");
		assertEquals(testDeidaDeida.getDescription(),"geitungur");
		assertEquals(testDeidaDeida.getPicture(),"gull");
	}

}
