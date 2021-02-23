package com.example.tms;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyTasks {
    List<TaskModel> myTasksList;
    public MyTasks(List<TaskModel> myTasksList){
        this.myTasksList = myTasksList;
    }
    public MyTasks(){
        String[] taskNames= {"Physics", "Chemistry"};
        int[] year={2021, 2021};
        int[] month={1,2};
        int[] date={22,23};
        int[] hr ={9,10};
        int[] mint={15, 25};

        this.myTasksList = new ArrayList<>();
        for (int i=0; i<taskNames.length; i++){
            TaskModel t= new TaskModel(taskNames[i], year[i],month[i], date[i], hr[i], mint[i] );
            myTasksList.add(t);
        }
    }

    public List<TaskModel> getMyTasksList() {
        return myTasksList;
    }

    public void setMyTasksList(List<TaskModel> myTasksList) {
        this.myTasksList = myTasksList;
    }
}
