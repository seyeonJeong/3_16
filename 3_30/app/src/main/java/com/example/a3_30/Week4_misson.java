package com.example.a3_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Week4_misson extends AppCompatActivity {
    ImageView img1, img2;
    Button up,down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week4_misson);
        setTitle("changeImg");

        img1 = (ImageView) findViewById(R.id.Imgwinter);
        img2 = (ImageView) findViewById(R.id.Imgwinter2);

        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        img1.setImageResource(R.drawable.winter);
        img2.setImageResource(0);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageResource(R.drawable.winter);
                img2.setImageResource(0);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageResource(0);
                img2.setImageResource(R.drawable.winter);
            }
        });
    }
}