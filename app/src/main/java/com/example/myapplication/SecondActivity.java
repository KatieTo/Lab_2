package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //get link of EditText
        // get link of the button
        EditText editNumber = findViewById(R.id.editText);
        Button confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(v -> { //set listener on the button

            String text = editNumber.getText().toString(); //read field
            Intent intent = new Intent(); //was create empty intent
            intent.putExtra("result", text); //here we add data
            setResult(RESULT_OK, intent);
            finish(); //end of activity
        });
    }
}
