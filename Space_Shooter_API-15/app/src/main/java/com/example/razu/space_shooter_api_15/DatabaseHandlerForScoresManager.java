package com.example.razu.space_shooter_api_15;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rAZU on 26-Jan-15.
 */
public class DatabaseHandlerForScoresManager extends SQLiteOpenHelper {
    
    private static final int DATABASE_VERSION=1;
    
    private static final String DATABASE_NAME="ScoreManagerFullNewTest"; // "SoundManagerFullNewoneNewone";

    private static final String TABLE_NAME="ScoresTableFullNewTest"; // "SoundTableFullNewoneNewOne";

    private static final String KEY_ID="id";
    private static final String KEY_PLAYER_NAME="playerName";
    private static final String KEY_PLAYER_SCORE="playerScore";
    private static final String KEY_LAST_PLAYED_SCORE="lastPlayedScore";


    int lastPlayedScore;


    public DatabaseHandlerForScoresManager(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SoundTable_TABLE= "CREATE TABLE " + TABLE_NAME + " (" +
                KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_PLAYER_NAME +" TEXT," +
                KEY_PLAYER_SCORE +" INTEGER," +
                KEY_LAST_PLAYED_SCORE +" INTEGER" +
                " )";
        db.execSQL(CREATE_SoundTable_TABLE);


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public int checkDatabaseIsEmptyOrNot()
    {
        int rowCount=0;

        try
        {
            SQLiteDatabase dbForRowCount = this.getReadableDatabase();
            String getQuery = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = dbForRowCount.rawQuery(getQuery, null);

            if (cursor != null) cursor.moveToFirst();
            rowCount = cursor.getCount();
            System.out.println("row value  in check =" + rowCount);

            dbForRowCount.close();

        }catch(Exception e){
            System.out.println("error= " + e);
        }

        return rowCount;
    }

    public void insertScoresData(ScoresManager scoresManager)
    {

        try
        {
            SQLiteDatabase db = this.getWritableDatabase();

            String insertQuery = "INSERT INTO " + TABLE_NAME + " ('" + KEY_PLAYER_NAME + "','" + KEY_PLAYER_SCORE + "','" + KEY_LAST_PLAYED_SCORE + "') VALUES('" + scoresManager.getPlayerName() + "','" + scoresManager.getPlayerScore() + "','" + scoresManager.getLastPlayedScore() + "');";
            db.execSQL(insertQuery);

            System.out.println("myData inserted");

            db.close();
        }
        catch (Exception e)
        {
            System.out.println("error= " + e);
        }
    }

    public void updateScoresData(ScoresManager scoresManager , int inputId)
    {

        int rowCount=checkDatabaseIsEmptyOrNot();

        if(rowCount<=0)
        {
            insertScoresData(scoresManager);
        }
        else if(rowCount>0)
        {
            System.out.println("Row already exists.Number of rows : "+rowCount);

            try
            {
                SQLiteDatabase db = this.getWritableDatabase();
                String updateQuery = "UPDATE " + TABLE_NAME + " SET " + KEY_PLAYER_NAME + " = '" + scoresManager.getPlayerName() + "', " + KEY_PLAYER_SCORE + " = " + scoresManager.getPlayerScore() + " WHERE " + KEY_ID + " = " + inputId;
                db.execSQL(updateQuery);

                System.out.println("myData updated1 : " + scoresManager.getPlayerName() + "  myData2 updated1 : " + scoresManager.getPlayerScore());
                ScoresManager scoresManagerObject = getScoresDataById(1);
                System.out.println("myData updated2 : " + scoresManagerObject.getPlayerName() + "  myData2 updated2 : " + scoresManagerObject.getPlayerScore());

                db.close();
            }catch (Exception e){
                System.out.println("error= " + e);
            }

        }

    }

    public ScoresManager getScoresDataById(int inputId)
    {

        ScoresManager scoresManagerObject=new ScoresManager();

        try
        {
            SQLiteDatabase db =this.getReadableDatabase();
            String getQuery="SELECT * FROM "+ TABLE_NAME + " WHERE id='" + inputId + "'" ;
            Cursor cursor = db.rawQuery(getQuery,null);

            if(cursor!=null)cursor.moveToFirst();

            do{
                scoresManagerObject =new ScoresManager(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3));

                //System.out.println("id=" + scoresManagerObject._id + "pn" + scoresManagerObject._playerName + "ps" + scoresManagerObject._playerScore);

            }while(cursor.moveToNext());

            db.close();
        }catch(Exception e){
            System.out.println("error= " + e);
        }


        return scoresManagerObject;
    }

    public String[] getAllPlayerName()
    {
        int totalRow=checkDatabaseIsEmptyOrNot();
        String[] playerName=new String[totalRow];

        int row=0;

        ScoresManager scoresManagerObjectSorted=new ScoresManager();

        try {
            SQLiteDatabase db = this.getReadableDatabase();

            String getQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + KEY_PLAYER_SCORE + " DESC";//" WHERE id='" + input_id + "'" ;

            Cursor cursor = db.rawQuery(getQuery, null);

            if (cursor != null) cursor.moveToFirst();

            do {

                scoresManagerObjectSorted = new ScoresManager(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3));

                playerName[row] = scoresManagerObjectSorted.getPlayerName();
                row++;

            } while (cursor.moveToNext());


            db.close();
        }catch(Exception e){
            System.out.println("error in getAllPlayerName()= " + e);
        }


        return  playerName;
    }

    public String[] getAllPlayerScore()
    {
        int totalRow=checkDatabaseIsEmptyOrNot();
        String[] playerScore=new String[totalRow];

        int row=0;

        ScoresManager scoresManagerObjectSorted=new ScoresManager();

        try {
            SQLiteDatabase db = this.getReadableDatabase();

            String getQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + KEY_PLAYER_SCORE + " DESC";//" WHERE id='" + input_id + "'" ;

            Cursor cursor = db.rawQuery(getQuery, null);

            if (cursor != null) cursor.moveToFirst();

            do {

                scoresManagerObjectSorted = new ScoresManager(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3));

                playerScore[row] = ""+scoresManagerObjectSorted.getPlayerScore();
                row++;

            } while (cursor.moveToNext());


            db.close();
        }catch(Exception e){
            System.out.println("error in getAllPlayerScore()= " + e);
        }


        return  playerScore;
    }




    //Don't need
    public void sortScoresData()
    {
        int idUnSorted=0;

        String[] playerNameStringArray = new String[checkDatabaseIsEmptyOrNot()+1];
        int[] playerScoreIntegerArray = new int[checkDatabaseIsEmptyOrNot()+1];

        ScoresManager scoresManagerObjectSorted=new ScoresManager();

        try {
            SQLiteDatabase db = this.getReadableDatabase();

            String getQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + KEY_PLAYER_SCORE + " DESC";//" WHERE id='" + input_id + "'" ;

            Cursor cursor = db.rawQuery(getQuery, null);

            if (cursor != null) cursor.moveToFirst();

            do {
                idUnSorted++;

                scoresManagerObjectSorted = new ScoresManager(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3));

                playerNameStringArray[idUnSorted] = scoresManagerObjectSorted.getPlayerName();
                playerScoreIntegerArray[idUnSorted] = scoresManagerObjectSorted.getPlayerScore();


            } while (cursor.moveToNext());

            for (int temp = 1; temp <= checkDatabaseIsEmptyOrNot(); temp++) {
                ScoresManager scoresManagerObjectForSort = new ScoresManager(playerNameStringArray[temp], playerScoreIntegerArray[temp]);
                updateScoresData(scoresManagerObjectForSort, temp);
            }

            db.close();
        }catch(Exception e){
            System.out.println("error= " + e);
        }

    }

    public void setScoresData(ScoresManager scoresManager)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            String insertQuery = "INSERT INTO " + TABLE_NAME + " ('" + KEY_PLAYER_NAME + "','" + KEY_PLAYER_SCORE + "') VALUES('" + scoresManager.getPlayerName() + "','" + scoresManager.getPlayerScore() + "');";
            db.execSQL(insertQuery);

            db.close();
        }catch(Exception e){
            System.out.println("error= " + e);
        }

    }

    public int getLastPlayedScore()
    {

        ScoresManager scoresManagerObject=getScoresDataById(checkDatabaseIsEmptyOrNot());
        lastPlayedScore=scoresManagerObject.getLastPlayedScore();

        return lastPlayedScore;

    }

    public ScoresManager getSortedScoresData(int position)
    {
        ScoresManager scoresManagerObject=new ScoresManager();

        //forGettingSortedScoresData();
        //  scoresManagerObject=new ScoresManager(playerNameStringArray[position] , playerScoreIntegerArray[position]);

        return  scoresManagerObject;


    }

}
