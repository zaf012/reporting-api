package com.zaferakgul.reporting_api.models;

public class TransactionData {
    private FxInfo fx;
    private CustomerInfo customerInfo;
    private MerchantInfo merchant;
    private IpnInfo ipn;
    private TransactionInfo transaction;
    private AcquirerInfo acquirer;
    private Boolean refundable;

    public TransactionData() {
    }

    public TransactionData(FxInfo fx, CustomerInfo customerInfo, MerchantInfo merchant, IpnInfo ipn, TransactionInfo transaction, AcquirerInfo acquirer, Boolean refundable) {
        this.fx = fx;
        this.customerInfo = customerInfo;
        this.merchant = merchant;
        this.ipn = ipn;
        this.transaction = transaction;
        this.acquirer = acquirer;
        this.refundable = refundable;
    }

    public FxInfo getFx() {
        return fx;
    }

    public void setFx(FxInfo fx) {
        this.fx = fx;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public MerchantInfo getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantInfo merchant) {
        this.merchant = merchant;
    }

    public IpnInfo getIpn() {
        return ipn;
    }

    public void setIpn(IpnInfo ipn) {
        this.ipn = ipn;
    }

    public TransactionInfo getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionInfo transaction) {
        this.transaction = transaction;
    }

    public AcquirerInfo getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(AcquirerInfo acquirer) {
        this.acquirer = acquirer;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }
}