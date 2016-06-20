package com.example.surender.chikoopapp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CompleteNEarn extends AppCompatActivity {


    ImageView down_img;
    TextView heading_txt;
    Spinner nativeLanguage,household,income,profession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_nearn);

        heading_txt =(TextView) findViewById(R.id.heading_txt);
        down_img = (ImageView) findViewById(R.id.down_img);

        heading_txt.setText("Complete & Earn Credits");


        down_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompleteNEarn.this, ProfilePage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_down,R.anim.slide_out_down);
            }
        });


        /*nativeLanguage = (Spinner)findViewById(R.id.activeNEarn_NativeLanguage);
        List<String> list = new ArrayList<String>();
        list.add("Romania");
        list.add("Mexico");
        list.add("Germany");
        list.add("United Kingdom");
        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(CompleteNEarn.this,R.layout.spinner_text_view, list);
        nativeLanguage.setAdapter(dataAdapter);*/

//        household = (Spinner)findViewById(R.id.activeNEarn_HouseHold);
//        income = (Spinner)findViewById(R.id.activeNEarn_familyIncome);
//        profession = (Spinner)findViewById(R.id.activeNEarn_Profession);
    }

    public void nextButtonCall(View v)
    {
        Intent intent = new Intent(this,PinInterest.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent intent = new Intent(this, ProfilePage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_down,R.anim.slide_out_down);

                //Toast.makeText(getApplicationContext(), "Back button clicked", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return true;
    }
}

