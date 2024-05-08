package org.example.magnificentgallery.Entity;

import java.security.Key;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private double loan;
    private String address;
    private String email;

    // Constructors
    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String phoneNumber, double loan, String address, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.loan = loan;
        this.address = address;
        this.email = email;
    }

    // Getters and Setters
    public Number getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Number getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


