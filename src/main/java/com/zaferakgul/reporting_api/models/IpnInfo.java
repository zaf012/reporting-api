package com.zaferakgul.reporting_api.models;

public class IpnInfo {
    private Boolean received;

    public IpnInfo() {
    }

    public IpnInfo(Boolean received) {
        this.received = received;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }
}