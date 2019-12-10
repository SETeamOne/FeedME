package com.example.feedme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {
    private Button mbtn_edit_confirm;
    private Button mbtn_edit_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        mbtn_edit_confirm = findViewById(R.id.btn_edit_confirm);
        mbtn_edit_cancel = findViewById(R.id.btn_edit_cancel);
        mbtn_edit_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditProfileActivity.this, "edit profile successfully", Toast.LENGTH_SHORT).show();
            }
        });
        mbtn_edit_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this,ProfileFragment.class);
                startActivity(intent);

            }
        });
    }
}
