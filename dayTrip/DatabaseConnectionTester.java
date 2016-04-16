package dayTrip;

import java.sql.*;
import java.util.ArrayList;


public class DatabaseConnectionTester {
	
	public static void main(String[] args)
	{
		//AttractionManager amTest = new AttractionManager();
		//TripManager tmTest = new TripManager();
		Interface testface = new Interface();
		DatabaseInterface dbtester = testface.getDatabaseInterface();
		dbtester.insertInitialTestData();
		String location = "Reykjav�k";
		Date date = new Date(22,06,2016);
		int numberOfPeople = 5;
		String type = "Family friendly";
		ArrayList<Trip> res = testface.search(location,date,numberOfPeople,type);
		
		for(int i = 0; i<res.size(); i++)
		{
			System.out.println(res.get(i));
		}
		
	   
	   
	}

}
