package com.example.captchapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Result extends AppCompatActivity {
    String coords;
    TextView tv;
    private String userData = "userData";
    public static int failedCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");
        coords = "";
        tv = (TextView)findViewById(R.id.textView);
        double result = Double.parseDouble(getIntent().getStringExtra("result"));
        String xy = getIntent().getStringExtra("xy");
        //String y = getIntent().getStringExtra("yCord");
        String mode = getIntent().getStringExtra("mode");
        String imgNo = getIntent().getStringExtra("imgNo");
        String time = getIntent().getStringExtra("time");
        String age = UserInfo.usersAge;
        String gender = UserInfo.gender;
        String vision = UserInfo.vision;
        String hand = UserInfo.hand;

        if(mode.equals("easy")){
            if((int)((result*100)/4) == 100){
                tv.setText(" Your accuracy is: " + (double)((result*100)/4) + "%\n Age : " + age
                        + ", Gender : " + gender + ", Vision : " + vision + "\n Hand : " + hand + ", Successful");
                coords ="Age : " + age + ", Gender : " + gender + ", Vision : " + vision
                        + ", Hand : " + hand + "\nFor Capthca Image : " + imgNo + ", Mode : " + mode
                        +", Attempt: " + failedCounter + "\n"+ xy+"\nSuccessful\n\n";
                failedCounter = 0;
            } else {
                tv.setText(" Your accuracy is: " + (double)((result*100)/4) + "%\n Age : " + age
                        + ", Gender : " + gender + ", Vision : " + vision + "\n Hand : " + hand + ", Unsuccessful");
                coords ="Age : " + age + ", Gender : " + gender + ", Vision : " + vision
                        + ", Hand : " + hand + "\nFor Capthca Image : " + imgNo + ", Mode : " + mode
                        +", Attempt: " + failedCounter + "\n"+ xy+"\nUnsuccessful\n\n";
            }

        } else {
            if((int)((result*100)/4) == 100){
                tv.setText(" Your accuracy is: " + (double)((result*100)/4) + "%\n Age : " + age
                        + ", Gender : " + gender + ", Vision : " + vision + "\n Hand : " + hand + ", Successful");
                coords ="Age : " + age + ", Gender : " + gender + ", Vision : " + vision
                        + ", Hand : " + hand + "\nFor Capthca Image : " + imgNo + ", Mode : " + mode
                        +", Attempt: " + failedCounter + "\n"+ xy+"\nSuccessful\n\n";
                failedCounter = 0;
            } else {
                tv.setText(" Your accuracy is: " + (double)((result*100)/4) + "%\n Age : " + age
                        + ", Gender : " + gender + ", Vision : " + vision + "\n Hand : " + hand + ", Unsuccessful");
                coords ="Age : " + age + ", Gender : " + gender + ", Vision : " + vision
                        + ", Hand : " + hand + "\nFor Capthca Image : " + imgNo + ", Mode : " + mode
                        +", Attempt: " + failedCounter + "\n"+ xy+"\nUnsuccessful\n\n";
            }
        }



        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File myExFile = new File(cw.getExternalFilesDir("/HandMotionData" ),"motionData.txt");

        try {
            FileOutputStream fos = new FileOutputStream(myExFile, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.append(coords);
            outputStreamWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }
}
