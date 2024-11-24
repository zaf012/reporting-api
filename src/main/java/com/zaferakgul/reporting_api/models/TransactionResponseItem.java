package com.zaferakgul.reporting_api.models;

public class TransactionResponseItem {
    private int count;      // Quantity transaction
    private int total;      // Total amount
    private String currency; // Original currency

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TransactionResponseItem(int count, int total, String currency) {
        this.count = count;
        this.total = total;
        this.currency = currency;
    }

    public TransactionResponseItem() {
    }
}
