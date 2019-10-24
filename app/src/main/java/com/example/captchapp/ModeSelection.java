package com.example.captchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class ModeSelection extends AppCompatActivity {
    private RadioGroup radioGroupMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_selection);
        radioGroupMode = findViewById(R.id.radioGroupMode);

        radioGroupMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.easy:
                        transition("easy");
                        break;
                    case R.id.hard:
                        transition("hard");
                        break;
                }
            }
        });
    }

    private void transition(String mode) {
        if(mode.equals("easy")){
            Intent intent = new Intent(this, TestImageEasy.class);
            intent.putExtra("mode", "easy");
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, TestImage.class);
            intent.putExtra("mode", "hard");
            startActivity(intent);
        }
    }
}
