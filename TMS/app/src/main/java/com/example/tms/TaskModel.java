package com.example.tms;

public class TaskModel {
    private  String subName;
    private String taskTime;
    private String taskDay;
    private String taskDate;

    public TaskModel(String subName, String taskTime, String taskDay, String taskDate) {
        this.subName = subName;
        this.taskTime = taskTime;
        this.taskDay = taskDay;
        this.taskDate = taskDate;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskDay() {
        return taskDay;
    }

    public void setTaskDay(String taskDay) {
        this.taskDay = taskDay;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
}
