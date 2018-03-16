    package com.kowalczyk.arek.mobilnymandat;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

    public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText arTextName = (EditText) findViewById(R.id.arTextName);
        final EditText arTextId = (EditText) findViewById(R.id.arTextId);
        final EditText arTextPolice = (EditText) findViewById(R.id.arTextPolice);
        final EditText arTextLogin = (EditText) findViewById(R.id.arTextLogin);
        final EditText arTextPass = (EditText) findViewById(R.id.arTextPass);

        final Button arButtonReg = (Button) findViewById(R.id.arButtonReg);

        arButtonReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String name = arTextName.getText().toString();
                final int id = Integer.parseInt(arTextId.getText().toString());
                final String station = arTextPolice.getText().toString();
                final String username = arTextLogin.getText().toString();
                final String password = arTextPass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Rejestracja nieudana!")
                                        .setNegativeButton("Spróbuj ponownie!", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, id, station, username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });

    }
}
