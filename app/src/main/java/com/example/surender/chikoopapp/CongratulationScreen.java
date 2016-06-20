package com.example.surender.chikoopapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class CongratulationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation_screen);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

        //getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.yourimage));

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        actionBar.setCustomView(getLayoutInflater().inflate(R.layout.abs_layout, null),
//                new ActionBar.LayoutParams(
//                        ActionBar.LayoutParams.WRAP_CONTENT,
//                        ActionBar.LayoutParams.MATCH_PARENT,
//                        Gravity.CENTER
//                )
//        );
    }

    public void GetStartCall(View v)
    {
        Intent intent = new Intent(this,HomeScreen.class);
        startActivity(intent);
    }
}
