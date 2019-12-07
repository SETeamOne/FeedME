package com.example.feedme;

import android.content.Intent;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private Button mBtn_Register;
    private Button mBtn_Cancel;
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
    }

    private class ButtonListen implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_register:
                    intent = new Intent(RegisterActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btn_cancel:
                    intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}

