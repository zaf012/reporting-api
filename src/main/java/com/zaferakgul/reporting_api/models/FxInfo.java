package com.zaferakgul.reporting_api.models;

public class FxInfo {
    private MerchantFx merchant;

    public FxInfo() {
    }

    public FxInfo(MerchantFx merchant) {
        this.merchant = merchant;
    }

    public MerchantFx getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantFx merchant) {
        this.merchant = merchant;
    }
}