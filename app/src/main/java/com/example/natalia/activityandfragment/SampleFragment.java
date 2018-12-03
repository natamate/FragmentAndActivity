package com.example.natalia.activityandfragment;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    final static ArrayList<EmailMessage> dataWithDetails = new ArrayList<>();
    final static ArrayList<String> data = new ArrayList<>();

    static{
        EmailMessage exampleMessage = new EmailMessage();
        exampleMessage.setMessage("Hello! It's example message");
        exampleMessage.setSubject("Example");
        exampleMessage.setEmail("test@test.com");
        dataWithDetails.add(exampleMessage);
        data.add(exampleMessage.getEmail());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sample, container, false);

        Bundle bundle = getArguments();
        addMessageToList(bundle);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, data);

        ListView lvData = (ListView) view.findViewById(R.id.lvData);

        lvData.setAdapter(adapter);

        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedData = data.get(position);
                DetailFragment detailFragment = new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString(MainActivity.EMAIL_EXTRA, selectedData);
                EmailMessage emailMessage = getDetailForEmail(selectedData);
                bundle.putString(MainActivity.SUBJECT_EXTRA, emailMessage.getSubject());
                bundle.putString(MainActivity.MESSAGE_EXTRA, emailMessage.getMessage());

                detailFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.detailLayout, detailFragment);
                transaction.addToBackStack(selectedData);
                transaction.commit();
                //fragmentManager.beginTransaction().replace(R.id.detailLayout, detailFragment).commit();
            }
        });
        return view;
    }

    private void addMessageToList(Bundle bundle) {
        if(bundle != null){

            EmailMessage emailMessage = new EmailMessage();
            if (bundle.getString(MainActivity.EMAIL_EXTRA) != null){
                emailMessage.setEmail(bundle.getString(MainActivity.EMAIL_EXTRA));
                data.add(emailMessage.getEmail());
            }
            if (bundle.getString(MainActivity.SUBJECT_EXTRA) != null){
                emailMessage.setSubject(bundle.getString(MainActivity.SUBJECT_EXTRA));
            }
            if (bundle.getString(MainActivity.MESSAGE_EXTRA) != null){
                emailMessage.setMessage(bundle.getString(MainActivity.MESSAGE_EXTRA));
            }
            dataWithDetails.add(emailMessage);
        }
    }


    private EmailMessage getDetailForEmail(String email){
        if (email == null){
            return new EmailMessage();
        }
        for (EmailMessage emailMessage : dataWithDetails){
            if (email.equals(emailMessage.getEmail())){
                return emailMessage;
            }
        }
        return new EmailMessage();
    }
}
