package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnlogout, displaybtn,createbtn;
    SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        btnlogout = findViewById(R.id.logout);
        displaybtn = findViewById(R.id.btndisplay);
        createbtn = findViewById(R.id.btncreate);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferenceConfig.WriteLoginStatus(false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });

        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DisplayActivity.class));
            }
        });

        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CreateActivity.class));
            }
        });

    }
}
