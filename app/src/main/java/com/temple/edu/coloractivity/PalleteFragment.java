package com.temple.edu.coloractivity;

import android.support.v4.app.Fragment;

public class PalleteFragment extends Fragment {
    OnColorSelectedListener c;

    public PalleteFragment(){

    }

    // Required method that container needs to implement
    public interface OnColorSelectedListener{
        void selectColor(int position);
    }

}
