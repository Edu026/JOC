package com.example.joc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {
        static ArrayList<String> records = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String intents;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                intents= null;
            } else {
                intents= extras.getString("INTENTS");
            }
        } else {
            intents= (String) savedInstanceState.getSerializable("INTENTS");
        }
    }


}