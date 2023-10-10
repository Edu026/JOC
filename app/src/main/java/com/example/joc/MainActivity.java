package com.example.joc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    String oldAnswers = "";

    Integer intents = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intRandom = rand.nextInt(10);

        final Button button_1 = findViewById(R.id.button_1);
        final Button button = findViewById(R.id.button);
        final EditText answer = findViewById(R.id.editTextNumber);
        TextView viewAnswers = findViewById(R.id.intents);

        String OnClick;
        android:OnClick = "sendMessage";



        button_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    intents ++;

                    int numberAnswer = Integer.parseInt(answer.getText().toString());

                    oldAnswers += numberAnswer + "\n";
                    CharSequence text = "";

                    Log.i("INFO","El número random és: " + intRandom);
                    if (numberAnswer < intRandom) {
                        text = "El número que buscas es mayor";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                    } else if (numberAnswer > intRandom) {
                        text = "El número que buscas es menor";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                    } else if (numberAnswer == intRandom){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage(R.string.dialog_message);
                        //.setTitle(R.string.dialog_title);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }catch (NumberFormatException e){}

                viewAnswers.setText(oldAnswers);
            }


        });
    }
    
    public void sendMessage(View view){
        Intent intent = new Intent(MainActivity.this, RecordsActivity.class);
        intent.putExtra("INTENTS",intent.toString());

        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        alert.setTitle("VOLS GUARDAR EL TEU RECORD ?");
        alert.setMessage("ESCRIU EL TEU NOM");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = String.valueOf(input.getText());
                startActivity(intent);

                // Do something with value!
            }
        });

        alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

}
