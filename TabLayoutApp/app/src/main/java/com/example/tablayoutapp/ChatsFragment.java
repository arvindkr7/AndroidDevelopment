package com.example.tablayoutapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ChatsFragment extends Fragment {


    public static ChatsFragment getInstance(){
        ChatsFragment chatsFragment = new ChatsFragment();
        return chatsFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public ChatsFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View chatsView = inflater.inflate(R.layout.fragment_chats, container, false);




        return chatsView;
        //return inflater.inflate(R.layout.fragment_chats, container, false);
    }
}