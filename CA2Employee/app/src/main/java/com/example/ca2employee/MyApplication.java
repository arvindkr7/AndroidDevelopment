package com.example.ca2employee;

public class MyApplication {
    private MyEmployees myEmployees = new MyEmployees();

    public MyEmployees getMyEmployees() {
        return myEmployees;
    }

    public void setMyEmployees(MyEmployees myEmployees) {
        this.myEmployees = myEmployees;
    }
}
