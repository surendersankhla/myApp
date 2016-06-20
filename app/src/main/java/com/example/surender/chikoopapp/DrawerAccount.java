package com.example.surender.chikoopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class DrawerAccount extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_account);

        listView = (ListView) findViewById(R.id.account_listView);

        String[] str ={"Change Number",
                "Change Email",
                "Change Username",
                "Add Bank Account",
                "Saved Cards",
                "Backup Account",
                "Delete Account"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DrawerAccount.this,android.R.layout.simple_list_item_1,str);
        listView.setAdapter(adapter);

    }
}
