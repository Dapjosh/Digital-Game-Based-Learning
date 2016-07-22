package com.example.oladapo.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Congratulations extends Activity {
    public static final String KEY_DIFFICULTY = "org.example.sudoku.difficulty";
    private static final String TAG = "Sudoku";
    TextView textScore;
    Button saveButton;
    TextView textViewTime;
    Button restartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
//        getIntent().putExtra(KEY_DIFFICULTY, DIFFICULTY_CONTINUE);
        final int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
        final int finalScore = getIntent().getExtras().getInt("final_score");
        final int sudokuScore = getIntent().getExtras().getInt("sudoku_score");
        final int equationScore = getIntent().getExtras().getInt("equation_score");
        final long minutesRemaining = getIntent().getExtras().getLong("minutes_remaining");
        switch (diff) {
            case 2:
                setContentView(R.layout.congratulations);
                Log.d(TAG, "final score" + finalScore);
                textScore = (TextView) findViewById(R.id.textViewScore);
                restartButton = (Button) findViewById(R.id.restart);
                textViewTime = (TextView) findViewById(R.id.textViewTime);
                textScore.setText(""+finalScore+ " whooping points");
                textViewTime.setText("" +minutesRemaining+" seconds");
                saveButton = (Button) findViewById(R.id.saveButton);
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Intent intent = new Intent(Congratulations.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Intent intent = new Intent(Congratulations.this, Register.class);
                        intent.putExtra("score", finalScore);
                        startActivity(intent);
                    }
                });
                break;
            case 1:
                setContentView(R.layout.congratulations);
                Log.d(TAG, "final score" + finalScore);
                restartButton = (Button) findViewById(R.id.restart);
                textViewTime = (TextView) findViewById(R.id.textViewTime);
                textScore = (TextView) findViewById(R.id.textViewScore);
                textScore.setText(""+finalScore+" whooping points");
                textViewTime.setText("" +minutesRemaining+" seconds");
                saveButton = (Button) findViewById(R.id.saveButton);
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Intent intent = new Intent(Congratulations.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Intent intent = new Intent(Congratulations.this, Register.class);
                        intent.putExtra("score", finalScore);
                        startActivity(intent);
                    }
                });
               /* nextButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SecondActivity.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });*/
                break;
            case 0:
                Log.d(TAG, "final score" + finalScore);
                Log.d(TAG, "minutes" + minutesRemaining);
                setContentView(R.layout.congratulations);
                restartButton = (Button) findViewById(R.id.restart);
                textScore = (TextView) findViewById(R.id.textViewScore);
                textViewTime = (TextView) findViewById(R.id.textViewTime);
                textScore.setText(""+finalScore+" whooping points");
                textViewTime.setText("" +minutesRemaining+" seconds");
                saveButton = (Button) findViewById(R.id.saveButton);
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Intent intent = new Intent(Congratulations.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Intent intent = new Intent(Congratulations.this, Register.class);
                        intent.putExtra("score", finalScore);
                        startActivity(intent);
                    }
                });
               /* nextButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SecondActivity.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });*/
                break;
        }
    }
}
