package com.example.Is_big_your_eyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 29.09.13
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public class ResultActivity extends Activity {
    MainTest test;
    Button Bexit;
    Button tostart;
    TextView TVresult;
    TextView TVmasiv;
    int result=0;
    int id;

    void ID(){
        id=getIntent().getIntExtra("ID",id);

        Log.e("Re", "It works");
        switch (id){
            case 2:  test=new Test2();  break;
            case 1:  test=new BigEyes(); break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ID();
        setContentView(R.layout.result);
        TVmasiv=(TextView)findViewById(R.id.masivresult);
        result=getIntent().getIntExtra("result",result);
        TVresult=(TextView)findViewById(R.id.tvresult);
        Bexit=(Button)findViewById(R.id.Exit);
        tostart=(Button)findViewById(R.id.buttonStart);
        TVmasiv.setText("Ваш результат: "+result);
        test.result(TVresult,result);

        Bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tostart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RAintent = new Intent(ResultActivity.this, MyActivity.class);
                startActivity(RAintent);
                finish();
            }
        });
    }
    public void onBackPressed() {
// do something on back.
        Toast.makeText(getApplicationContext(), "Back pressed", Toast.LENGTH_SHORT).show();
        return;
    }
}
