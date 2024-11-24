package com.zaferakgul.reporting_api.models;

public class TransactionReportRequest {
    private String fromDate;
    private String toDate;
    private int merchant;     // Merchant ID
    private int acquirer;     // Acquirer ID

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getMerchant() {
        return merchant;
    }

    public void setMerchant(int merchant) {
        this.merchant = merchant;
    }

    public int getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(int acquirer) {
        this.acquirer = acquirer;
    }

    public TransactionReportRequest() {
    }

    public TransactionReportRequest(String fromDate, String toDate, int merchant, int acquirer) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.merchant = merchant;
        this.acquirer = acquirer;
    }
}
