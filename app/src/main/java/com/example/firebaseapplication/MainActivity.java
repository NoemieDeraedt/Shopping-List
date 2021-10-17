package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSignInButton(View v) {
        username = (EditText)findViewById(R.id.username);

        if (username.getText().length() == 0) {

        } else {
            Intent i = new Intent(this, ShoppingList.class);
            i.putExtra("username", String.valueOf(username.getText()));
            startActivity(i);
        }
    }

    public void onClickRegisterButton(View v) {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }
}