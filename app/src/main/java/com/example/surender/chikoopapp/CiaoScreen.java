package com.example.surender.chikoopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class CiaoScreen extends AppCompatActivity {

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciao_screen);

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


    }
}
