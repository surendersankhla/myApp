package com.example.surender.chikoopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MyTransaction extends AppCompatActivity {

    TableLayout tableLayout;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_transaction);

        tableLayout = (TableLayout) findViewById(R.id.transactionTable);

        for (int i = 0; i <10; i++) {

            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            tv = new TextView(this);
            tv.setText("hello "+i);
            tv.setTextSize(18);
            row.addView(tv);
            tableLayout.addView(row,i);
        }
    }
}
