package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Dao.DBConnect;
import application.AdminViewAccounts;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminController {

	@FXML
	private Pane pane1;
	
	@FXML
	private TextField txtUseridup;
	@FXML
    private ImageView AdminView;

	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	public AdminController() {
		conn = new DBConnect();
	}
	 
	public void initialize() {
	    	Image image1=new Image("/Images/MainView.jpg");
	    	AdminView.setImage(image1);
	    }

	public void viewAccounts() {

		AdminViewAccounts viewaccount= new AdminViewAccounts();
		// call method from DynamicTable class and pass some arbitrary query string
		viewaccount.ViewAdminAccount("Select Booking_ID,service_start_date,service_stop_date,Payment_Method "
				+ "from orchard_one_booking");
	}

	@FXML
    void deleteRec(ActionEvent event) {
		try {
			 
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/DelCustomerBookingDetails.fxml"));
			 Parent root1=(Parent) loader.load();
			 Stage stage=new Stage();
			 stage.setTitle("Booking View");
			 stage.setScene(new Scene(root1));
			 stage.show();
	       }
			catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
    }

    @FXML
    void mangerApproval(ActionEvent event) {
    	try {
			 
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ApprovalCustomerBookingDetails.fxml"));
			 Parent root1=(Parent) loader.load();
			 Stage stage=new Stage();
			 stage.setTitle("Booking View");
			 stage.setScene(new Scene(root1));
			 stage.show();
	       }
			catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
    }

    @FXML
    void ReturnLogin(ActionEvent event) {
    	try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Login View");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
		return;
    }

}
