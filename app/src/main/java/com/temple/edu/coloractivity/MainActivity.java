package com.temple.edu.coloractivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements PalleteFragment.OnColorSelectedListener{
    private PalleteFragment pallete;
    private CanvasFragment canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Color Fragment Activity");

        pallete = new PalleteFragment();
        canvas = new CanvasFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.pallete_container, pallete)
                .replace(R.id.canvas_container, canvas)
                .commit();
    }

    @Override
    public void selectColor(int position) {
        Resources res = getResources();
        String[] colorList = res.getStringArray(R.array.colorList);
        Log.d("selectColor", colorList[position]);
        canvas.setBackgroundColor(colorList[position]);
    }
}
