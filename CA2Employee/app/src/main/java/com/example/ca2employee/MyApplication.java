package com.example.ca2employee;

import android.app.Application;

public class MyApplication extends Application {
    private MyEmployees myEmployees = new MyEmployees();

    public MyEmployees getMyEmployees() {
        return myEmployees;
    }

    public void setMyEmployees(MyEmployees myEmployees) {
        this.myEmployees = myEmployees;
    }
}
