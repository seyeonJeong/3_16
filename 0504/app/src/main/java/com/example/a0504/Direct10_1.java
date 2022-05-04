package com.example.a0504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Direct10_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct101);

        final RadioButton rdoSecond = (RadioButton) findViewById(R.id.rdoSecond);

        Button btnNewActivity = (Button)findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                if(rdoSecond.isChecked() == true) intent = new Intent(getApplicationContext(), SecondActivity10_1.class);
                else intent = new Intent(getApplicationContext(), Direct10_3.class);

                startActivity(intent);
            }
        });
    }
}