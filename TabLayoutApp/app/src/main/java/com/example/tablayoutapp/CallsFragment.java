package com.example.tablayoutapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CallsFragment extends Fragment {

    // create getInstance
    public static CallsFragment getInstance(){
        CallsFragment callsFragment = new CallsFragment();
        return callsFragment;
    }



    // override onAttach
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public CallsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View callsView = inflater.inflate(R.layout.fragment_calls, container, false);




        return callsView;
        //return inflater.inflate(R.layout.fragment_calls, container, false);
    }
}