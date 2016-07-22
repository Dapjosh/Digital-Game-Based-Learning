package com.example.oladapo.sudoku;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.oladapo.sudoku.Constants.SCORE;
import static com.example.oladapo.sudoku.Constants.TABLE_NAME;
import static com.example.oladapo.sudoku.Constants.TIME;
import static com.example.oladapo.sudoku.Constants.USERNAME;

public class Register extends Activity {

    private static final String TAG="Sudoku";

    private UsersData users;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        users = new UsersData(this);
        setContentView(R.layout.register);
        final EditText user_name = (EditText) findViewById(R.id.editUsername);
        final int finalScore = getIntent().getExtras().getInt("score");
        Button submitButton = (Button) findViewById(R.id.submit_button);
        final EditText editName = (EditText)findViewById(R.id.editName);
        Button saveIntoButton = (Button) findViewById(R.id.saveIntoDatabase);
        submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                String userName = user_name.getText().toString();
                Context context = getApplicationContext();
                SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(context);
                String registerName = sp.getString("registerName", null);
                Log.d(TAG, "Your username is"+ userName);
                if(userName == registerName){
                    Toast.makeText(getApplicationContext(), "You are already registered, please just save score",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (userName.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field Vacant",
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Log.d(TAG, "Success in getting your name and score is "+finalScore);
                    addUsers(userName,finalScore);
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor= pref.edit();
                    editor.putString("registerName", userName);
                    editor.commit();
                    Toast.makeText(getApplicationContext(),
                            "Account Successfully Created and score saved! ", Toast.LENGTH_LONG)
                            .show();
                    Intent i = new Intent(Register.this,
                            Start.class);
                    startActivity(i);
                    finish();

                }
            }
        });
        saveIntoButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               /* Context context = getApplicationContext();
                SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(context);
                String registerName = sp.getString("registerName", null);*/
                String registerName = editName.getText().toString();
                Log.d(TAG, "Your score is"+ finalScore);
                if(registerName == null){
                    Toast.makeText(getApplicationContext(), "Please enter your username before you save. ",
                            Toast.LENGTH_LONG).show();
                    return;
                }else{
                    addScores(finalScore,registerName);
                    Toast.makeText(getApplicationContext(), "Your score has been saved!",
                            Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
        /*
        try {
            addEvent("Hello, Android!" );
            Cursor cursor = getEvents()
            showEvents(cursor);
        } finally {
            events.close();
        }*/
    }
    private void addUsers(String username, int score) {
        SQLiteDatabase db = users.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, System.currentTimeMillis());
        values.put(USERNAME, username);
        values.put(SCORE, score);
        db.insertOrThrow(TABLE_NAME,null,values);
    }
    private void addScores(int score, String username) {
        SQLiteDatabase db = users.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, System.currentTimeMillis());
        values.put(SCORE, score);
        db.update(TABLE_NAME,values, USERNAME+"="+"'"+username+"'",null);
    }

}
