package controllers;

import java.time.LocalDate;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.LoginModel;

public class CustomerUpdateBookingController {
	@FXML
	private TextField txtupNumberOfRooms;

	@FXML
    private ChoiceBox updateMode;

	@FXML
	private DatePicker txtUpStart;

	@FXML
	private DatePicker txtUpStop;

	@FXML
	private Label updatedLabel;

	private LoginModel model;
	public CustomerUpdateBookingController() {
		model = new LoginModel();
	}
	ObservableList<String> PaymentTypeChoice = FXCollections.observableArrayList("Cash", "Credit", "Debit"); 
	 public void initialize() {
		  updateMode.setItems(PaymentTypeChoice);
		}
	@FXML
	void ReturnButn(ActionEvent event) {

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

	@FXML
	void updatebutn(ActionEvent event) {
		updatedLabel.setText("");
		String NoofRoom = this.txtupNumberOfRooms.getText();
		String newBooking= (String) this.updateMode.getValue();
		LocalDate updatedServiceStartDate = txtUpStart.getValue();
		LocalDate updatedSrviceServiceStopDate = txtUpStop.getValue();

		UpdateBookingDetails(NoofRoom,newBooking,updatedServiceStartDate,updatedSrviceServiceStopDate);

	}

	private void UpdateBookingDetails(String NumberofRoom, String newBooking, LocalDate updatedServiceStartDate,
			LocalDate updatedSrviceServiceStopDate) {
		Boolean isEntered1 = model.UpdateBooking(NumberofRoom,newBooking,updatedServiceStartDate,updatedSrviceServiceStopDate);
		if (isEntered1) { 
			updatedLabel.setText("Successfully updated The Services!!!...");
		}
	}

}
