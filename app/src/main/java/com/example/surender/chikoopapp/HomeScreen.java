package com.example.surender.chikoopapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView userName;
    ImageView toggle;
    TextView HeaderTitle;
    TabHost tabHost;

    ImageView hor_ciao,hor_celegram,hor_cinsio,hor_chikoopay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = (ImageView) findViewById(R.id.drawer_img);
        HeaderTitle = (TextView) findViewById(R.id.heading_txt);

        HeaderTitle.setText("Ciao");

        hor_ciao  = (ImageView) findViewById(R.id.hor_ciao);
        hor_celegram  = (ImageView) findViewById(R.id.hor_celegram);
        hor_cinsio  = (ImageView) findViewById(R.id.hor_cinsio);
        hor_chikoopay  = (ImageView) findViewById(R.id.hor_chikoopay);

        hor_ciao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        hor_celegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        hor_cinsio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        hor_chikoopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        assert drawer != null;
        drawer.openDrawer(GravityCompat.START);

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert drawer != null;
                drawer.openDrawer(GravityCompat.START);
            }
        });

        changeHeaderData();


        tabHost = (TabHost) findViewById(R.id.ciao_tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("SPEED DIAL");
        tabSpec.setIndicator("SPEED DIAL");
        tabSpec.setContent(R.id.ciao_tab_speedDial);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("RECENTS");
        tabSpec.setIndicator("RECENTS");
        tabSpec.setContent(R.id.ciao_tab_recent);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("CONTACTS");
        tabSpec.setContent(R.id.ciao_tab_contact);
        tabSpec.setIndicator("CONTACTS");
        tabHost.addTab(tabSpec);



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        assert fab != null;
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//
//            }
//        });


//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public  void changeHeaderData()
    {
        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(this);
       // View header=navigationView.getHeaderView(0);
/*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
        userName = (TextView)findViewById(R.id.UserName);
        userName.setText("Surender Sankhla");

        RelativeLayout accountMenu = (RelativeLayout)findViewById(R.id.accountLayout);
        assert accountMenu != null;
        accountMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this,DrawerAccount.class));
            }
        });

        RelativeLayout notificationMenu = (RelativeLayout)findViewById(R.id.notificationLayout);
        assert notificationMenu != null;
        notificationMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this,DrawerNotification.class));;
            }
        });

        RelativeLayout privacyMenu = (RelativeLayout)findViewById(R.id.privacyLayout);
        assert privacyMenu != null;
        privacyMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this,DrawerPrivacy.class));
            }
        });

        RelativeLayout myCouponMenu = (RelativeLayout)findViewById(R.id.coupanLayout);
        assert myCouponMenu != null;
        myCouponMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this,DrawerMyCoupons.class));
            }
        });

        RelativeLayout transactionMenu = (RelativeLayout)findViewById(R.id.transactionLayout);
        assert transactionMenu != null;
        transactionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this,MyTransaction.class));
            }
        });

        RelativeLayout findFriendMenu = (RelativeLayout)findViewById(R.id.findFriendLayout);
        assert findFriendMenu != null;
        findFriendMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this,DrawerFindFriends.class));
            }
        });
    }
}
