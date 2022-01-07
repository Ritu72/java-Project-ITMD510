package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import Dao.DBConnect;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class LoginModel extends DBConnect {

	/*
	 * private Boolean admin; private int id;
	 * 
	 * public int getId() { return id; } public void setId(int id) { this.id = id; }
	 * public Boolean isAdmin() { return admin; } public void setAdmin(Boolean
	 * admin) { this.admin = admin; }
	 */

	public String id;
	public static String aaa;
	public static int Member_Id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getCredentials(String username, String password, String ck ){

		String query = "SELECT * FROM orchard_one_user WHERE User_Name = ? and Password = ? and User_Type= ?";
		try(PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, ck);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) { 

				aaa=rs.getString("User_Id");
				setId(rs.getString("User_Id"));
				//setAdmin(rs.getBoolean("admin"));

				return true;
			}
			stmt.close();

		}catch (SQLException e) {
			e.printStackTrace();   
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	public boolean Sign_Up(String user_Id,String username, String password, String userType ) {
		String query1 = "INSERT INTO orchard_one_user (User_Id,User_Name,Password,User_Type) "
				+ "VALUES (?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query1)){
			statement.setString(1, user_Id);
			statement.setString(2,username);
			statement.setString(3, password);
			statement.setString(4, userType);
			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				return true;
			}
			statement.close();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace(); try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		}
		return false;
	}
	public boolean SubmitDetails(String customerName, String customerAdd, String customerZip,
			String customerCity, String customerState ) {
		String query1 = "INSERT INTO orchard_one_customer (User_Id,Customer_Name,Address,Zipcode,City,State) "
				+ "VALUES (?,?,?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query1)){
			statement.setString(1, aaa );
			statement.setString(2, customerName);
			statement.setString(3,customerAdd);
			statement.setString(4, customerZip);
			statement.setString(5, customerCity); 
			statement.setString(6, customerState); 
			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) {
				return true;
			}
			statement.close();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	public Boolean SubmitMembershipDetails(String memberType, LocalDate dPbirthday2, LocalDate dPAnniversary2) {

		// TODO Auto-generated method stub
		String query1 = "INSERT INTO orchard_one_membership (User_Id,Member_Type,Member_Birth_Day,Member_Anniversary) "
				+ "VALUES (?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query1)){
			statement.setString(1, aaa );
			statement.setString(2,memberType);
			statement.setString(3,dPbirthday2.toString());
			statement.setString(4,dPAnniversary2.toString()); 
			//statement.setInt(6, discount); 
			int rowsInserted = statement.executeUpdate();
			statement.close();

			if (rowsInserted > 0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
		}
		return false;
	}


	public Boolean BookingSubmit(String serviceOffered, LocalDate serviceStartDate, LocalDate serviceStopDate,
			int room2,int adult, int children2, int extraBed2, int bookingcost2, String payMode2) {
		String query1 = "INSERT INTO orchard_one_booking (User_Id,Service_Id,Service_Start_Date,Service_stop_Date,"
				+ "Num_Room,Num_Adults,Num_Child,ExtraBed,Booking_Cost,Payment_Method) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query1)){
			statement.setString(1, aaa);
			statement.setString(2,serviceOffered);
			statement.setString(3,serviceStartDate.toString());
			statement.setString(4,serviceStopDate.toString());
			statement.setInt(5,room2);
			statement.setInt(6,adult);
			statement.setInt(7,children2);
			statement.setInt(8,extraBed2);
			statement.setInt(9,bookingcost2);
			statement.setString(10,payMode2);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {

				return true;


			}
			statement.close();

		}catch (SQLException e) {
			e.printStackTrace();   
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		return false;
	}


	public Boolean UpdateBooking(String numberofRoom, String newBooking,
			LocalDate updatedServiceStartDate, LocalDate updatedSrviceServiceStopDate) {
		String query1="UPDATE orchard_one_booking SET Num_Room= ?, Payment_Method= ? " +
				",Service_Start_Date=?, Service_stop_Date=? where user_id= ? ";
		try(PreparedStatement statement = connection.prepareStatement(query1)){
			statement.setString(1,numberofRoom); statement.setString(2,newBooking);
			statement.setString(3,updatedServiceStartDate.toString());
			statement.setString(4,updatedSrviceServiceStopDate.toString());
			statement.setString(5,aaa);
			statement.executeUpdate(); 
			statement.close();

		}catch (SQLException e) { e.printStackTrace(); }
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}

	public Boolean DeleteRecord(String deleteRec) {
		String query1="DELETE FROM orchard_one_booking where Booking_Id=?";
		try(PreparedStatement statement = connection.prepareStatement(query1)){
			statement.setString(1,deleteRec); 
			statement.executeUpdate(); 
			statement.close();
		}catch (SQLException e) { e.printStackTrace(); }
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
	}

	public Boolean UpdateRoomBooking(String roomBooked, String Roomid,String choiceApproval2) {
		String query1="UPDATE orchard_one_booking SET Room_No=?,ManagerApproval=?  where Booking_id=? ";
		try(PreparedStatement statement = connection.prepareStatement(query1)){
			statement.setString(1,roomBooked);
			statement.setString(2,choiceApproval2);
			statement.setString(3,Roomid); 
			statement.executeUpdate(); 
			statement.close();
		}catch (SQLException e) { e.printStackTrace(); }
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; 
		
	}





}//end class