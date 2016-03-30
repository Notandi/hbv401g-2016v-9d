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
	
	//
	public void removeObject(T t){
		
		
	};

}
