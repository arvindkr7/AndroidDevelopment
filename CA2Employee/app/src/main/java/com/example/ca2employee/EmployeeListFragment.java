package com.example.ca2employee;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.security.identity.ResultData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeListFragment extends Fragment {

    public static FragmentManager fragmentManager;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;

    CircleImageView imageView;
    RecyclerView recyclerView;
    SearchView searchView;
    ImageButton btnAddEmployee;
    List<EmployeeModel> employeesList = new ArrayList<>();

    MyEmployees myEmployees;

    EmployeeModel employeeModel;

    LinearLayoutManager linearLayoutManager;

    EmployeeAdapter employeeAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmployeeListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeListFragment newInstance(String param1, String param2) {
        EmployeeListFragment fragment = new EmployeeListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        myEmployees = ((MyApplication)getActivity().getApplication()).getMyEmployees();

        employeesList = myEmployees.getMyEmployeesList();
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_employee_list, container, false);


        // initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(getContext());

        // initialize recyclerview
        recyclerView = v.findViewById(R.id.rv_fl_List);



        // set layout manager
        recyclerView.setLayoutManager(linearLayoutManager);


        // initialize


        // adding two more objects into the collection


        //EmployeeModel e1 = new EmployeeModel(R.drawable.ic_launcher_background, "Arvind","ceo");
        //employeesList.add(e1);

        //EmployeeModel e2 = new EmployeeModel(R.drawable.ic_launcher_foreground, "kumar","md");
        //employeesList.add(e2);

        //employeesList = myEmployees.getMyEmployeesList();

        // initialize adapter

        employeeAdapter = new EmployeeAdapter(getContext(), employeesList);



        // set adapter

        recyclerView.setAdapter(employeeAdapter);

        searchView = v.findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                employeeAdapter.getFilter().filter(newText);
                return false;
            }
        });

        // implementing functions for adding employee

        btnAddEmployee = v.findViewById(R.id.btn_addEmployee);
        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addEmployeeDialog();


            }
        });





        return v;
    }

    public void addEmployeeDialog(){
        EditText etName;
        EditText etJobTitle;
        //CircleImageView imageView;

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());


        View view = getActivity().getLayoutInflater().inflate(R.layout.layout_dialog, null);

        // get the widgets
        etName = view.findViewById(R.id.et_name_ld);
        etJobTitle = view.findViewById(R.id.et_jobTitle_ld);
        imageView = view.findViewById(R.id.iv_image_ld);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImage();
            }
        });


        builder.setView(view);
        builder.setTitle("Add an Employee");

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                int image = R.drawable.ic_photo_camera_back;
                String name = etName.getText().toString().trim();
                String jobTitle = etJobTitle.getText().toString().trim();

                // passing values to another function for saving into list and acknowledge the adapter
                applyValues(image, name, jobTitle);

                Toast.makeText(getContext(), "Details received "+name+" "+jobTitle, Toast.LENGTH_SHORT).show();
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.show();



    }

    public void applyValues(int photo, String name, String jobTitle) {
        EmployeeModel e;

        if (imageUri!=null){
            e = new EmployeeModel(imageUri, name,jobTitle);
        }else{
            e = new EmployeeModel(photo, name,jobTitle);
        }

        employeesList.add(e);

        employeeAdapter.notifyItemInserted(employeesList.size()-1); // acknowledge to adapter new data inserted
        Toast.makeText(getActivity(), "Added successfully", Toast.LENGTH_SHORT).show();

    }



    public void pickImage(){

        Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
        gallery.setType("image/*");

        //gallery.setAction(Intent.ACTION_GET_CONTENT);

       // startActivityForResult(gallery, PICK_IMAGE);

        startActivityForResult(Intent.createChooser(gallery, "Select Profile Picture"), PICK_IMAGE);


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PICK_IMAGE){
            imageUri = data.getData();

            imageView.setImageURI(imageUri);
            //Toast.makeText(getContext(), "imageUri "+imageUri.toString(), Toast.LENGTH_SHORT).show();
        }


        /*
        if (requestCode==PICK_IMAGE && resultCode == ResultData.STATUS_OK && data !=null && data.getData() !=null){
            imageUri = data.getData();
            try {
                //Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                Bundle bundle = data.getExtras();
                Bitmap imageBitmap = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(imageBitmap);

            } catch (Exception e){
                e.printStackTrace();
            }
        }

         */

    }





}