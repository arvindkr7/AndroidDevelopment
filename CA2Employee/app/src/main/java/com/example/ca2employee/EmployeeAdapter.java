package com.example.ca2employee;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {

    // initialize required variables
    private final Context context;
    private final List<EmployeeModel> employeesList;

    public EmployeeAdapter(Activity context, MyEmployees myEmployees) {
        this.context = context;
        this.employeesList = myEmployees.getMyEmployeesList();
    }

    @Override
    public int getCount() {
        // no. of employees in the list
        return employeesList.size();
    }

    @Override
    public EmployeeModel getItem(int i) {

        // get item at index i
        return employeesList.get(i);
    }

    @Override
    public long getItemId(int i) {

        // optional method generally returns null
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // most important this will return the required values for single employee

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.employee_card_layout, viewGroup, false);

        // now getting the required views of employee card layout
        ImageView image = view.findViewById(R.id.iv_image_ecLayout);
        TextView tvName = view.findViewById(R.id.tv_name_ecLayout);
        TextView tvJobTitle = view.findViewById(R.id.tv_jobTitle_ecLayout);

        // get details of employee at current index i
        EmployeeModel employee = (EmployeeModel)this.getItem(i);

        // now set those values to views

        image.setImageResource(employee.getImage());
        tvName.setText(employee.getName());
        tvJobTitle.setText(employee.getJobTitle());



        return view;
    }
}
