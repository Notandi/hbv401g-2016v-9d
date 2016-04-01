package dayTrip;

import java.util.ArrayList;

public class Interface {
	private static AttractionManager attractionManager;
	private static BookingManager bookingManager;
	private static CarManager carManager;
	private static CustomerManager customerManager;
	private static TripManager tripManager;
	private static DatabaseInterface databaseInterface;
	
	public Interface()
	{
		this.setDatabaseInterface(new DatabaseInterface());
		this.setAttractionManager(new AttractionManager(databaseInterface));
		this.setBookingManager(new BookingManager(databaseInterface));
		this.setCarManager(new CarManager(databaseInterface));
		this.setCustomerManager(new CustomerManager(databaseInterface));
		this.setTripManager(new TripManager(databaseInterface));
	}

	public AttractionManager getAttractionManager() {
		return attractionManager;
	}

	public void setAttractionManager(AttractionManager attractionManager) {
		this.attractionManager = attractionManager;
	}

	public BookingManager getBookingManager() {
		return bookingManager;
	}

	public void setBookingManager(BookingManager bookingManager) {
		this.bookingManager = bookingManager;
	}

	public CarManager getCarManager() {
		return carManager;
	}

	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
	}

	public CustomerManager getCustomerManager() {
		return customerManager;
	}

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	public TripManager getTripManager() {
		return tripManager;
	}

	public void setTripManager(TripManager tripManager) {
		this.tripManager = tripManager;
	}

	public DatabaseInterface getDatabaseInterface() {
		return databaseInterface;
	}

	public void setDatabaseInterface(DatabaseInterface databaseInterface) {
		this.databaseInterface = databaseInterface;
	}
	
	public static class UserInterface {
		private int manager;
		private ArrayList<String> filters;
		
		public UserInterface()
		{
			setFilters(new ArrayList<String>());
		}
		
		public ArrayList<?> search(String searchString)
		{
			Query query = new Query(manager, searchString, this.filters);
			ArrayList<?> res;
			switch (manager){
			case 1:
				res = attractionManager.search(query);				
				break;
			case 2:
				res = tripManager.search(query);
				break;
			case 3:
				res = carManager.search(query);
				break;
			case 4:
				res = bookingManager.search(query);
				break;
			case 5:
				res = customerManager.search(query);
				break;			
			default:
				res = null;
			}
		
			return res;
		}
		
		public void removeFilter(String filter){
			this.filters.remove(filter);			
		};
		
		public int getManager() {return manager;}
		
		public void setManager(int newManager){this.manager = newManager;}

		public ArrayList<String> getFilters() {
			return filters;
		}

		public void addFilter(String filter){
			this.filters.add(filter);
		}
		
		public void setFilters(ArrayList<String> filters) {
			this.filters = filters;
		}

	}
	
	public static class AdminInterface extends UserInterface {
		
		public AdminInterface() {
			
			setFilters(new ArrayList<String>());
		}
		
	}
}
