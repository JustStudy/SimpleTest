package com.example.Is_big_your_eyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 29.09.13
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */
public class QuestionsLayout extends Activity{
    MainTest test;
    int id;
    Button NextPage;
    Button PrevPage;
    TextView TVQuestion;
    RadioGroup maingroup;
    TextView TVNumber;
    RadioButton A;
    RadioButton B;
    RadioButton C;
    int i=0;

   void initTest(){
     id=getIntent().getIntExtra("ID",id);

        switch (id){
            case 2:  test=new Test2();  break;
            case 1:  test=new BigEyes(); break;
                    }

    }

    void showInViewQuestion(MainTest test){
        int k=i+1;
        TVNumber.setText("Вопрос "+k);
        TVQuestion.setText(test.someQuestion[i]);
        A.setText(test.variantA[i]);
        B.setText(test.variantB[i]);
        C.setText(test.variantC[i]);
    }

    void initResources(MainTest test){

        test.someQuestion=getResources().getStringArray(test.ID_question);
        test.rezultMasiv =new int[test.someQuestion.length];
        test.variantA=getResources().getStringArray(test.ID_var_a);
        test.variantB=getResources().getStringArray(test.ID_var_b);
        test.variantC=getResources().getStringArray(test.ID_var_c);
    }

   void initComponents(){
       PrevPage=(Button)findViewById(R.id.buttonPref);
       TVNumber=(TextView)findViewById(R.id.questionNumber);
        NextPage=(Button)findViewById(R.id.buttonNextQuestion);
        TVQuestion=(TextView)findViewById(R.id.questionName);
        maingroup=(RadioGroup)findViewById(R.id.radiogroup);
        A=(RadioButton)findViewById(R.id.variantA);
        B=(RadioButton)findViewById(R.id.variantB);
        C=(RadioButton)findViewById(R.id.variantC);
    }
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.questionlayout);
          initTest();
            initResources(test);
           initComponents();
          showInViewQuestion(test);
                  PrevPage.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(i>=1){
                      i--;
                      showInViewQuestion(test);
                  }
              }
          });
             NextPage.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     test.calculate(maingroup,i);
                     i++;
                     if(i<test.someQuestion.length){
                        showInViewQuestion(test);
                      }
                    else{
                         for(int h=0; h<test.rezultMasiv.length;h++){
                             test.total_result+=test.rezultMasiv[h];
                         }
                         Intent QLintent = new Intent(QuestionsLayout.this, ResultActivity.class);

                         QLintent.putExtra("result",test.total_result);
                         QLintent.putExtra("ID",id);
                         startActivity(QLintent);
                         finish();

                     }

                 }
             });
    }

    public void onBackPressed() {
// do something on back.
        Toast.makeText(getApplicationContext(),"Back pressed",Toast.LENGTH_SHORT).show();
        return;
    }
}
