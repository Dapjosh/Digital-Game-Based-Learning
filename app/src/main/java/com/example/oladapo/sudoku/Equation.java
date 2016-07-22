package com.example.oladapo.sudoku;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class Equation extends Activity {
    private static final String TAG = "Sudoku";
    public static final String KEY_DIFFICULTY = "org.example.sudoku.difficulty";
    public static final String MyPREFERENCES = "MyPrefs" ;
    ProgressBar progressBar;
    TextView textViewTime;
    Button buttonHelp;
    CountDownTimer countDownTimer;
    long millisRemaining = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
        switch (diff) {
            case 2:
                setContentView(R.layout.equationhard);

                buttonHelp = (Button)findViewById(R.id.buttonHelp);

                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                textViewTime = (TextView) findViewById(R.id.textViewTime);
                countDownTimer = new CountDownTimer(120000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int progress = (int) (millisUntilFinished / 1000);
                        millisRemaining = 120000-millisUntilFinished;
                        progressBar.setProgress(progressBar.getMax() - progress);
                        textViewTime.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        Log.d(TAG, "The " + diff);
                        Intent intent = new Intent(Equation.this,GameOver.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                }.start();
                buttonHelp.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                        alertDialog.setTitle("Help");
                        alertDialog.setMessage(" In the equation you are required to solve for x. The equation is in the form ax+b=c or ax-b=c, In solving equations with\n" +
                                "        + sign you move the b to the c making it c-b and then divide your answer by a and that gives your solution. In an equation with the negative operation,\n" +
                                "        you move b to c and this makes it to be c + b, then divide your answer by a to arrive at the required solution.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();

                                    }
                                });
                        alertDialog.show();

                    }
                });
                /*final CounterClass timer = new CounterClass(180000, 1000);
                timer.start();*/
                calculateAlgebraHard();
                break;
            case 1:
                setContentView(R.layout.equationmedium);
                buttonHelp = (Button)findViewById(R.id.buttonHelp);

                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                textViewTime = (TextView) findViewById(R.id.textViewTime);
                countDownTimer = new CountDownTimer(90000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int progress = (int) (millisUntilFinished / 1000);
                        millisRemaining = 90000-millisUntilFinished;
                        progressBar.setProgress(progressBar.getMax() - progress);
                        textViewTime.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        Intent intent = new Intent(Equation.this,GameOver.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                }.start();
                buttonHelp.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                        alertDialog.setTitle("Help");
                        alertDialog.setMessage(" In the equation you are required to solve for x. The equation is in the form ax+b=c or ax-b=c, In solving equations with\n" +
                                "        + sign you move the b to the c making it c-b and then divide your answer by a and that gives your solution. In an equation with the negative operation,\n" +
                                "        you move b to c and this makes it to be c + b, then divide your answer by a to arrive at the required solution.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();

                                    }
                                });
                        alertDialog.show();

                    }
                });
                /*final CounterClass timer2 = new CounterClass(180000, 1000);
                timer2.start();*/
                calculateAlgebraMedium();
                break;
            case 0:
                setContentView(R.layout.equationeasy);

                progressBar = (ProgressBar) findViewById(R.id.progressBar);
                textViewTime = (TextView) findViewById(R.id.textViewTime);
               countDownTimer = new CountDownTimer(60000, 1000) {


                    public void onTick(long millisUntilFinished) {
                        int progress = (int) (millisUntilFinished / 1000);
                        progressBar.setProgress(progressBar.getMax() - progress);
                        millisRemaining = 60000-millisUntilFinished;
                        Log.d(TAG, "this is left "+millisRemaining/1000);
                        textViewTime.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        Intent intent = new Intent(Equation.this,GameOver.class);
                        intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                        startActivity(intent);
                    }
                }.start();
                buttonHelp = (Button)findViewById(R.id.buttonHelp);
                buttonHelp.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                        alertDialog.setTitle("Help");
                        alertDialog.setMessage(" In the equation you are required to solve for x. The equation is in the form ax+b=c or ax-b=c, In solving equations with\n" +
                                "        + sign you move the b to the c making it c-b and then divide your answer by a and that gives your solution. In an equation with the negative operation,\n" +
                                "        you move b to c and this makes it to be c + b, then divide your answer by a to arrive at the required solution.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();

                                    }
                                });
                        alertDialog.show();

                    }
                });
//                final CounterClass timer3 = new CounterClass(180000, 1000);
//                timer3.start();
                calculateAlgebraEasy();
                break;
        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    public void calculateAlgebraHard() {
        final int[] answers = new int[17];
        final int[] variablesa = new int[17];
        final int[] variablesb = new int[17];
        final int[] variablesc = new int[17];
        final char[] operators = new char[17];

        final TextView variable_a_1 = (TextView) findViewById(R.id.variable_a_1);
        final TextView variable_a_2 = (TextView) findViewById(R.id.variable_a_2);
        final TextView variable_a_3 = (TextView) findViewById(R.id.variable_a_3);
        final TextView variable_a_4 = (TextView) findViewById(R.id.variable_a_4);
        final TextView variable_a_5 = (TextView) findViewById(R.id.variable_a_5);
        final TextView variable_a_6 = (TextView) findViewById(R.id.variable_a_6);
        final TextView variable_a_7 = (TextView) findViewById(R.id.variable_a_7);
        final TextView variable_a_8 = (TextView) findViewById(R.id.variable_a_8);
        final TextView variable_a_9 = (TextView) findViewById(R.id.variable_a_9);
        final TextView variable_a_10 = (TextView) findViewById(R.id.variable_a_10);
        final TextView variable_a_11 = (TextView) findViewById(R.id.variable_a_11);
        final TextView variable_a_12 = (TextView) findViewById(R.id.variable_a_12);
        final TextView variable_a_13 = (TextView) findViewById(R.id.variable_a_13);
        final TextView variable_a_14 = (TextView) findViewById(R.id.variable_a_14);
        final TextView variable_a_15 = (TextView) findViewById(R.id.variable_a_15);
        final TextView variable_a_16 = (TextView) findViewById(R.id.variable_a_16);
        final TextView variable_a_17 = (TextView) findViewById(R.id.variable_a_17);

        final TextView variable_b_1 = (TextView) findViewById(R.id.variable_b_1);
        final TextView variable_b_2 = (TextView) findViewById(R.id.variable_b_2);
        final TextView variable_b_3 = (TextView) findViewById(R.id.variable_b_3);
        final TextView variable_b_4 = (TextView) findViewById(R.id.variable_b_4);
        final TextView variable_b_5 = (TextView) findViewById(R.id.variable_b_5);
        final TextView variable_b_6 = (TextView) findViewById(R.id.variable_b_6);
        final TextView variable_b_7 = (TextView) findViewById(R.id.variable_b_7);
        final TextView variable_b_8 = (TextView) findViewById(R.id.variable_b_8);
        final TextView variable_b_9 = (TextView) findViewById(R.id.variable_b_9);
        final TextView variable_b_10 = (TextView) findViewById(R.id.variable_b_10);
        final TextView variable_b_11 = (TextView) findViewById(R.id.variable_b_11);
        final TextView variable_b_12 = (TextView) findViewById(R.id.variable_b_12);
        final TextView variable_b_13 = (TextView) findViewById(R.id.variable_b_13);
        final TextView variable_b_14 = (TextView) findViewById(R.id.variable_b_14);
        final TextView variable_b_15 = (TextView) findViewById(R.id.variable_b_15);
        final TextView variable_b_16 = (TextView) findViewById(R.id.variable_b_16);
        final TextView variable_b_17 = (TextView) findViewById(R.id.variable_b_17);

        final TextView operator_1 = (TextView) findViewById(R.id.operator_1);
        final TextView operator_2 = (TextView) findViewById(R.id.operator_2);
        final TextView operator_3 = (TextView) findViewById(R.id.operator_3);
        final TextView operator_4 = (TextView) findViewById(R.id.operator_4);
        final TextView operator_5 = (TextView) findViewById(R.id.operator_5);
        final TextView operator_6 = (TextView) findViewById(R.id.operator_6);
        final TextView operator_7 = (TextView) findViewById(R.id.operator_7);
        final TextView operator_8 = (TextView) findViewById(R.id.operator_8);
        final TextView operator_9 = (TextView) findViewById(R.id.operator_9);
        final TextView operator_10 = (TextView) findViewById(R.id.operator_10);
        final TextView operator_11 = (TextView) findViewById(R.id.operator_11);
        final TextView operator_12 = (TextView) findViewById(R.id.operator_12);
        final TextView operator_13 = (TextView) findViewById(R.id.operator_13);
        final TextView operator_14 = (TextView) findViewById(R.id.operator_14);
        final TextView operator_15 = (TextView) findViewById(R.id.operator_15);
        final TextView operator_16 = (TextView) findViewById(R.id.operator_16);
        final TextView operator_17 = (TextView) findViewById(R.id.operator_17);


        final TextView variable_c_1 = (TextView) findViewById(R.id.variable_c_1);
        final TextView variable_c_2 = (TextView) findViewById(R.id.variable_c_2);
        final TextView variable_c_3 = (TextView) findViewById(R.id.variable_c_3);
        final TextView variable_c_4 = (TextView) findViewById(R.id.variable_c_4);
        final TextView variable_c_5 = (TextView) findViewById(R.id.variable_c_5);
        final TextView variable_c_6 = (TextView) findViewById(R.id.variable_c_6);
        final TextView variable_c_7 = (TextView) findViewById(R.id.variable_c_7);
        final TextView variable_c_8 = (TextView) findViewById(R.id.variable_c_8);
        final TextView variable_c_9 = (TextView) findViewById(R.id.variable_c_9);
        final TextView variable_c_10 = (TextView) findViewById(R.id.variable_c_10);
        final TextView variable_c_11 = (TextView) findViewById(R.id.variable_c_11);
        final TextView variable_c_12 = (TextView) findViewById(R.id.variable_c_12);
        final TextView variable_c_13 = (TextView) findViewById(R.id.variable_c_13);
        final TextView variable_c_14 = (TextView) findViewById(R.id.variable_c_14);
        final TextView variable_c_15 = (TextView) findViewById(R.id.variable_c_15);
        final TextView variable_c_16 = (TextView) findViewById(R.id.variable_c_16);
        final TextView variable_c_17 = (TextView) findViewById(R.id.variable_c_17);

        final EditText answer_1 = (EditText) findViewById(R.id.answer_1);
        final EditText answer_2 = (EditText) findViewById(R.id.answer_2);
        final EditText answer_3 = (EditText) findViewById(R.id.answer_3);
        final EditText answer_4 = (EditText) findViewById(R.id.answer_4);
        final EditText answer_5 = (EditText) findViewById(R.id.answer_5);
        final EditText answer_6 = (EditText) findViewById(R.id.answer_6);
        final EditText answer_7 = (EditText) findViewById(R.id.answer_7);
        final EditText answer_8 = (EditText) findViewById(R.id.answer_8);
        final EditText answer_9 = (EditText) findViewById(R.id.answer_9);
        final EditText answer_10 = (EditText) findViewById(R.id.answer_10);
        final EditText answer_11 = (EditText) findViewById(R.id.answer_11);
        final EditText answer_12 = (EditText) findViewById(R.id.answer_12);
        final EditText answer_13 = (EditText) findViewById(R.id.answer_13);
        final EditText answer_14 = (EditText) findViewById(R.id.answer_14);
        final EditText answer_15 = (EditText) findViewById(R.id.answer_15);
        final EditText answer_16 = (EditText) findViewById(R.id.answer_16);
        final EditText answer_17 = (EditText) findViewById(R.id.answer_17);


        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                answers[0] = Integer.parseInt(answer_1.getText().toString());
                answers[1] = Integer.parseInt(answer_2.getText().toString());
                answers[2] = Integer.parseInt(answer_3.getText().toString());
                answers[3] = Integer.parseInt(answer_4.getText().toString());
                answers[4] = Integer.parseInt(answer_5.getText().toString());
                answers[5] = Integer.parseInt(answer_6.getText().toString());
                answers[6] = Integer.parseInt(answer_7.getText().toString());
                answers[7] = Integer.parseInt(answer_8.getText().toString());
                answers[8] = Integer.parseInt(answer_9.getText().toString());
                answers[9] = Integer.parseInt(answer_10.getText().toString());
                answers[10] = Integer.parseInt(answer_11.getText().toString());
                answers[11] = Integer.parseInt(answer_12.getText().toString());
                answers[12] = Integer.parseInt(answer_13.getText().toString());
                answers[13] = Integer.parseInt(answer_14.getText().toString());
                answers[14] = Integer.parseInt(answer_15.getText().toString());
                answers[15] = Integer.parseInt(answer_16.getText().toString());
                answers[16] = Integer.parseInt(answer_17.getText().toString());

                operators[0] = operator_1.getText().charAt(0);
                operators[1] = operator_2.getText().charAt(0);
                operators[2] = operator_3.getText().charAt(0);
                operators[3] = operator_4.getText().charAt(0);
                operators[4] = operator_5.getText().charAt(0);
                operators[5] = operator_6.getText().charAt(0);
                operators[6] = operator_7.getText().charAt(0);
                operators[7] = operator_8.getText().charAt(0);
                operators[8] = operator_9.getText().charAt(0);
                operators[9] = operator_10.getText().charAt(0);
                operators[10] = operator_11.getText().charAt(0);
                operators[11] = operator_12.getText().charAt(0);
                operators[12] = operator_13.getText().charAt(0);
                operators[13] = operator_14.getText().charAt(0);
                operators[14] = operator_15.getText().charAt(0);
                operators[15] = operator_16.getText().charAt(0);
                operators[16] = operator_17.getText().charAt(0);

                variablesa[0] = Integer.parseInt(variable_a_1.getText().toString());
                variablesa[1] = Integer.parseInt(variable_a_2.getText().toString());
                variablesa[2] = Integer.parseInt(variable_a_3.getText().toString());
                variablesa[3] = Integer.parseInt(variable_a_4.getText().toString());
                variablesa[4] = Integer.parseInt(variable_a_5.getText().toString());
                variablesa[5] = Integer.parseInt(variable_a_6.getText().toString());
                variablesa[6] = Integer.parseInt(variable_a_7.getText().toString());
                variablesa[7] = Integer.parseInt(variable_a_8.getText().toString());
                variablesa[8] = Integer.parseInt(variable_a_9.getText().toString());
                variablesa[9] = Integer.parseInt(variable_a_10.getText().toString());
                variablesa[10] = Integer.parseInt(variable_a_11.getText().toString());
                variablesa[11] = Integer.parseInt(variable_a_12.getText().toString());
                variablesa[12] = Integer.parseInt(variable_a_13.getText().toString());
                variablesa[13] = Integer.parseInt(variable_a_14.getText().toString());
                variablesa[14] = Integer.parseInt(variable_a_15.getText().toString());
                variablesa[15] = Integer.parseInt(variable_a_16.getText().toString());
                variablesa[16] = Integer.parseInt(variable_a_17.getText().toString());

                variablesb[0] = Integer.parseInt(variable_b_1.getText().toString());
                variablesb[1] = Integer.parseInt(variable_b_2.getText().toString());
                variablesb[2] = Integer.parseInt(variable_b_3.getText().toString());
                variablesb[3] = Integer.parseInt(variable_b_4.getText().toString());
                variablesb[4] = Integer.parseInt(variable_b_5.getText().toString());
                variablesb[5] = Integer.parseInt(variable_b_6.getText().toString());
                variablesb[6] = Integer.parseInt(variable_b_7.getText().toString());
                variablesb[7] = Integer.parseInt(variable_b_8.getText().toString());
                variablesb[8] = Integer.parseInt(variable_b_9.getText().toString());
                variablesb[9] = Integer.parseInt(variable_b_10.getText().toString());
                variablesb[10] = Integer.parseInt(variable_b_11.getText().toString());
                variablesb[11] = Integer.parseInt(variable_b_12.getText().toString());
                variablesb[12] = Integer.parseInt(variable_b_13.getText().toString());
                variablesb[13] = Integer.parseInt(variable_b_14.getText().toString());
                variablesb[14] = Integer.parseInt(variable_b_15.getText().toString());
                variablesb[15] = Integer.parseInt(variable_b_16.getText().toString());
                variablesb[16] = Integer.parseInt(variable_b_17.getText().toString());

                variablesc[0] = Integer.parseInt(variable_c_1.getText().toString());
                variablesc[1] = Integer.parseInt(variable_c_2.getText().toString());
                variablesc[2] = Integer.parseInt(variable_c_3.getText().toString());
                variablesc[3] = Integer.parseInt(variable_c_4.getText().toString());
                variablesc[4] = Integer.parseInt(variable_c_5.getText().toString());
                variablesc[5] = Integer.parseInt(variable_c_6.getText().toString());
                variablesc[6] = Integer.parseInt(variable_c_7.getText().toString());
                variablesc[7] = Integer.parseInt(variable_c_8.getText().toString());
                variablesc[8] = Integer.parseInt(variable_c_9.getText().toString());
                variablesc[9] = Integer.parseInt(variable_c_10.getText().toString());
                variablesc[10] = Integer.parseInt(variable_c_11.getText().toString());
                variablesc[11] = Integer.parseInt(variable_c_12.getText().toString());
                variablesc[12] = Integer.parseInt(variable_c_13.getText().toString());
                variablesc[13] = Integer.parseInt(variable_c_14.getText().toString());
                variablesc[14] = Integer.parseInt(variable_c_15.getText().toString());
                variablesc[15] = Integer.parseInt(variable_c_16.getText().toString());
                variablesc[16] = Integer.parseInt(variable_c_17.getText().toString());

                int c = 0;
                for (int i = 0; i < 17; i++) {
                    if (((operators[i] == '+') || (operators[i] == '-'))) {
                        if ((answers[i] != 0) && (variablesa[i] != 0) && (variablesb[i] != 0) && (variablesc[i] != 0)) {
                            if (answers[i] == solveAlgebra(variablesa[i], variablesb[i], variablesc[i], operators[i])) {
                                c++;
                            }
                        } else {
                            AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                            alertDialog.setTitle("You have not entered a number in variable a, b or c");
                            alertDialog.setMessage("Please check the values supplied and play again!");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        }
                    } else {
                        AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                        alertDialog.setTitle("Operator entered is not an addition or subtraction operator");
                        alertDialog.setMessage("Check values, and play again");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }

                }
                final int score = c * 5;
                if (score == 85) {
                    countDownTimer.cancel();
                    AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                    alertDialog.setTitle("Congratulations");
                    alertDialog.setMessage("Stage 1 is completed!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                                    Intent intent = new Intent(Equation.this, Game.class);
                                    intent.putExtra(Game.KEY_DIFFICULTY, diff);
                                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    SharedPreferences.Editor editor= pref.edit();
                                    editor.putInt("equation_score3",score);
                                    editor.putLong("minutesRemaining", millisRemaining/1000);
                                    Log.d(TAG,"TIME "+ millisRemaining/1000);
                                    editor.commit();
                                    intent.putExtra("answerh1", answer_1.getText().toString());
                                    intent.putExtra("answerh2", answer_2.getText().toString());
                                    intent.putExtra("answerh3", answer_3.getText().toString());
                                    intent.putExtra("answerh4", answer_4.getText().toString());
                                    intent.putExtra("answerh5", answer_5.getText().toString());
                                    intent.putExtra("answerh6", answer_6.getText().toString());
                                    intent.putExtra("answerh7", answer_7.getText().toString());
                                    intent.putExtra("answerh8", answer_8.getText().toString());
                                    intent.putExtra("answerh9", answer_9.getText().toString());
                                    intent.putExtra("answerh10", answer_10.getText().toString());
                                    intent.putExtra("answerh11", answer_11.getText().toString());
                                    intent.putExtra("answerh12", answer_12.getText().toString());
                                    intent.putExtra("answerh13", answer_13.getText().toString());
                                    intent.putExtra("answerh14", answer_14.getText().toString());
                                    intent.putExtra("answerh15", answer_15.getText().toString());
                                    intent.putExtra("answerh16", answer_16.getText().toString());
                                    intent.putExtra("answerh17", answer_17.getText().toString());
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();
                } else {
                    Log.d(TAG, "Failed " + score);
                    countDownTimer.cancel();
                        AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                        alertDialog.setTitle("Failed, Your score is " + score + "you have to answer all solutions for x correctly");
                        alertDialog.setMessage("Please try again!");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                                        Intent intent = new Intent(Equation.this,GameOver.class);
                                        intent.putExtra("score", score);
                                        intent.putExtra(GameOver.KEY_DIFFICULTY, diff);
                                        startActivity(intent);
                                    }
                                });
                        alertDialog.show();

                            int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                            Intent intent = new Intent(Equation.this, GameOver.class);
                            intent.putExtra(Game.KEY_DIFFICULTY, diff);
                            intent.putExtra("score", score);
                            startActivity(intent);



                }
            }
        });


    }

    public void calculateAlgebraMedium() {
        final int[] answers = new int[12];
        final int[] variablesa = new int[12];
        final int[] variablesb = new int[12];
        final int[] variablesc = new int[12];
        final char[] operators = new char[12];

        final TextView variable_a_1 = (TextView) findViewById(R.id.variable_a_1);
        final TextView variable_a_2 = (TextView) findViewById(R.id.variable_a_2);
        final TextView variable_a_3 = (TextView) findViewById(R.id.variable_a_3);
        final TextView variable_a_4 = (TextView) findViewById(R.id.variable_a_4);
        final TextView variable_a_5 = (TextView) findViewById(R.id.variable_a_5);
        final TextView variable_a_6 = (TextView) findViewById(R.id.variable_a_6);
        final TextView variable_a_7 = (TextView) findViewById(R.id.variable_a_7);
        final TextView variable_a_8 = (TextView) findViewById(R.id.variable_a_8);
        final TextView variable_a_9 = (TextView) findViewById(R.id.variable_a_9);
        final TextView variable_a_10 = (TextView) findViewById(R.id.variable_a_10);
        final TextView variable_a_11 = (TextView) findViewById(R.id.variable_a_11);
        final TextView variable_a_12 = (TextView) findViewById(R.id.variable_a_12);

        final TextView variable_b_1 = (TextView) findViewById(R.id.variable_b_1);
        final TextView variable_b_2 = (TextView) findViewById(R.id.variable_b_2);
        final TextView variable_b_3 = (TextView) findViewById(R.id.variable_b_3);
        final TextView variable_b_4 = (TextView) findViewById(R.id.variable_b_4);
        final TextView variable_b_5 = (TextView) findViewById(R.id.variable_b_5);
        final TextView variable_b_6 = (TextView) findViewById(R.id.variable_b_6);
        final TextView variable_b_7 = (TextView) findViewById(R.id.variable_b_7);
        final TextView variable_b_8 = (TextView) findViewById(R.id.variable_b_8);
        final TextView variable_b_9 = (TextView) findViewById(R.id.variable_b_9);
        final TextView variable_b_10 = (TextView) findViewById(R.id.variable_b_10);
        final TextView variable_b_11 = (TextView) findViewById(R.id.variable_b_11);
        final TextView variable_b_12 = (TextView) findViewById(R.id.variable_b_12);


        final TextView operator_1 = (TextView) findViewById(R.id.operator_1);
        final TextView operator_2 = (TextView) findViewById(R.id.operator_2);
        final TextView operator_3 = (TextView) findViewById(R.id.operator_3);
        final TextView operator_4 = (TextView) findViewById(R.id.operator_4);
        final TextView operator_5 = (TextView) findViewById(R.id.operator_5);
        final TextView operator_6 = (TextView) findViewById(R.id.operator_6);
        final TextView operator_7 = (TextView) findViewById(R.id.operator_7);
        final TextView operator_8 = (TextView) findViewById(R.id.operator_8);
        final TextView operator_9 = (TextView) findViewById(R.id.operator_9);
        final TextView operator_10 = (TextView) findViewById(R.id.operator_10);
        final TextView operator_11 = (TextView) findViewById(R.id.operator_11);
        final TextView operator_12 = (TextView) findViewById(R.id.operator_12);



        final TextView variable_c_1 = (TextView) findViewById(R.id.variable_c_1);
        final TextView variable_c_2 = (TextView) findViewById(R.id.variable_c_2);
        final TextView variable_c_3 = (TextView) findViewById(R.id.variable_c_3);
        final TextView variable_c_4 = (TextView) findViewById(R.id.variable_c_4);
        final TextView variable_c_5 = (TextView) findViewById(R.id.variable_c_5);
        final TextView variable_c_6 = (TextView) findViewById(R.id.variable_c_6);
        final TextView variable_c_7 = (TextView) findViewById(R.id.variable_c_7);
        final TextView variable_c_8 = (TextView) findViewById(R.id.variable_c_8);
        final TextView variable_c_9 = (TextView) findViewById(R.id.variable_c_9);
        final TextView variable_c_10 = (TextView) findViewById(R.id.variable_c_10);
        final TextView variable_c_11 = (TextView) findViewById(R.id.variable_c_11);
        final TextView variable_c_12 = (TextView) findViewById(R.id.variable_c_12);


        final EditText answer_1 = (EditText) findViewById(R.id.answer_1);
        final EditText answer_2 = (EditText) findViewById(R.id.answer_2);
        final EditText answer_3 = (EditText) findViewById(R.id.answer_3);
        final EditText answer_4 = (EditText) findViewById(R.id.answer_4);
        final EditText answer_5 = (EditText) findViewById(R.id.answer_5);
        final EditText answer_6 = (EditText) findViewById(R.id.answer_6);
        final EditText answer_7 = (EditText) findViewById(R.id.answer_7);
        final EditText answer_8 = (EditText) findViewById(R.id.answer_8);
        final EditText answer_9 = (EditText) findViewById(R.id.answer_9);
        final EditText answer_10 = (EditText) findViewById(R.id.answer_10);
        final EditText answer_11 = (EditText) findViewById(R.id.answer_11);
        final EditText answer_12 = (EditText) findViewById(R.id.answer_12);


        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                answers[0] = Integer.parseInt(answer_1.getText().toString());
                answers[1] = Integer.parseInt(answer_2.getText().toString());
                answers[2] = Integer.parseInt(answer_3.getText().toString());
                answers[3] = Integer.parseInt(answer_4.getText().toString());
                answers[4] = Integer.parseInt(answer_5.getText().toString());
                answers[5] = Integer.parseInt(answer_6.getText().toString());
                answers[6] = Integer.parseInt(answer_7.getText().toString());
                answers[7] = Integer.parseInt(answer_8.getText().toString());
                answers[8] = Integer.parseInt(answer_9.getText().toString());
                answers[9] = Integer.parseInt(answer_10.getText().toString());
                answers[10] = Integer.parseInt(answer_11.getText().toString());
                answers[11] = Integer.parseInt(answer_12.getText().toString());


                operators[0] = operator_1.getText().charAt(0);
                operators[1] = operator_2.getText().charAt(0);
                operators[2] = operator_3.getText().charAt(0);
                operators[3] = operator_4.getText().charAt(0);
                operators[4] = operator_5.getText().charAt(0);
                operators[5] = operator_6.getText().charAt(0);
                operators[6] = operator_7.getText().charAt(0);
                operators[7] = operator_8.getText().charAt(0);
                operators[8] = operator_9.getText().charAt(0);
                operators[9] = operator_10.getText().charAt(0);
                operators[10] = operator_11.getText().charAt(0);
                operators[11] = operator_12.getText().charAt(0);



                variablesa[0] = Integer.parseInt(variable_a_1.getText().toString());
                variablesa[1] = Integer.parseInt(variable_a_2.getText().toString());
                variablesa[2] = Integer.parseInt(variable_a_3.getText().toString());
                variablesa[3] = Integer.parseInt(variable_a_4.getText().toString());
                variablesa[4] = Integer.parseInt(variable_a_5.getText().toString());
                variablesa[5] = Integer.parseInt(variable_a_6.getText().toString());
                variablesa[6] = Integer.parseInt(variable_a_7.getText().toString());
                variablesa[7] = Integer.parseInt(variable_a_8.getText().toString());
                variablesa[8] = Integer.parseInt(variable_a_9.getText().toString());
                variablesa[9] = Integer.parseInt(variable_a_10.getText().toString());
                variablesa[10] = Integer.parseInt(variable_a_11.getText().toString());
                variablesa[11] = Integer.parseInt(variable_a_12.getText().toString());

                variablesb[0] = Integer.parseInt(variable_b_1.getText().toString());
                variablesb[1] = Integer.parseInt(variable_b_2.getText().toString());
                variablesb[2] = Integer.parseInt(variable_b_3.getText().toString());
                variablesb[3] = Integer.parseInt(variable_b_4.getText().toString());
                variablesb[4] = Integer.parseInt(variable_b_5.getText().toString());
                variablesb[5] = Integer.parseInt(variable_b_6.getText().toString());
                variablesb[6] = Integer.parseInt(variable_b_7.getText().toString());
                variablesb[7] = Integer.parseInt(variable_b_8.getText().toString());
                variablesb[8] = Integer.parseInt(variable_b_9.getText().toString());
                variablesb[9] = Integer.parseInt(variable_b_10.getText().toString());
                variablesb[10] = Integer.parseInt(variable_b_11.getText().toString());
                variablesb[11] = Integer.parseInt(variable_b_12.getText().toString());


                variablesc[0] = Integer.parseInt(variable_c_1.getText().toString());
                variablesc[1] = Integer.parseInt(variable_c_2.getText().toString());
                variablesc[2] = Integer.parseInt(variable_c_3.getText().toString());
                variablesc[3] = Integer.parseInt(variable_c_4.getText().toString());
                variablesc[4] = Integer.parseInt(variable_c_5.getText().toString());
                variablesc[5] = Integer.parseInt(variable_c_6.getText().toString());
                variablesc[6] = Integer.parseInt(variable_c_7.getText().toString());
                variablesc[7] = Integer.parseInt(variable_c_8.getText().toString());
                variablesc[8] = Integer.parseInt(variable_c_9.getText().toString());
                variablesc[9] = Integer.parseInt(variable_c_10.getText().toString());
                variablesc[10] = Integer.parseInt(variable_c_11.getText().toString());
                variablesc[11] = Integer.parseInt(variable_c_12.getText().toString());


                int c = 0;
                for (int i = 0; i < 12; i++) {
                    if (answers[i] == solveAlgebra(variablesa[i], variablesb[i], variablesc[i], operators[i])) {
                        c++;

                    }
                }
                final int score = c * 5;
                if (score == 60) {
                    countDownTimer.cancel();
                    AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                    alertDialog.setTitle("Congratulations");
                    alertDialog.setMessage("Stage 1 is completed!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                                    Intent intent = new Intent(Equation.this, Game.class);
                                    intent.putExtra(Game.KEY_DIFFICULTY, diff);
                                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    SharedPreferences.Editor editor= pref.edit();
                                    editor.putInt("equation_score2",score);
                                    editor.putLong("minutesRemaining", millisRemaining/1000);
                                    Log.d(TAG,"TIME "+ millisRemaining/1000);
                                    editor.commit();
                                    intent.putExtra("answerm1", answer_1.getText().toString());
                                    intent.putExtra("answerm2", answer_2.getText().toString());
                                    intent.putExtra("answerm3", answer_3.getText().toString());
                                    intent.putExtra("answerm4", answer_4.getText().toString());
                                    intent.putExtra("answerm5", answer_5.getText().toString());
                                    intent.putExtra("answerm6", answer_6.getText().toString());
                                    intent.putExtra("answerm7", answer_7.getText().toString());
                                    intent.putExtra("answerm8", answer_8.getText().toString());
                                    intent.putExtra("answerm9", answer_9.getText().toString());
                                    intent.putExtra("answerm10", answer_10.getText().toString());
                                    intent.putExtra("answerm11", answer_11.getText().toString());
                                    intent.putExtra("answerm12", answer_12.getText().toString());
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();
                } else {
                    Log.d(TAG, "Failed " + score);
                    AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                    countDownTimer.cancel();
                    alertDialog.setTitle("Failed, Your score is " + score + "you have to answer all solutions for x correctly");
                    alertDialog.setMessage("Please try again!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                                    Intent intent = new Intent(Equation.this,GameOver.class);
                                    intent.putExtra("score", score);
                                    intent.putExtra(GameOver.KEY_DIFFICULTY, diff);
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();
                }
            }
        });


    }

    public void calculateAlgebraEasy() {
        final int[] answers = new int[8];
        final int[] variablesa = new int[8];
        final int[] variablesb = new int[8];
        final int[] variablesc = new int[8];
        final char[] operators = new char[8];

        final TextView variable_a_1 = (TextView) findViewById(R.id.variable_a_1);
        final TextView variable_a_2 = (TextView) findViewById(R.id.variable_a_2);
        final TextView variable_a_3 = (TextView) findViewById(R.id.variable_a_3);
        final TextView variable_a_4 = (TextView) findViewById(R.id.variable_a_4);
        final TextView variable_a_5 = (TextView) findViewById(R.id.variable_a_5);
        final TextView variable_a_6 = (TextView) findViewById(R.id.variable_a_6);
        final TextView variable_a_7 = (TextView) findViewById(R.id.variable_a_7);
        final TextView variable_a_8 = (TextView) findViewById(R.id.variable_a_8);

        final TextView variable_b_1 = (TextView) findViewById(R.id.variable_b_1);
        final TextView variable_b_2 = (TextView) findViewById(R.id.variable_b_2);
        final TextView variable_b_3 = (TextView) findViewById(R.id.variable_b_3);
        final TextView variable_b_4 = (TextView) findViewById(R.id.variable_b_4);
        final TextView variable_b_5 = (TextView) findViewById(R.id.variable_b_5);
        final TextView variable_b_6 = (TextView) findViewById(R.id.variable_b_6);
        final TextView variable_b_7 = (TextView) findViewById(R.id.variable_b_7);
        final TextView variable_b_8 = (TextView) findViewById(R.id.variable_b_8);

        final TextView operator_1 = (TextView) findViewById(R.id.operator_1);
        final TextView operator_2 = (TextView) findViewById(R.id.operator_2);
        final TextView operator_3 = (TextView) findViewById(R.id.operator_3);
        final TextView operator_4 = (TextView) findViewById(R.id.operator_4);
        final TextView operator_5 = (TextView) findViewById(R.id.operator_5);
        final TextView operator_6 = (TextView) findViewById(R.id.operator_6);
        final TextView operator_7 = (TextView) findViewById(R.id.operator_7);
        final TextView operator_8 = (TextView) findViewById(R.id.operator_8);


        final TextView variable_c_1 = (TextView) findViewById(R.id.variable_c_1);
        final TextView variable_c_2 = (TextView) findViewById(R.id.variable_c_2);
        final TextView variable_c_3 = (TextView) findViewById(R.id.variable_c_3);
        final TextView variable_c_4 = (TextView) findViewById(R.id.variable_c_4);
        final TextView variable_c_5 = (TextView) findViewById(R.id.variable_c_5);
        final TextView variable_c_6 = (TextView) findViewById(R.id.variable_c_6);
        final TextView variable_c_7 = (TextView) findViewById(R.id.variable_c_7);
        final TextView variable_c_8 = (TextView) findViewById(R.id.variable_c_8);

        final EditText answer_1 = (EditText) findViewById(R.id.answer_1);
        final EditText answer_2 = (EditText) findViewById(R.id.answer_2);
        final EditText answer_3 = (EditText) findViewById(R.id.answer_3);
        final EditText answer_4 = (EditText) findViewById(R.id.answer_4);
        final EditText answer_5 = (EditText) findViewById(R.id.answer_5);
        final EditText answer_6 = (EditText) findViewById(R.id.answer_6);
        final EditText answer_7 = (EditText) findViewById(R.id.answer_7);
        final EditText answer_8 = (EditText) findViewById(R.id.answer_8);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                answers[0] = Integer.parseInt(answer_1.getText().toString());
                answers[1] = Integer.parseInt(answer_2.getText().toString());
                answers[2] = Integer.parseInt(answer_3.getText().toString());
                answers[3] = Integer.parseInt(answer_4.getText().toString());
                answers[4] = Integer.parseInt(answer_5.getText().toString());
                answers[5] = Integer.parseInt(answer_6.getText().toString());
                answers[6] = Integer.parseInt(answer_7.getText().toString());
                answers[7] = Integer.parseInt(answer_8.getText().toString());


                operators[0] = operator_1.getText().charAt(0);
                operators[1] = operator_2.getText().charAt(0);
                operators[2] = operator_3.getText().charAt(0);
                operators[3] = operator_4.getText().charAt(0);
                operators[4] = operator_5.getText().charAt(0);
                operators[5] = operator_6.getText().charAt(0);
                operators[6] = operator_7.getText().charAt(0);
                operators[7] = operator_8.getText().charAt(0);


                variablesa[0] = Integer.parseInt(variable_a_1.getText().toString());
                variablesa[1] = Integer.parseInt(variable_a_2.getText().toString());
                variablesa[2] = Integer.parseInt(variable_a_3.getText().toString());
                variablesa[3] = Integer.parseInt(variable_a_4.getText().toString());
                variablesa[4] = Integer.parseInt(variable_a_5.getText().toString());
                variablesa[5] = Integer.parseInt(variable_a_6.getText().toString());
                variablesa[6] = Integer.parseInt(variable_a_7.getText().toString());
                variablesa[7] = Integer.parseInt(variable_a_8.getText().toString());


                variablesb[0] = Integer.parseInt(variable_b_1.getText().toString());
                variablesb[1] = Integer.parseInt(variable_b_2.getText().toString());
                variablesb[2] = Integer.parseInt(variable_b_3.getText().toString());
                variablesb[3] = Integer.parseInt(variable_b_4.getText().toString());
                variablesb[4] = Integer.parseInt(variable_b_5.getText().toString());
                variablesb[5] = Integer.parseInt(variable_b_6.getText().toString());
                variablesb[6] = Integer.parseInt(variable_b_7.getText().toString());
                variablesb[7] = Integer.parseInt(variable_b_8.getText().toString());


                variablesc[0] = Integer.parseInt(variable_c_1.getText().toString());
                variablesc[1] = Integer.parseInt(variable_c_2.getText().toString());
                variablesc[2] = Integer.parseInt(variable_c_3.getText().toString());
                variablesc[3] = Integer.parseInt(variable_c_4.getText().toString());
                variablesc[4] = Integer.parseInt(variable_c_5.getText().toString());
                variablesc[5] = Integer.parseInt(variable_c_6.getText().toString());
                variablesc[6] = Integer.parseInt(variable_c_7.getText().toString());
                variablesc[7] = Integer.parseInt(variable_c_8.getText().toString());

                final ArrayList<Integer> elements = new ArrayList<>();
                int c = 0;
                for (int i = 0; i < 8; i++) {

                    if (answers[i] == solveAlgebra(variablesa[i], variablesb[i], variablesc[i], operators[i])) {
                        elements.add(answers[i]);
                        c++;
                    }
                }
                final int score = c * 5;
                if (score == 40) {
                    countDownTimer.cancel();
                    AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                    alertDialog.setTitle("Congratulations");
                    alertDialog.setMessage("Stage 1 is completed!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                                    Intent intent = new Intent(Equation.this, Game.class);
                                    intent.putExtra(Game.KEY_DIFFICULTY, diff);
                                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    SharedPreferences.Editor editor= pref.edit();
                                    editor.putLong("minutesRemaining", millisRemaining/1000);
                                    Log.d(TAG,"TIME "+ millisRemaining/1000);
                                    editor.putInt("equation_score1",score);
                                    editor.commit();
//                                    intent.putIntegerArrayListExtra("values", elements);
                                    intent.putExtra("answer1", answer_1.getText().toString());
                                    intent.putExtra("answer2", answer_2.getText().toString());
                                    intent.putExtra("answer3", answer_3.getText().toString());
                                    intent.putExtra("answer4", answer_4.getText().toString());
                                    intent.putExtra("answer5", answer_5.getText().toString());
                                    intent.putExtra("answer6", answer_6.getText().toString());
                                    intent.putExtra("answer7", answer_7.getText().toString());
                                    intent.putExtra("answer8", answer_8.getText().toString());
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();
                } else {
                    Log.d(TAG, "Failed " + score);
                    countDownTimer.cancel();
                    AlertDialog alertDialog = new AlertDialog.Builder(Equation.this).create();
                    alertDialog.setTitle("Failed, Your score is " + score + "you have to answer all solutions for x correctly");
                    alertDialog.setMessage("Please try again!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                                    Intent intent = new Intent(Equation.this,GameOver.class);
                                    intent.putExtra(GameOver.KEY_DIFFICULTY, diff);
                                    intent.putExtra("score", score);
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }

    private int constant_x;

    public int solveAlgebra(int a, int b, int c, char operator) {
        switch (operator) {
            case '+':
                int right_side = c - b;
                constant_x = right_side / a;
                break;
            case '-':
                right_side = c + b;
                constant_x = right_side / a;
                break;
        }
        return constant_x;
    }



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.


    /*public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            int progress = (int) (millisUntilFinished/1000);


            progressBar.setProgress(progressBar.getMax()-progress);
        }

        @Override
        public void onFinish() {
            finish();
        }
    }*/

}
/*
public class CounterClass extends CountDownTimer {
    public CounterClass(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onFinish() {
        textViewTime.setText("Complete");
    }

    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onTick(long millisUntilFinished) {
        int progress = (int) (millisUntilFinished / 1000);
        progressBar.setProgress(progressBar.getMax() - progress);

        long millis = millisUntilFinished;
        @SuppressLint("DefaultLocale")
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        System.out.println(hms);
        textViewTime.setText(hms);
    }
}
*/
