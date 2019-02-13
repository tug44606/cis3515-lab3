package com.temple.edu.coloractivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends BaseAdapter {
    Context c;
    List<String> colorList;

    public ColorAdapter(Context c, List<String> colorList) {
        this.c = c;
        this.colorList = colorList;
    }

    @Override
    public int getCount() {
        return colorList.size();
    }

    @Override
    public Object getItem(int position) {
        return colorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view;
        if(convertView instanceof TextView){
            view = (TextView) convertView;
        }
        else {
            view = new TextView(c);
        }

        String setColor = colorList.get(position);

        view.setText(setColor);
        view.setBackgroundColor(Color.parseColor(setColor));

        return view;
    }
}
