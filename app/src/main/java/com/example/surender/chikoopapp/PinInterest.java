package com.example.surender.chikoopapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class PinInterest extends AppCompatActivity {

    ListView pinInterestList;

    String[] pinTitle;
    int[] pinIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_interest);
        pinInterestList = (ListView) findViewById(R.id.pin_listView);

        pinTitle = new String[]{"Watch lover",
                "Gadget Freak",
                "Fragrance Wearer",
                "Auto Enthusiast",
                "Jewelry Rich",
                "Books Fan",
                "Chocolate Romeo",
                "Street Shopper",
                "Travel Freak",
                "Beauty Everyday",
                "Gadget Freak",
                "Frequent Flyer",
                "Fashionista",
                "Party Animal",
                "Fitness Freak",
                "Shades Shopper",
                "Gamer",
                "Apparel Addict",
                "Art-Lover",
                "Online Shopper",
                "Foodie",
                "Cosmetician",
                "Shoes Shopper"
        };
        pinIcon = new int[]{R.drawable.p26,
                R.drawable.p27,
                R.drawable.p28,
                R.drawable.p29,
                R.drawable.p30,
                R.drawable.p31,
                R.drawable.p32,
                R.drawable.p33,
                R.drawable.p34,
                R.drawable.p35,
                R.drawable.p36,
                R.drawable.p37,
                R.drawable.p38,
                R.drawable.p39,
                R.drawable.p40,
                R.drawable.p41,
                R.drawable.p42,
                R.drawable.p43,
                R.drawable.p44,
                R.drawable.p46,
                R.drawable.p47,
                R.drawable.p48,
                R.drawable.p49
        };

        pinInterestList.setAdapter(new PinInterestAdapter(this,pinTitle,pinIcon,"PIN IT"));
    }

    public void submitBtnCall(View v)
    {
        Intent intent = new Intent(this,CongratulationScreen.class);
        startActivity(intent);
    }

    public void favoriteBtnCall(View v)
    {
        Intent intent = new Intent(this,Favorite.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
    }
}
