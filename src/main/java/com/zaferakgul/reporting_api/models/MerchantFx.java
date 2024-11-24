package com.zaferakgul.reporting_api.models;

public class MerchantFx {
    private Double originalAmount;
    private String originalCurrency;

    public Double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public MerchantFx() {
    }

    public MerchantFx(Double originalAmount, String originalCurrency) {
        this.originalAmount = originalAmount;
        this.originalCurrency = originalCurrency;
    }
}