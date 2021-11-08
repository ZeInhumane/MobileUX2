package com.example.mobileux2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_UserInfo extends AppCompatActivity implements View.OnClickListener{

    private boolean fulltimestudent = false ;
    private String selectedGender ;
    private String studDOB , fullTime;
    private RadioGroup radioGenderGroup;
    private RadioButton radioGenderButton;
    private EditText stdName, stdID;
    private DatePicker pickDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        radioGenderGroup=(RadioGroup)findViewById(R.id.rdGpBox);
        stdName = (EditText) findViewById((R.id.editTextStudentName));
        stdID = (EditText) findViewById(R.id.editTextStudentID);
        pickDOB = (DatePicker) findViewById(R.id.dPickDOB);

    }

    @Override
    public void onClick(View v) {

        // Get the selected Gender Group
        int selectedId=radioGenderGroup.getCheckedRadioButtonId();
        radioGenderButton=(RadioButton)findViewById(selectedId);
        selectedGender = radioGenderButton.getText().toString();
        studDOB = pickDOB.getDayOfMonth() + "/" + pickDOB.getMonth() +"/" + pickDOB.getYear();

        if (fulltimestudent){
            fullTime ="Full Time Student";
        }else{
            fullTime = "Part Time Student";
        }

        String display = "Student Name : " + stdName.getText().toString() + "Student ID : " +
                stdID.getText().toString() + " Status : " + fullTime + " " + selectedGender.toString() + " DOB : " + studDOB.toString() ;



        switch (v.getId()) {

            case R.id.btnNextPage:
                Toast.makeText(Activity_UserInfo.this,display,Toast.LENGTH_SHORT).show();
                // Start of Create Dialog
                AlertDialog.Builder alertUser = new AlertDialog.Builder(this);
                alertUser.setMessage(display).setTitle("User Information");
                AlertDialog alertDialog = alertUser.create();
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface alertDialog, int which){
                    }
                });
                alertDialog.show();
                // End of Create Dialog

                Intent i = new Intent(this, ActivityQuizQ.class);
                startActivity(i);
                break;
        }

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.chkBoxFullTime:
                if (checked)
                    fulltimestudent = true ;
                break;
        }
    }
}

