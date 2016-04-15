package dayTrip;

import java.util.ArrayList;
import java.sql.*;

public class DatabaseInterface {
	
	private Connection c;
	
	public DatabaseInterface()
	{
		this.init();
	}
	
	public DataBlock select(Query query)
	{		
		
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
	      c = DriverManager.getConnection("jdbc:sqlite:trips.db");
	      try{
	    	  try {
			   	  Statement stmt = c.createStatement();
			      String sql = "CREATE TABLE Trips " +
			                   "(ID INT PRIMARY KEY     NOT NULL," +
			                   " TITLE           TEXT    NOT NULL, " + 
			                   " LOCATION            INT     NOT NULL, " + 
			                   " DESCRIPTION        TEXT, " + 
			                   " PRICE         INT, " +
			                   " DATE		   TEXT NOT NULL, " +
			                   " TRANSPORTATION		TEXT, " +
			                   " DEPARTURE TIME		TEXT, " +
			                   " SLOTS 				INT)"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      //c.close();
			      
			    } catch ( Exception e ) {
			      throw e;
			    }
		   System.out.println("Trip table created successfully");
		   
		   try {
			   	  Statement stmt = c.createStatement();
			      String sql = "CREATE TABLE Attractions " +
			                   "(ID INT PRIMARY KEY     NOT NULL," +
			                   " NAME           TEXT    NOT NULL, " + 
			                   " TYPE           TEXT    , " + 
			                   " LOCATION       TEXT, " + 
			                   " DESCRIPTION    TEXT)"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      //c.close();
			      
			    } catch ( Exception e ) {
			      throw e;
			    }
		   System.out.println("Attractions Table created successfully");
		   
		   try {
			   	  Statement stmt = c.createStatement();
			      String sql = "CREATE TABLE AttractionsInTrips " +
			                   "(ID INT PRMARY KEY		 NOT NULL," +
			                   "TRIP_ID INT 			 NOT NULL," +
			                   " ATTRACTION_ID INT 		 NOT NULL)"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      //c.close();
			      
			    } catch ( Exception e ) {
			      throw e;
			    }
		   System.out.println("AttractionsInTrips Table created successfully");
	    	  
	    	  
	      }
	      
	      catch(Exception ex)
	      {
	    	  System.out.println("Database already contains all tables, have fun :)");
	    	  return;
	      }
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
	public Attraction selectAttraction(int id){
		Attraction atr = null;
		Statement stmt = null;
		try{
			stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Attractions WHERE ID = " + id + ";" );
		    atr = new Attraction(rs.getInt("ID"),rs.getString("TYPE"),rs.getString("LOCATION"),rs.getString("DESCRIPTION"),rs.getString("NAME"));
		    rs.close();
		    stmt.close();
			
		}catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
	    return atr;
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
	    System.out.println("Updated slots successfully");
	}

}
