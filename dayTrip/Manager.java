package dayTrip;
import java.util.ArrayList;


public class Manager<T> {
	
	private ArrayList<T> managedObjects;
	private DatabaseInterface databaseInterface;
	
	public Manager(DatabaseInterface databaseInterface)
	{
		managedObjects = new ArrayList<T>();	
		this.databaseInterface =  databaseInterface;
	}
	
	public ArrayList<?> search(Query query){
		ArrayList<?> res = this.databaseInterface.select(query);
		return res;
	};
	public void addObject(T t){managedObjects.add(t);};	
	public void syncManagedObjects(ArrayList<T> searchResults){managedObjects.addAll(searchResults);}
	
	public int createObject(int manager, String[] fields, String[] values)
	{
		Pair[] query = new Pair[fields.length];
		switch (manager){
			case 1:
				query[0] = new Pair("Table", "Attraction");				
				break;
			case 2:
				query[0] = new Pair("Table", "Trip");
				break;
			case 3:
				query[0] = new Pair("Table","Car");
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
		
		
		if(this.databaseInterface.insert(query) == 1) return 1;
		
		return -1;
				
	}
	
	public void removeObject(T t){
		
		
	};

}
