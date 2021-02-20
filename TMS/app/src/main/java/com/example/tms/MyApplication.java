package com.example.tms;

import android.app.Application;

public class MyApplication extends Application {

    private  MyTasks myTasks;

    public MyTasks getMyTasks() {
        return myTasks;
    }

    public void setMyTasks(MyTasks myTasks) {
        this.myTasks = myTasks;
    }
}
