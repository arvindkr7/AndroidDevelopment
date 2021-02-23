package com.example.tms;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Calendar;

public class TaskAdapter extends BaseAdapter {

    Activity myActivity;
    MyTasks myTasks;




    public TaskAdapter(Activity myActivity, MyTasks myTasks) {
        this.myActivity = myActivity;
        this.myTasks = myTasks;
    }

    @Override
    public int getCount() {
        // no. of elements in task list
        return myTasks.getMyTasksList().size();
    }

    @Override
    public TaskModel getItem(int i) {
        // might need to change the return type to TaskModel
        // get item at index i when clicking
        return myTasks.getMyTasksList().get(i);
    }

    @Override
    public long getItemId(int i) {
        // optional method

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // most important, this will return the required values for singleTask layout
        View SingleTask;
        LayoutInflater inflater = (LayoutInflater) myActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        SingleTask = inflater.inflate(R.layout.singletask, viewGroup, false);

        TextView tvTaskName =SingleTask.findViewById(R.id.tv_singleTaskName);
        TextView tvTaskDateTime= SingleTask.findViewById(R.id.tv_singleTaskDateTime);

        TaskModel t = (TaskModel)this.getItem(i);

        tvTaskName.setText(t.getName());
        tvTaskDateTime.setText(getDateTime(t));


        return SingleTask;
    }

    public CharSequence getDateTime(TaskModel t){
        int year = t.getYear();
        int month = t.getMonth();
        int date = t.getDate();
        int hr = t.getHr();
        int mint = t.getMint();

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, date);
        c.set(Calendar.HOUR, hr);
        c.set(Calendar.MINUTE, mint);

        CharSequence dateTime = DateFormat.format("hh:mm a - E dd MMM", c);
        return dateTime;

    }
}
