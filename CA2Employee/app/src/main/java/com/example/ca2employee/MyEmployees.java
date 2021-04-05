package com.example.ca2employee;

import java.util.ArrayList;
import java.util.List;

public class MyEmployees {

    List<EmployeeModel> myEmployeesList;
    // generate constructor
    public MyEmployees(List<EmployeeModel> myEmployeesList) {
        this.myEmployeesList = myEmployeesList;
    }
    // default constructor for default values to display
    public MyEmployees(){
        int[] images = {R.drawable.arvind, R.drawable.autumhacks};
        String[] names = {"Arvind", "Kumar"};
        String[] jobTitles = {"CL", "MD"};

        this.myEmployeesList = new ArrayList<>();

        for (int i= 0; i<names.length; i++){
            EmployeeModel employeeModel = new EmployeeModel(images[i], names[i], jobTitles[i]);
            myEmployeesList.add(employeeModel);

        }

    }




    public List<EmployeeModel> getMyEmployeesList() {
        return myEmployeesList;
    }

    public void setMyEmployeesList(List<EmployeeModel> myEmployeesList) {
        this.myEmployeesList = myEmployeesList;
    }
}
