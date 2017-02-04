package com.example.razu.space_shooter_api_15;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivityStartPageActivity extends Activity {


    DatabaseHandlerForScoresManager databaseHandlerForScoresManager=new DatabaseHandlerForScoresManager(this);
    DataBaseHandlerForSettingsManager dataBaseHandlerForSettingsManager=new DataBaseHandlerForSettingsManager(this);

    MediaPlayer mediaPlayerButtonClickSoundOnOrOff;
    int buttonClickSoundOnOff=1;

    FrameLayout startPage;

    Button aboutGame;
    Button play;
    Button scores;
    Button instructions;
    ImageButton settings;
    ImageButton exit;

    FrameLayout exitPage;

    int flagForExitPageVisibility=0;

    int k=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.startpage_layout);

       /* int rowCount=dt.checkDatabaseIsEmptyOrNot();
        if (rowCount==0)dt.insertData(new ZzDoNotNeedSoundManager(1,1));
        dt.updateSound(new ZzDoNotNeedSoundManager(0, 1));*/

        startPage=(FrameLayout)findViewById(R.id.startPageId);

        aboutGame=(Button)findViewById(R.id.buttonAboutGameId);
        play=(Button)findViewById(R.id.buttonPlayId);
        scores=(Button)findViewById(R.id.buttonScoresId);
        instructions=(Button)findViewById(R.id.buttonInstructionsId);

        settings=(ImageButton)findViewById(R.id.buttonSettingId);
        exit=(ImageButton)findViewById(R.id.buttonExitId);

        exitPage=(FrameLayout)findViewById(R.id.exitPageId);
        exitPage.setVisibility(View.INVISIBLE);
        flagForExitPageVisibility=0;

        int rowCount=dataBaseHandlerForSettingsManager.checkDatabaseIsEmptyOrNot();
        if (rowCount==0)dataBaseHandlerForSettingsManager.insertAllSettingsData(new SettingsManager(1,1,1,1));
        dataBaseHandlerForSettingsManager.updateAllSettings(new SettingsManager(1, 1, 1, 1));

      //  if(databaseHandlerForScoresManager.checkDatabaseIsEmptyOrNot()>0)
      //  databaseHandlerForScoresManager.forGettingSortedScoresData();
       // Toast.makeText(getApplicationContext(),"onCreate Main",Toast.LENGTH_SHORT).show();

    }

    public MainActivityStartPageActivity() {
     //   dt.updateSound(new ZzDoNotNeedSoundManager(1, 1));
      //  Toast.makeText(getApplicationContext(),"constructor Main",Toast.LENGTH_SHORT).show();
     //   System.out.println(" my constructor main");

    }

    public void Button_About_Game_clickAction(View v){

     /*   ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);
        if( soundManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }*/

        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }

        Intent aboutGameIntent=new Intent(this,AboutGameActivity.class);
        startActivity(aboutGameIntent);


    }

    public void ButtonInstructionsClickAction(View v){

       /* ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);
        if( soundManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }*/
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }

        Intent instructionsIntent=new Intent(this,InstructionsActivity.class);
        startActivity(instructionsIntent);


    }

    public void ButtonPlayClickAction(View v){

       /* ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);
        if( soundManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }*/
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }

        Intent playIntent=new Intent(this,PlayActivity.class);
        startActivity(playIntent);


    }

    public void ButtonSettingsClickAction(View v){

     /*   ZzDoNotNeedSoundManager sound2=new ZzDoNotNeedSoundManager(1,1);
        ZzDoNotNeedSoundManager sound3;
        ZzDoNotNeedDatabaseHandlerForSoundManager dt=new ZzDoNotNeedDatabaseHandlerForSoundManager(this);

        dt.setSound(sound2);
        sound3=dt.getSoundStatus(1);
        Toast.makeText(getApplicationContext(), "Button sound is"+sound3.button_sound, Toast.LENGTH_LONG).show();*/

      /*  sound3=dt.getSoundStatus(1);
        if(sound3.button_sound==1) {
            Toast.makeText(getApplicationContext(), "Button sound is ON ", Toast.LENGTH_LONG).show();
        }
        if(sound3.button_sound==0) {
            Toast.makeText(getApplicationContext(), "Button sound is OFF ", Toast.LENGTH_LONG).show();
        }*/

        /*ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);
        if( soundManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }*/
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }

        Intent settings_intent=new Intent(this,SettingsActivity.class);
        startActivity(settings_intent);



    }

    public void ButtonScoresClickAction(View v){


        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }

      //  databaseHandlerForScoresManager.insertScoresData(new ScoresManager("Ibrahim",32,32));
     /*   databaseHandlerForScoresManager.insertScoresData(new ScoresManager("Suzon",265,265));
        databaseHandlerForScoresManager.insertScoresData(new ScoresManager("Kazi",265,265));
        databaseHandlerForScoresManager.insertScoresData(new ScoresManager("Faruk",14,14));
        databaseHandlerForScoresManager.insertScoresData(new ScoresManager("Rafiq",12,12));*/

        if(databaseHandlerForScoresManager.checkDatabaseIsEmptyOrNot()>0)
        {
           // Intent scoresIntent=new Intent(this,ZzDoNotNeedScoresActivityTest.class);
            Intent scoresIntent=new Intent(this,ScoresActivity.class);
            startActivity(scoresIntent);
        }
        else Toast.makeText(getApplicationContext(),"The game is not played yet",Toast.LENGTH_SHORT).show();

    }

    public void ButtonExitClickAction(View v){

        /*ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);
        if( soundManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }*/
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }


        exitPage.setVisibility(View.VISIBLE);
        flagForExitPageVisibility=1;
        aboutGame.setEnabled(false);
        play.setEnabled(false);
        scores.setEnabled(false);
        instructions.setEnabled(false);
        settings.setEnabled(false);
        exit.setEnabled(false);



       // Intent exit_intent=new Intent(this,ZzDoNotNeedExitActivity.class);
       // startActivity(exit_intent);


    }

    public void buttonYesExitClickAction(View v)
    {
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }


       // System.exit(0);
        finish();
    }

    public void buttonNoExitClickAction(View v)
    {
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }

        exitPage.setVisibility(View.INVISIBLE);
        flagForExitPageVisibility=0;
        aboutGame.setEnabled(true);
        play.setEnabled(true);
        scores.setEnabled(true);
        instructions.setEnabled(true);
        settings.setEnabled(true);
        exit.setEnabled(true);

    }

    @Override
    public void onAttachedToWindow() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    }

    @Override
    public void onStart(){
        super.onStart();
       // Toast.makeText(getApplicationContext(),"onStart Main",Toast.LENGTH_SHORT).show();

        // setContentView(R.layout.startpage_layout);

    }

    @Override
    public void onRestart(){
        super.onRestart();
      //  Toast.makeText(getApplicationContext(),"onRestart Main",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume(){
        super.onResume();
       // Toast.makeText(getApplicationContext(),"onResume Main",Toast.LENGTH_SHORT).show();
        //   setContentView(R.layout.startpage_layout);

    }
    @Override
    public void onPause(){
        super.onPause();
        //  setContentView(R.layout.startpage_layout);
        // onResume();
      //  Toast.makeText(getApplicationContext(),"onPause Main",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStop(){
        super.onStop();
       // Toast.makeText(getApplicationContext(),"onstop Main",Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onBackPressed() {

        exitPage.setVisibility(View.VISIBLE);
        flagForExitPageVisibility=1;
        aboutGame.setEnabled(false);
        play.setEnabled(false);
        scores.setEnabled(false);
        instructions.setEnabled(false);
        settings.setEnabled(false);
        exit.setEnabled(false);

    }



/*    public void onDestory(){
        super.onDestroy();

    }*/


}
