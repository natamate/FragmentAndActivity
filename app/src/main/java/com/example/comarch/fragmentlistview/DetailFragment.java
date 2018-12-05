package com.example.comarch.fragmentlistview;


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


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView textView = view.findViewById(R.id.tvDetail);

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getString(MainActivity.SELECTED_DATA_KEY) != null){
                textView.setText(bundle.getString(MainActivity.SELECTED_DATA_KEY));
            }
        }
        return view;
    }

}
