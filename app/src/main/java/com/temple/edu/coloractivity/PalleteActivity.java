package com.temple.edu.coloractivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class PalleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pallete Activity");

        final ConstraintLayout constraintLayout = findViewById(R.id.layout);

        Spinner spinner = findViewById(R.id.spinner);

        final List<String> colorList = Arrays.asList("white", "blue", "red", "green", "yellow", "magenta", "purple", "teal", "cyan", "darkgray");

        final ColorAdapter colorAdapter = new ColorAdapter(this, colorList);

        spinner.setAdapter(colorAdapter);
        spinner.setSelection(0, false);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("Position: " + position);

                //create intent
                Intent intent = new Intent(PalleteActivity.this, CanvasActivity.class);

                // define intent
                intent.putExtra("color",  colorList.get(position));

                // start activity
                startActivity(intent);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
