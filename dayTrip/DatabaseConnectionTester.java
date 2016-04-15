package dayTrip;

import java.sql.*;


public class DatabaseConnectionTester {
	
	public static void main(String[] args)
	{
		System.out.println("Hello world");
		Connection c = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	   System.out.println("Opened database successfully");
	}

}
