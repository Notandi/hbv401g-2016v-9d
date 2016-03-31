package dayTrip;
import java.util.ArrayList;


public class Manager<T> {
	
	private ArrayList<T> ManagedObjects;
	
	public Manager()
	{
		ManagedObjects = new ArrayList<T>();		
	}
	public ArrayList<T> search(Query query){
		ArrayList<T> a = new ArrayList<T>();
		return a;		
	};
	public void addObject(T t){ManagedObjects.add(t);};	
	public void syncManagedObjects(ArrayList<T> searchResults){ManagedObjects.addAll(searchResults);}
	
	public int createObject(int manager, String[] fields, String[] values)
	{
		Pair[] query = new Pair[fields.length];
		switch (manager){
			case 1:
				query[0] = new Pair("Table","Car");
				break;
			case 2:
				query[0] = new Pair("Table", "Trip");
				break;
			case 3:
				query[0] = new Pair("Table", "Attraction");
				break;
			case 4:
				query[0] = new Pair("Table", "Booking");
				break;
			case 5:
				query[0] = new Pair("Table", "Customer");
				break;			
		}
		
		for(int i = 1; i<fields.length; i++)
		{
			query[i] = new Pair(fields[i], values[i]);
		}
		
		
		if(Interface.getDatabaseInterface().select(query) == 1) return 1;
		
		return -1;
				
	}
	
	public void removeObject(T t){
		
		
	};

}
