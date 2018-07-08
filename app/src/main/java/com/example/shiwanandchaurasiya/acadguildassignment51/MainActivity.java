package com.example.shiwanandchaurasiya.acadguildassignment51;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Annotation;
/*
  This is the main Activity means the launcher activity of our Application.And through this activity we are showing the UI
*/
/*
 * This activity is extending AppCompatActivity to make this activity compatible with backword
 * */
public class MainActivity extends AppCompatActivity {
    /*
    * Creating object of TextView and Button
    * */
    TextView textView;
    Button btn;

    /*
   @Override means this is an overrriden method of the Activity LifeCycle and this call back is used to create the UI of the Acivity.
   @return This method is not returning anything as it's return type is void.
   @Param This method is taking the Bundle's instance as an arguement named as savedInstanceState used to fetch the details sent by another activity or method.
   This method is responsible for initializing all the views and setting the content view through the layout file.

   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * setContentView is method to bind layout xml file with activity
         * */
        setContentView(R.layout.activity_main);
        /*
        * Initializing textView and btn using findViewById method
        * */
        textView = (TextView)findViewById(R.id.txt);
        btn = (Button) findViewById(R.id.btn);
        //setting onClickListener on btn to listen on click event
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fading_effect);//Loading fading_effect animation file
                textView.startAnimation(anim);//starting animation in textView
                //setting AnimationListener on anim object
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        //THis method will be called when animation will be started
                        Toast.makeText(MainActivity.this, "Fading animation started!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //THis method will be called when animation will be ended
                        Toast.makeText(MainActivity.this, "Fading animation ended!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        //THis method will be called when animation will repeating
                        Toast.makeText(MainActivity.this, "Fading animation is repeating!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
