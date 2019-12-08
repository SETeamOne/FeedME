package com.example.feedme;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtn_home_log;
    private Button mBtn_home_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn_home_log = findViewById(R.id.btn_home_log);
        mBtn_home_reg = findViewById(R.id.btn_home_reg);
        setListeners();
    }

    public void setListeners() {
        OnClick onClick = new OnClick();
        mBtn_home_log.setOnClickListener(onClick);
        mBtn_home_reg.setOnClickListener(onClick);
    }

    public class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_home_log:
                    intent = new Intent(MainActivity.this, loginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_home_reg:
                    intent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
