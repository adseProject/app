package com.example.mario.user_draft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button createProfileBtn;
    Button selectProfileBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createProfileBtn = (Button) findViewById(R.id.createButton);
        selectProfileBtn = (Button) findViewById(R.id.selectButton);

    }
    public void openCreateProfileActivity(){
        Intent intent = new Intent(this, CreateProfileActivity.class);
        startActivity(intent);
    }
    public void openDisplayProfileActivity(){
        Intent intent = new Intent(this, displayProfile.class);
        startActivity(intent);
    }

    public void selectButtonClicked(View view) {
        openDisplayProfileActivity();
    }

    public void createButtonClicked(View view) {
        openCreateProfileActivity();
    }
}
