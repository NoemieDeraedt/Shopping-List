package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {

    public TextView totalView;
    public TextView nbItemsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        totalView = (TextView)findViewById(R.id.total_payment);
        nbItemsView = (TextView)findViewById(R.id.nb_items_payment);

        Intent intent = getIntent();
        Double total = (Double) intent.getDoubleExtra("total", 0);
        Integer number = (Integer) intent.getIntExtra("number", 0);

        totalView.setText(String.valueOf(total));
        nbItemsView.setText(String.valueOf(number));
    }
}