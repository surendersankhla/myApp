package com.example.surender.chikoopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DrawerMyCoupons extends AppCompatActivity {

    ListView offerlistView;

    int[] coupanImg = {R.drawable.pvr_cinema,R.drawable.pvr_cinema,R.drawable.pvr_cinema,R.drawable.pvr_cinema};
    String[] title = {"PVR Cinema,3 Location","PVR Cinema,3 Location","PVR Cinema,3 Location","PVR Cinema,3 Location"};
    String[] offerTag = {"Save Rs. 300","Buy 1 Get 1","Save Rs.150","30% off"};
    String[] expiryDate = {"17 jun 2016","18 jun 2016","19 jun 2016","20 jun 2016"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_my_coupons);

        offerlistView = (ListView)findViewById(R.id.myCouponListView);
        offerlistView.setAdapter(new MyCouponAdapter(DrawerMyCoupons.this,title,offerTag,expiryDate,coupanImg));
    }
}
