package com.example.closet_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

public class member_init extends AppCompatActivity {
    private static final String TAG ="member_init";
    private ImageView profileImageView;
    private String profilePath;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_init);
        mAuth = FirebaseAuth.getInstance();

        profileImageView = findViewById(R.id.profileimageView);
        profileImageView.setOnClickListener(onClickListener);

        findViewById(R.id.checkbutton).setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0 : {
                if(resultCode == Activity.RESULT_OK){
                    profilePath = data.getStringExtra("profilePath");
                    Bitmap bmp = BitmapFactory.decodeFile(profilePath);
                    ImageView img;
                    profileImageView.setImageBitmap(bmp);
                }
                break;
            }
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.checkbutton:
                    profileUpdate();
                    break;
                case R.id.profileimageView:
                    myStartActivity(CameraActivity.class);
                    break;

            }
        }
    };


    private void profileUpdate(){
        final String name = ((EditText)findViewById(R.id.nameEdittext)).getText().toString();
        final String phone = ((EditText)findViewById(R.id.phoneEdittext)).getText().toString();
        final String birth = ((EditText)findViewById(R.id.birthEdittext)).getText().toString();
        final String address = ((EditText)findViewById(R.id.addressEdittext)).getText().toString();
        if(name.length()>0 && phone.length() > 9 && birth.length() > 5 && address.length() > 0) {
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            final StorageReference mountainImagesRef = storageRef.child("users/"+user.getUid()+"/profileImage.jpg");

            try{
                InputStream stream = new FileInputStream(new File(profilePath));
                UploadTask uploadTask = mountainImagesRef.putStream(stream);
                uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }
                        // Continue with the task to get the download URL
                        return mountainImagesRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downloadUri = task.getResult();
                            FirebaseFirestore db = FirebaseFirestore.getInstance();
                            Memberinfo memberinfo = new Memberinfo(name,phone,birth,address, downloadUri.toString());
                            db.collection("users").document(user.getUid()).set(memberinfo)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                startToast("회원정보 등록을 성공하였습니다.");
                                                finish();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                startToast("회원정보 등록에 실패 하였습니다.");
                                                Log.w(TAG, "Error updating document", e);
                                            }
                                        });
                        } else {
                            // Handle failures
                            // ...
                            Log.e("로그","실패");
                        }
                    }
                });
            }catch (FileNotFoundException e){
                Log.e("로그","에러 "+e.toString());
            }


        }else{
            startToast("회원 정보를 입력해주세요.");
        }
    }
    private void startToast(String msg) {Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();}

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivityForResult(intent,0);
    }
}