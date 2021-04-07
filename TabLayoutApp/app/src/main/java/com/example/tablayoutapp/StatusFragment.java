package com.example.tablayoutapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StatusFragment extends Fragment {


    // create getInstance
    public static StatusFragment getInstance(){
        StatusFragment statusFragment = new StatusFragment();
        return  statusFragment;
    }


    // override onAttach
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public StatusFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View statusView = inflater.inflate(R.layout.fragment_status, container, false);




        return statusView;
        // return inflater.inflate(R.layout.fragment_status, container, false);
    }
}