package dayTrip;

public class Manager {
	
	private DataBlock managedObjects;
	private DatabaseInterface databaseInterface;
	private int type;
	
	public Manager(DatabaseInterface databaseInterface, int type)
	{
		this.setType(type);
		managedObjects = new DataBlock(type);	
		this.databaseInterface =  databaseInterface;
		
	}
	
	public DataBlock search(Query query){
		DataBlock res = this.databaseInterface.select(query);
		return res;
	};
	
	public void syncManagedObjects(DataBlock searchResults){
		
		
		int type = searchResults.getType();
		switch(type){
		case 1:	
			this.managedObjects.getAttractions().addAll(searchResults.getAttractions());
			break;
		case 2: 
			this.managedObjects.getTrips().addAll(searchResults.getTrips());
			break;
		}		
	}
	
	public Pair[] constructPairs(String[] fields, String[] values)
	{
		Pair[] query = new Pair[fields.length];
		switch (this.type){
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
		
		return query;
	}
	
	public int createObject(String[] fields, String[] values)
	{				
		if(this.databaseInterface.insert(constructPairs(fields,values)) == 1) return 1;		
		return -1;
				
	}
	
	public int removeObject(String[] fields, String[] values){		
		
		if(this.databaseInterface.delete(constructPairs(fields,values)) == 1) return 1;		
		return -1;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	};

}
