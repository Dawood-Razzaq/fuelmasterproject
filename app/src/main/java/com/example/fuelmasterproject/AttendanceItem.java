package com.example.fuelmasterproject;

public class AttendanceItem {
    public String name;
    public String initials;
    public String times;
    public String status;
    public String statusType;

    public AttendanceItem(String name, String initials, String times, String status, String statusType) {
        this.name = name;
        this.initials = initials;
        this.times = times;
        this.status = status;
        this.statusType = statusType;
    }
}
