package com.example.surender.chikoopapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Favorite extends AppCompatActivity {

    ListView favList;
    String[] favTitle;
    int[] favIcon;

    ImageView down_img;
    TextView heading_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        favList = (ListView) findViewById(R.id.favorite_listView);

        favTitle = new String[]{"Entertainment ","Food & Drinks","Lifestyle","Fashion","Automobiles","Appliances","Health Care","Education","Travel"};
        favIcon = new int[]{R.drawable.p50,R.drawable.p51,R.drawable.p52,R.drawable.p53,R.drawable.p54,R.drawable.p55,R.drawable.p56,R.drawable.p57,R.drawable.p58};

        favList.setAdapter(new PinInterestAdapter(this,favTitle,favIcon,"FOLLOW"));

        heading_txt =(TextView) findViewById(R.id.heading_txt);
        down_img = (ImageView) findViewById(R.id.down_img);

        heading_txt.setText("Favorite Categories");


        down_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favorite.this, PinInterest.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_down,R.anim.slide_out_down);
            }
        });
    }

    public void submitBtnCall(View v)
    {
        Intent intent = new Intent(this,CongratulationScreen.class);
        startActivity(intent);
    }

    public void backBtnCall(View v)
    {
        Intent intent = new Intent(this,PinInterest.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_down,R.anim.slide_out_down);
    }
}
