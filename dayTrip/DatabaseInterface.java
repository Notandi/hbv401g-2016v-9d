package dayTrip;

import java.util.ArrayList;
import java.sql.*;

public class DatabaseInterface {
	
	private Connection c;
	private AttractionManager attractionManager;
	private TripManager tripManager;
	
	public DatabaseInterface()
	{
		this.initConnection();
		
	}
	public void addManagers(AttractionManager am, TripManager tm){
		attractionManager = am;
		tripManager = tm;
	}
	
	public void initConnection()
	{
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
	      }
	      catch(Exception e)
	      {
	    	  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  	    	System.exit(0);
	      }
	    }
	    catch(Exception e)
	    {
	    	  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  	    	System.exit(0);
	    }
	    	  
	    	  
	}
	
	public void init() {
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
			                   " DATE		   INT NOT NULL, " +
			                   " TRANSPORTATION		TEXT, " +
			                   " DEPARTURE_TIME		TEXT, " +
			                   " SLOTS 				INT, " +
			                   " TYPE               TEXT)"; 
			      stmt.executeUpdate(sql);
			      stmt.close();
			      
			      
			    } catch ( Exception e ) {
			      throw e;
			    }
		   
		   
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
		   
	    	  
	    	  
	      }
	      
	      catch(Exception e)
	      {
	    	  	    	  
	    	  System.out.println("Database already contains all tables, have fun :)");
	    	  return;
	      }
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    //System.out.println("Opened database successfully");
	}
	
	public ArrayList<Trip> select(Query query)
	{	
		
		ArrayList<Trip> resultTrips = new ArrayList<Trip>();
		Statement stmt = null;
		ResultSet rs = null;
		String type = query.getType();
		String location = query.getLocation();
		int startDate = dateToInt(query.getStartDate());
		int endDate = dateToInt(query.getEndDate());
		//String date = dateToString(query.getDate());
		int numOfPeople = query.getNumOfPeople();
		
		ArrayList<Trip> tripsInDB = tripManager.findMatchingTrips(query);
		
		
		
		
		
	    try {
	    	stmt = c.createStatement();
		    String sql = "SELECT * FROM Trips WHERE TYPE = '"+type+"' AND LOCATION = '"+location
		    		+ "' AND DATE >= "+startDate+" AND DATE <= "+endDate+ " AND SLOTS >= "+numOfPeople+";";
		    if(tripsInDB.size() > 0) {
		    	for(int i = 1; i<tripsInDB.size(); i++)
		    	{
		    		sql += " AND ID != " + tripsInDB.get(i).getId();		    	
		    	}
		    	sql += ";";
		    }
	    	//String sql = "SELECT * FROM Trips";
		    rs = stmt.executeQuery(sql);
		    while ( rs.next() ) {
		         int trip_id = rs.getInt("ID");
		         Date trip_date = intToDate(rs.getInt("DATE"));
		         String trip_title = rs.getString("TITLE");
		         String trip_departureTime = rs.getString("DEPARTURE_TIME");
		         String trip_location = rs.getString("LOCATION");
		         String trip_description = rs.getString("DESCRIPTION");
		         int trip_price = rs.getInt("PRICE");
		         String trip_transportation = rs.getString("TRANSPORTATION");
		         int trip_slots = rs.getInt("SLOTS");
		         String trip_type = rs.getString("TYPE");
		         ArrayList<Attraction> trip_attractions = findAttractionsInTrip(trip_id);	         
		         Trip trip = new Trip(trip_title,trip_departureTime,trip_location,trip_id,
		        		              trip_description,trip_price,trip_transportation,trip_attractions,trip_slots,trip_date,trip_type);
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
	
	public int dateToInt (Date date){
		int intDate;
		intDate = date.getDay();
		intDate += date.getMonth()*100;
		intDate += date.getYear()*10000;
		return intDate;
	}
	public Date intToDate (int date){
		int day = date % 100;
		int month = ((date - day)  % 10000 )/ 100 ;
		int year = (date - day - month)/ 10000;
		Date returnDate = new Date(day,month,year);
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
	    // Hendi attractions sem voru fundin í database inn í Attraction manager
	    attractionManager.addToArrayList(databaseAttractions);
	    //Splæsi saman manager attractionunum og databaseAttractionunum
	    if (databaseAttractions != null){
		    managerAttractions.addAll(databaseAttractions);
	    }
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
		    	selectAttractions += " OR ID = " + ids.get(i);		    	
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
	
	public boolean updateSlots(Trip trip, int numOfPeople) {
		
		Statement stmt = null;
		int currentSlots = trip.getSlots();
		int newSlots = currentSlots - numOfPeople;
		trip.setSlots(currentSlots - numOfPeople);
		
	    try {
	    	stmt = c.createStatement();
		    String sql = "UPDATE Trips set SLOTS = " + newSlots + " where ID=" + trip.getId();
		    stmt.executeUpdate(sql);
		    c.commit();
		    stmt.close();
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
	    return true;
	}
	
	public void insertInitialTestData() {
		
		try {		   	
		   	 
			/* ------------------ INSERT INTO TRIPS ------------------ */
		      Statement stmt = c.createStatement();
		      //Trip #1
		      String sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160601, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      
		      //Trip #2
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Ski-church trip', 'Akureyri','A wonderful ski-trip starting with morning prayer in the local church', 15000, 20160602, 'Bus', '06:00', 50, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #3
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Diamond Circle', 'Egilsstaðir','Witness the beauty of the Great canyon Ásbyrgi and Dettifoss', 169000, 20160603, 'Helicopter', '12:00', 6, 'Luxury' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #4
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Hornstrandir', 'Akureyri','Beautiful place located in the west fjords of Iceland', 29000, 20160604, 'Ferry', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #5
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Snorkeling in Silfra', 'Reykjavík','Snorkle between two continents in the crystal clear water of Silfra!', 69000, 20160605, 'Bus', '15:00', 6, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #6
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Esjan', 'Reykjavík','Hike the beautiful mountain Esjan', 5900, 20160606, 'Bus', '09:00', 30, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #7
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('River rafting', 'Akureyri','River rafting in the amazing river Jökulsá eystri', 15900, 20160607, 'Bus', '08:00', 16, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #8
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Sight seeing in Reykjavík', 'Akureyri','Drive around Reykjavík and see the best places!', 3100, 20160608, 'Bus', '15:00', 42, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #9
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Whale watching', 'Reykjavík','Watch whales in faxaflói!', 19000, 20160609, 'none', '16:00', 20, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #10
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Bláa lónið', 'Reykjavík','Swim in the famous geothermal spa', 8000, 20160610, 'bus', '13:00', 40, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #11 
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Vesturbæjarlaug', 'Reykjavík','Swim in the typical Icelandic swimming pool', 900, 20160611, 'Walk', '06:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      //Trip #12
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Lauagardalslaug', 'Reykjavík','Swim in the typical Icelandic swimming pool', 900, 20160612, 'Walk', '06:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      
		      //Trip #13 (golden circle #2)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160604, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #14 (golden circle #3)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160607, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #15 (golden circle #4)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160610, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #16 (golden circle #5)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160613, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #17 (golden circle #6)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160616, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #18 (golden circle #6)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160619, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #19 (golden circle #7)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160622, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #20 (golden circle #8)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160625, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #21 (golden circle #9)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160628, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #22 (golden circle #10)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
		                   "VALUES ('Golden Circle', 'Reykjavík','Wonderful circular trip', 5000, 20160630, 'Bus', '10:00', 30, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #23 (river rafting #2)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('River rafting', 'Akureyri','River rafting in the amazing river Jökulsá eystri', 15900, 20160614, 'Bus', '08:00', 16, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #24 (river rafting #3)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('River rafting', 'Akureyri','River rafting in the amazing river Jökulsá eystri', 15900, 20160618, 'Bus', '08:00', 16, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		      
		     //Trip #25 (river rafting #4)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('River rafting', 'Akureyri','River rafting in the amazing river Jökulsá eystri', 15900, 20160621, 'Bus', '08:00', 16, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		      
		    //Trip #26 (river rafting #5)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('River rafting', 'Akureyri','River rafting in the amazing river Jökulsá eystri', 15900, 20160626, 'Bus', '08:00', 16, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #27 (snorkeling # 2)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Snorkeling in Silfra', 'Reykjavík','Snorkle between two continents in the crystal clear water of Silfra!', 69000, 20160615, 'Bus', '15:00', 6, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #28 (snorkeling # 3)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Snorkeling in Silfra', 'Reykjavík','Snorkle between two continents in the crystal clear water of Silfra!', 69000, 20160620, 'Bus', '15:00', 6, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #29 (snorkeling # 4)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Snorkeling in Silfra', 'Reykjavík','Snorkle between two continents in the crystal clear water of Silfra!', 69000, 20160624, 'Bus', '15:00', 6, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		    //Trip #30 (snorkeling # 5)
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Snorkeling in Silfra', 'Reykjavík','Snorkle between two continents in the crystal clear water of Silfra!', 69000, 20160629, 'Bus', '15:00', 6, 'Adventure' );"; 
		      stmt.executeUpdate(sql);
		      
		    //Trip #31 (ski-church trip #2) 
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Ski-church trip', 'Akureyri','A wonderful ski-trip starting with morning prayer in the local church', 15000, 20160617, 'Bus', '06:00', 50, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      
		    //Trip #32 (ski-church trip #3) 
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Ski-church trip', 'Akureyri','A wonderful ski-trip starting with morning prayer in the local church', 15000, 20160623, 'Bus', '06:00', 50, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      
		    //Trip #33 (ski-church trip #4) 
		      sql = "INSERT INTO Trips (TITLE,LOCATION,DESCRIPTION,PRICE,DATE,TRANSPORTATION,DEPARTURE_TIME,SLOTS, TYPE) " +
	                   "VALUES ('Ski-church trip', 'Akureyri','A wonderful ski-trip starting with morning prayer in the local church', 15000, 20160627, 'Bus', '06:00', 50, 'Family friendly' );"; 
		      stmt.executeUpdate(sql);
		      
		      
		      
		      
		      /* ------------------ INSERT INTO ATTRACTIONS ------------------ */
		      // Attraction #1
		      sql = "INSERT INTO Attractions (NAME,TYPE,LOCATION,DESCRIPTION) " +
	                "VALUES ('Gullfoss', 'Waterfall', 'Reykjavík', 'Very nice waterfall lots of gold');"; 
		      stmt.executeUpdate(sql);
		      // Attraction #2
		      sql = "INSERT INTO Attractions (NAME,TYPE,LOCATION,DESCRIPTION) " +
		                "VALUES ('Geysir', 'Natural wonder', 'Reykjavík', 'A very hot and steamy wonder');"; 
			  stmt.executeUpdate(sql);
			  // Attraction #3
			  sql = "INSERT INTO Attractions (NAME,TYPE,LOCATION,DESCRIPTION) " +
		                "VALUES ('Þingvellir', 'National park', 'Reykjavík', 'A very beautiful national park filled with geological wonders');"; 
			  stmt.executeUpdate(sql);
			  // Attraction #4
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Hlíðarfjall', 'Ski resort', 'Akureyri', 'A wonderful ski-resort');";
			  stmt.executeUpdate(sql);
			  // Attraction #5
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Akureyrarkirkja', 'Church', 'Akureyri', 'A beautiful church with magnificent stairs');";
			  stmt.executeUpdate(sql);
			  // Attraction #6  
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Ásbyrgi', 'National park', 'Egilsstaðir', 'A nature wonder which looks like a horseshoe from the sky');";
			  stmt.executeUpdate(sql);
			  // Attraction #7
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Dettifoss', 'Waterfall', 'Egilsstaðir', 'The most powerful waterfall in Europe');";
			  stmt.executeUpdate(sql);
			  // Attraction #8
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Hornstrandir', 'National park', 'Akureyri', 'Beautiful place');";
			  stmt.executeUpdate(sql);
			  // Attraction #9
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Silfra', 'Natural wonder', 'Reykjavík', ' The beautiful crack between the North American and Eurasian continents');";
			  stmt.executeUpdate(sql);
			  // Attraction #10
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Esjan', 'Mountain', 'Reykjavík', 'Beautiful mountain seen from Reykjavík');";
			  stmt.executeUpdate(sql);
			  // Attraction #11
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Jökulsá eystri', 'River', 'Akureyri', 'A powerful river perfect for river rafting');";
			  stmt.executeUpdate(sql);
			  // Attraction #12
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Hallgrímskirkja', 'Church', 'Reykjavík', 'The tall church of Reykjavík that everybody loves');";
			  stmt.executeUpdate(sql);
			  // Attraction #13
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Bláa lónið', 'Spa', 'Reykjavík', 'The geothermal pool, one of the most popular attractions in Iceland');";
			  stmt.executeUpdate(sql);
			  // Attraction #14
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Vesturbæjarlaug', 'Swimming pool', 'Reykjavík', 'The typical icelandic swimming pool');";
			  stmt.executeUpdate(sql);
			  // Attraction #15
			  sql = "INSERT INTO Attractions (NAME, TYPE, LOCATION, DESCRIPTION) "+
					  	"VALUES('Laugardalslaug', 'Swimming pool', 'Reykjavík', 'The typical icelandic swimming pool');";
			  stmt.executeUpdate(sql);


			  // insert fyrir mismunandi trips sem koma bara fyrir einusinni
			  sql = "INSERT INTO AttractionsInTrips (TRIP_ID, ATTRACTION_ID) " +
					  	"VALUES (3,6), (3,7), (4,8), (5,3), (5,9), (6,10), (8,12), (8,10), (9,10), (10,13), (11,14), (11,12), (11,10), (12,15), (12,12), (12,10) ;";
			  stmt.executeUpdate(sql);
			  
			  // insert fyrir golden circle ferðir 1 til 10
			  sql = "INSERT INTO AttractionsInTrips (TRIP_ID, ATTRACTION_ID) "+
					  	"VALUES (1,1), (1,2), (1,3), (13,1), (13,2), (13,3), (14,1), (14,2), (14,3), (15,1), (15,2), (15,3), (16,1), (16,2), (16,3),(17,1), (17,2), (17,3),(18,1), (18,2), (18,3), (19,1), (19,2), (19,3), (20,1), (20,2), (20,3), (21,1), (21,2), (21,3), (22,1), (22,2), (22,3)  ;";
			  stmt.executeUpdate(sql);
			  
			// insert fyrir river rafting ferðir 1 til 5
			  sql = "INSERT INTO AttractionsInTrips (TRIP_ID, ATTRACTION_ID) "+
					  	"VALUES (7,11), (23,11), (24,11), (25,11), (26,11)  ;";
			  stmt.executeUpdate(sql);
			  
			// insert fyrir snokeling 1 til 5
			  sql = "INSERT INTO AttractionsInTrips (TRIP_ID, ATTRACTION_ID) "+
					  	"VALUES (5,3), (5,9), (27,3), (27,9), (28,3), (28,9), (29,3), (29,9), (30,3), (30,9)  ;";
			  stmt.executeUpdate(sql);
			// insert fyrir ski church trip 1 til 4
			  sql = "INSERT INTO AttractionsInTrips (TRIP_ID, ATTRACTION_ID) "+
					  	"VALUES (2,4), (2,5), (31,4), (31,5), (32,4), (32,5), (33,4), (33,5) ;";
			  stmt.executeUpdate(sql);

		      stmt.close();
		      c.commit();
		      
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }		

		
	}
	

}
