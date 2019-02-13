package com.temple.edu.coloractivity;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout constraintLayout = findViewById(R.id.layout);
        Spinner spinner = findViewById(R.id.spinner);

        List colorList = Arrays.asList("white", "blue", "red", "green", "yellow", "magenta", "purple", "green", "cyan", "darkgray");

        final ColorAdapter colorAdapter = new ColorAdapter(this, colorList);

        spinner.setAdapter(colorAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Setting background color for spinner
                view.setBackgroundColor(Color.parseColor("white"));
                // Setting the background color
                constraintLayout.setBackgroundColor(Color.parseColor((String)colorAdapter.getItem(position)));
                // Output message
                Toast.makeText(ColorActivity.this, "Selection has been made!", Toast.LENGTH_LONG).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
