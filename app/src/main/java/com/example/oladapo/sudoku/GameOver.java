package com.example.oladapo.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by oladapo on 6/30/16.
 */
public class GameOver extends Activity {

    public static final String KEY_DIFFICULTY= "org.example.sudoku.difficulty";
    private static final String TAG = "Sudoku" ;
    Button restartButton;
    TextView gameScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate" );
//        getIntent().putExtra(KEY_DIFFICULTY, DIFFICULTY_CONTINUE);
        final int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
        final int score = getIntent().getExtras().getInt("score");
        switch (diff) {
            case 2:
                setContentView(R.layout.gameover);
                restartButton = (Button) findViewById(R.id.restart);
                gameScore = (TextView) findViewById(R.id.textView5);
                gameScore.setText(""+score+" points");
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Log.d(TAG, "score "+ score);
                        Intent intent = new Intent(GameOver.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });
                break;
            case 1:
                setContentView(R.layout.gameover);
                restartButton = (Button) findViewById(R.id.restart);
                gameScore = (TextView) findViewById(R.id.textView5);
                gameScore.setText(""+score+" points");
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Log.d(TAG, "score "+ score);
                        Intent intent = new Intent(GameOver.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
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
                setContentView(R.layout.gameover);
                restartButton = (Button) findViewById(R.id.restart);
                gameScore = (TextView) findViewById(R.id.textView5);
                gameScore.setText(""+score+" points");
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Log.d(TAG, "score "+ score);
                        Intent intent = new Intent(GameOver.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
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
