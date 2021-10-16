package com.example.firebaseapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<ListItem> {

    public CustomListAdapter(Context context, int resource, List<ListItem> listData) {
        super(context, resource, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItem item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.itemTitle);
        TextView price = (TextView) convertView.findViewById(R.id.itemPrice);
        title.setText(item.name);
        price.setText(Double.toString(item.price) + "€");
        return convertView;
    }
}
