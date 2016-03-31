package dayTrip;

public class Interface {
	private AttractionManager attractionManager;
	private BookingManager bookingManager;
	private CarManager carManager;
	private CustomerManager customerManager;
	private TripManager tripManager;
	private DatabaseInterface databaseInterface;
	
	public Interface()
	{
		this.setAttractionManager(new AttractionManager());
		this.setBookingManager(new BookingManager());
		this.setCarManager(new CarManager());
		this.setCustomerManager(new CustomerManager());
		this.setTripManager(new TripManager());
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
}
