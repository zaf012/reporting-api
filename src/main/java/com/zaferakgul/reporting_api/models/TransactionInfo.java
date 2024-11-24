package com.zaferakgul.reporting_api.models;

import com.zaferakgul.reporting_api.enums.TransactionStatus;

public class TransactionInfo {
    private String referenceNo;
    private TransactionStatus status;
    private String operation;
    private String message;
    private String createdAt;
    private String transactionId;

    public TransactionInfo() {
    }

    public TransactionInfo(String referenceNo, TransactionStatus status, String operation, String message, String createdAt, String transactionId) {
        this.referenceNo = referenceNo;
        this.status = status;
        this.operation = operation;
        this.message = message;
        this.createdAt = createdAt;
        this.transactionId = transactionId;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}