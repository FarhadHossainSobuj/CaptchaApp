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
    String coords = "";
    TextView tv;
    private String userData = "userData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");

        tv = (TextView)findViewById(R.id.textView);
        int result = Integer.parseInt(getIntent().getStringExtra("result"));
        String x = getIntent().getStringExtra("xCord");
        String y = getIntent().getStringExtra("yCord");
        coords ="X : "+ x + "\nY: "+y+"\n\n";
        tv.setText("Your accuracy is: " + (float)((result*100)/12) + "%");

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
