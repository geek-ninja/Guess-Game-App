package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int x = new Random().nextInt(20) + 1;
    String y = Integer.toString(x);
    int start=0;
    int trails=0;

    public void submit(View view) {
        Button button = findViewById(R.id.button);
        TextView res = findViewById(R.id.result);
        TextView trail=findViewById(R.id.trails);
        TextView welcome = findViewById(R.id.welcome);
        EditText playerName = findViewById(R.id.editName);
        String welcomeText = playerName.getText().toString();
        //res.setText(y);
        EditText guess = findViewById(R.id.editText);
        String g = guess.getText().toString();
        //int A = Integer.parseInt(g);
        //res.setText(g);
        try{
            int A = Integer.parseInt(g);
            if (welcomeText.equals("")){
                welcome.setText("Plz enter your name !");
                start =0;
            }
            else{
                button.setVisibility(View.VISIBLE);
                if (start == 1) {
                    if (trails >= 4) {
                        trail.setText("You have no trails left!");
                        //res.setText("Sorry...Better luck next time and the answer is " + x);
                        Intent intent = new Intent(MainActivity.this,WonActivity.class);
                        String lostStr = "Sorry ..Better Luck next Time, Correct guess is "+ x;
                        intent.putExtra("resultMessage",lostStr);
                        startActivity(intent);

                    } else {
                        trails++;
                        trail.setText("You have "+(5-trails)+" trails left!");
                        if (y.equals(g) && !(y.equals(""))) {
                            //res.setText("Congo!!you got it ");
                            Intent intent = new Intent(MainActivity.this,WonActivity.class);
                            intent.putExtra("resultMessage","Congo !! You got it ");
                            startActivity(intent);
                        } else if (A > x) {
                            res.setText("Guess a lower number");
                        } else if (A < x) {
                            res.setText("Guess a higher number");
                        }
                    }
                }
                else {
                    res.setText("You can't start..Enter name first");
                }
            }
        }
        catch (NumberFormatException e){
            res.setText("plz enter a number");
        }
    }
    public void nameSubmit(View view){
        TextView nameText = findViewById(R.id.playerName);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        EditText playerName = findViewById(R.id.editName);
        TextView welcome=findViewById(R.id.welcome);
        String welcomeText=playerName.getText().toString();
        if (welcomeText.equals("")){
            welcome.setText("Enter the player name first");
            start=0;
        }
        else {
            welcome.setText("Welcome to the game " + welcomeText);
            start = 1;
            button.setVisibility(View.VISIBLE);
            nameText.setVisibility(View.GONE);
            playerName.setVisibility(View.GONE);
            button2.setText("Let's Play");
        }
    }
}
