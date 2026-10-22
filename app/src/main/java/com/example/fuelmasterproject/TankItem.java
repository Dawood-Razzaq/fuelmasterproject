package com.example.fuelmasterproject;

public class TankItem {
    public String name;
    public String volume;
    public int percent;
    public String status;
    public String statusType;

    public TankItem(String name, String volume, int percent, String status, String statusType) {
        this.name = name;
        this.volume = volume;
        this.percent = percent;
        this.status = status;
        this.statusType = statusType;
    }
}
