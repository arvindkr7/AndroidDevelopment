package com.example.ca2employee;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeDetailsFragment extends Fragment {

    TextView tvName, tvJobTitle;
    de.hdodenhof.circleimageview.CircleImageView imageView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmployeeDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeDetailsFragment newInstance(String param1, String param2) {
        EmployeeDetailsFragment fragment = new EmployeeDetailsFragment();
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
        View v =  inflater.inflate(R.layout.fragment_employee_details, container, false);

        tvName = v.findViewById(R.id.tv_name_fl_details);
        tvJobTitle = v.findViewById(R.id.tv_jobTitle_fl_details);
        imageView = v.findViewById(R.id.iv_image_fl_details);

        Bundle bundle = this.getArguments();
        if (bundle!=null){
            String name = bundle.getString("name");

            String jobTitle = bundle.getString("jobTitle");
            int image = bundle.getInt("image");
            Uri imageUri = (Uri) bundle.getParcelable("imageUri");

            tvName.setText(name);
            tvJobTitle.setText(jobTitle);

            if (imageUri!=null){
                imageView.setImageURI(imageUri);
            }else{
                imageView.setImageResource(image);
            }


        }else {
            tvName.setText("Sorry, I don't know what's ur name");
        }




    return v;
    }
}