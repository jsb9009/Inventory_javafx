package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Blob;

/**
 * Created by jaliya on 12/5/17.
 */
public class User {

    private StringProperty userId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty role;
    private StringProperty password;
    private StringProperty contactNo;
    private StringProperty address;
    private StringProperty picLocation;


    public User() {
        this.userId = new SimpleStringProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.role = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.contactNo = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.picLocation = new SimpleStringProperty();
    }

    public String getPicLocation() {
        return picLocation.get();
    }

    public StringProperty picLocationProperty() {
        return picLocation;
    }

    public void setPicLocation(String picLocation) {
        this.picLocation.set(picLocation);
    }

    public String getContactNo() {
        return contactNo.get();
    }

    public StringProperty contactNoProperty() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo.set(contactNo);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getUserId() {
        return userId.get();
    }

    public StringProperty userIdProperty() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId.set(userId);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
