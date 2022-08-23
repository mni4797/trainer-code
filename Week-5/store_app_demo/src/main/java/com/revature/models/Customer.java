package com.revature.models;
// This package contains models AKA POJOs

// POJO - Plain ol'  java object
// It's a design pattern used for creating classes that are meant to 
// hold some data in a structured manner
// Customer POJO => holding customer data 
// POJOs classes allow you to group different data and data types 
// in one object
// POJOs are really useful for data that you can't really contain
// in a simple data type like your primitives or string

/**
 * POJO for Customer Information
 */
public class Customer {
    // For properties/fields in a POJO you can just base it
    // on the columns of the corresponding table in the DB

    // ==========Fields============
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String password;

    // ===================Constructor===============
    // gets called when you create an instance.
    // allows you to set default values for your fields
    // used in object instantiation: Customer cust1 = new Customer();
    // No args constructor
    public Customer() {
        super();
    }

    // ******************Methods*****************************
    // =================Getters=============================
    // getter gets info about a private field and returns it
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    // ===================Setters=====================
    // Set values for your private fields
    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
