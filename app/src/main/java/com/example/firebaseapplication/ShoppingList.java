package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ShoppingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        ArrayList<ListItem> allItems = new ArrayList<>();
        allItems.add(new ListItem("Butter", 3));
        allItems.add(new ListItem("Milk", 3));
        allItems.add(new ListItem("Pasta", 0.59));
        allItems.add(new ListItem("Orange Juice", 3));
        allItems.add(new ListItem("Cheese", 3));

        ArrayList<ListItem> searchList = new ArrayList<>();
        ListView listView = (ListView)findViewById(R.id.list_view);
        CustomListAdapter adapter = new CustomListAdapter(ShoppingList.this, R.layout.list_item_layout, allItems);

        listView.setAdapter(adapter);

        EditText text = findViewById(R.id.searchBar);
//        text.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.i(null, s.toString());
//
//                ArrayList<ListItem> searchList = new ArrayList<>();
//                ListView listView = (ListView)findViewById(R.id.list_view);
//                CustomListAdapter adapter = new CustomListAdapter(ShoppingList.this, searchList);
//
//                for (int i = 0; i < allItems.size() && s.toString().length() != 0; i++) {
//                    if (allItems.get(i).name.toLowerCase(Locale.ROOT).contains(s.toString().toLowerCase(Locale.ROOT))) {
//                        Log.i(null, allItems.get(i).name);
//                        searchList.add(allItems.get(i));
//                        //Log.i(null, String.valueOf(adapter.getItem(0)));
//                    }
//                }
//                listView.setAdapter(adapter);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) { }
//        });
    }


}