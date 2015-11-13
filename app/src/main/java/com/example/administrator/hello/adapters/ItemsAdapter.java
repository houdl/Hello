package com.example.administrator.hello.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.hello.R;
import com.example.administrator.hello.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends ArrayAdapter<Item> {
    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView home;
    }

    public ItemsAdapter(Context context, List<Item> items) {
        super(context, R.layout.item_list, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.item_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.name.setText(item.remoteId + "");
        // Return the completed view to render on screen

        return convertView;
    }
}