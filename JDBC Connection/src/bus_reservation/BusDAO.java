package bus_reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {

	public void displayBusInfo() throws SQLException {
		
		Connection con = DbConnection.getConnection();
		String query = "select * from bus";
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery(query);
		
		System.out.println("--------------------------------");
		
		while(res.next()) {
			System.out.println("Bus no "+res.getInt(1));
			if(res.getInt(2) == 0)
				System.out.println("Ac: No");
			else
				System.out.println("Ac: Yes");
			
			System.out.println("Capacity "+res.getInt(3));
		}
		
		System.out.println("--------------------------------");
	}

	public int getCapacity(int busNo) throws SQLException{
		
		Connection con = DbConnection.getConnection();
		String query = "select capacity from bus where id="+busNo;
		Statement st = con.createStatement();
		ResultSet res = st.executeQuery(query);
		res.next();
		return res.getInt(1);
	}

}
