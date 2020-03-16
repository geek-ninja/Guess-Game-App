package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WonActivity extends AppCompatActivity {

    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        resultText = findViewById(R.id.wonText);
        Intent intent = getIntent();
        String str = intent.getStringExtra("resultMessage");
        resultText.setText(str);
    }

    public void reStart(View view){
        Intent intent = new Intent(WonActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
