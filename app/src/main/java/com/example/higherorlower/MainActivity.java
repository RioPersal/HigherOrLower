package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void randomNumberGenerator()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt();
    }
    public void onGuess(View view){

        try {
            EditText editText = (EditText) findViewById(R.id.editText);
            int guessedNumber = Integer.parseInt(editText.getText().toString());
            if (guessedNumber < randomNumber)
            Toast.makeText(this,"Higher !!", Toast.LENGTH_SHORT).show();
            else if (guessedNumber > randomNumber)
            Toast.makeText(this,"Lower !!", Toast.LENGTH_SHORT).show();
            else if (guessedNumber == randomNumber)
            {
                Toast.makeText(this,"You got me !!", Toast.LENGTH_SHORT).show();
                randomNumberGenerator();
            }

        }catch (Exception e){
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setError("Harap memasukkan angka untuk bermain !!");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }
}