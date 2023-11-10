package bus_reservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {

	String passengerName;
	int busNo;
	Date date;
	
	public Booking() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Passesnger Name");
		passengerName = scan.next();
		System.out.println("Enter bus number");
		busNo = scan.nextInt();
		System.out.println("Enter Journey date (dd-mm-yyyy)");
		String dateIn = scan.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateFormat.parse(dateIn);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	public boolean isAvailable() throws SQLException {
		
		BusDAO busDao = new BusDAO();
		int capacity = busDao.getCapacity(busNo);
		
		BookingDAO bookingDao = new BookingDAO();
		int booked = bookingDao.getBookedCount(busNo,date);
		
		return booked<capacity;
	}
}
