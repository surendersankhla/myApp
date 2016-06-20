package com.example.surender.chikoopapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VarifyOPTScreen extends AppCompatActivity {

    EditText OPTValue;
    TextView clickHere;
    Button VarifyButton;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varify_optscreen);

        OPTValue = (EditText)findViewById(R.id.verify_OTPValue);
        VarifyButton = (Button)findViewById(R.id.verify_ButtonSignUp);
        clickHere = (TextView)findViewById(R.id.verify_clickHere);
        relativeLayout = (RelativeLayout)findViewById(R.id.verify_loadingScreen);

        VarifyButton.setEnabled(false);
        OPTValue.setEnabled(false);

//        final Thread thread = new Thread(){
//            @Override
//            public void run() {
//
//                try {
//                    sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally {
//
//                        //clickHereCall(relativeLayout);
//                    relativeLayout.setAlpha(0);
//                    VarifyButton.setEnabled(true);
//                    OPTValue.setEnabled(true);
//                }
//            }
//        };
//        thread.start();

        VarifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VarifyOPTScreen.this,Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.flip_left_in, R.anim.flip_left_out);
            }
        });
    }
    public void clickHereCall(View view)
    {
        relativeLayout.setAlpha(0);
        VarifyButton.setEnabled(true);
        OPTValue.setEnabled(true);
    }
}
