package com.example.oladapo.sudoku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.BaseColumns._ID;
import static com.example.oladapo.sudoku.Constants.SCORE;
import static com.example.oladapo.sudoku.Constants.TABLE_NAME;
import static com.example.oladapo.sudoku.Constants.TIME;
import static com.example.oladapo.sudoku.Constants.USERNAME;
/**
 *
 * Created by oladapo on 6/22/16.
 */

public class UsersData extends SQLiteOpenHelper {
    private static final String TAG = "Sudoku";
    private static final String DATABASE_NAME = "users.db" ;
    private static final int DATABASE_VERSION = 1;

    public UsersData(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Success in creating database");
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TIME
                + " INTEGER," + USERNAME + " TEXT NOT NULL," + SCORE + " INTEGER );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        Log.d(TAG, "Upgrade");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
