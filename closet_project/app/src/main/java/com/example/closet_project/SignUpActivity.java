package com.example.closet_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.signup).setOnClickListener(onClickListener);
        findViewById(R.id.login).setOnClickListener(onClickListener);
    }
    @Override public void onBackPressed(){
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.signup:
                    signUp();
                    break;
                case R.id.login:
                    myStartActivity(LoginActivity.class);
                    finish();
                    break;
            }
        }
    };


    private void signUp() {
        String email = ((EditText) findViewById(R.id.email)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.checkpw)).getText().toString();

        if (email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {
            if (password.equals(passwordCheck)) {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startToast("회원가입에 성공했습니다.");
                            myStartActivity(MainActivity.class);
                            finish();
                        } else {
                            if (task.getException().toString() != null) {
                               startToast("회원가입에 실패했습니다.");
                            }
                        }
                    }
                });
            } else {
                startToast("비밀번호가 일치하지 않습니다.");
            }
        } else {
            startToast("아이디와 비밀번호를 확인해주세요.");
        }
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    private void startToast(String msg) {Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();}
}