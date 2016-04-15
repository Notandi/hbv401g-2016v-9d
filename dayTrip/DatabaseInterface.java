package dayTrip;

import java.util.ArrayList;
import java.sql.*;

public class DatabaseInterface {
	
	private Connection c;
	
	public DataBlock select(Query query)
	{
		this.init();
		
		int type = query.getType();
		DataBlock res = new DataBlock(type);
		
		/*switch(type){
		case 1:	ArrayList<Attraction> mockresultAttraction =  MockData.MockAttraction(query);
				res.setAttractions(mockresultAttraction);
				break;
		case 2: ArrayList<Trip> mockresultTrip = MockData.MockTrip(query);
				res.setTrips(mockresultTrip);
				break;
		}
		return res;*/
		DataBlock datablock = new DataBlock(2);
		return datablock;
	}
	
	private void init() {
		c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}
	
	public int insert(Pair[] query)
	{		
		//if()
		return 1;
	}
	
	public int delete(Pair[] query)
	{
		return 1;
	}
	
	public void updateSlots(Trip trip, int numOfPeople) {
		
		Statement stmt = null;
		int currentSlots = trip.getSlots();
		trip.setSlots(currentSlots - numOfPeople);
		
	    try {
	    	stmt = c.createStatement();
		    String sql = "UPDATE Trips set SLOTS = " + trip.getSlots() + " where ID=" + trip.getId();
		    stmt.executeUpdate(sql);
		    c.commit();
		    stmt.close();
		    c.close();
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}

}
