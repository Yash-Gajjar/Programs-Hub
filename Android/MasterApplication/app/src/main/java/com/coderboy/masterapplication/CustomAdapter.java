package com.coderboy.masterapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private final ArrayList<People> people;
    private final Context context;

    public CustomAdapter(Context context, ArrayList<People> people) {
        this.people = people ;
        this.context = context ;
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tvFirstName, tvLastName ;

        View llView = View.inflate(context, R.layout.double_names_layout, null);

        tvFirstName = llView.findViewById(R.id.tvListViewFirstName);
        tvLastName = llView.findViewById(R.id.tvListViewLastName);

        tvFirstName.setText(people.get(position).getFirstName());
        tvLastName.setText(people.get(position).getLastName());

        return llView;
    }
}
