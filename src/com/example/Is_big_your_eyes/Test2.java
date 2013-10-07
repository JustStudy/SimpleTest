package com.example.Is_big_your_eyes;

import android.widget.RadioGroup;
 import android.widget.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ruslik
 * Date: 29.09.13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */
public class Test2 extends MainTest {


    Test2(){

        super();
       int [] var_a={0,6,3,4,8,10,8,6,6,6};
        int [] var_b={6,0,9,6,5,3,0,0,1,1};
        int [] var_c={3,8,0,1,0,6,6,10,9,10};
        ID_var_a=R.array.test2_a;
        ID_var_b=R.array.test2_b;
         ID_var_c=R.array.test2_c;
        ID_question=R.array.test_2;
        super.a=var_a;
        super.b=var_b;
        super.c=var_c;
    }

    void calculate(RadioGroup radiogroup,int i){
     switch (radiogroup.getCheckedRadioButtonId()){
         case R.id.variantA: rezultMasiv[i]=a[i]; break;
         case R.id.variantB: rezultMasiv[i]=b[i]; break;
         case R.id.variantC: rezultMasiv[i]=c[i]; break;

     } }

     void result(TextView TVresult, int result){
         if(result>70)
             TVresult.setText(R.string.test2_71);
         else if(result<36)
             TVresult.setText(R.string.test2_35);
         else {TVresult.setText(R.string.test2_35_75);}
     }
        }
