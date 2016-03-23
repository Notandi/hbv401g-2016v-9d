package dayTrip;


public class  Manager<T> {
	
	private T[] ManagedObjects;
	
	public T[] search(Query query);
	public void addObject(T t);
	public void removeObject(T t);

}
