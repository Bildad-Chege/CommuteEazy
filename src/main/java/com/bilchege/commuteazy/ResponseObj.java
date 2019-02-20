package com.bilchege.commuteazy;

public class ResponseObj {

    private String operatorName;
    private String address;
    private double latitude;
    private double longitude;

    public ResponseObj() {
    }

    public ResponseObj(String operatorName, String address, double latitude, double longitude) {
        this.operatorName = operatorName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
