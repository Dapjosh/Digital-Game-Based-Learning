package com.example.oladapo.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

@SuppressWarnings("LoopStatementThatDoesntLoop")
public class Game extends Activity {
    private static final String TAG = "Sudoku" ;
    public static final String KEY_DIFFICULTY= "org.example.sudoku.difficulty";
    private static final String PREF_PUZZLE = "puzzle" ;
    public static final int DIFFICULTY_CONTINUE = -1;
    public static final int DIFFICULTY_EASY = 0;
    public static final int DIFFICULTY_MEDIUM=1;
    public static final int DIFFICULTY_HARD =2;
    private int puzzleHard[] = new int[9 * 9];
    private int puzzleMedium[] = new int[6 * 6];
    private int puzzleEasy[] = new int[4 * 4];
    private PuzzleViewHard puzzleViewHard;
    private PuzzleViewMedium puzzleViewMedium;
    private PuzzleViewEasy puzzleViewEasy;
    AlertDialog alertDialog;
    String answer_1;
    String answer_2;
    String answer_3;
    String answer_4;
    String answer_5;
    String answer_6;
    String answer_7;
    String answer_8;

    String answerM_1;
    String answerM_2;
    String answerM_3;
    String answerM_4;
    String answerM_5;
    String answerM_6;
    String answerM_7;
    String answerM_8;
    String answerM_9;
    String answerM_10;
    String answerM_11;
    String answerM_12;

    String answerH_1;
    String answerH_2;
    String answerH_3;
    String answerH_4;
    String answerH_5;
    String answerH_6;
    String answerH_7;
    String answerH_8;
    String answerH_9;
    String answerH_10;
    String answerH_11;
    String answerH_12;
    String answerH_13;
    String answerH_14;
    String answerH_15;
    String answerH_16;
    String answerH_17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate" );
//        getIntent().putExtra(KEY_DIFFICULTY, DIFFICULTY_CONTINUE);
        int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
        //getting answers for easy equations
        answer_1 = getIntent().getExtras().getString("answer1");
        answer_2 = getIntent().getExtras().getString("answer2");
        answer_3 = getIntent().getExtras().getString("answer3");
        answer_4 = getIntent().getExtras().getString("answer4");
        answer_5 = getIntent().getExtras().getString("answer5");
        answer_6 = getIntent().getExtras().getString("answer6");
        answer_7 = getIntent().getExtras().getString("answer7");
        answer_8 = getIntent().getExtras().getString("answer8");

        // getting answers from medium equations
         answerM_1 = getIntent().getExtras().getString("answerm1");
         answerM_2 = getIntent().getExtras().getString("answerm2");
         answerM_3 = getIntent().getExtras().getString("answerm3");
        answerM_4 = getIntent().getExtras().getString("answerm4");
        answerM_5 = getIntent().getExtras().getString("answerm5");
         answerM_6 = getIntent().getExtras().getString("answerm6");
         answerM_7 = getIntent().getExtras().getString("answerm7");
         answerM_8 = getIntent().getExtras().getString("answerm8");
        answerM_9 = getIntent().getExtras().getString("answerm9");
         answerM_10 = getIntent().getExtras().getString("answerm10");
        answerM_11 = getIntent().getExtras().getString("answerm11");
        answerM_12 = getIntent().getExtras().getString("answerm12");

        //getting answers from hard equations
         answerH_1 = getIntent().getExtras().getString("answerh1");
         answerH_2 = getIntent().getExtras().getString("answerh2");
        answerH_3 = getIntent().getExtras().getString("answerh3");
         answerH_4 = getIntent().getExtras().getString("answerh4");
         answerH_5 = getIntent().getExtras().getString("answerh5");
         answerH_6 = getIntent().getExtras().getString("answerh6");
        answerH_7 = getIntent().getExtras().getString("answerh7");
         answerH_8 = getIntent().getExtras().getString("answerh8");
        answerH_9 = getIntent().getExtras().getString("answerh9");
         answerH_10 = getIntent().getExtras().getString("answerh10");
         answerH_11 = getIntent().getExtras().getString("answerh11");
        answerH_12 = getIntent().getExtras().getString("answerh12");
       answerH_13 = getIntent().getExtras().getString("answerh13");
         answerH_14 = getIntent().getExtras().getString("answerh14");
        answerH_15 = getIntent().getExtras().getString("answerh15");
         answerH_16 = getIntent().getExtras().getString("answerh16");
        answerH_17 = getIntent().getExtras().getString("answerh17");


//        getPuzzleEasy(easyPuzzle);
//        String answer = getIntent().getIntegerArrayListExtra("elements").toString();
        switch (diff) {
            case 2:
                puzzleViewHard = new PuzzleViewHard(this);
                setContentView(puzzleViewHard);
                alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Welcome");
                alertDialog.setMessage("Bingo! You were able to make it to this stage, here you have to correctly place numbers 1 to 9 in a cell so that these numbers do not occur twice row wise and column wise. Touch the return button on your device when you are through.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                alertDialog.show();
                puzzleViewHard.requestFocus();
                puzzleHard = getPuzzleHard(diff);
                calculateUsedTilesHard();
                break;
            case 1:

                alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Welcome");
                alertDialog.setMessage("Bingo! You were able to make it to this stage, here you have to correctly place numbers 1 to 6 in a cell so that these numbers do not occur twice row wise and column wise. Touch the return button on your device when you are through");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                alertDialog.show();
                puzzleMedium = getPuzzleMedium(diff);
                calculateUsedTilesMedium();

                puzzleViewMedium = new PuzzleViewMedium(this);
                setContentView(puzzleViewMedium);
                puzzleViewMedium.requestFocus();

                break;
            case 0:

                alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Welcome");
                alertDialog.setMessage("Bingo! You were able to make it to this stage, here you have to correctly place numbers 1 to 4 in a cell so that these numbers do not occur twice row wise and column wise. Touch the return button on your device when you are through");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                alertDialog.show();
                puzzleEasy = getPuzzleEasy(diff);
                calculateUsedTilesEasy();
                puzzleViewEasy = new PuzzleViewEasy(this);
                setContentView(puzzleViewEasy);
                puzzleViewEasy.requestFocus();
                break;
        }
    }

    protected void showKeypadOrErrorHard(int x, int y) {
        int tiles[] = getUsedTilesHard(x, y);
        if (tiles.length == 9) {
            Toast toast = Toast.makeText(this,
                    R.string.no_moves_label, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            Log.d(TAG, "showKeypad: used=" + toPuzzleStringHard(tiles));
            Dialog v = new KeypadHard(this, tiles, puzzleViewHard);
            v.show();
        }
    }
    protected void showKeypadOrErrorMedium(int x, int y) {
        int tiles[] = getUsedTilesMedium(x, y);
        if (tiles.length == 6) {
            Toast toast = Toast.makeText(this,
                    R.string.no_moves_label, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            Log.d(TAG, "showKeypad: used=" + toPuzzleStringMedium(tiles));
            Dialog v = new KeypadMedium(this, tiles, puzzleViewMedium);
            v.show();
        }
    }
    protected void showKeypadOrErrorEasy(int x, int y) {
        int tiles[] = getUsedTilesEasy(x, y);
        if (tiles.length == 4) {
            Toast toast = Toast.makeText(this,
                    R.string.no_moves_label, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            Log.d(TAG, "showKeypad: used=" + toPuzzleStringEasy(tiles));
               /* Dialog v = new KeypadEasy(this, tiles, puzzleViewEasy);
                v.show();*/
            }
    }
    protected boolean setTileIfValidHard(int x, int y, int value) {
        int tiles[] = getUsedTilesHard(x, y);
        if (value != 0) {
            for (int tile : tiles) {
                if (tile == value)
                    return false;
            }
        }
        setTileHard(x, y, value);
        calculateUsedTilesHard();
        return true;
    }
    protected boolean setTileIfValidMedium(int x, int y, int value) {
        int tiles[] = getUsedTilesMedium(x, y);
        if (value != 0) {
            for (int tile : tiles) {
                if (tile == value)
                    return false;
            }
        }
        setTileMedium(x, y, value);
        calculateUsedTilesMedium();
        return true;
    }
    protected boolean setTileIfValidEasy(int x, int y, int value) {
        int tiles[] = getUsedTilesEasy(x, y);
        if (value != 0) {
            for (int tile : tiles) {
                if (tile == value)
                    return false;
            }
        }
        setTileEasy(x, y, value);
        calculateUsedTilesEasy();
        /*if (isSolvedEasy() == true) {
            Log.d(TAG, "yOU ARE TRUE");
            Context context = getApplicationContext();
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
            int equationScore = sp.getInt("equation_score1", 0);
            int sudokuScore = 20;
            Log.d(TAG, "Your score is " + equationScore);
            int diff = 0;
            Intent i = new Intent(context, Congratulations.class);
            int finalScore = sudokuScore + equationScore;
            Log.d(TAG, "Your final is " + finalScore);
            Log.d(TAG, "Your diff is " + diff);
            i.putExtra("final_score", finalScore);
            i.putExtra("diff", diff);
            context.startActivity(i);
        }
        else
        {
            Log.d(TAG, "vERY False");
            return false;
        }*/
        return true;
    }
    private final int usedHard[][][] = new int[9][9][];
    private final int usedMedium[][][] = new int[6][6][];
    private final int usedEasy[][][] = new int[4][4][];
    protected int[] getUsedTilesHard(int x, int y) {
        return usedHard[x][y];
    }
    protected int[] getUsedTilesMedium(int x, int y) {
        return usedMedium[x][y];
    }
    protected int[] getUsedTilesEasy(int x, int y) {
        return usedEasy[x][y];
    }

    private void calculateUsedTilesHard() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                usedHard[x][y] = calculateUsedTilesHard(x, y);
// Log.d(TAG, "used[" + x + "][" + y + "] = "
// + toPuzzleString(used[x][y]));
            }
        }
    }
    private void calculateUsedTilesMedium() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                usedMedium[x][y] = calculateUsedTilesMedium(x, y);
// Log.d(TAG, "used[" + x + "][" + y + "] = "
// + toPuzzleString(used[x][y]));
            }
        }
    }
    private void calculateUsedTilesEasy() {
        Log.d(TAG, "on calc"+answer_1);
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                usedEasy[x][y] = calculateUsedTilesEasy(x, y);
// Log.d(TAG, "used[" + x + "][" + y + "] = "
// + toPuzzleString(used[x][y]));
            }
        }
    }
    private int[] calculateUsedTilesHard(int x, int y) {
        int c[] = new int[9];
// horizontal
        for (int i = 0; i < 9; i++) {
            if (i == y)
                continue;
            int t = getTileHard(x, i);
            if (t != 0)
                c[t - 1] = t;
        }
// vertical
        for (int i = 0; i < 9; i++) {
            if (i == x)
                continue;
            int t = getTileHard(i, y);
            if (t != 0)
                c[t - 1] = t;
        }
// same cell block
        int startx = (x / 3) * 3;
        int starty = (y / 3) * 3;
        for (int i = startx; i < startx + 3; i++) {
            for (int j = starty; j < starty + 3; j++) {
                if (i == x && j == y)
                    continue;
                int t = getTileHard(i, j);
                if (t != 0)
                    c[t - 1] = t;
            }
        }
// compress
        int nused = 0;
        for (int t : c) {
            if (t != 0)
                nused++;
        }
        int c1[] = new int[nused];
        nused = 0;
        for (int t : c) {
            if (t != 0)
                c1[nused++] = t;
        }
        return c1;
    }
    private int[] calculateUsedTilesMedium(int x, int y) {
        int c[] = new int[6];
// horizontal
        for (int i = 0; i < 6; i++) {
            if (i == y)
                continue;
            int t = getTileMedium(x, i);
            if (t != 0)
                c[t - 1] = t;
        }
// vertical
        for (int i = 0; i < 6; i++) {
            if (i == x)
                continue;
            int t = getTileMedium(i, y);
            if (t != 0)
                c[t - 1] = t;
        }
// same cell block
        int startx = (x/3)*3;
        int starty = (y/2)*2;
        for (int i = startx; i < startx + 3; i++) {
            for (int j = starty; j < starty + 2; j++) {
                if (i == x && j == y)
                    continue;
                int t = getTileMedium(i, j);
                if (t != 0)
                    c[t - 1] = t;
            }
        }
// compress
        int nused = 0;
        for (int t : c) {
            if (t != 0)
                nused++;
        }
        int c1[] = new int[nused];
        nused = 0;
        for (int t : c) {
            if (t != 0)
                c1[nused++] = t;
        }
        return c1;
    }
    private int[] calculateUsedTilesEasy(int x, int y) {
        int c[] = new int[4];
// horizontal
        for (int i = 0; i < 4; i++) {
            if (i == y)
                continue;
            int t = getTileEasy(x, i);
            if (t != 0)
                c[t - 1] = t;
        }
// vertical
        for (int i = 0; i < 4; i++) {
            if (i == x)
                continue;
            int t = getTileEasy(i, y);
            if (t != 0)
                c[t - 1] = t;
        }
// same cell block
        int startx = (x/2) * 2;
        int starty = (y/2) * 2;
        for (int i = startx; i < startx + 2; i++) {
            for (int j = starty; j < starty + 2; j++) {
                if (i == x && j == y)
                    continue;
                int t = getTileEasy(i, j);
                if (t != 0)
                    c[t - 1] = t;
            }
        }
// compress
        int nused = 0;
        for (int t : c) {
            if (t != 0)
                nused++;
        }
        int c1[] = new int[nused];
        nused = 0;
        for (int t : c) {
            if (t != 0)
                c1[nused++] = t;
        }
        return c1;
    }

   /* private final String easyPuzzle =
//            answer_1+answer_2+"0"+"0"+answer_3+"0"+"0"+"0"+"0"+"0"+answer_4+"0"+answer_5+"0"+"0"+answer_6;
  "4200100000402003";*/
//    private final String mediumPuzzle =
//            "650003040000306000" +
//            "500102630000201004" ;
//    private final String hardPuzzle =
//            "009000000080605020001070000" +
//                    "000000700706040002004000000" +
//                    "000501003000000020000000700" ;

    private int[] getPuzzleHard(int diffHard) {
        String puzHard;

        /*if(diffHard == DIFFICULTY_CONTINUE){
            puzHard = getPreferences(MODE_PRIVATE).getString(PREF_PUZZLE,
                    hardPuzzle);
        }*/
        String hardPuzzle = "0"+"0"+"0"+"0"+"0"+"0"+"0"+answerH_1+"0"+
                "0"+"0"+"0"+"0"+"0"+answerH_2+"0"+"0"+answerH_3+
                "0"+"0"+"0"+answerH_4+"0"+"0"+"0"+"0"+"0"+
                "0"+"0"+"0"+"0"+"0"+"0"+answerH_5+"0"+"0"+
                answerH_6+"0"+answerH_7+answerH_8+"0"+"0"+"0"+"0"+"0"+
                "0"+"0"+answerH_9+answerH_10+"0"+"0"+"0"+"0"+"0"+
                "0"+answerH_11+"0"+"0"+"0"+"0"+answerH_12+"0"+"0"+
                "0"+"0"+"0"+"0"+answerH_13+"0"+"0"+answerH_14+"0"+
                "0"+answerH_15+"0"+answerH_16+answerH_17+"0"+"0"+"0"+"0";
        puzHard = hardPuzzle;
        return fromPuzzleStringHard(puzHard);
    }
    private int[] getPuzzleMedium(int diffMedium) {
        String puzMedium;
       /* if(diffMedium == DIFFICULTY_CONTINUE){
            puzMedium = getPreferences(MODE_PRIVATE).getString(PREF_PUZZLE,
                    mediumPuzzle);
        }*/
        String mediumPuzzle = "0"+answerM_1+answerM_2+"0"+answerM_3+"0"+
                answerM_4+answerM_5+"0"+answerM_6+"0"+"0"+
                "0"+"0"+"0"+"0"+"0"+answerM_7+
                answerM_8+"0"+answerM_9+"0"+answerM_10+answerM_11+
                "0"+"0"+"0"+"0"+"0"+"0"+
                "0"+"0"+answerM_12+"0"+"0"+"0";
        puzMedium = mediumPuzzle;
        return fromPuzzleStringMedium(puzMedium);
    }
    private int[] getPuzzleEasy(int diffEasy) {
        String puzEasy;
        /*if(diffEasy == DIFFICULTY_CONTINUE){
            puzEasy = getPreferences(MODE_PRIVATE).getString(PREF_PUZZLE,
                    easyPuzzle);
        }*/
//        Bundle extras = getIntent().getExtras();
//        int[] arrayB = extras.getIntArray("values");
        String easyPuzzle = "0"+answer_1+"0"+"0"+"0"+answer_2+answer_3+"0"+"0"+"0"+answer_4+answer_5+answer_6+answer_7+answer_8+"0";
        Log.d(TAG, "on get"+easyPuzzle);

        puzEasy = easyPuzzle;
        return fromPuzzleStringEasy(puzEasy);
    }

    static private String toPuzzleStringHard(int[] puzHard) {
        StringBuilder bufHard = new StringBuilder();
        for (int element : puzHard) {
            bufHard.append(element);
        }
        return bufHard.toString();
    }
    static private String toPuzzleStringMedium(int[] puzMedium) {
        StringBuilder bufMedium = new StringBuilder();
        for (int element : puzMedium) {
            bufMedium.append(element);
        }
        return bufMedium.toString();
    }
    static private String toPuzzleStringEasy(int[] puzEasy) {
        StringBuilder bufEasy = new StringBuilder();
        for (int element : puzEasy) {
            bufEasy.append(element);
        }
        return bufEasy.toString();
    }
    static protected int[] fromPuzzleStringHard(String string) {
        int[] puzHard = new int[string.length()];
        for (int i = 0; i < puzHard.length; i++) {
            puzHard[i] = string.charAt(i) - '0' ;
        }
        return puzHard;
    }
    static protected int[] fromPuzzleStringMedium(String string) {
        int[] puzMedium = new int[string.length()];
        for (int i = 0; i < puzMedium.length; i++) {
            puzMedium[i] = string.charAt(i) - '0' ;
        }
        return puzMedium;
    }
    static protected int[] fromPuzzleStringEasy(String string) {
        int[] puzEasy = new int[string.length()];
        for (int i = 0; i < puzEasy.length; i++) {
            puzEasy[i] = string.charAt(i) - '0' ;
        }
        return puzEasy;
    }
    private int getTileHard(int x, int y) {
        return puzzleHard[y * 9 + x];
    }
    private int getTileMedium(int x, int y) {return puzzleMedium[y * 6 + x]; }
    private int getTileEasy(int x, int y) {return puzzleEasy[y * 4 + x]; }
    private void setTileHard(int x, int y, int value) {
        puzzleHard[y * 9 + x] = value;
    }
    private void setTileMedium(int x, int y, int value) { puzzleMedium[y * 6 + x] = value; }
    private void setTileEasy(int x, int y, int value) { puzzleEasy[y * 4 + x] = value; }
    protected String getTileStringHard(int x, int y) {
        int v = getTileHard(x, y);
        if (v == 0)
            return "" ;
        else
            return String.valueOf(v);
    }
    protected String getTileStringMedium(int x, int y) {
        int v = getTileMedium(x, y);
        if (v == 0)
            return "" ;
        else
            return String.valueOf(v);
    }
    protected String getTileStringEasy(int x, int y) {
        int v = getTileEasy(x, y);
        if (v == 0)
            return "" ;
        else
            return String.valueOf(v);
    }
    public boolean isSolvedHard() {
        for (int element : puzzleHard) {
            if (element == 0)
                return false;
        }
        return true;
    }

    public boolean isSolvedMedium() {
        for (int element : puzzleMedium) {
            if (element == 0)
                return false;
        }
        return true;
    }
    public boolean isSolvedEasy() {
        for (int element : puzzleEasy){
            if (element == 0)
                return false;
                Log.d(TAG, " not SOLVED");
        }
        Log.d(TAG, "SOLVED");
        return true;
    }
    public boolean checkIsSolvedHard()
    {
        //check if the game is complete after each valid move
        if (isSolvedHard() == true) {
            int sudokuScore = 50;
            int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
            int score = getIntent().getExtras().getInt("score");
            int finalScore = sudokuScore + score;
            Log.d(TAG, "Your score is " + score);
            Intent i = new Intent(this, Congratulations.class);
            i.putExtra(Game.KEY_DIFFICULTY, diff);
            i.putExtra("final_score", finalScore);
            startActivity(i);
        }
        else
        {
            return false;
        }
        return false;
    }
    public boolean checkIsSolvedMedium()
    {
        //check if the game is complete after each valid move
        if (isSolvedMedium() == true) {
            int sudokuScore = 30;
            int score = getIntent().getExtras().getInt("score");
            Log.d(TAG, "Your score is " + score);
            int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
            Intent i = new Intent(this, Congratulations.class);
            i.putExtra(Game.KEY_DIFFICULTY, diff);
            int finalScore = sudokuScore + score;
            i.putExtra("final_score", finalScore);
            startActivity(i);}
        else
        {
            return false;
        }
        return false;
    }
    /*public boolean checkIsSolvedEasy()
    {
        //check if the game is complete after each valid move
        if (isSolvedEasy()==true) {
            int sudokuScore = 20;
            int score = getIntent().getExtras().getInt("score");
            int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);
            Log.d(TAG, "Your score is " + score);
            Intent i = new Intent(this, Congratulations.class);
            i.putExtra(Game.KEY_DIFFICULTY, diff);
            int finalScore = sudokuScore + score;
            i.putExtra("final_score", finalScore);
            startActivity(i);
        }
        else
        {
            return false;
        }
        return false;
    }*/
    @Override
    protected void onResume() {
        super.onResume();
        Music.play(this, R.raw.game);
    }
   /* @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause" );
        Music.stop(this);
        int diff = getIntent().getExtras().getInt(KEY_DIFFICULTY);

// Save the current puzzle
        switch (diff) {
            case 2:
                getPreferences(MODE_PRIVATE).edit().putString(PREF_PUZZLE,
                        toPuzzleStringHard(puzzleHard)).commit();
                break;
            case 1:
                getPreferences(MODE_PRIVATE).edit().putString(PREF_PUZZLE,
                        toPuzzleStringMedium(puzzleMedium)).commit();
                break;
            case 0:
                getPreferences(MODE_PRIVATE).edit().putString(PREF_PUZZLE,
                        toPuzzleStringEasy(puzzleEasy)).commit();
                break;
        }
    }*/
}
