package com.example.apicall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {
    private final ArrayList<TempClass> arrClassObjs;
    private final Context context;

    public CustomAdapter(Context context, ArrayList<TempClass> arrClassObjs) {
        this.arrClassObjs = arrClassObjs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.arrClassObjs.size();
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

        TextView etFirstName, etLastName;

        View llView = View.inflate(context, R.layout.custom_listview, null);

        etFirstName = llView.findViewById(R.id.tvFirstName);
        etLastName = llView.findViewById(R.id.tvLastName);

        etFirstName.setText(arrClassObjs.get(position).getFirstName());
        etLastName.setText(arrClassObjs.get(position).getLastName());

        return llView;
    }
}
