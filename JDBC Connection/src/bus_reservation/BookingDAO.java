package bus_reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {

	public int getBookedCount(int busNo, Date date) throws SQLException {
		
		Connection con = DbConnection.getConnection();
		String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqlDate);
		ResultSet res = pst.executeQuery();
		res.next();
		
		return res.getInt(1);
	}

	public void addBooking(Booking booking) throws SQLException {
		
		Connection con = DbConnection.getConnection();
		String query = "insert into booking values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqlDate);

		pst.executeUpdate();
	}

}
