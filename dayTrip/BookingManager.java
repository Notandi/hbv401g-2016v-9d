package dayTrip;

public class BookingManager extends Manager<Booking> {

	private Booking[] bookings;

	public Booking[] getBookings() {
		return bookings;
	}

	public void setBookings(Booking[] bookings) {
		this.bookings = bookings;
	}
}
