package com.example.a04_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Misson3 extends AppCompatActivity {

    EditText inputbox1;
    TextView view1;
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misson3);


        inputbox1 = (EditText) findViewById(R.id.inputbox);
        view1 = (TextView) findViewById(R.id.textbyte);
        btn1 = (Button) findViewById(R.id.send);
        btn2 = (Button) findViewById(R.id.exit);

        inputbox1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = inputbox1.getText().toString();
                view1.setText(input.length()+"/80 글자 수 ");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String send_text = inputbox1.getText().toString();
                Toast.makeText(getApplicationContext(), send_text, Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

    }
}