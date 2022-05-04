package com.example.a0504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main10_1 extends AppCompatActivity {
    private Button btnNewActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main101);

        init();
        initLr();
    }
    public void init(){
        btnNewActivity = findViewById(R.id.btnNewActivity);
    }

    public void initLr(){
        btnNewActivity.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SecondActivity10_1.class);
            startActivity(intent);
        });
    }
}