package com.example.surender.chikoopapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ProfilePage extends AppCompatActivity{

    ImageView profilePic;
    RoundedImage roundedImage;
    Button nextButton;
    Button earnCredit;
    TextView datePickerText;
    ImageView wallPicture;

    ImageView toggle;
    TextView headerTag;
    RelativeLayout actionBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        headerTag = (TextView)findViewById(R.id.heading_txt);
        toggle = (ImageView) findViewById(R.id.down_img);

        assert toggle != null;
        toggle.setImageResource(R.drawable.drawer_button);
        assert headerTag != null;
        headerTag.setText("Create Your Profile");

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(ProfilePage.this,HomeScreen.class));
                overridePendingTransition(R.anim.pull_in_left,R.anim.push_out_right);
            }
        });

        profilePic = (ImageView)findViewById(R.id.profilePage_profilePic);
        wallPicture = (ImageView) findViewById(R.id.profilePage_wallPic);

        nextButton = (Button) findViewById(R.id.profilePage_next);
        earnCredit = (Button) findViewById(R.id.profilepage_earnCredit);
        datePickerText = (TextView) findViewById(R.id.profilePage_dateOfBirth);

        actionBarLayout = (RelativeLayout) findViewById(R.id.custome_actionbar_mainLayout);
       // assert actionBarLayout != null;
        //actionBarLayout.setBackgroundColor(Color.BLACK);


        //Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.default_user);
        //roundedImage = new RoundedImage(bm);
        //profilePic.setImageDrawable(roundedImage);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this,PinInterest.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_right,R.anim.push_out_left);
            }
        });

        earnCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this,CompleteNEarn.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
            }
        });


    }

//    @Override
//    public void onBackPressed() {
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        datePickerText.setSelected(false);
//        datePickerText.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ProfilePage.this,""+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
//                DatePickerCall(datePickerText);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }

    public  void DatePickerCall(View v)
    {
        Calendar mcurrentDate=Calendar.getInstance();
        int mYear=mcurrentDate.get(Calendar.YEAR);
        int mMonth=mcurrentDate.get(Calendar.MONTH);
        int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker=new DatePickerDialog(ProfilePage.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                    int month = selectedmonth+1;
                datePickerText.setText(""+selectedday+"/"+month+"/"+selectedyear);
            }
        },mYear, mMonth, mDay);
        mDatePicker.setTitle("Select Date of Birth");
        mDatePicker.show();
    }

    public  void AddImageInBackGround(View v)
    {

        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        final int ACTIVITY_SELECT_IMAGE = 1234;
        startActivityForResult(intent, ACTIVITY_SELECT_IMAGE);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1234:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    assert cursor != null;
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
                   // wallPicture.setImageBitmap(yourSelectedImage);
                    wallPicture.setImageURI(selectedImage);
            /* Now you have choosen image in Bitmap format in object "yourSelectedImage". You can use it in way you want! */
                }
        }

    };
}
