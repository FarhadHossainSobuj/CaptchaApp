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
        radioGroupHand = findViewById(R.id.radioGroupHand);
        radioGroupVision = findViewById(R.id.radioGroupVision);

    }
    public void onSubmitClicked(View view){
        switch (radioGroupGender.getCheckedRadioButtonId()){
            case R.id.radioFemale:
                gender = "Female";
                break;
            case R.id.radioMale:
                gender = "Male";
                break;
        }
        switch (radioGroupHand.getCheckedRadioButtonId()){
            case R.id.rightHand:
                hand = "Right";
                break;
            case R.id.leftHand:
                hand = "Left";
                break;
        }
        switch (radioGroupVision.getCheckedRadioButtonId()){
            case R.id.impaired:
                vision = "Impaired";
                break;
            case R.id.notImpaired:
                vision = "Not Impaired";
                break;
        }

        if(age.getText().toString().equals("") || hand.equals("") || gender.equals("") || vision.equals("")){
            Toast.makeText(this, "Enter information first", Toast.LENGTH_SHORT).show();
        }else {
            usersAge = age.getText().toString();
            userInfo = usersAge + " " + gender + " " + vision + " " + hand;
            Intent intent = new Intent(this, ModeSelection.class);
            startActivity(intent);
        }
    }

}
