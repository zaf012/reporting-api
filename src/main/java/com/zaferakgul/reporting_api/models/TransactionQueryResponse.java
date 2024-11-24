package com.zaferakgul.reporting_api.models;

import java.util.List;

public class TransactionQueryResponse {
    private Integer perPage;
    private Integer currentPage;
    private String nextPageUrl;
    private String prevPageUrl;
    private Integer from;
    private Integer to;
    private List<TransactionData> data;

    public TransactionQueryResponse() {
    }

    public TransactionQueryResponse(Integer perPage, Integer currentPage, String nextPageUrl, String prevPageUrl, Integer from, Integer to, List<TransactionData> data) {
        this.perPage = perPage;
        this.currentPage = currentPage;
        this.nextPageUrl = nextPageUrl;
        this.prevPageUrl = prevPageUrl;
        this.from = from;
        this.to = to;
        this.data = data;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public List<TransactionData> getData() {
        return data;
    }

    public void setData(List<TransactionData> data) {
        this.data = data;
    }
}