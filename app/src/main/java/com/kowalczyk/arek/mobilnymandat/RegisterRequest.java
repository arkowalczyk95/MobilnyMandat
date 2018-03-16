package com.kowalczyk.arek.mobilnymandat;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;



public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://arkow.byethost7.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, int id, String station, String username,  String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("id", id + "");
        params.put("station", station);
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
