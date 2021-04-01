package com.example.ca2employee;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {


    // initialize required variables
    //private final Context context;
    private final List<EmployeeModel> employeeList;



    // generate constructor
    public EmployeeAdapter(List<EmployeeModel> employeeModelArrayList) {
        //this.context = context;
        this.employeeList = employeeModelArrayList;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // initialize view

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_card_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EmployeeModel employeeModel = employeeList.get(position);

        // set image on image view
        holder.imageView.setImageResource(employeeModel.getImage());
        holder.tvName.setText(employeeModel.getName());
        holder.tvJobTitle.setText(employeeModel.getJobTitle());


    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }


    // this class is being extended as RecyclerView.Adapter<EmployeeAdapter.ViewHolder>

    class ViewHolder extends RecyclerView.ViewHolder {


        // initialize required views for the card view
        ImageView imageView;
        TextView tvName, tvJobTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // connect widgets to the actual IDs to communicate with them

            imageView = itemView.findViewById(R.id.iv_image_ecLayout);
            tvName = itemView.findViewById(R.id.tv_name_ecLayout);
            tvJobTitle = itemView.findViewById(R.id.tv_jobTitle_ecLayout);

        }

    }


}