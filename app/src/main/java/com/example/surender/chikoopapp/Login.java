package com.example.surender.chikoopapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    Button login;
    EditText contactNo,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login = (Button)findViewById(R.id.login_loginbtn);
        contactNo = (EditText) findViewById(R.id.login_EditTextMobileNO);
        password =(EditText) findViewById(R.id.login_EditTextPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this,ProfilePage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.rest_animation,R.anim.push_out_left);
//                if (!contactNo.getText().toString().equals("") && !password.getText().toString().equals(""))
//                {
//                    if (contactNo.getText().toString().equals("1234567890") && password.getText().toString().equals("password"))
//                    {
//                        Intent intent = new Intent(Login.this,ProfilePage.class);
//                        startActivity(intent);
//                    }
//                    else
//                    {
//                        showAlertMessage("Enter Valid Mobile Number And Password");
//                    }
//                }
//                else
//                {
//                   showAlertMessage("Enter Valid credentials");
//                }
            }
        });
    }

    public void showAlertMessage(String msg_string)
    {
        AlertDialog.Builder msg = new AlertDialog.Builder(Login.this);
        msg.setMessage(""+msg_string);
        AlertDialog dialog = msg.create();
        dialog.show();
    }

}


