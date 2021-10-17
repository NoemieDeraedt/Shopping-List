package com.example.firebaseapplication;

import java.io.Serializable;

public class ListItem implements Serializable {
    String name;
    double price;
    boolean checked;

    public ListItem(String newName, double newPrice, boolean newChecked) {
        name = newName;
        price = newPrice;
        checked = newChecked;
    }
}
