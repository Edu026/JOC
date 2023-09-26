package com.example.joc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static Random rand = new Random();
    static int intRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intRandom = rand.nextInt(10);

        final Button button = findViewById(R.id.button_1);
        final EditText answer  = findViewById(R.id.editTextNumber);
        //TextView viewRandom = (TextView)findViewById(R.id.textView2);
        //viewRandom.setText(intRandom);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(MainActivity.this, text, duration);
                toast.show();

                //Log.i("INFO","El número introduït és: " + intRandom);

            }
        });
    }
}