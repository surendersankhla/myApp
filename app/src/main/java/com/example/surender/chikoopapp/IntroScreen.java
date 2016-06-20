package com.example.surender.chikoopapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IntroScreen extends AppCompatActivity {

    ViewPager SlidePager;
    SwipeAdapter adpater;
    ImageView infoPage1,infoPage2,infoPage3,infoPage4,infoPage5,infoPage6;
    Button SignUP_Button,Login_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        SlidePager = (ViewPager)findViewById(R.id.info_view_pager);

        adpater = new SwipeAdapter(this);
        SlidePager.setAdapter(adpater);

        infoPage1 = (ImageView)findViewById(R.id.dot1);
        infoPage2 = (ImageView)findViewById(R.id.dot2);
        infoPage3 = (ImageView)findViewById(R.id.dot3);
        infoPage4 = (ImageView)findViewById(R.id.dot4);
        infoPage5 = (ImageView)findViewById(R.id.dot5);
        infoPage6 = (ImageView)findViewById(R.id.dot6);

        SignUP_Button = (Button)findViewById(R.id.singup);
        Login_Button = (Button)findViewById(R.id.login);

        SlidePager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                Log.v("hello Page","Number "+position);

                    if ( position == 0)
                    {
                        infoPage1.setImageResource(R.drawable.orange_dot);
                        infoPage2.setImageResource(R.drawable.gray_dot);
                        infoPage3.setImageResource(R.drawable.gray_dot);
                        infoPage4.setImageResource(R.drawable.gray_dot);
                        infoPage5.setImageResource(R.drawable.gray_dot);
                        infoPage6.setImageResource(R.drawable.gray_dot);
                    }
                    else if (position == 1)
                    {
                        infoPage1.setImageResource(R.drawable.gray_dot);
                        infoPage2.setImageResource(R.drawable.orange_dot);
                        infoPage3.setImageResource(R.drawable.gray_dot);
                        infoPage4.setImageResource(R.drawable.gray_dot);
                        infoPage5.setImageResource(R.drawable.gray_dot);
                        infoPage6.setImageResource(R.drawable.gray_dot);
                    }
                    else  if (position == 2)
                    {
                        infoPage1.setImageResource(R.drawable.gray_dot);
                        infoPage2.setImageResource(R.drawable.gray_dot);
                        infoPage3.setImageResource(R.drawable.orange_dot);
                        infoPage4.setImageResource(R.drawable.gray_dot);
                        infoPage5.setImageResource(R.drawable.gray_dot);
                        infoPage6.setImageResource(R.drawable.gray_dot);
                    }
                    else  if (position == 3)
                    {
                        infoPage1.setImageResource(R.drawable.gray_dot);
                        infoPage2.setImageResource(R.drawable.gray_dot);
                        infoPage3.setImageResource(R.drawable.gray_dot);
                        infoPage4.setImageResource(R.drawable.orange_dot);
                        infoPage5.setImageResource(R.drawable.gray_dot);
                        infoPage6.setImageResource(R.drawable.gray_dot);
                    }
                    else  if (position == 4)
                    {
                        infoPage1.setImageResource(R.drawable.gray_dot);
                        infoPage2.setImageResource(R.drawable.gray_dot);
                        infoPage3.setImageResource(R.drawable.gray_dot);
                        infoPage4.setImageResource(R.drawable.gray_dot);
                        infoPage5.setImageResource(R.drawable.orange_dot);
                        infoPage6.setImageResource(R.drawable.gray_dot);
                    }
                    else  if (position == 5)
                    {
                        infoPage1.setImageResource(R.drawable.gray_dot);
                        infoPage2.setImageResource(R.drawable.gray_dot);
                        infoPage3.setImageResource(R.drawable.gray_dot);
                        infoPage4.setImageResource(R.drawable.gray_dot);
                        infoPage5.setImageResource(R.drawable.gray_dot);
                        infoPage6.setImageResource(R.drawable.orange_dot);
                    }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        SignUP_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intd= new Intent(IntroScreen.this,Singup.class);
                startActivity(intd);
                //overridePendingTransition(R.anim.activity_open_scale,R.anim.activity_close_scale);

            }
        });

        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intd= new Intent(IntroScreen.this,Login.class);
                startActivity(intd);

            }
        });


    }

    public  void  getSlideNumber(Integer num)
    {

    }
}
