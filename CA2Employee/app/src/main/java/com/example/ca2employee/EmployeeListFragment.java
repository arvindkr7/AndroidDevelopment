package com.example.ca2employee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeListFragment extends Fragment {

    RecyclerView recyclerView;
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


        EmployeeModel e1 = new EmployeeModel(R.drawable.ic_launcher_background, "Arvind","ceo");
        employeesList.add(e1);

        EmployeeModel e2 = new EmployeeModel(R.drawable.ic_launcher_foreground, "kumar","md");
        employeesList.add(e2);

        //employeesList = myEmployees.getMyEmployeesList();

        // initialize adapter

        employeeAdapter = new EmployeeAdapter(employeesList);



        // set adapter

        recyclerView.setAdapter(employeeAdapter);





        return v;
    }
}