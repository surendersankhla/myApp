package com.example.surender.chikoopapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Singup extends AppCompatActivity {

    EditText mobileNo;
    EditText firstName;
    EditText lastName;
    EditText userName;
    EditText emailID;
    EditText password;
    EditText conformPassword;
    EditText refferalCode;

    TextView suppoort;

    Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        mobileNo = (EditText) findViewById(R.id.SignUp_EditTextMobileNO);
        firstName = (EditText) findViewById(R.id.SignUp_EditTextFirstName);
        lastName = (EditText) findViewById(R.id.SignUp_EditTextLastName);
        userName = (EditText) findViewById(R.id.SignUp_EditTextUserName);
        emailID = (EditText) findViewById(R.id.SignUp_EditTextEmailAddress);
        password = (EditText) findViewById(R.id.SignUp_EditTextPassword);
        conformPassword = (EditText) findViewById(R.id.SignUp_EditTextConformPassword);
        refferalCode = (EditText) findViewById(R.id.SignUp_EditTextReferalCode);

        suppoort = (TextView) findViewById(R.id.SignUp_TextSupport);

        loginButton = (Button) findViewById(R.id.SignUp_ButtonSignUp);


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        userName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(!hasFocus)
                {
                  //  Log.v("dadadada","aadadadadcvcvcvcvcvcrturtututututututututututututututuhjhjhjhjhjhhjhjhjhjhjhjhjhjvc");
                    userName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.text_icon3,0,R.drawable.available_image,0);
                }
                if(userName.getText().toString().equals(""))
                {
                    userName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.text_icon3,0,R.drawable.waiting_available,0);
                }

            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (networkInfo!= null && networkInfo.isConnected())
                {
                    BackgroundTask backgroundTask = new BackgroundTask();
                    backgroundTask.execute(mobileNo.getText().toString(),
                            firstName.getText().toString(),
                            lastName.getText().toString(),
                            userName.getText().toString(),
                            emailID.getText().toString(),
                            password.getText().toString(),
                            refferalCode.getText().toString());

                    //finish();
                    Intent intent = new Intent(Singup.this,VarifyOPTScreen.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Singup.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class BackgroundTask extends AsyncTask<String,Void,String>
    {
        String url_info;
        @Override
        protected void onPreExecute() {
            url_info = "https://www.chikoop.com/api/index.php/user/register";
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... args) {
            String M_No,f_name,l_name,u_name,email,pass,ref;
            M_No = args[0];
            f_name = args[1];
            l_name = args[2];
            u_name = args[3];
            email = args[4];
            pass = args[5];
            ref = args[6];

           try {
                URL url =new URL(url_info);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String str = URLEncoder.encode("mobile","UTF-8")+"="+URLEncoder.encode(M_No,"UTF-8")+"&"+
                        URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(f_name,"UTF-8")+"&"+
                        URLEncoder.encode("lastname","UTF-8")+"="+URLEncoder.encode(l_name,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(u_name,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8")+"&"+
                        URLEncoder.encode("refered_by","UTF-8")+"="+URLEncoder.encode(ref,"UTF-8");
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.close();

                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();

                httpURLConnection.disconnect();

                return "Data Input Success...";

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            if (result ==  null)
                return;

            Toast.makeText(Singup.this,result,Toast.LENGTH_SHORT).show();
        }
    }
}


