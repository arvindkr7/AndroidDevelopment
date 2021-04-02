package com.example.ca2employee;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    public static FragmentManager fragmentManager;


    // initialize required variables
    private final Context context;
    private final List<EmployeeModel> employeeList;



    // generate constructor
    public EmployeeAdapter(Context context, List<EmployeeModel> employeeModelArrayList) {
        this.context = context;
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        // initialize required views for the card view
        de.hdodenhof.circleimageview.CircleImageView imageView;
        TextView tvName, tvJobTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // connect widgets to the actual IDs to communicate with them

            imageView = itemView.findViewById(R.id.iv_image_ecLayout);
            tvName = itemView.findViewById(R.id.tv_name_ecLayout);
            tvJobTitle = itemView.findViewById(R.id.tv_jobTitle_ecLayout);


            // set on item click listener on each card what to happen

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {


            EmployeeModel e = employeeList.get(getAdapterPosition());


            // now send data from list fragment to details fragment

            // NOTE: Intent can't be used in case of fragment. Only Bundle works while passing data

            Bundle bundle = new Bundle();

            bundle.putString("name", e.getName());
            bundle.putString("jobTitle", e.getJobTitle());
            bundle.putInt("image", e.getImage());




            EmployeeDetailsFragment detailsFragment = new EmployeeDetailsFragment();
            detailsFragment.setArguments(bundle);

            // okay, now get this details on new fragment. that is detail

            fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();

                // Now get the object of second fragment where data to be sent and displayed
            fragmentManager.beginTransaction().replace(R.id.fl_main, detailsFragment, null).addToBackStack(null).commit();



            // just a toast for debugging

            //Toast.makeText(view.getContext(), e.getName() +" "+e.getJobTitle(), Toast.LENGTH_SHORT).show();

        }
    }


}