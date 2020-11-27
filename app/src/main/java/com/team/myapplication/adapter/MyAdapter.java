package com.team.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.team.myapplication.Constant;
import com.team.myapplication.R;

public class MyAdapter extends ArrayAdapter {
    Context context;
    public MyAdapter(Context context, int textViewResourceId,
                     String[] objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {

// Inflating the layout for the custom Spinner
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View layout = inflater.inflate(R.layout.item_spinner, parent, false);

// Declaring and Typecasting the textview in the inflated layout
        TextView nameTV =  layout
                .findViewById(R.id.nameTV);
        TextView costTV =  layout
                .findViewById(R.id.costTV);

        nameTV.setText(Constant.getShippingName()[position]);
        costTV.setText(Constant.getCost()[position]);
        return layout;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}