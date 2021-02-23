package com.example.tms;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TaskAdapter extends BaseAdapter implements Filterable {

    Activity myActivity;
    MyTasks myTasks;
    List<TaskModel> filteredTasks;
    List<TaskModel> allTasks;



    public TaskAdapter(Activity myActivity, MyTasks myTasks) {
        this.myActivity = myActivity;
        this.myTasks = myTasks;
        this.filteredTasks = myTasks.getMyTasksList();
        this.allTasks = myTasks.getMyTasksList();

    }

    @Override
    public int getCount() {
        // no. of elements in task list
        return filteredTasks.size();
    }

    @Override
    public TaskModel getItem(int i) {
        // might need to change the return type to TaskModel
        // get item at index i when clicking
        return filteredTasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        // optional method
        // generally returns null
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

        c.set( year, month, date, hr, mint,0);

        CharSequence dateTime = DateFormat.format("hh:mm a - E dd MMM", c);
        return dateTime;

    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults results = new FilterResults();

                if (charSequence == null){
                    results.count = allTasks.size();
                    results.values = allTasks;

                }else {
                    String searchQuery = charSequence.toString().toLowerCase();
                    List<TaskModel> searchResult = new ArrayList<>();
                    for (TaskModel t: allTasks){
                      if (t.getName().contains(searchQuery)) {
                          searchResult.add(t);
                      }
                      results.count = searchResult.size();
                      results.values = searchResult;
                    }
                }


                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                    filteredTasks = (List<TaskModel>) results.values;
                    notifyDataSetChanged();
            }
        };
        return  filter;
    }
}
