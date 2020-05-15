package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;//window code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get links of the buttons
        Button button1 = findViewById(R.id.buttonActF);
        Button button2 = findViewById(R.id.buttonActS);

        button1.setOnClickListener(l -> { //setting listener on the first button
                    Intent intent = new Intent(this, SecondActivity.class);
                    startActivityForResult(intent, REQUEST_CODE); //context method
        });

        button2.setOnClickListener(l -> { //set listener of implicit intent
            String q = "Intent Android"; //text of internet request
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH); //google search
            intent.putExtra(SearchManager.QUERY, q);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            Intent openLinkIntent = null;
            if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(openLinkIntent);
            } else {
                Log.d("Intent", "Error!");
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "User has gone out of the activity", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_OK) {

                if (data != null) {
                    String text = data.getStringExtra("result");
                    if (text != null) {
                        TextView nameResult = findViewById(R.id.result);
                        nameResult.setText(text);
                    }
                }
            }
        }
    }
}
