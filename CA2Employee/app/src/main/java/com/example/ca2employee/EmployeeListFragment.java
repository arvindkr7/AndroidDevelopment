package com.example.ca2employee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeListFragment extends Fragment {

    EditText editText;
    Button button;

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
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_employee_list, container, false);

        editText = v.findViewById(R.id.et_name_fl_list);
        button = v.findViewById(R.id.btn_submit_fl_list);


        button.setOnClickListener(view -> {

            // now we send data from this fragment to second

// NOTE : Intent can't be used here. Intent can be used only with Activity not suitable with Fragment
            Bundle bundle = new Bundle();


            bundle.putString("name", editText.getText().toString());

            // similarly, you can send other data types such as
             //bundle.putBoolean("isPresent", true);
             //bundle.putFloat("salary", 1234.5f);
            // bundle.putInt("image", R.drawable.ic_launcher_background);

             // so, these value along with can be send

            EmployeeDetailsFragment detailsFragment = new EmployeeDetailsFragment();
            detailsFragment.setArguments(bundle);

            // okay, now get this details on new fragment. that is detail

            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().replace(R.id.fl_main, detailsFragment).commit();

        });

        return v;
    }
}