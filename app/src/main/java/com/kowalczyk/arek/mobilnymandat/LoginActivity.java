package com.kowalczyk.arek.mobilnymandat;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText alTextLogin = (EditText) findViewById(R.id.alTextLogin);
        final EditText alTextPass = (EditText) findViewById(R.id.alTextPass);
        final TextView alTextReg = (TextView) findViewById(R.id.alTextReg);
        final Button alButtonLog = (Button) findViewById(R.id.alButtonLog);

        alTextReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(regIntent);
            }
        });

        alButtonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(LoginActivity.this, MenuActivity.class);
                LoginActivity.this.startActivity(menuIntent);
//                final String username = alTextLogin.getText().toString();
//                final String password = alTextPass.getText().toString();
//
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonResponse = new JSONObject(response);
//                            boolean success = jsonResponse.getBoolean("success");
//
//                            if (success) {
//                                String name = jsonResponse.getString("name");
//                                int id = jsonResponse.getInt("id");
//                                String station = jsonResponse.getString("station");
//
//                                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
//                                intent.putExtra("name", name);
//                                intent.putExtra("id", id);
//                                intent.putExtra("station", station);
//                                intent.putExtra("username", username);
//                                LoginActivity.this.startActivity(intent);
//                            } else {
//                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                                builder.setMessage("Logowanie nieudane!")
//                                        .setNegativeButton("Spróbuj ponownie!", null)
//                                        .create()
//                                        .show();
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//
//                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
//                queue.add(loginRequest);
            }
        });

    }
}
