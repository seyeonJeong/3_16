package com.example.a0504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class mission10_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission103);

        EditText edtNum1 = findViewById(R.id.edtNum1);
        EditText edtNum2 = findViewById(R.id.edtNum2);
        RadioGroup rdoGroup = findViewById(R.id.rdoGroup);
        Button btnNewActivity = findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), second.class);

                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.rdoAdd:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.rdoSub:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.rdoMul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.rdoDiv:
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }

                intent.putExtra("Num1",
                        Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",
                        Integer.parseInt(edtNum2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과 :" + hap,
                    Toast.LENGTH_SHORT).show();
        }
    }
}