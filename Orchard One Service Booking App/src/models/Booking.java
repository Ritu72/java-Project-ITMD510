package models;

import java.sql.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Booking {
	private IntegerProperty Booking_id;
    private StringProperty user_id;
    private IntegerProperty service_id;
    private IntegerProperty member_id;
    private SimpleObjectProperty<Date> startdate;
    private SimpleObjectProperty<Date> Stopdate;
    private IntegerProperty Booking_cost;
    private IntegerProperty Payment_method;
    public Booking() {
    	this.Booking_id = new SimpleIntegerProperty();
    	this.user_id = new SimpleStringProperty();
    	this.service_id = new SimpleIntegerProperty();
    	this.member_id = new SimpleIntegerProperty();
    	this.startdate = new SimpleObjectProperty<>();
    	this.Stopdate = new SimpleObjectProperty<>();
    	this.Booking_cost = new SimpleIntegerProperty();
    	this.Payment_method = new SimpleIntegerProperty();
    	
    }
	public IntegerProperty getBooking_id() {
		return Booking_id;
	}
	public void setBooking_id(IntegerProperty booking_id) {
		Booking_id = booking_id;
	}
	public StringProperty getUser_id() {
		return user_id;
	}
	public void setUser_id(StringProperty user_id) {
		this.user_id = user_id;
	}
	public IntegerProperty getService_id() {
		return service_id;
	}
	public void setService_id(IntegerProperty service_id) {
		this.service_id = service_id;
	}
	public IntegerProperty getMember_id() {
		return member_id;
	}
	public void setMember_id(IntegerProperty member_id) {
		this.member_id = member_id;
	}
	public SimpleObjectProperty<Date> getStartdate() {
		return startdate;
	}
	public void setStartdate(SimpleObjectProperty<Date> startdate) {
		this.startdate = startdate;
	}
	public SimpleObjectProperty<Date> getStopdate() {
		return Stopdate;
	}
	public void setStopdate(SimpleObjectProperty<Date> stopdate) {
		Stopdate = stopdate;
	}
	public IntegerProperty getBooking_cost() {
		return Booking_cost;
	}
	public void setBooking_cost(IntegerProperty booking_cost) {
		Booking_cost = booking_cost;
	}
	public IntegerProperty getPayment_method() {
		return Payment_method;
	}
	public void setPayment_method(IntegerProperty payment_method) {
		Payment_method = payment_method;
	}
}
