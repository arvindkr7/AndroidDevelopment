package com.example.ca2employee;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> implements Filterable {

    public static FragmentManager fragmentManager;


    // initialize required variables
    private final Context context;
    private final List<EmployeeModel> employeeList;
    ArrayList<EmployeeModel> backup;



    // generate constructor
    public EmployeeAdapter(Context context, List<EmployeeModel> employeeModelArrayList) {
        this.context = context;
        this.employeeList = employeeModelArrayList;
        this.backup = new ArrayList<>(employeeModelArrayList);
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
        if (employeeModel.getImageUri()!=null){
            holder.imageView.setImageURI(employeeModel.getImageUri());
        }else{
        holder.imageView.setImageResource(employeeModel.getImage());}


        holder.tvName.setText(employeeModel.getName());
        holder.tvJobTitle.setText(employeeModel.getJobTitle());


        // set on click listener on edit button

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  create dialog alert
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());

                View dialogView =LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.custom_dialog, null);
                ImageButton btnClose;
                de.hdodenhof.circleimageview.CircleImageView imageView;
                EditText tvName, tvJobTitle;

                btnClose = dialogView.findViewById(R.id.btn_close_cd);
                imageView = dialogView.findViewById(R.id.iv_image_cd);
                tvName = dialogView.findViewById(R.id.et_name_cd);
                tvJobTitle = dialogView.findViewById(R.id.et_jobTitle_cd);


                if (employeeModel.getImageUri()!=null){
                    imageView.setImageURI(employeeModel.getImageUri());
                }else{
                    imageView.setImageResource(employeeModel.getImage());
                }

                tvName.setText(employeeModel.getName());
                tvJobTitle.setText(employeeModel.getJobTitle());


                builder.setView(dialogView)
                        .setCancelable(true)
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                            }
                        });
                //builder.show();

                final AlertDialog show = builder.show();

                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        show.dismiss();
                        Toast.makeText(context.getApplicationContext(), "Cancelled!", Toast.LENGTH_SHORT).show();

                    }
                });





            }
        });


        // set click listener on
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {

            // get the position which data to be removed from adapter
            int position1 = holder.getAdapterPosition();


            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                View dialogView =LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.delete_dialog, null);
                de.hdodenhof.circleimageview.CircleImageView imageView;
                TextView tvName, tvJobTitle;

                imageView = dialogView.findViewById(R.id.iv_image_dd);
                tvName = dialogView.findViewById(R.id.tv_name_dd);
                tvJobTitle = dialogView.findViewById(R.id.tv_jobTitle_dd);


                if (employeeModel.getImageUri()!=null){
                    imageView.setImageURI(employeeModel.getImageUri());
                }else{
                    imageView.setImageResource(employeeModel.getImage());
                }

                tvName.setText(employeeModel.getName());
                tvJobTitle.setText(employeeModel.getJobTitle());


                builder.setView(dialogView);

                builder.setTitle("Are you sure want to delete")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "Not deleted!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                EmployeeModel employee = employeeList.get(position1);
                                // remove that element from the adapter showing in list
                                employeeList.remove(position1);

                                // notify adapter which position removed
                                notifyItemRemoved(position1);
                                notifyItemRangeChanged(position1, employeeList.size());

                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

            }
        });




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
        ImageButton btnEdit, btnDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // connect widgets to the actual IDs to communicate with them

            imageView = itemView.findViewById(R.id.iv_image_ecLayout);
            tvName = itemView.findViewById(R.id.tv_name_ecLayout);
            tvJobTitle = itemView.findViewById(R.id.tv_jobTitle_ecLayout);
            btnEdit = itemView.findViewById(R.id.btn_edit_ecLayout);
            btnDelete = itemView.findViewById(R.id.btn_delete_ecLayout);


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
            bundle.putParcelable("imageUri", e.getImageUri());



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

    // implementing Filterable method here
    @Override
    public Filter getFilter() {
        // now create internal class of Filter type
        return filter;
    }

    // filter result works through background thread or can say child thread
    // backend thread
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {

            // create a temporary arrayList of EmployeeModel type for storing or modifying records
            ArrayList<EmployeeModel> filteredList= new ArrayList<>();

            // when no character, return the original list itself
            if (keyword.toString().isEmpty()) filteredList.addAll(backup);
            else {

                // searching result only on employee name
                for (EmployeeModel emp:backup){
                    if (emp.getName().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filteredList.add(emp);

                }
            }

            // make an object of FilterResults type then pass to publishResult for final updating

            FilterResults results = new FilterResults();
            results.values = filteredList;


            return results;
        }

        // publishing results work through main thread (frontend thread)

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            // the data comes to results parameter

            // 1. clear the existing data of original arraylist
            // 2. now, push the received results into original list

            employeeList.clear();

            // typecast required to that of original list
            employeeList.addAll((ArrayList<EmployeeModel>)results.values);
            notifyDataSetChanged(); // acknowledgement to main thread to take next action

        }
    };  // getFilter function ends here




}