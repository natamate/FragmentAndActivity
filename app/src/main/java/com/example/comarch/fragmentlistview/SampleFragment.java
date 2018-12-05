package com.example.comarch.fragmentlistview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends Fragment {


    public SampleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        ArrayList<String> data = new ArrayList<>();
        data.add("Message 1");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_list_item_1,
                data
        );

        ListView lvData = view.findViewById(R.id.lvData);
        lvData.setAdapter(arrayAdapter);
        return view;
    }

}
