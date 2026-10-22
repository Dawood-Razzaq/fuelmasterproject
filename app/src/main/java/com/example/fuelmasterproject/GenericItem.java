package com.example.fuelmasterproject;

public class GenericItem {
    public String title;
    public String subtitle;
    public String chipText;
    public String chipType;
    public int iconResId;

    public GenericItem(String title, String subtitle, String chipText, String chipType, int iconResId) {
        this.title = title;
        this.subtitle = subtitle;
        this.chipText = chipText;
        this.chipType = chipType;
        this.iconResId = iconResId;
    }
}
