package com.zaferakgul.reporting_api.models;

import java.util.List;

public class TransactionReportResponse {
    private String status;
    private List<TransactionResponseItem> response; // Response details

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TransactionResponseItem> getResponse() {
        return response;
    }

    public void setResponse(List<TransactionResponseItem> response) {
        this.response = response;
    }

    public TransactionReportResponse(String status, List<TransactionResponseItem> response) {
        this.status = status;
        this.response = response;
    }

    public TransactionReportResponse() {
    }
}
