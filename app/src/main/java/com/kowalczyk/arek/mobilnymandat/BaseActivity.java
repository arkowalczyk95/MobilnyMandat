package com.kowalczyk.arek.mobilnymandat;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.kowalczyk.arek.mobilnymandat.MenuActivity.fines;

public class BaseActivity extends AppCompatActivity {
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        lv = (ListView) findViewById(R.id.basList);
        List<String> list = new ArrayList<String>();

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list );

        ArrayList<Fine> myListItems  = new ArrayList<Fine>();

        final Intent intent = getIntent();
        final String fname = intent.getStringExtra("fname");
        final int pesel = intent.getIntExtra("pesel", -1);
        final String father = intent.getStringExtra("father");
        final String doc = intent.getStringExtra("doc");
        final String add = intent.getStringExtra("add");
        final String base = intent.getStringExtra("base");
        final String crime = intent.getStringExtra("crime");
        final int price = intent.getIntExtra("price", -1);

        Fine fine = null;
        try{
            fine = new Fine(fname, pesel, father, doc, add, base, crime, price);
        } catch (NumberFormatException n)   {
            AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
            builder.setMessage("Operacja nieudana!")
                    .setNegativeButton("Spróbuj ponownie!", null)
                    .create()
                    .show();
        }
        list.add(fine.toString());
        //myListItems.add(fine.getName(), fine.getPesel(), fine.getFather(), fine.getDoc(), fine.getAdd(), fine.getBase(), fine.getCrime(), fine.getPrice());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list );

        lv.setAdapter(arrayAdapter);
    }
}
