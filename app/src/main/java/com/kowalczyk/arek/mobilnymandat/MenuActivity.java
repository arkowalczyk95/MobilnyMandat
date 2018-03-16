package com.kowalczyk.arek.mobilnymandat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    static List<Fine> fines = new ArrayList<Fine>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final int id = intent.getIntExtra("id", -1);
        final String station = intent.getStringExtra("station");
        final String username = intent.getStringExtra("username");

        final String fname = intent.getStringExtra("fname");
        final int pesel = intent.getIntExtra("pesel", -1);
        final String father = intent.getStringExtra("father");
        final String doc = intent.getStringExtra("doc");
        final String add = intent.getStringExtra("add");
        final String base = intent.getStringExtra("base");
        final String crime = intent.getStringExtra("crime");
        final int price = intent.getIntExtra("price", -1);


        final Button bFine = (Button) findViewById(R.id.buFine);
        bFine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent fineIntent = new Intent(MenuActivity.this, FineActivity.class);
                MenuActivity.this.startActivity(fineIntent);
            }
        });

        final Button bBase = (Button) findViewById(R.id.bBase);
        bBase.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent baseIntent = new Intent(MenuActivity.this, BaseActivity.class);
                baseIntent.putExtra("fname", fname);
                baseIntent.putExtra("pesel", pesel);
                baseIntent.putExtra("father", father);
                baseIntent.putExtra("doc", doc);
                baseIntent.putExtra("add", add);
                baseIntent.putExtra("base", base);
                baseIntent.putExtra("crime", crime);
                baseIntent.putExtra("price", price);
                MenuActivity.this.startActivity(baseIntent);
            }
        });

        final Button bUser = (Button) findViewById(R.id.bUser);
        bUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent userIntent = new Intent(MenuActivity.this, UserActivity.class);
                userIntent.putExtra("name", name);
                userIntent.putExtra("id", id);
                userIntent.putExtra("station", station);
                userIntent.putExtra("username", username);
                MenuActivity.this.startActivity(userIntent);
            }
        });

        final Button bLog = (Button) findViewById(R.id.bLog);
        bLog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent logIntent = new Intent(MenuActivity.this, LoginActivity.class);
                MenuActivity.this.startActivity(logIntent);
            }
        });
    }
}
