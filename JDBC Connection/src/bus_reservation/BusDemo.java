package bus_reservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {

	public static void main(String[] args) throws SQLException {
		
		BusDAO busDao = new BusDAO();
		try {
			busDao.displayBusInfo();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Enter 1 for booking \nEnter 2 for stop this ");
			int userOpt = scan.nextInt();
			if(userOpt == 1) {
//				System.out.println("Booking....");
				Booking booking = new Booking();
				if(booking.isAvailable()) {
					
					BookingDAO bookingDao = new BookingDAO();
					bookingDao.addBooking(booking);
					
					System.out.println("Booking is confirmed");
				}
				else {
					System.out.println("Bus is full try another bus or date");
				}
			}
			else {
				System.out.println("Stop Booking....");
				break;
			}
		}
		scan.close();

	}

}
