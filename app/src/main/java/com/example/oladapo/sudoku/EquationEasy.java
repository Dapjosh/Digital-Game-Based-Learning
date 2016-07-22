package com.example.oladapo.sudoku;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EquationEasy  extends Activity {
    private static final String TAG = "Sudoku";
    public static final String KEY_DIFFICULTY = "org.example.sudoku.difficulty";
    public static final String MyPREFERENCES = "MyPrefs" ;
    ProgressBar progressBar;
    TextView textViewTime;
    Button buttonHelp;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
        setContentView(R.layout.equationeasy);
        View tableLayout = findViewById(R.id.table_layout);

        TextView textHead = new TextView(this);
        textHead.setText("Solve for x");
        textHead.setId(1);
        textHead.setGravity(Gravity.CENTER);
        textHead.setTextSize(30);
        textHead.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        ((TableLayout) tableLayout).addView(textHead);
        List<EditText> allEds = new ArrayList<EditText>();
        for (int i=2; i<=9; i++){
            TableRow tableRow = new TableRow(this);
            tableRow.setId(i);
            tableRow.setPadding(10,0,0,10);
            for(int j = 10; j <=15; j++){
                TextView tv = new TextView(this);
                tv.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                tv.setBackgroundColor(getResources().getColor(R.color.puzzle_selected));
                tv.setTextColor(getResources().getColor(R.color.colorTitle));
                tv.setPadding(5,5,5,5);
                tv.setGravity(Gravity.CENTER);
                tv.setTextAppearance(this, android.R.style.TextAppearance_Small);
                tv.setId(j);
                tableRow.addView(tv);
            }

            EditText edit = new EditText(this);
            edit.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            edit.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            edit.setTextColor(getResources().getColor(R.color.colorTitle));
            edit.setPadding(5,5,5,5);
            edit.setGravity(Gravity.CENTER);
            edit.setTextAppearance(this, android.R.style.TextAppearance_Small);
            edit = new EditText(EquationEasy.this);
            allEds.add(edit);
            // One new TextView will also be assigned an id==12:


        }
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        countDownTimer = new CountDownTimer(30000, 1000) {



            public void onTick(long millisUntilFinished) {
                int progress = (int) (millisUntilFinished / 1000);
                progressBar.setProgress(progressBar.getMax() - progress);
                textViewTime.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Intent intent = new Intent(EquationEasy.this,GameOver.class);
                intent.putExtra(Equation.KEY_DIFFICULTY, diff);
                startActivity(intent);
            }
        }.start();
        buttonHelp = (Button)findViewById(R.id.buttonHelp);
        buttonHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(EquationEasy.this).create();
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
        b.setOnClickListener(new View.OnClickListener() {
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
                if (score == 30) {
                    countDownTimer.cancel();
                    AlertDialog alertDialog = new AlertDialog.Builder(EquationEasy.this).create();
                    alertDialog.setTitle("Congratulations");
                    alertDialog.setMessage("Stage 1 is completed!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                                    Intent intent = new Intent(EquationEasy.this, Game.class);
                                    intent.putExtra(Game.KEY_DIFFICULTY, diff);
                                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    SharedPreferences.Editor editor= pref.edit();
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
                    AlertDialog alertDialog = new AlertDialog.Builder(EquationEasy.this).create();
                    alertDialog.setTitle("Failed, Your score is " + score + "you have to answer all solutions for x correctly");
                    alertDialog.setMessage("Please try again!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
                                    Intent intent = new Intent(EquationEasy.this,GameOver.class);
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

}
