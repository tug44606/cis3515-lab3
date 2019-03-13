package com.temple.edu.coloractivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PalleteFragment extends Fragment {
    OnColorSelectedListener c;
    private Spinner spinner;


    public PalleteFragment(){

    }

    // Required method that container needs to implement
    public interface OnColorSelectedListener{
        void selectColor(int position);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate view
        View v = inflater.inflate(R.layout.pallete_fragment,container,false);

        Resources res = getResources();
        // Color background to display
        String[] colorList = res.getStringArray(R.array.colorList);
        // Color text to display
        String[] displayList = res.getStringArray(R.array.displayList);

        // get Spinner
        spinner = v.findViewById(R.id.spinner);

        // create Adapter and set to spinner
        ColorAdapter adapter = new ColorAdapter(PalleteFragment.super.getContext(), colorList, displayList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // set background color
                c.selectColor(i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnColorSelectedListener) {
            c = (OnColorSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnColorSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        c = null;
    }

}
