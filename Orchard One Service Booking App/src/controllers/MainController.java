package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController {
	   @FXML
	    private ImageView FxImageLogo;

	    @FXML
	    private ImageView MainView;
	    
	
		 
	 @FXML
	    void main_signin(ActionEvent event) {
		 try {
			 
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
			 Parent root1=(Parent) loader.load();
			 Stage stage=new Stage();
			 
			 stage.setTitle("Login View");
			 stage.setScene(new Scene(root1));
			 stage.show();
	       }
			catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
	    }

	    @FXML
	    void main_signup(ActionEvent event) {
	    	try {
	   		 
	   		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/SignupView.fxml"));
	   		 Parent root1=(Parent) loader.load();
	   		 Stage stage=new Stage();
	   		 stage.setTitle("Signup View");
	   		 stage.setScene(new Scene(root1));
	   		 stage.show();
	          }
	   		catch (Exception e) {
	   			System.out.println("Error occured while inflating view: " + e);
	   		}
	    }
}
