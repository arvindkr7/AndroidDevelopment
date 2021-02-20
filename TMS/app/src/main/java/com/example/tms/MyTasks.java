package com.example.tms;

import java.util.ArrayList;
import java.util.List;

public class MyTasks {
    List<TaskModel> myTasksList;
    public MyTasks(List<TaskModel> myTasksList){
        this.myTasksList = myTasksList;
    }
    public MyTasks(){
        String[] subNames={"Physics", "Chemistry", "Maths"};
        String[] taskTimes={"09:00", "10:00", "11:00"};
        String[] taskDays ={"Sat", "Sat", "Sat"};
        String[] taskDates ={"20 Feb", "21 Feb", "22 Feb"};
        this.myTasksList = new ArrayList<>();
        for (int i=0; i<subNames.length; i++){
            TaskModel t= new TaskModel(subNames[i], taskTimes[i], taskDays[i], taskDates[i]);
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
