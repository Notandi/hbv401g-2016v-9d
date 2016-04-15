package dayTrip;

import java.util.ArrayList;
import java.sql.*;

public class DatabaseInterface {
	
	private Connection c;
	private AttractionManager attractionManager;
	private TripManager tripManager;
	
	public DatabaseInterface(AttractionManager am, TripManager tm)
	{
		attractionManager = am;
		tripManager = tm;
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
	      c.setAutoCommit(false);
	      try{
	    	  try {
	    		  Statement stmt = c.createStatement();
	    		  String sql = "PRAGMA foreign_keys = ON";
	    		  stmt.executeUpdate(sql);
	    		  stmt.close();	    		  
	    	  }
	    	  catch(Exception e)
	    	  {
	    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  	    	System.exit(0);
	    	  }
	    	  
	    	  try {
			   	  Statement stmt = c.createStatement();
			      String sql = "CREATE TABLE Trips " +
			                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT     ," +
			                   " TITLE           TEXT    NOT NULL, " + 
			                   " LOCATION            INT     NOT NULL, " + 
			                   " DESCRIPTION        TEXT, " + 
			                   " PRICE         INT, " +
			                   " DATE		   TEXT NOT NULL, " +
			                   " TRANSPORTATION		TEXT, " +
			                   " DEPARTURE_TIME		TEXT, " +
			                   " SLOTS 				INT)"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      
			      
			    } catch ( Exception e ) {
			      throw e;
			    }
		   System.out.println("Trip table created successfully");
		   
		   try {
			   	  Statement stmt = c.createStatement();
			      String sql = "CREATE TABLE Attractions " +
			                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT     ," +
			                   " NAME           TEXT    NOT NULL, " + 
			                   " TYPE           TEXT    , " + 
			                   " LOCATION       TEXT, " + 
			                   " DESCRIPTION    TEXT)"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      
			      
			    } catch ( Exception e ) {
			      throw e;
			    }
		   System.out.println("Attractions Table created successfully");
		   
		   try {
			   	  Statement stmt = c.createStatement();
			      String sql = "CREATE TABLE AttractionsInTrips " +
			                   "(ID INTEGER PRIMARY KEY	AUTOINCREMENT 	 ," +
			                   "TRIP_ID INT REFERENCES TRIP(ID)		 NOT NULL," +
			                   "ATTRACTION_ID INT INT REFERENCES ATTRACTION(ID)	 NOT NULL)"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      
			      
			    } catch ( Exception e ) {
			      throw e;
			    }
		   System.out.println("AttractionsInTrips Table created successfully");
	    	  
	    	  
	      }
	      
	      catch(Exception e)
	      {
	    	  /*
	    	  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  	      System.exit(0);*/
	    	  
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
	
	public void insertInitialTestData() {
		
		try {		   	
		   	 
		      Statement stmt = c.createStatement();
		      String sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS) " +
		                   "VALUES ('Golden Circle', 'Reykjav�k','Wonderful circular trip', 5000, '22/06/2016', 'Bus', '10:00', 30 );"; 
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO Attractions (NAME,TYPE,LOCATION,DESCRCIPTION) " +
	                "VALUES ('Gullfoss', 'Waterfall', 'Reykjav�k', 'Very nice waterfall lots of gold');"; 
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO Attractions (NAME,TYPE,LOCATION,DESCRCIPTION) " +
		                "VALUES ('Geysir', 'Natural wonder', 'Reykjav�k', 'A very hot and steamy wonder');"; 
			  stmt.executeUpdate(sql);
			  
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Hl��arfjall', 'Ski resort', 'Akureyri', 'A wonderful ski-resort');";
		      
		      /*
		      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		            "VALUES (70, 'Allen', 25, 'Texas', 15000.00 );"; 
		      stmt.executeUpdate(sql);

		      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		            "VALUES (73, 'Teddy', 23, 'Norway', 20000.00 );"; 
		      stmt.executeUpdate(sql);

		      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		            "VALUES (74, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
		      stmt.executeUpdate(sql);*/

		      stmt.close();
		      c.commit();
		      
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
		
		try {
		      
		      Statement stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Trips;" );
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         
		         System.out.println( "ID = " + id );
		         
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
	}
	

}
