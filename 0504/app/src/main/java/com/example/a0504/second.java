package com.example.a0504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent inIntent = getIntent();
        String calc = (inIntent.getStringExtra("Calc"));

        int calValue = 0;
        if (calc.equals("+")) {
            calValue = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        } else if (calc.equals("-")) {
            calValue = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        } else if (calc.equals("*")) {
            calValue = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        } else {
            calValue = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);
        }

        int retValue = calValue;

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), mission10_3.class);
                outIntent.putExtra("Hap", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}