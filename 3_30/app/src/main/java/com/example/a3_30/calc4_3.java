package com.example.a3_30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calc4_3 extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnPer;
    TextView textResult;
    String num1, num2;
    Double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc43);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnPer = (Button) findViewById(R.id.BtnPer);

        textResult = (TextView) findViewById(R.id.TextResult);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                } catch(Exception e){
                    boolean check_num1 = num1.isEmpty();
                    boolean check_num2 = num2.isEmpty();
                    if(check_num1 && check_num2) {
                        Toast.makeText(getApplicationContext(), "empty number!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                } catch(Exception e){
                    boolean check_num1 = num1.isEmpty();
                    boolean check_num2 = num2.isEmpty();
                    if(check_num1 && check_num2) {
                        Toast.makeText(getApplicationContext(), "empty number!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                } catch(Exception e){
                    boolean check_num1 = num1.isEmpty();
                    boolean check_num2 = num2.isEmpty();
                    if(check_num1 && check_num2) {
                        Toast.makeText(getApplicationContext(), "empty number!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    if(Double.parseDouble(num2) == 0 ){
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());

                } catch(Exception e){
                    boolean check_num1 = num1.isEmpty();
                    boolean check_num2 = num2.isEmpty();
                    if(check_num1 && check_num2) {
                        Toast.makeText(getApplicationContext(), "empty number!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                } catch(Exception e){
                    boolean check_num1 = num1.isEmpty();
                    boolean check_num2 = num2.isEmpty();
                    if(check_num1 && check_num2) {
                        Toast.makeText(getApplicationContext(), "empty number!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}