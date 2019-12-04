package com.example.feedme;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class loginActivity extends AppCompatActivity {
    private Button mBtn_Login;
    private Button mBtn_Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBtn_Login = findViewById(R.id.btn_login);
        mBtn_Cancel = findViewById(R.id.btn_cancel);
        mBtn_Login.setOnClickListener(new ButtonListener());
        mBtn_Cancel.setOnClickListener(new ButtonListener());
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_login:
                    intent = new Intent(loginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btn_cancel:
                    intent = new Intent(loginActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}