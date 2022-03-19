package com.example.a3_16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Practice2_7 extends AppCompatActivity {

    EditText editText;
    Button button1;
    Button button2;
    RadioGroup RadioGruop1;
    RadioButton RadioButton1;
    RadioButton RadioButton2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice27);

        editText = findViewById(R.id.editText3);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        RadioGruop1 = findViewById(R.id.radioGroup1);
        RadioButton1 = findViewById(R.id.radioButton3);
        RadioButton2 = findViewById(R.id.radioButton4);
        imageView = findViewById(R.id.imageView);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = editText.getText().toString();
                Toast.makeText(getApplicationContext(),text1,Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text2 = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text2));
                startActivity(intent);
            }
        });

        RadioGruop1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String result;
                int id = RadioGruop1.getCheckedRadioButtonId();
                if(id == R.id.radioButton3){
                    imageView.setImageResource(R.drawable.android12);
                }
                else{
                    imageView.setImageResource(R.drawable.android12_gray);
                }
            }
        });



    }
}