package dayTrip;

import java.sql.*;


public class DatabaseConnectionTester {
	
	public static void main(String[] args)
	{
		System.out.println("Hello world");
		Connection c = null;
		 
		Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:trips.db");
		      c.setAutoCommit(false);
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	   System.out.println("Opened database successfully");
	   
	   
	   //CREATE TABLES
	   /*
	   try {
		   	  stmt = c.createStatement();
		      String sql = "CREATE TABLE Trips " +
		                   "(ID INT PRIMARY KEY     NOT NULL," +
		                   " TITLE           TEXT    NOT NULL, " + 
		                   " LOCATION            INT     NOT NULL, " + 
		                   " DESCRIPTION        TEXT, " + 
		                   " PRICE         INT, " +
		                   " DATE		   TEXT NOT NULL, " +
		                   " TRANSPORTATION		TEXT, " +
		                   " DEPARTURE TIME		TEXT, +
		                   " SLOTS 				INT)"; 
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	   System.out.println("Trip table created successfully");
	   
	   try {
		   	  stmt = c.createStatement();
		      String sql = "CREATE TABLE Attractions " +
		                   "(ID INT PRIMARY KEY     NOT NULL," +
		                   " NAME           TEXT    NOT NULL, " + 
		                   " TYPE           TEXT    , " + 
		                   " LOCATION       TEXT, " + 
		                   " DESCRIPTION    TEXT)"; 
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	   System.out.println("Attractions Table created successfully");
	   
	   try {
		   	  stmt = c.createStatement();
		      String sql = "CREATE TABLE AttractionsInTrips " +
		                   "(ID INT PRMARY KEY		 NOT NULL," +
		                    "(TRIP_ID INT 			 NOT NULL," +
		                   " ATTRACTION_ID INT 		 NOT NULL)"; 
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	   System.out.println("AttractionsInTrips Table created successfully");
	   
	   */
	   
	   
	  /* try {
		   	
		   	 
		      stmt = c.createStatement();
		      String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		                   "VALUES (69, 'Paul', 32, 'California', 20000.00 );"; 
		      stmt.executeUpdate(sql);

		      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		            "VALUES (70, 'Allen', 25, 'Texas', 15000.00 );"; 
		      stmt.executeUpdate(sql);

		      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		            "VALUES (73, 'Teddy', 23, 'Norway', 20000.00 );"; 
		      stmt.executeUpdate(sql);

		      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
		            "VALUES (74, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
		      stmt.executeUpdate(sql);

		      stmt.close();
		      c.commit();
		      c.close();
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	   System.out.println("Inserted into company table");*/
	   
	   /*try {
		      
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("name");
		         int age  = rs.getInt("age");
		         String  address = rs.getString("address");
		         float salary = rs.getFloat("salary");
		         System.out.println( "ID = " + id );
		         System.out.println( "NAME = " + name );
		         System.out.println( "AGE = " + age );
		         System.out.println( "ADDRESS = " + address );
		         System.out.println( "SALARY = " + salary );
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }*/
	   
	   
	}

}
