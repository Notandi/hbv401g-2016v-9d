package dayTrip;


public abstract class Manager<T> {
	
	private T[] ManagedObjects;
	
	public abstract <T> T[] search(Query query);
	public abstract <T> void addObject(T t);
	public abstract <T> void removeObject(T t);

}
