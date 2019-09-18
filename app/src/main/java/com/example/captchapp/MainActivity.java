package com.example.captchapp;
import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static final int PERMISSION_REQUEST_CODE=100;

    private int dragCounter, success;

    private ImageView img0, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int imgIndex = Integer.parseInt(getIntent().getStringExtra("testImageNo"));
        int totalTestImage = 6;

        img0 = findViewById(R.id.img0);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        img13 = findViewById(R.id.img13);
        img14 = findViewById(R.id.img14);
        img15 = findViewById(R.id.img15);
        final List<ImageView> list = new ArrayList<>(15);
        list.add(img0);
        list.add(img1);
        list.add(img2);
        list.add(img3);
        list.add(img4);
        list.add(img5);
        list.add(img6);
        list.add(img7);
        list.add(img8);
        list.add(img9);
        list.add(img10);
        list.add(img11);
        list.add(img12);
        list.add(img13);
        list.add(img14);
        list.add(img15);

        ArrayList<Integer> list1 = new ArrayList<Integer>(16);
        ArrayList<Bitmap> bitmaps = new ArrayList<>(16);
        ArrayList<Integer> tagList = new ArrayList<Integer>(16);

        for (int i=0; i<=15; i++) {
            list1.add(new Integer(i));
        }

        int rand = new Random().nextInt(5);
        for (int i=0; i<=15; i++) {
            if(i < 12){
                bitmaps.add(BitmapFactory.decodeFile("/storage/emulated/0/img/"+imgIndex+"/"+(i+1)+".png"));
            } else {
                bitmaps.add(BitmapFactory.decodeFile("/storage/emulated/0/img/"+rand+"/"+(i-3)+".png"));
            }
        }
        Collections.shuffle(list1);
        for (int i=0; i<=15; i++) {
            tagList.add(list1.get(i));
        }
        if(isStoragePermissionGranted()){
            for (int i = 0; i < 16; i++){
                list.get(i).setImageBitmap(bitmaps.get(list1.get(i)));
                list.get(i).setTag(""+tagList.get(i));
            }
        }

        for(int i = 0; i <= 15; i++){
            list.get(i).setOnTouchListener(this);
        }
        findViewById(R.id.inputLayout1).setOnDragListener(this);
        findViewById(R.id.inputLayout2).setOnDragListener(this);
        findViewById(R.id.inputLayout3).setOnDragListener(this);
        findViewById(R.id.inputLayout4).setOnDragListener(this);
        findViewById(R.id.inputLayout5).setOnDragListener(this);
        findViewById(R.id.inputLayout6).setOnDragListener(this);
        findViewById(R.id.inputLayout7).setOnDragListener(this);
        findViewById(R.id.inputLayout8).setOnDragListener(this);
        findViewById(R.id.inputLayout9).setOnDragListener(this);
        findViewById(R.id.inputLayout10).setOnDragListener(this);
        findViewById(R.id.inputLayout11).setOnDragListener(this);
        findViewById(R.id.inputLayout12).setOnDragListener(this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            // signal for the start of a drag and drop operation
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;

            // the drag point has entered the bounding box of the View
            case DragEvent.ACTION_DRAG_ENTERED:
                v.setBackgroundColor(0xFFFFF6F9);
                break;

            // the user has moved the drag shadow outside the bounding box of the View
            case DragEvent.ACTION_DRAG_EXITED:
                v.setBackgroundColor(v.getId() == R.id.inputLayout1 ? 0xFFE8E6E7 : 0xFFB1BEC4);
                break;

            // the drag and drop operation has concluded
            case DragEvent.ACTION_DRAG_ENDED:
                v.setBackgroundColor(v.getId() == R.id.inputLayout1 ? 0xFFE8E6E7 : 0xFFB1BEC4);
                break;

            //drag shadow has been released,the drag point is within the bounding box of the View
            case DragEvent.ACTION_DROP:
                String id = "";
                View view = (View) event.getLocalState();
                // we want to make sure it is dropped only to left and right parent view
                if (v.getId() == R.id.inputLayout1 || v.getId() == R.id.inputLayout2 || v.getId() == R.id.inputLayout3
                        || v.getId() == R.id.inputLayout4 || v.getId() == R.id.inputLayout5 || v.getId() == R.id.inputLayout6
                        || v.getId() == R.id.inputLayout7 || v.getId() == R.id.inputLayout8 || v.getId() == R.id.inputLayout9
                        || v.getId() == R.id.inputLayout10 || v.getId() == R.id.inputLayout11 || v.getId() == R.id.inputLayout12) {
                    ViewGroup source = (ViewGroup) view.getParent();
                    source.removeView(view);
                    LinearLayout target = (LinearLayout) v;
                    target.addView(view);
                    id = target.getTag().toString();
                }
                // make view visible as we set visibility to invisible while starting drag
                //Toast.makeText(this, "" + view.getTag().toString(), Toast.LENGTH_SHORT).show();
                dragCounter = dragCounter + 1;
                if(Integer.parseInt(id) == Integer.parseInt(view.getTag().toString())){
                    success = success + 1;
                }
                view.setVisibility(View.VISIBLE);
                if(dragCounter >= 12){
                    Intent intent = new Intent(this, Result.class);
                    intent.putExtra("result", "" + success);
                    startActivity(intent);
                }
                //Toast.makeText(this, "Dragged: "+dragCounter+" Success: " + success, Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            ClipData data = ClipData.newPlainText("id", view.getResources().getResourceEntryName(view.getId()));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                view.startDragAndDrop(data, shadowBuilder, view, 0);
            } else {
                view.startDrag(data, shadowBuilder, view, 0);
            }

            view.setVisibility(View.INVISIBLE);
            return true;
        }
        return false;
    }
}