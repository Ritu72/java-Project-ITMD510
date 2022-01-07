package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.LoginModel;


public class CustomerController  {
	 
	static String userid;
	private LoginModel model; 
	@FXML
    private ImageView CustomerImageView;
	public static String getUserid() {
		return userid;
	}
	public void initialize() {
    	Image image1=new Image("/Images/Gallary.jpg");
    	CustomerImageView.setImage(image1);
    }
	 @FXML
	    public void CustomerDetails() {
	    	try {
	   		 FXMLLoader loader = new FXMLLoader();
	   		 loader.setLocation(getClass().getResource("/views/CustomerDetails.fxml"));
	   		 Parent root2=(Parent) loader.load();
	   		 Stage stage=new Stage();
	   		 stage.setTitle("Customer Form View");
	   		 stage.setScene(new Scene(root2));
	   		 
	   		 stage.show();
	          }
	   		catch (Exception e) {
	   			System.out.println("Error occured while inflating view: " + e);
	   		}
	    
	    }
	 @FXML
     public void Memberdetails(ActionEvent event){
		try {
			 
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MemDetails.fxml"));
			 Parent root3=(Parent) loader.load();
			 Stage stage=new Stage();
			 stage.setTitle("Member View");
			 stage.setScene(new Scene(root3));
			 stage.show();
	       }
			catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
		}
	@FXML
	    void BookingDetails(ActionEvent event) {
		try {
			 
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/BookingDetails.fxml"));
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
	    public void UpdateBooking(ActionEvent event) {
	    	try {
				 
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/UpdateCustomerBookingDetails.fxml"));
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
	    public void logout(ActionEvent event) {
	    	try {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
				Main.stage.setScene(scene);
				Main.stage.setTitle("Customer View");
			} catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
			return;
	      
	    }
	    @FXML
	    public void viewAccounts() throws IOException {

	    	try {
				 
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ViewAccounts.fxml"));
				 Parent root1=(Parent) loader.load();
				 Stage stage=new Stage();
				 stage.setTitle("View Booking Details");
				 stage.setScene(new Scene(root1));
				 stage.show();
		       }
				catch (Exception e) {
					System.out.println("Error occured while inflating view: " + e);
				}

		}
	    
	public static String setUserid(String user_id) {
		String userid = user_id;
		System.out.println("Welcome id " + userid);
		return userid;
	}
	
}
