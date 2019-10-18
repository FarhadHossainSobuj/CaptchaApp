package com.example.captchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FailedActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed);
        Result.failedCounter += 1;
    }

    public void onRetryClicked(View view) {
        Intent intent = new Intent(this, ModeSelection.class);
        startActivity(intent);
    }
}
