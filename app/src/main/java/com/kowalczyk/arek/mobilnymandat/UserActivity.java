package com.kowalczyk.arek.mobilnymandat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final int id = intent.getIntExtra("id", -1);
        final String station = intent.getStringExtra("station");
        final String username = intent.getStringExtra("username");

        EditText uName = (EditText) findViewById(R.id.uName);
        EditText uId = (EditText) findViewById(R.id.uId);
        EditText uStation = (EditText) findViewById(R.id.uStation);
        EditText uUsername = (EditText) findViewById(R.id.uUsername);

        Button button = (Button) findViewById(R.id.button);

        uName.setText(name);
        uId.setText(id + "");
        uStation.setText(station);
        uUsername.setText(username);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(UserActivity.this, MenuActivity.class);
                UserActivity.this.startActivity(menuIntent);
            }
        });
    }
}
