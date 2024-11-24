package com.zaferakgul.reporting_api.models;

public class AuthResponse {
    private String token;  // JWT Token
    private String status; // Request status

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AuthResponse(String token, String status) {
        this.token = token;
        this.status = status;
    }

    public AuthResponse() {
    }
}
