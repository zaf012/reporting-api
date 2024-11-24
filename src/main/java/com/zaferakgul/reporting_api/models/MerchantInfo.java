package com.zaferakgul.reporting_api.models;

public class MerchantInfo {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MerchantInfo() {
    }

    public MerchantInfo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}