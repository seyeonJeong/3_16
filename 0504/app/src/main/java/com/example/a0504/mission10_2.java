package com.example.a0504;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class mission10_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission102);

        setTitle("명화 선호도 투표");

        final  int[] voteCount = {0,0,0,0,0,0,0,0,0};
        ImageView[] image = new ImageView[9];
        Integer[] imageID = {
                R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9
        };
        final String[] imgName = {
                "독서하는 소녀",
                "꽃장식 모자 소녀",
                "부채를 든 소녀",
                "이레느깡 단 베르양",
                "잠자는 소녀",
                "테라스의 두 자매",
                "피아노 레슨",
                "피아노 앞의 소녀들",
                "해변에서",
        };

        for(int i=0; i< imageID.length;i++){
            final int idx = i;
            image[idx] = (ImageView) findViewById(imageID[idx]);
            image[idx].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[idx]++;
                    Toast.makeText(getApplicationContext(),imgName[idx]+"총 "+voteCount[idx]+" 표", Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnResult = (Button)findViewById(R.id.btnResult);
        btnResult.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), mission10_2_result.class);
            intent.putExtra("VoteCount", voteCount);
            intent.putExtra("ImageName", imgName);
            startActivity(intent);
        });
    }
}