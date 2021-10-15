package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSignInButton(View v) {
        Intent i = new Intent(this, ShoppingList.class);
        startActivity(i);
    }

    public void onClickRegisterButton(View v) {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }
}