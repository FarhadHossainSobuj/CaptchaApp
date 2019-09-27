package com.example.captchapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;

public class TestImage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_test_image);

        int totalTestImage = 17;

        final ArrayList<Integer> list1 = new ArrayList<Integer>(totalTestImage);
        ArrayList<Bitmap> bitmaps = new ArrayList<>(totalTestImage);
        ArrayList<Integer> tagList = new ArrayList<Integer>(totalTestImage);

        for (int i=0; i<=totalTestImage; i++) {
            list1.add(new Integer(i));
        }
        for (int i=0; i<=totalTestImage; i++) {
            bitmaps.add(BitmapFactory.decodeFile("/storage/emulated/0/img/"+i+"/"+"0.png"));
        }
        Collections.shuffle(list1);
        ImageView iv = (ImageView)findViewById(R.id.imageView);
        iv.setImageBitmap(bitmaps.get(list1.get(0)));


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openStartingPoint = new Intent(TestImage.this,
                            MainActivity.class);
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
