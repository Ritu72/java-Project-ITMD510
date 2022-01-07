package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.LoginModel;

public class DeleteBookingDetailsController {
	 @FXML
	    private TextField delRecord;

	    @FXML
	    private Label SuccessFullMessage;
	    private LoginModel model;
	    public DeleteBookingDetailsController() {
	    	 model = new LoginModel();
	    }
	    

	    @FXML
	    void DeleteRecord(ActionEvent event) {
	    	SuccessFullMessage.setText("");
	    	String deleteRec=this.delRecord.getText();
	    	DeleteBooking(deleteRec);

	    }

	    private void DeleteBooking(String deleteRec) {
	    	Boolean isEntered1 = model.DeleteRecord(deleteRec);
			if (isEntered1) {
				SuccessFullMessage.setText("Record Successfully Deleted!!!...");
				return;
				}
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

}
