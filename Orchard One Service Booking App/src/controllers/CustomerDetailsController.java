package controllers;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

//import models.LoginModel;
import models.LoginModel;


public class CustomerDetailsController {
	  @FXML
	    private TextField txtcustName;

	    @FXML
	    private TextField txtcustadd;

	    @FXML
	    private TextField txtcustzip;

	    @FXML
	    private TextField txtcustcity;

	    @FXML
	    private TextField txtcuststate;
	    
	    @FXML
	    private Label labelErrCust;
	    
	    private LoginModel model;
	    public CustomerDetailsController() {
	    model = new LoginModel();
	    }
	    
	    public String userid1;
		/*
		 * public CustomerDetailsController() { model = new CustomerModel(); }
		 */
	    
	    @FXML
	    void submitCustomerDetails() {
	    	String userid="";
	    	labelErrCust.setText("");
			String CustomerName = this.txtcustName.getText();
			String CustomerAdd = this.txtcustadd.getText();
			String CustomerZip = this.txtcustzip.getText();
			String CustomerCity= this.txtcustcity.getText();
			String CustomerState = this.txtcuststate.getText();
			CheckSubmitDetails(CustomerName,CustomerAdd, CustomerZip,CustomerCity,CustomerState );
	    }
	    
	    public void CheckSubmitDetails(String customerName, String customerAdd, String customerZip,
				String customerCity, String customerState) {
			// TODO Auto-generated method stub
	    	Boolean isEntered1 = model.SubmitDetails(customerName,customerAdd,customerZip,customerCity,customerState);
			if (isEntered1) {
				labelErrCust.setText("User Successfully Added!");
				
		}
	    }

		@FXML
	    void ReturnCustomerView() {
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
		public static void setCustomerId(String userid1) {
			// TODO Auto-generated method stub
			String Custuserid = userid1;
			System.out.println("Welcome id " + Custuserid);
			//return userid1;
			
		}
		
	    
}
