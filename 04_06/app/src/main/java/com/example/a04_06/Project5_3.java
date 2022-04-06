package com.example.a04_06;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Project5_3 extends AppCompatActivity {

    EditText text;
    Button btn;
    TextView textView;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_project51);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(255,255,255));
        setContentView(baseLayout,params);

        text = new EditText(this);
        baseLayout.addView(text);

        btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn);

        textView = new TextView(this);
        baseLayout.addView(textView);

        name = new TextView(this);
        name.setText("2018038027_정세연");
        baseLayout.addView(name);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String text1 = text.getText().toString();
                textView.setText(text1);
                textView.setTextColor(Color.MAGENTA);
            }
        });
    }
}