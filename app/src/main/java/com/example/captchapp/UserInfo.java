package com.example.captchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity {
    private EditText age;
    private RadioGroup radioGroupGender, radioGroupHand, radioGroupVision;
    public String userInfo;
    public static String gender, vision, hand, usersAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        setTitle("User Info");

        age = findViewById(R.id.age);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radioFemale:
                        gender = "Female";
                        break;
                    case R.id.radioMale:
                        gender = "Male";
                        break;
                }
            }
        });
        radioGroupHand = findViewById(R.id.radioGroupHand);
        radioGroupHand.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.rightHand:
                        hand = "Right";
                        break;
                    case R.id.leftHand:
                        hand = "Left";
                        break;
                }
            }
        });
        radioGroupVision = findViewById(R.id.radioGroupVision);
        radioGroupVision.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.impaired:
                        vision = "Impaired";
                        break;
                    case R.id.notImpaired:
                        vision = "Not Impaired";
                        break;
                }
            }
        });
    }
    public void onSubmitClicked(View view){

        //String usersAge, gender, hand, vision;
        //usersAge = age.getText().toString();
        //gender = (male.isChecked())?"Male":(female.isChecked())?"Female":"Other";
        //hand = (leftHandy.isChecked())?"Left":(rightHandy.isChecked())?"Right":"";
        //vision = (visionImpaired.isChecked())?"Vision Impared":(notVisionImpaired.isChecked())?"Not Vision Impaired":"";
        //userInfo = "Age: " + usersAge + ", Gender: " + gender + ", Hand: " + hand + ", Vision: " + vision;
        //Toast.makeText(this, "" + userInfo, Toast.LENGTH_SHORT).show();
        usersAge = age.getText().toString();
        userInfo = usersAge + " " + gender + " " + vision + " " + hand;
        Intent intent = new Intent(this, ModeSelection.class);
        //intent.putExtra("age", usersAge);
        //intent.putExtra("gender", gender);
        //intent.putExtra("hand", hand);
        //intent.putExtra("vision", vision);
        startActivity(intent);
    }

}
