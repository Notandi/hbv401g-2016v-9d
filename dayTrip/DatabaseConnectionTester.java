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
		String location = "Reykjavík";
		Date startDate = new Date(20,06,2016);
		Date endDate = new Date(23,06,2016);
		int numberOfPeople = 5;
		String type = "Familyfriendly";
		ArrayList<Trip> res = testface.search(location,startDate,endDate,numberOfPeople,type);
		
		/*
		for(int i = 0; i<res.size(); i++)
		{
			System.out.println(res.get(i));
		}*/
		
	   
	   
	}

}
