package com.example.firebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ShoppingList extends AppCompatActivity {

    public ArrayList<ListItem> userItems = new ArrayList<>();
    public ArrayList<ListItem> allItems = new ArrayList<>();

    public void seeUserList(CustomListAdapter adapter, ListView listView, TextView itemTitle) {
        adapter.clear();
        adapter.add(allItems.get(0));
        adapter.add(allItems.get(2));
        adapter.add(allItems.get(4));
        listView.setAdapter(adapter);
        itemTitle.setText("My items");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        allItems.add(new ListItem("Butter", 3));
        allItems.add(new ListItem("Milk", 3));
        allItems.add(new ListItem("Pasta", 0.59));
        allItems.add(new ListItem("Orange Juice", 3));
        allItems.add(new ListItem("Cheese", 3));

        ArrayList<ListItem> listToDisplay = new ArrayList<>();
        ListView listView = (ListView)findViewById(R.id.list_view);
        CustomListAdapter adapter = new CustomListAdapter(ShoppingList.this, R.layout.list_item_layout, listToDisplay);

        TextView itemTitle = (TextView)findViewById(R.id.pageTitle);

        EditText text = findViewById(R.id.searchBar);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(null, s.toString());
                itemTitle.setText("Searching items...");

                adapter.clear();
                if (s.toString().length() == 0) {
                    seeUserList(adapter, listView, itemTitle);
                } else {
                    for (int i = 0; i < allItems.size() && s.toString().length() != 0; i++) {
                        if (allItems.get(i).name.toLowerCase(Locale.ROOT).contains(s.toString().toLowerCase(Locale.ROOT))) {
                            Log.i(null, allItems.get(i).name);
                            adapter.add(allItems.get(i));
                        }
                    }
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        if (text.length() == 0) {
            seeUserList(adapter, listView, itemTitle);
        }
    }

    public void onClickCheckBox(View view) {
        ListItem tag = (ListItem) view.getTag();
        boolean checked = ((CheckBox) view).isChecked();

        Log.i(null, tag.name + " " + checked);


    }
}