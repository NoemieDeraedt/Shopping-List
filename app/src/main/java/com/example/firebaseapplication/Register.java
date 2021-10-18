package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    public EditText username;
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onClickSignInButton(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void onClickRegisterButton(View v) {
        username = (EditText)findViewById(R.id.usernameRegister);
        password = (EditText)findViewById(R.id.passwordRegister);

        if (password.getText().length() < 6 && !password.getText().toString().contains(" ")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Your password needs to have more than 6 characters and no space.",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else if (username.getText().length() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Your username cannot be empty.",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else if (username.getText().length() < 6) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Your username need to have at least 6 characters.",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent i = new Intent(this, ShoppingList.class);
            i.putExtra("username", String.valueOf(username.getText()));
            startActivity(i);
        }
    }
}