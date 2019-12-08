package com.example.feedme;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private Button mBtn_Register;
    private Button mBtn_Cancel;
    private EditText et_username, et_password, et_confirm_pwd, et_email;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mBtn_Register = findViewById(R.id.btn_register);
        mBtn_Cancel = findViewById(R.id.btn_cancel);
        mBtn_Register.setOnClickListener(new ButtonListen());
        mBtn_Cancel.setOnClickListener(new ButtonListen());
        Objects.requireNonNull(getSupportActionBar()).hide();

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_confirm_pwd = findViewById(R.id.et_confirm_pwd);
        et_email = findViewById(R.id.et_email);

        progressBar = new ProgressBar(this);

    }

    private void registerUser(){
        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        // final String confirm_pwd = et_email.getText().toString().trim();
        final String email = et_email.getText().toString().trim();

        // progressBar
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // progressBar

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // progressBar
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                params.put("email", email);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    private class ButtonListen implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_register:
                    registerUser();
                    startActivity(new Intent(RegisterActivity.this, RegisterActivity.class));
                    finish();
                    break;

                case R.id.btn_cancel:
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    break;
            }
        }
    }
    @Override
    public boolean onKeyDown( int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        }

        return super.onKeyDown(keyCode, event);
    }


}

