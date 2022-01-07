package controllers;

import java.time.LocalDate;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.LoginModel;

public class CustomerBookingDetailsController {

    @FXML
    private TextField txtBookUserid;

    @FXML
    private TextField TxtRoom;

    @FXML
    private TextField txtAdults;

    @FXML
    private TextField txtNoOfChild;

    @FXML
    private TextField txtExtrabed;

    @FXML
    private TextField txtBookingCost;

    @FXML
    private Label BookingLabelError;

    @FXML
    private DatePicker DpstartDate;

    @FXML
    private DatePicker DPStopDate;

    @FXML
    private ChoiceBox CBServiceid;
    @FXML
    private ChoiceBox CBMethod;
    private LoginModel model;
    public CustomerBookingDetailsController() {
    model = new LoginModel();
    }
    int Room;
    int Adult;
    int children;
    int ExtraBed;
    int Bookingcost;
    
    ObservableList<String> ServiceIdOffered = FXCollections.observableArrayList("101", "102","103");
	// ObservableList<String> MemberTypeFees = FXCollections.observableArrayList("100","200","550"); 
	ObservableList<String> PaymentTypeChoice = FXCollections.observableArrayList("Cash", "Credit"); 
    public void initialize() {
    	CBServiceid.setItems(ServiceIdOffered);
    	CBMethod.setItems(PaymentTypeChoice);
	}
    
    @FXML
    void BookingSubmitForm(ActionEvent event) {
    	String BookingLabelError="";
		String serviceOffered= (String) this.CBServiceid.getValue();
	    String PayMode= (String) this.CBMethod.getValue();
		LocalDate ServiceStartDate = DpstartDate.getValue();
		LocalDate ServiceStopDate = DPStopDate.getValue();
		 this.Room = Integer.parseInt(TxtRoom.getText());
		 this.Adult = Integer.parseInt(txtAdults.getText());
		 this.children = Integer.parseInt(txtNoOfChild.getText());
		 this.ExtraBed = Integer.parseInt(txtExtrabed.getText());
		 this.Bookingcost = Integer.parseInt(txtBookingCost.getText());
		CheckSubmitDetails(serviceOffered,ServiceStartDate,ServiceStopDate,Room,Adult,children,ExtraBed,Bookingcost,PayMode);
    }
    private void CheckSubmitDetails(String serviceOffered, LocalDate serviceStartDate, LocalDate serviceStopDate,
			int room2, int adult2, int children2, int extraBed2, int bookingcost2,String PayMode2) {
		Boolean isEntered1 = model.BookingSubmit(serviceOffered,serviceStartDate,serviceStopDate,room2,adult2,children2,extraBed2,bookingcost2,PayMode2);
		if (isEntered1) {
			BookingLabelError.setText("Booked Service Suucessfully!");
		}
		
	}
	
    @FXML
    void ReturnCustMainPage(ActionEvent event) {
    	try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/CustomerView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Customer View");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
		return;
    }
}
