package dayTrip;

import java.sql.*;


public class DatabaseConnectionTester {
	
	public static void main(String[] args)
	{
		//AttractionManager amTest = new AttractionManager();
		//TripManager tmTest = new TripManager();
		Interface testface = new Interface();
		DatabaseInterface dbtester = testface.getDatabaseInterface();
		dbtester.insertInitialTestData();
		
		
		
	   
	   
	}

}
