package controllers;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.LoginModel;

public class LoginController  {
	ObservableList<String> availableChoices = FXCollections.observableArrayList("Manager", "Guest"); 

    @FXML
	private TextField txtUsername;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private Label lblError;
	 @FXML
	private Hyperlink txtUserid;

	private LoginModel model;
	@FXML
    private ChoiceBox checklabel;
	public String user_id; 
	
	@SuppressWarnings("unchecked")
	@FXML
	public void initialize() {
	checklabel.setItems(availableChoices);
	}
	public LoginController() {
		model = new LoginModel();
	}
	
	public void login() {

		lblError.setText("");
		String username = this.txtUsername.getText();
		String password = this.txtPassword.getText();
		String ck= (String) this.checklabel.getValue();

		// Validations
		if (username == null || username.trim().equals("")) {
			lblError.setText("Username Cannot be empty or spaces");
			return;
		}
		if (password == null || password.trim().equals("")) {
			lblError.setText("Password Cannot be empty or spaces");
			return;
		}
		if (username == null || username.trim().equals("") && (password == null || password.trim().equals(""))) {
			lblError.setText("User name / Password Cannot be empty or spaces");
			return;
		}

		// authentication check
		checkCredentials(username, password,ck);

	}

	public void checkCredentials(String username, String password, String ck) {
	
		Boolean isValid = model.getCredentials(username, password,ck);
		if (!isValid) {
			lblError.setText("User does not exist!");
			return;
		}
		try {
			AnchorPane root;
			
			if (isValid && ck.equals("Manager")) {
				// If user is admin, inflate admin view

				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ManagerView.fxml"));
				Main.stage.setTitle("Admin View");

			} else {
				// If user is customer, inflate customer view

				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/CustomerView.fxml"));
				// ***Set user ID acquired from db****
				user_id = model.getId();  
				CustomerController.setUserid(user_id);
				Main.stage.setTitle("Customer View");
			}

			Scene scene = new Scene(root);
			Main.stage.setScene(scene);

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}

	}
	
	
}