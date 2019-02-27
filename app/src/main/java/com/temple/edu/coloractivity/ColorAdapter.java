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
    String[] colorList;
    String[] displayList;

    public ColorAdapter(Context c, String[] colorList, String[] displayList) {
        this.c = c;
        this.colorList = colorList;
        this.displayList = displayList;
    }

    @Override
    public int getCount() {
        return colorList.length;
    }

    @Override
    public Object getItem(int position) {
        return colorList[position];
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

        String setColorText = displayList[position];
        String setColorBG = colorList[position];


        view.setText(setColorText);
        view.setBackgroundColor(Color.parseColor(setColorBG));

        return view;
    }
}
