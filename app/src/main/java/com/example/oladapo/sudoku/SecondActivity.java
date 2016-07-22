package com.example.oladapo.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by oladapo on 6/28/16.
 */
public class SecondActivity extends Activity {
    public static final String KEY_DIFFICULTY= "org.example.sudoku.difficulty";
    private static final String TAG = "Sudoku" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate" );
//        getIntent().putExtra(KEY_DIFFICULTY, DIFFICULTY_CONTINUE);
        final int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
        switch (diff) {
            case 2:
                setContentView(R.layout.second);
                View nextButton = findViewById(R.id.next_button);
                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onCreate "+ diff );
                        Intent intent = new Intent(SecondActivity.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });
                break;
            case 1:
                setContentView(R.layout.second);
                View nextButton2 = findViewById(R.id.next_button);
                nextButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SecondActivity.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });
                break;
            case 0:
                setContentView(R.layout.second);
                View nextButton3 = findViewById(R.id.next_button);
                nextButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SecondActivity.this, Equation.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                });
                break;
        }
    }
}
