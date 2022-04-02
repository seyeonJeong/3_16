package com.example.a3_30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Select4_4 extends AppCompatActivity {
    TextView text1, text2;
    Switch chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoR, rdoQ, rdoS;
    Button btnStart,btnExit;
    ImageView imgPet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select44);
        setTitle("안드로이드 버전 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);

        btnStart = (Button)findViewById(R.id.Start);
        btnExit = (Button)findViewById(R.id.Exit);
        rGroup1 = (RadioGroup)findViewById(R.id.Rgroup1);
        rdoQ = (RadioButton) findViewById(R.id.AndQ);
        rdoR = (RadioButton) findViewById(R.id.AndR);
        rdoS = (RadioButton) findViewById(R.id.AndS);


        imgPet = (ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkAgree.isChecked() == true){
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    btnStart.setVisibility(android.view.View.VISIBLE);
                    btnExit.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                }else{
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    btnStart.setVisibility(android.view.View.INVISIBLE);
                    btnExit.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(rGroup1.getCheckedRadioButtonId()) {
                    case R.id.AndQ:
                        imgPet.setImageResource(R.drawable.q);
                        break;
                    case R.id.AndR:
                        imgPet.setImageResource(R.drawable.r);
                        break;
                    case R.id.AndS:
                        imgPet.setImageResource(R.drawable.s);
                        break;
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkAgree.setChecked(false);
                rdoQ.setChecked(false);
                rdoR.setChecked(false);
                rdoS.setChecked(false);
                imgPet.setImageResource(0);
            }
        });


    }
}