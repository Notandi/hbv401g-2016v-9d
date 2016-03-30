package dayTrip;
import java.util.ArrayList;

public class UserInterface {
	private int manager;
	private ArrayList<String> filters;
	
	public UserInterface()
	{
		setFilters(new ArrayList<String>());
	}
	
	public void removeFilter(String filter){};
	public int getManager() {return manager;}
	public void setManager(int newManager){this.manager = newManager;}

	public ArrayList<String> getFilters() {
		return filters;
	}

	public void setFilters(ArrayList<String> filters) {
		this.filters = filters;
	}

}
