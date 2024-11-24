package com.zaferakgul.reporting_api.models;

public class CustomerInfo {

    private String number;
    private String email;
    private String billingFirstName;
    private String billingLastName;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public CustomerInfo() {
    }

    public CustomerInfo(String number, String email, String billingFirstName, String billingLastName) {
        this.number = number;
        this.email = email;
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
    }
}