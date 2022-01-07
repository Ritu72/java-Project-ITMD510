package controllers;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.AnchorPane;
import models.LoginModel;

public class SignUpController {
	@FXML
    private Label lblError1=null;
	@FXML
    private TextField txtUserId=null;

    @FXML
    private TextField txtUser_Name=null;

    @FXML
    private TextField txtUserType=null;

    @FXML
    private PasswordField txtPass=null;
    private LoginModel model;
    
    public SignUpController() {
		model = new LoginModel();
	}

	public void Signup() {
		lblError1.setText("");
		String user_Id = this.txtUserId.getText();
		String username = this.txtUser_Name.getText();
		String password = this.txtPass.getText();
		String userType = this.txtUserType.getText();
	
		CheckSign_Up(user_Id,username, password,userType );
		
	}
	public void CheckSign_Up(String user_Id,String username, String password, String userType ){
		Boolean isEntered = model.Sign_Up(user_Id,username, password,userType);
		if (isEntered) {
			lblError1.setText("User Successfully Added!");
			try {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/application/style.css").toExternalForm());
				Main.stage.setScene(scene);
				Main.stage.setTitle("Login");
			} catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
			return;
		}

	}
	public void logout() {
		// System.exit(0);
		
	}
}
