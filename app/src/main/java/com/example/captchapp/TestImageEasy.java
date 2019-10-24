package com.example.captchapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class TestImageEasy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_image_easy);
        int totalTestImage = 6;

        final ArrayList<Integer> list1 = new ArrayList<Integer>(totalTestImage);
        ArrayList<Bitmap> bitmaps = new ArrayList<>(totalTestImage);

        for (int i=0; i< totalTestImage; i++) {
            list1.add(new Integer(i));
        }
        for (int i=0; i<=totalTestImage; i++) {
            bitmaps.add(BitmapFactory.decodeFile("/storage/emulated/0/img/easy/"+i+"/"+"0.png"));
        }
        Collections.shuffle(list1);
        ImageView iv = (ImageView)findViewById(R.id.imageViewEasy);
        iv.setImageBitmap(bitmaps.get(list1.get(0)));


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openStartingPoint = new Intent(TestImageEasy.this,
                            ActivityEasyTask.class);
                    openStartingPoint.putExtra("testImageNo", "" + list1.get(0));
                    startActivity(openStartingPoint);
                }

            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
