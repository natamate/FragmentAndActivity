package com.example.natalia.activityandfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView emailDetail, subjectDetail, messageDetail;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        emailDetail = (TextView) view.findViewById(R.id.emailDetail);
        subjectDetail = (TextView) view.findViewById(R.id.subjectDetail);
        messageDetail = (TextView) view.findViewById(R.id.messageDetail);

        Bundle bundle = getArguments();
        if(bundle != null){
           setTextIfExist(bundle);
        }
        return view;
    }


    private void setTextIfExist(Bundle bundle){
        if (bundle.getString(MainActivity.EMAIL_EXTRA) != null){
            emailDetail.setText(bundle.getString(MainActivity.EMAIL_EXTRA));
        }

        if (bundle.getString(MainActivity.SUBJECT_EXTRA) != null){
            subjectDetail.setText(bundle.getString(MainActivity.SUBJECT_EXTRA));
        }

        if (bundle.getString(MainActivity.MESSAGE_EXTRA) != null){
            messageDetail.setText(bundle.getString(MainActivity.MESSAGE_EXTRA));
        }
    }

}
