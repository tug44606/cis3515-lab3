package com.temple.edu.coloractivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        setTitle("Canvas Activity");

        final ConstraintLayout constraintLayout = findViewById(R.id.canvasLayout);


        constraintLayout.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("color")));
    }
}
