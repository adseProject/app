package com.example.mario.user_draft;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateProfileActivity extends Activity {

    EditText Vorname;
    EditText Name;
    EditText Email;
    EditText DOB;
    MyDBHelper dbHelper;
    //Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        dbHelper = new MyDBHelper(this, null, null, 1);

        //Spinner layout
        Spinner dropdown = findViewById(R.id.spinnerGeschlecht);
        String[] items = new String[]{"Mann", "Frau"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        //Text Connection

        Vorname = (EditText)findViewById(R.id.inputVorname);
        Name = (EditText) findViewById(R.id.inputName);
        Email = (EditText)findViewById(R.id.inputEmail);
        DOB = (EditText)findViewById(R.id.inputDOB);
        //mySpinner = (Spinner)findViewById(R.id.spinnerGeschlecht);


    }

    public void createButtonClicked(View view) {
        Users user = new Users(Vorname.getText().toString(), Name.getText().toString(), Email.getText().toString(), DOB.getText().toString());
        dbHelper.addUser(user);
    }
}
// , mySpinner.getSelectedItem().toString()