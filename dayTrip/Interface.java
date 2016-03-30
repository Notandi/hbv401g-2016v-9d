package dayTrip;

import java.util.ArrayList;

public class Interface {
	private AttractionManager attractionManager;
	private BookingManager bookingManager;
	private CarManager carManager;
	private CustomerManager customerManager;
	private TripManager tripManager;
	private int manager;
	private ArrayList<String> filters;
	
	public Interface()
	{
		this.attractionManager = new AttractionManager();
		this.bookingManager = new BookingManager();
		this.carManager = new CarManager();
		this.customerManager = new CustomerManager();
		this.tripManager = new TripManager();
		this.filters = new ArrayList<String>();
	}
	
	public void removeFilter(String filter){};
	public void setManager(int newManager){this.manager = newManager;}

}
