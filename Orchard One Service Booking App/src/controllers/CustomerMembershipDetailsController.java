package controllers;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import models.LoginModel;
import javafx.scene.control.Label;
import java.time.LocalDate;
public class CustomerMembershipDetailsController extends LoginController {
	@FXML
	private TextField txtfees;
	@FXML
	private Label MemberLabelError;
	@FXML
	private DatePicker DPbirthday;
	@FXML
	private DatePicker DPAnniversary;

	@FXML
	private ChoiceBox CBMemberType;

	@FXML
	private ChoiceBox CBPaymentMode;

	@FXML
	private TextField txtMemberId;


	private LoginModel model;
	
	

	ObservableList<String> MemberTypeChoice = FXCollections.observableArrayList("Silver", "Gold","platinum");
	// ObservableList<String> MemberTypeFees = FXCollections.observableArrayList("100","200","550"); 
	ObservableList<String> PaymentTypeChoice = FXCollections.observableArrayList("Cash", "Credit"); 
	@FXML
	public void initialize() {
		CBMemberType.setItems(MemberTypeChoice);
		CBPaymentMode.setItems(PaymentTypeChoice);
	}
	public CustomerMembershipDetailsController() {
		model = new LoginModel();
	}
	/*
	 * @FXML private void showFee() {
	 * txtfees.setText(MemberTypeFees.toString()+"$");
	 * 
	 * }
	 */


	@FXML private void showuserID() { 
		String Customeruser_id = model.getId();
		txtMemberId.setText(Customeruser_id); }

	@SuppressWarnings("rawtypes")
	@FXML
	void SubmitMembershipDetails() {

		String MemberLabelError="";
		String MemberType= (String) this.CBMemberType.getValue();
		String PaymentMode= (String) this.CBPaymentMode.getValue();
		

       LocalDate DOB = DPbirthday.getValue();
       LocalDate MemAnn = DPAnniversary.getValue();
       //txtMemberId.setText(value);
       
       checkSubmitMembershipDetails(MemberType,DOB,MemAnn);

	}
	public void setUser(String id) {
		txtMemberId.setText(user_id);

    }

	private void checkSubmitMembershipDetails(String memberType, LocalDate dOB, LocalDate memAnn) {
		// TODO Auto-generated method stub
		Boolean isEntered1 =model.SubmitMembershipDetails(memberType,dOB,memAnn); 
		if(isEntered1) {
			MemberLabelError.setText("Successfully Enrolled for Orchard one Membership!"); 
		}

	}

	@FXML
	void ReturnCustViewMem() {
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
