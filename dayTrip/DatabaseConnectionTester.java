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
		Date startDate = new Date(1,06,2016);
		Date endDate = new Date(30,06,2016);
		int numberOfPeople = 5;
		String type = "Family friendly";
		ArrayList<Trip> res = testface.search(location,startDate,endDate,numberOfPeople,type);
		
		System.out.println("Length of result: " + res.size());
		
		for(int i = 0; i<res.size(); i++)
		{
			System.out.println("Trip: " + res.get(i).getTitle());
			ArrayList<Attraction> attractions = res.get(i).getAttractions();
			System.out.println("Length of attractions: "+attractions.size());
			for(int k = 0;k<attractions.size(); k++)
			{
				System.out.println("Attraction name: "+attractions.get(k).getName());
			}
			
		}
		
	   
	   
	}

}
