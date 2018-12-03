package com.example.natalia.activityandfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final static String EMAIL_EXTRA = "EMAIL";
    public final static String SUBJECT_EXTRA = "SUBJECT";
    public final static String MESSAGE_EXTRA = "MESSAGE";

    private Button button;

    static ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
                openAddedActivity();

            }
        });

        SampleFragment sampleFragment = new SampleFragment();
        Bundle bundle = getBundleWithMessageDetails();
        sampleFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainLayout, sampleFragment).commit();

    }

    @NonNull
    private Bundle getBundleWithMessageDetails() {
        Bundle bundle = new Bundle();

        Intent intent = getIntent();
        String email = intent.getStringExtra(EMAIL_EXTRA);
        String subject = intent.getStringExtra(SUBJECT_EXTRA);
        String message = intent.getStringExtra(MESSAGE_EXTRA);

        bundle.putString(EMAIL_EXTRA, email);
        bundle.putString(SUBJECT_EXTRA, subject);
        bundle.putString(MESSAGE_EXTRA, message);
        return bundle;
    }

    public void openAddedActivity(){
        Intent intent = new Intent(this, AddedActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
