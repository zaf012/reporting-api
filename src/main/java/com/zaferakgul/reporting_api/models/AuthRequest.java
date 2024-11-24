package com.zaferakgul.reporting_api.models;

public class AuthRequest {

    private String email;    // Email address
    private String password; // Password

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthRequest() {
    }
}