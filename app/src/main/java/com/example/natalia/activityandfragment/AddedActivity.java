package com.example.natalia.activityandfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddedActivity extends AppCompatActivity {

    TextView email, subject, message;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added);
        email = (TextView) findViewById(R.id.e_mail);
        subject = (TextView) findViewById(R.id.subject);
        message = (TextView) findViewById(R.id.message);

        btnSend = (Button) findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMessageToList();
            }
        });
    }

    private void addMessageToList(){
        Intent intent = new Intent(this, MainActivity.class);
        String emailText = email.getText().toString();
        String subjectText = subject.getText().toString();
        String messageText = message.getText().toString();

        intent.putExtra(MainActivity.EMAIL_EXTRA, emailText);
        intent.putExtra(MainActivity.SUBJECT_EXTRA, subjectText);
        intent.putExtra(MainActivity.MESSAGE_EXTRA, messageText);

        startActivity(intent);
    }
}
