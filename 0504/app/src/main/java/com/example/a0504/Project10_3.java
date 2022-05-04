package com.example.a0504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Project10_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project103);
        setTitle("액티비티 테스트 예제");
        android.util.Log.i("액티비티 테스트", "onCreate()");

        Button btnDial = (Button)findViewById(R.id.btnDial);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        Button btnFinish = (Button)findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("액티비티 테스트", "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("액티비티 테스트", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("액티비티 테스트", "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("액티비티 테스트", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("액티비티 테스트", "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("액티비티 테스트", "onRestart()");
    }
}