package org.example.magnificentgallery.Entity;

import java.security.Key;
import java.util.ArrayList;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private double loan;
    private String email;

    // Constructors
    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, double loan, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loan = loan;
        this.email = email;
    }

    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1,"Özge", "Odabaş",0,"ozge.odabas@bahcesehir.edu.tr"));
        customers.add(new Customer(2,"Selin", "Yerli",0,"selin.yerli@bahcesehir.edu.tr"));
        customers.add(new Customer(3,"Alper", "Avcı",0,"alper.avci@bahcesehir.edu.tr"));

        return  customers;
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

    public Number getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


