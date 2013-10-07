package com.example.Is_big_your_eyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {
    public  int TEST_ID;
    Button Next;
    TextView TvTest1;
    TextView TvTest2;
    /**
     * Called when the activity is first created.
     */
      private   void next(int k){

            Intent intent = new Intent(MyActivity.this, QuestionsLayout.class);
            intent.putExtra("ID",k);
            startActivity(intent);
            finish();
        }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TvTest1=(TextView)findViewById(R.id.BtnBigEyes);
        TvTest2=(TextView)findViewById(R.id.BtnYourNerve);
        Next=(Button)findViewById(R.id.startTest);
        TvTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TEST_ID=1;
                next(TEST_ID);


            }
        });
        TvTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  TEST_ID=2;

                next(TEST_ID);


            }
        });
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
    @Override
    public void onBackPressed() {
// do something on back.
        Toast.makeText(getApplicationContext(),"Back pressed",Toast.LENGTH_SHORT).show();
        return;
    }
}
