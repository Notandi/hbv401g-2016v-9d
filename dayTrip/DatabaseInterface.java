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
	
	public ArrayList<Trip> select(Query query)
	{		
		ArrayList<Trip> resultTrips = new ArrayList<Trip>();
		Statement stmt = null;
		ResultSet rs = null;
		String type = query.getType();
		String location = query.getLocation();
		String date = dateToString(query.getDate());
		int numOfPeople = query.getNumOfPeople();
		
		
		
	    try {
	    	stmt = c.createStatement();
		    String sql = "SELECT * FROM Trip WHERE TYPE = "+type+" AND LOCATION = "+location+" "
		    		+ "AND DATE = "+date+"AND SLOTS > "+numOfPeople+";";
		    rs = stmt.executeQuery(sql);
		    while ( rs.next() ) {
		         int trip_id = rs.getInt("ID");
		         Date trip_date = stringToDate(rs.getString("DATE"));
		         String trip_title = rs.getString("TITLE");
		         String trip_departureTime = rs.getString("DEPARTURE_TIME");
		         String trip_location = rs.getString("LOCATION");
		         String trip_description = rs.getString("DESCRIPTION");
		         int trip_price = rs.getInt("PRICE");
		         String trip_transportation = rs.getString("TRANSPORTATION");
		         int trip_slots = rs.getInt("SLOTS");
		         ArrayList<Attraction> trip_attractions = findAttractionsInTrip(trip_id);	         
		         Trip trip = new Trip(trip_title,trip_departureTime,trip_location,trip_id,
		        		              trip_description,trip_price,trip_transportation,trip_attractions,trip_slots,trip_date);
		         this.tripManager.addTrip(trip);
		         resultTrips.add(trip);	         
		      }
		    
		    c.commit();
		    stmt.close();
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }	
	   
	    
		return resultTrips;
	}
	
	public String dateToString(Date date)
	{
		String stringDate = "";
		stringDate = date.getDay()+"/"+date.getMonth()+"/"+date.getYear();
		return stringDate;
	}
	
	public Date stringToDate(String date)
	{
		int day = Integer.parseInt(date.substring(0,2));
		int month = Integer.parseInt(date.substring(3,5));
		int year = Integer.parseInt(date.substring(6,10));
		
		Date returnDate = new Date(day, month, year);
		return returnDate;
	}
	
	
	public ArrayList<Attraction> findAttractionsInTrip(int trip_id)
	{
		
		//Sækja öll IDs á attractions sem eru í þessu Trip
	    ArrayList<Integer> attractionIDs = selectAttractionIDs(trip_id);
	    //Athuga hvaða attractions eru núþegar til í attractionManager
	    Pair existingAttractions = attractionManager.locateExistingAttractions(attractionIDs);
	    attractionIDs = existingAttractions.getIds();
	    //Næ í öll attractions sem vantar upp á úr database, sem voru ekki til í attractionManager
	    ArrayList<Attraction> databaseAttractions = selectAttractions(attractionIDs);
	    ArrayList<Attraction> managerAttractions = existingAttractions.getAttractions();
	    //Splæsi saman manager attractionunum og databaseAttractionunum
	    managerAttractions.addAll(databaseAttractions);
	    return managerAttractions;
	}
	
	
	public ArrayList<Integer> selectAttractionIDs(int id) {		
		
		Statement stmt = null;
		ArrayList<Integer> ids = null;
		
	    try {
	    	ids = new ArrayList<Integer>();
	    	stmt = c.createStatement();
		    String sql = "SELECT ATTRACTION_ID FROM AttractionsInTrips WHERE TRIP_ID =" + id;
		    ResultSet rs = stmt.executeQuery(sql);
		    while( rs.next() ) {
		    	ids.add(rs.getInt("ATTRACTION_ID"));
		    }
		    c.commit();
		    stmt.close();
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
	    System.out.println("Returned ID's succesfully!");
	    return ids;	    
	}
	
	
	
	public int insert(Pair[] query)
	{		
		return 1;
	}
	
	public int delete(Pair[] query)
	{
		return 1;
	}
	public ArrayList<Attraction> selectAttractions(ArrayList<Integer> ids){
		ArrayList<Attraction> attractions = new ArrayList<Attraction>();
		Statement stmt = null;
		if(ids.size() == 0) return null;
		
		try{
			
			stmt = c.createStatement();
			String selectAttractions = "SELECT * FROM Attractions WHERE ID = " + ids.get(0);
		    for(int i = 1; i<ids.size(); i++)
		    {
		    	selectAttractions += "AND ID = " + ids.get(i);		    	
		    }
		    
		    selectAttractions += ";";
			
			ResultSet rs = stmt.executeQuery(selectAttractions);
		    
			 while ( rs.next() ) {		         		         
		         Attraction attraction = new Attraction(rs.getInt("ID"),rs.getString("TYPE"),rs.getString("LOCATION"),rs.getString("DESCRIPTION"),rs.getString("NAME"));
		         attractions.add(attraction);		         
		      }
					    
		    rs.close();
		    stmt.close();
			
		}catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
	    return attractions;
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
		   	 
			/* ------------------ INSERT INTO TRIPS ------------------ */
		      Statement stmt = c.createStatement();
		      String sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, '22/06/2016', 'Bus', '10:00', 30 );"; 
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS) " +
	                   "VALUES ('Ski-church trip', 'Akureyri','A wonderful ski-trip starting with morning prayer in the local church', 15000, '13/06/2016', 'Bus', '06:00', 50 );"; 
		      stmt.executeUpdate(sql);
		      
		      
		      /* ------------------ INSERT INTO ATTRACTIONS ------------------ */
		      sql = "INSERT INTO Attractions (NAME,TYPE,LOCATION,DESCRIPTION) " +
	                "VALUES ('Gullfoss', 'Waterfall', 'Reykjavík', 'Very nice waterfall lots of gold');"; 
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO Attractions (NAME,TYPE,LOCATION,DESCRIPTION) " +
		                "VALUES ('Geysir', 'Natural wonder', 'Reykjavík', 'A very hot and steamy wonder');"; 
			  stmt.executeUpdate(sql);
			  
			  sql = "INSERT INTO Attractions (NAME,TYPE,LOCATION,DESCRIPTION) " +
		                "VALUES ('Þingvellir', 'National park', 'Reykjavík', 'A very beautiful national park filled with geological wonders');"; 
			  stmt.executeUpdate(sql);
			  
			  
			  
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Hlíðarfjall', 'Ski resort', 'Akureyri', 'A wonderful ski-resort');";
			  stmt.executeUpdate(sql);
			  
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Akureyrarkirkja', 'Church', 'Akureyri', 'A beautiful church with magnificent stairs');";
			  stmt.executeUpdate(sql);
			  
			  
			  
			  sql = "INSERT INTO AttractionsInTrips (TRIP_ID, ATTRACTION_ID) "+
					  	"VALUES (1,1), (1,2), (1,3), (2,4), (2,5);";
			  stmt.executeUpdate(sql);
			  
			  
			  
			  
		      
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
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM AttractionsInTrips;" );
		      while ( rs.next() ) {
		         int id = rs.getInt("ID");
		         int trip_id = rs.getInt("TRIP_ID");
		         int attraction_id = rs.getInt("ATTRACTION_ID");
		         
		         System.out.println( "ID = " + id );
		         System.out.println( "TRIP_ID = " + trip_id );
		         System.out.println( "ATTRACTION_ID = " + attraction_id );
		         
		      }
		      rs.close();
		      stmt.close();
		      //c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		
	}
	

}
