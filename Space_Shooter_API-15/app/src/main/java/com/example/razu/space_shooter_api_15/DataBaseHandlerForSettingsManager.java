package com.example.razu.space_shooter_api_15;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rAZU on 31-Jan-15.
 */
public class DataBaseHandlerForSettingsManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="SoundManagerFullNewoneNewoneNewTest";

    private static final String TABLE_NAME="SoundTableFullNewoneNewOneNewTest";

    private static final String KEY_ID="id";
    private static final String KEY_BUTTON_SOUND="buttonSound";
    private static final String KEY_BACK_MUSIC="backMusic";
    private static final String KEY_GAMING_SOUND="gamingSound";
    private static final String KEY_MY_SHIP_NO="myShipNo";



    public DataBaseHandlerForSettingsManager(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SoundTable_TABLE= "CREATE TABLE " + TABLE_NAME + " (" +
                KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_BUTTON_SOUND +" INTEGER," +
                KEY_BACK_MUSIC +" INTEGER," +
                KEY_GAMING_SOUND +" INTEGER," +
                KEY_MY_SHIP_NO +" INTEGER" +
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
            System.out.println("row value  in checkDatabaseIsEmptyOrNot =" + rowCount);

            dbForRowCount.close();

        }catch(Exception e){
            System.out.println("error in checkDatabaseEmptyOrNot= " + e);
        }

        return rowCount;
    }


    public void insertAllSettingsData(SettingsManager settingsManager)
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            String insertQuery = "INSERT INTO " + TABLE_NAME + " ('" + KEY_BUTTON_SOUND + "','" + KEY_BACK_MUSIC + "','" + KEY_GAMING_SOUND + "','" + KEY_MY_SHIP_NO + "') VALUES('" + settingsManager.getButtonSound() + "','" + settingsManager.getBackgroundMusic() + "','" + settingsManager.getGamingSound() + "','" + settingsManager.getMyShipNo() + "');";
            db.execSQL(insertQuery);

            System.out.println("mySettingsData inserted");

            db.close();

        }catch(Exception e){
            System.out.println("error in insertSettingsData= " + e);
        }
    }


    public void updateAllSettings(SettingsManager settingsManager)
    {

        int rowCount=checkDatabaseIsEmptyOrNot();

        if(rowCount<=0)
        {
            insertAllSettingsData(settingsManager);
        }
        else if(rowCount>0)
        {
            System.out.println("Row already exists.Number of rows : "+rowCount);

            try {
                SQLiteDatabase db = this.getWritableDatabase();
                //String updateQuery="UPDATE "+ TABLE_NAME + " SET "+ KEY_BUTTON_SOUND + " = "+soundManager.getButtonSound()+ " WHERE " + KEY_ID + " = 1";
                String updateQuery = "UPDATE " + TABLE_NAME + " SET " + KEY_BUTTON_SOUND + " = " + settingsManager.getButtonSound() + " , " + KEY_BACK_MUSIC + " = " + settingsManager.getBackgroundMusic() +" , " + KEY_GAMING_SOUND + " = " + settingsManager.getGamingSound() +" , " + KEY_MY_SHIP_NO + " = " + settingsManager.getMyShipNo() + " WHERE " + KEY_ID + " = 1";
                db.execSQL(updateQuery);

                System.out.println("myData updatedAllSettings1: id=" + settingsManager._id + " bs=" + settingsManager._buttonSound + " bm="
                        + settingsManager._backgroundMusic+" gs="+settingsManager._gamingSound+" msn="+settingsManager._myShipNo);

                SettingsManager settingsManagerObject = getAllSettingsData(1);
                System.out.println("myData updatedAllSettings2: id=" + settingsManagerObject._id + " bs=" + settingsManagerObject._buttonSound + " bm="
                        + settingsManagerObject._backgroundMusic+" gs="+settingsManagerObject._gamingSound+" msn="+settingsManagerObject._myShipNo);

                db.close();
            }catch(Exception e){
                System.out.println("error in updateAllSettings= " + e);
            }

        }

    }


    public void updateButtonSound(int zeroOrOne)
    {

        int rowCount=checkDatabaseIsEmptyOrNot();

        if(rowCount<=0)
        {
            insertAllSettingsData(new SettingsManager(1,1,1,1) );
        }
        else if(rowCount>0)
        {
            System.out.println("Row already exists.Number of rows : "+rowCount);

            try {
                SQLiteDatabase db = this.getWritableDatabase();

                String updateQuery = "UPDATE " + TABLE_NAME + " SET " + KEY_BUTTON_SOUND + " = " + zeroOrOne + " WHERE " + KEY_ID + " = 1";
                db.execSQL(updateQuery);

                System.out.println("myData updated1 in updateButtonSound : " + zeroOrOne);
                SettingsManager settingsManagerObject = getAllSettingsData(1);
                System.out.println("myData updated2 in updateButtonSound : " + settingsManagerObject.getButtonSound());

                db.close();
            }catch(Exception e){
                System.out.println("error in updateButtonSound= " + e);
            }

        }

    }

    public void updateBackMusic(int zeroOrOne)
    {

        int rowCount=checkDatabaseIsEmptyOrNot();

        if(rowCount<=0)
        {
            insertAllSettingsData(new SettingsManager(1,1,1,1) );
        }
        else if(rowCount>0)
        {
            System.out.println("Row already exists.Number of rows : "+rowCount);

            try {
                SQLiteDatabase db = this.getWritableDatabase();

                String updateQuery = "UPDATE " + TABLE_NAME + " SET " + KEY_BACK_MUSIC + " = " + zeroOrOne + " WHERE " + KEY_ID + " = 1";
                db.execSQL(updateQuery);

                System.out.println("myData updated1 in updateBackMusic : " + zeroOrOne);
                SettingsManager settingsManagerObject = getAllSettingsData(1);
                System.out.println("myData updated2 in updateBackMusic : " + settingsManagerObject.getBackgroundMusic());

                db.close();
            }catch(Exception e){
                System.out.println("error in updateBackMusic= " + e);
            }

        }

    }

    public void updateGamingSound(int zeroOrOne)
    {

        int rowCount=checkDatabaseIsEmptyOrNot();

        if(rowCount<=0)
        {
            insertAllSettingsData(new SettingsManager(1,1,1,1) );
        }
        else if(rowCount>0)
        {
            System.out.println("Row already exists.Number of rows : "+rowCount);

            try {
                SQLiteDatabase db = this.getWritableDatabase();

                String updateQuery = "UPDATE " + TABLE_NAME + " SET " + KEY_GAMING_SOUND + " = " + zeroOrOne + " WHERE " + KEY_ID + " = 1";
                db.execSQL(updateQuery);

                System.out.println("myData updated1 in updateGamingSound : " + zeroOrOne);
                SettingsManager settingsManagerObject = getAllSettingsData(1);
                System.out.println("myData updated2 in updateGamingSound : " + settingsManagerObject.getGamingSound());

                db.close();
            }catch(Exception e){
                System.out.println("error in updateGamingSound= " + e);
            }

        }

    }

    public void updateMyShipNo(int myShipNo)
    {

        int rowCount=checkDatabaseIsEmptyOrNot();

        if(rowCount<=0)
        {
            insertAllSettingsData(new SettingsManager(1,1,1,1) );
        }
        else if(rowCount>0)
        {
            System.out.println("Row already exists.Number of rows : "+rowCount);

            try {
                SQLiteDatabase db = this.getWritableDatabase();

                String updateQuery = "UPDATE " + TABLE_NAME + " SET " + KEY_MY_SHIP_NO + " = " + myShipNo + " WHERE " + KEY_ID + " = 1";
                db.execSQL(updateQuery);

                System.out.println("myData updated1 in updateMyShipNo : " + myShipNo);
                  SettingsManager settingsManagerObject = getAllSettingsData(1);
                System.out.println("myData updated2 in updateMyShipNo : " + settingsManagerObject.getMyShipNo());

                db.close();
            }catch(Exception e){
                System.out.println("error in updateMyShipNo= " + e);
            }

        }

    }



    public SettingsManager getAllSettingsData(int input_id)
    {
        SettingsManager settingsManagerObject=new SettingsManager();

        try
        {
            SQLiteDatabase db = this.getReadableDatabase();
            String getQuery = "SELECT * FROM " + TABLE_NAME; //+ " WHERE id='" + input_id + "'" ;
            //+ KEY_ID +" = " +input_id;
            Cursor cursor = db.rawQuery(getQuery, null);

            if (cursor != null) cursor.moveToFirst();

            do {
                settingsManagerObject = new SettingsManager(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
                System.out.println("id=" + settingsManagerObject._id + " bs=" + settingsManagerObject._buttonSound + " bm="
                        + settingsManagerObject._backgroundMusic+" gs="+settingsManagerObject._gamingSound+" msn="+settingsManagerObject._myShipNo);

            } while (cursor.moveToNext());

            db.close();

        }catch(Exception e){
            System.out.println("error in getAllSettings= " + e);
        }

        return settingsManagerObject;
    }


}
