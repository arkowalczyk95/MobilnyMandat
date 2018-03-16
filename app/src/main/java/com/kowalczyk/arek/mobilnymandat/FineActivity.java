package com.kowalczyk.arek.mobilnymandat;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.kowalczyk.arek.mobilnymandat.MenuActivity.fines;

public class FineActivity extends AppCompatActivity {

    public ArrayList<Fine> myListItems  = new ArrayList<Fine>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine);

        final EditText fTextName = (EditText) findViewById(R.id.fTextName);
        final EditText fPesel = (EditText) findViewById(R.id.fPesel);
        final EditText fFather = (EditText) findViewById(R.id.fFather);
        final EditText fDoc = (EditText) findViewById(R.id.fDoc);
        final EditText fAdd = (EditText) findViewById(R.id.fAdd);
        final EditText fBase = (EditText) findViewById(R.id.fBase);
        final EditText fCrime = (EditText) findViewById(R.id.fCrime);
        final EditText fPrice = (EditText) findViewById(R.id.fPrice);

        final Button buBack = (Button) findViewById(R.id.buBack);
        buBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent logIntent = new Intent(FineActivity.this, MenuActivity.class);
            FineActivity.this.startActivity(logIntent);
        }


    });
        final Button buFine = (Button) findViewById(R.id.buFine);
        buFine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fname = fTextName.getText().toString();
                final int pesel = Integer.parseInt(fPesel.getText().toString());
                final String father = fFather.getText().toString();
                final String doc = fDoc.getText().toString();
                final String add = fAdd.getText().toString();
                final String base = fBase.getText().toString();
                final String crime = fCrime.getText().toString();
                final int price = Integer.parseInt(fPrice.getText().toString());

                Fine fine = null;
                try{
                    fine = new Fine(fname, pesel, father, doc, add, base, crime, price);
                } catch (NumberFormatException n)   {
                    AlertDialog.Builder builder = new AlertDialog.Builder(FineActivity.this);
                    builder.setMessage("Operacja nieudana!")
                            .setNegativeButton("Spróbuj ponownie!", null)
                            .create()
                            .show();
                }
                myListItems.add(fine);

                Intent fineIntent = new Intent(FineActivity.this, MenuActivity.class);
                fineIntent.putExtra("fname", fname);
                fineIntent.putExtra("pesel", pesel);
                fineIntent.putExtra("father", father);
                fineIntent.putExtra("doc", doc);
                fineIntent.putExtra("add", add);
                fineIntent.putExtra("base", base);
                fineIntent.putExtra("crime", crime);
                fineIntent.putExtra("price", price);
                FineActivity.this.startActivity(fineIntent);
            }
        });
    }
}
