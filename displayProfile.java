package com.example.mario.user_draft;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class displayProfile extends Activity {

    TextView dbView;
    Button showDBButton;
    MyDBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);

        dbView = (TextView)findViewById(R.id.dbDisplay);
        dbHelper = new MyDBHelper(this, null, null, 1);
        showDBButton = (Button)findViewById(R.id.showDB);
    }


    public void showDBClicked(View view) {

        Cursor c = dbHelper.getAllData();
        if(c.getCount() == 0) {
            showMessage("Error"," Nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
                buffer.append("ID :"+c.getString(0)+"\n");
                buffer.append("Vorname :"+c.getString(1)+"\n");
                buffer.append("Nachname :"+c.getString(2)+"\n");
                buffer.append("Email :"+c.getString(3)+"\n");
                buffer.append("Geburtsdatum :"+c.getString(4)+"\n");
                //buffer.append("Geschlecht: "+c.getString(5)+"\n\n");

        }

        showMessage("Data", buffer.toString());


        }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void textViewClicked(View view) {
    dbHelper.clearTable();
    }
}



