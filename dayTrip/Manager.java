package dayTrip;


public abstract class Manager<T> {
	
	private T[] ManagedObjects;
	
	public abstract <T> T[] search(Query query);
	
	
	

}
