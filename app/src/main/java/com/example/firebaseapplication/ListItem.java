package com.example.firebaseapplication;

public class ListItem {
    String name;
    double price;
    boolean checked;

    public ListItem(String newName, double newPrice, boolean newChecked) {
        name = newName;
        price = newPrice;
        checked = newChecked;
    }
}
