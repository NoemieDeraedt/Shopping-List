package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ShoppingList extends AppCompatActivity {

    public ArrayList<ListItem> userItems = new ArrayList<>();
    public ArrayList<ListItem> allItems = new ArrayList<>();
    public ArrayList<ListItem> listToDisplay = new ArrayList<>();
    public ListView listView;
    public CustomListAdapter adapter;
    public TextView itemTitle;
    public TextView totalView;
    public Double total = 0.0;
    public EditText searchBar;

    public void seeUserList() {
        adapter.clear();
        for (int i = 0; i < userItems.size(); i++)
            adapter.add(userItems.get(i));
        listView.setAdapter(adapter);
        itemTitle.setText("My items");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        Intent intent = getIntent();
        String username = (String) intent.getStringExtra("username");
        TextView usernameView = (TextView) findViewById(R.id.usernameView);

        usernameView.setText("Hello " + String.valueOf(username) + "!");

        allItems.add(new ListItem("Butter", 3, false));
        allItems.add(new ListItem("Milk", 3, false));
        allItems.add(new ListItem("Pasta", 0.59, false));
        allItems.add(new ListItem("Orange Juice", 3, false));
        allItems.add(new ListItem("Cheese", 3, false));

        listView = (ListView)findViewById(R.id.list_view);
        adapter = new CustomListAdapter(ShoppingList.this, R.layout.list_item_layout, listToDisplay);

        itemTitle = (TextView)findViewById(R.id.pageTitle);
        totalView = (TextView)findViewById(R.id.total);

        searchBar = findViewById(R.id.searchBar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itemTitle.setText("Searching items...");

                adapter.clear();
                if (s.toString().length() == 0) {
                    seeUserList();
                } else {
                    for (int i = 0; i < allItems.size() && s.toString().length() != 0; i++) {
                        if (allItems.get(i).name.toLowerCase(Locale.ROOT).contains(s.toString().toLowerCase(Locale.ROOT)))
                            adapter.add(allItems.get(i));
                    }
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        if (searchBar.length() == 0)
            seeUserList();
    }

    public void onClickCheckBox(View view) {
        ListItem tag = (ListItem) view.getTag();
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            if (!userItems.contains(tag)) {
                userItems.add(new ListItem(tag.name, tag.price, true));
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Item added!",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        } else {
            userItems.remove(tag);
            if (!itemTitle.getText().toString().equals("Searching items..."))
                seeUserList();
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Item removed!",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        calculateTotal();
    }

    public void calculateTotal() {
        total = 0.0;
        for (int i = 0; i < userItems.size(); i++)
            total += userItems.get(i).price;
        totalView.setText(String.valueOf(total) + "€");
    }

    public void onClickValidate(View view) {
        Intent intent = new Intent(this, Payment.class);

        intent.putExtra("total", total);
        intent.putExtra("number", userItems.size());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shopping_menu, menu);
        return true;
    }

    public void onClearItems(MenuItem item) {
        userItems.clear();
        calculateTotal();
        seeUserList();
        searchBar.setText("");
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void onClickDisconnect(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}