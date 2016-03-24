package dayTrip;
import java.util.ArrayList;

public class UserInterface {
	private int manager;
	private ArrayList<String> filters;
	
	public UserInterface()
	{
		filters = new ArrayList<String>();
	}
	
	public void removeFilter(String filter){};
	public void setManager(int newManager){this.manager = newManager;}

}
