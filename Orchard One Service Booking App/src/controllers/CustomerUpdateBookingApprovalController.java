package controllers;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.LoginModel;
public class CustomerUpdateBookingApprovalController {

	
	@FXML
    private TextField txtBookingRoom;

 @FXML
	    private ChoiceBox ChoiceApproval;
    
   
	ObservableList<String> ApprovalChoice = FXCollections.observableArrayList("Yes", "No"); 
	private LoginModel model;
    @FXML
    private Label txtsuccessmsg;
    @FXML
    private TextField txtBookingid;

    public void initialize() {
    	ChoiceApproval.setItems(ApprovalChoice);	
	}
    public CustomerUpdateBookingApprovalController() {
    	model = new LoginModel();
    }
    @FXML
    void ReturnAdminView(ActionEvent event) {
    	try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ManagerView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Manager View");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
		return;
    }

    @FXML
    void updateApproval(ActionEvent event) {
    	txtsuccessmsg.setText("");
    	String RoomBooked = this.txtBookingRoom.getText();
    	String BookingId = this.txtBookingid.getText();
    	String ChoiceApproval= (String) this.ChoiceApproval.getValue();
		
		UpdateApproval(RoomBooked,BookingId,ChoiceApproval);
    }

	private void UpdateApproval(String roomBooked, String BookingId, String choiceApproval2) {
		Boolean isEnter = model.UpdateRoomBooking(roomBooked,BookingId,choiceApproval2);
		if (isEnter) { 
			txtsuccessmsg.setText("Successfully Approve the Booking !!!...");
		}
		
	}
}
