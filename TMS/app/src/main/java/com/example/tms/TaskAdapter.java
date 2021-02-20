package com.example.tms;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

        TextView tvSubName =SingleTask.findViewById(R.id.tv_singleTaskSubjectName);
        TextView tvTaskTime= SingleTask.findViewById(R.id.tv_singleTaskTime);
        TextView tvTaskDay = SingleTask.findViewById(R.id.tv_singleTaskDayName);
        TextView tvTaskDate = SingleTask.findViewById(R.id.tv_singleTaskDate);

        TaskModel t = (TaskModel)this.getItem(i);

        tvSubName.setText(t.getSubName());
        tvTaskTime.setText(t.getTaskTime());
        tvTaskDay.setText(t.getTaskDay());
        tvTaskDate.setText(t.getTaskDate());

        return SingleTask;
    }
}
