package com.example.razu.space_shooter_api_15;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;


public class SettingsActivity extends Activity{

  //  MainActivityStartPageActivity m=new MainActivityStartPageActivity();
    DataBaseHandlerForSettingsManager dataBaseHandlerForSettingsManager=new DataBaseHandlerForSettingsManager(this);
    DatabaseHandlerForScoresManager databaseHandlerForScoresManager=new DatabaseHandlerForScoresManager(this);

    ImageButton nextButtonSpaceShipChooser;
    ImageButton previousButtonSpaceShipChooser;

    ImageView mySpaceShipImage;
    float xMySpaceShip;

    Bitmap spaceShipChooserBitmap;
    int myShipNo=1;

    Switch switchSoundOnOrOff;
    int buttonClickSoundOnOrOff=1;
    Switch switchBackMusicOnOrOff;
    int backMusicOnOrOff=1;
    Switch switchGamingSoundOnOrOff;
    int gamingSoundOnOrOff=1;

    MediaPlayer mediaPlayerButtonClickSoundOnOrOff;

    int permissionForRun=1;

    LinearLayout linearLayoutMain;
    float screenWidth=0;

    float SWIPE_MIN_DISTANCE = 65;
    float minYSwipeArea;
    float maxYSwipeArea;

    float downX = 0,downY=0;
    float upX=0,upY=0;
    float deltaX,deltaY;

    FrameLayout barSelectYourShipFrameLayout;
    FrameLayout barImageButtonFrameLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);


       // nextButtonSpaceShipChooser=(ImageButton)findViewById(R.id.idNextButtonSpaceShipChooser);
       // previousButtonSpaceShipChooser=(ImageButton)findViewById(R.id.idPreviousButtonSpaceShipChooser);

        mySpaceShipImage=(ImageView)findViewById(R.id.spaceShip1Id);

        switchSoundOnOrOff=(Switch)findViewById(R.id.switchSoundOnOrOffId);
        switchBackMusicOnOrOff=(Switch)findViewById(R.id.switchBackMusicOnOrOffId);
        switchGamingSoundOnOrOff=(Switch)findViewById(R.id.switchGamingSoundOnOrOffId);

        linearLayoutMain=(LinearLayout)findViewById(R.id.linearLayoutMainId);
        barSelectYourShipFrameLayout=(FrameLayout)findViewById(R.id.barSelectYourShipFrameLayoutId);
        barImageButtonFrameLayout=(FrameLayout)findViewById(R.id.barImageButtonFrameLayoutId);


      //  myShipSelection();



      /*  ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);

        if( soundManagerObject.getButtonSound()==1)switchSoundOnOrOff.setChecked(true);
        else switchSoundOnOrOff.setChecked(false);
        if( soundManagerObject.getBackgroundMusic()==1)switchBackMusicOnOrOff.setChecked(true);
        else switchBackMusicOnOrOff.setChecked(false);*/

        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);

        if( settingsManagerObject.getButtonSound()==1)switchSoundOnOrOff.setChecked(true);
        else switchSoundOnOrOff.setChecked(false);
        if( settingsManagerObject.getBackgroundMusic()==1)switchBackMusicOnOrOff.setChecked(true);
        else switchBackMusicOnOrOff.setChecked(false);
        if( settingsManagerObject.getGamingSound()==1)switchGamingSoundOnOrOff.setChecked(true);
        else switchGamingSoundOnOrOff.setChecked(false);

        int mySpaceShipNoFromDatabase=settingsManagerObject.getMyShipNo();
        myShipNo=mySpaceShipNoFromDatabase;

        if(myShipNo==1)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss1);
        else if(myShipNo==2)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss2);
        else if(myShipNo==3)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss3);
        else if(myShipNo==4)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss4);
        else if(myShipNo==5)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss5);
        else if(myShipNo==6)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss6);
        else if(myShipNo==7)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss7);

        mySpaceShipImage.setImageBitmap(spaceShipChooserBitmap);




        switchSoundOnOrOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

              /*  ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);
                if(isChecked)
                {
                    dt.updateSound(new ZzDoNotNeedSoundManager(1,soundManagerObject.getBackgroundMusic()));
                    Toast.makeText(getApplicationContext(), "Button sound is ON ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dt.updateSound(new ZzDoNotNeedSoundManager(0, soundManagerObject.getBackgroundMusic()));
                    Toast.makeText(getApplicationContext(), "Button sound is OFF ", Toast.LENGTH_SHORT).show();
                }*/

                if(isChecked)
                {
                    dataBaseHandlerForSettingsManager.updateButtonSound(1);
                    Toast.makeText(getApplicationContext(), "Button sound is ON ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dataBaseHandlerForSettingsManager.updateButtonSound(0);
                    Toast.makeText(getApplicationContext(), "Button sound is OFF ", Toast.LENGTH_SHORT).show();
                }

            }
        });


        switchBackMusicOnOrOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

              /*  ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);
                if(switchBackMusicOnOrOff.isChecked())
                {
                    dt.updateSound( new ZzDoNotNeedSoundManager(soundManagerObject.getButtonSound(), 1) );
                    Toast.makeText(getApplicationContext(), "Background Music is ON ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dt.updateSound( new ZzDoNotNeedSoundManager(soundManagerObject.getButtonSound(), 0) );
                    Toast.makeText(getApplicationContext(), "Background Music is OFF ", Toast.LENGTH_SHORT).show();
                }*/

                if(isChecked)
                {
                    dataBaseHandlerForSettingsManager.updateBackMusic(1);
                    Toast.makeText(getApplicationContext(), "Background Music is ON ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dataBaseHandlerForSettingsManager.updateBackMusic(0);
                    Toast.makeText(getApplicationContext(), "Background Music is OFF ", Toast.LENGTH_SHORT).show();
                }



            }
        });

        switchGamingSoundOnOrOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if(isChecked)
                {
                    dataBaseHandlerForSettingsManager.updateGamingSound(1);
                    Toast.makeText(getApplicationContext(), "Gaming Sound is ON ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dataBaseHandlerForSettingsManager.updateGamingSound(0);
                    Toast.makeText(getApplicationContext(), "Gaming Sound is OFF ", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        screenWidth=linearLayoutMain.getWidth();

        xMySpaceShip=(screenWidth/2) - (mySpaceShipImage.getWidth()/2);
        mySpaceShipImage.setX(xMySpaceShip);

        SWIPE_MIN_DISTANCE =(screenWidth/2) - (screenWidth/4);
        minYSwipeArea=barSelectYourShipFrameLayout.getY()+barSelectYourShipFrameLayout.getHeight()+21;
        maxYSwipeArea=barImageButtonFrameLayout.getY();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();

        if(action==MotionEvent.ACTION_DOWN){
            downX=event.getX();
            downY=event.getY();

        }

        if(downX > ( screenWidth/2-70 ) && downX < ( screenWidth/2+70 ) && action==MotionEvent.ACTION_MOVE){

            float xMove=event.getX();
            float yMove=event.getY();

            xMove=xMove-mySpaceShipImage.getWidth()/2;

            if(downY>minYSwipeArea && downY<maxYSwipeArea)mySpaceShipImage.setX(xMove);
        }

        if(downY>minYSwipeArea && downY<maxYSwipeArea  && downX > ( screenWidth/2-70 ) && downX < ( screenWidth/2+70 ))
        {
            if(action==MotionEvent.ACTION_UP)
            {
                upX=event.getX(); upY=event.getY();

                deltaX=downX-upX;
                deltaY=downY-upY;

                if(Math.abs(deltaX)>Math.abs(deltaY))
                {
                    //swipe horizontal
                    if(Math.abs(deltaX)>SWIPE_MIN_DISTANCE)
                    {
                        mySpaceShipImage.setX(xMySpaceShip);

                        if(deltaX<0)
                        {
                            //right swipe
                            if(myShipNo<=6)myShipNo++;

                            SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
                            if( settingsManagerObject.getButtonSound()==1)
                            {
                                mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
                                mediaPlayerButtonClickSoundOnOrOff.start();
                            }

                            if(myShipNo==1)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss1);
                            else if(myShipNo==2)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss2);
                            else if(myShipNo==3)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss3);
                            else if(myShipNo==4)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss4);
                            else if(myShipNo==5)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss5);
                            else if(myShipNo==6)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss6);
                            else if(myShipNo==7)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss7);


                            mySpaceShipImage.setX(xMySpaceShip);
                            mySpaceShipImage.setImageBitmap(spaceShipChooserBitmap);

                            dataBaseHandlerForSettingsManager.updateMyShipNo(myShipNo);

                        }

                        if(deltaX>0)
                        {
                            //left swipe
                            if(myShipNo>=2)myShipNo--;

                            SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
                            if( settingsManagerObject.getButtonSound()==1)
                            {
                                mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
                                mediaPlayerButtonClickSoundOnOrOff.start();
                            }

                            if(myShipNo==1)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss1);
                            else if(myShipNo==2)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss2);
                            else if(myShipNo==3)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss3);
                            else if(myShipNo==4)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss4);
                            else if(myShipNo==5)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss5);
                            else if(myShipNo==6)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss6);
                            else if(myShipNo==7)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss7);


                            mySpaceShipImage.setX(xMySpaceShip);
                            mySpaceShipImage.setImageBitmap(spaceShipChooserBitmap);

                            dataBaseHandlerForSettingsManager.updateMyShipNo(myShipNo);

                        }

                    }
                    else mySpaceShipImage.setX(xMySpaceShip);
                }
                else mySpaceShipImage.setX(xMySpaceShip);
            }

        }else mySpaceShipImage.setX(xMySpaceShip);


        return super.onTouchEvent(event);
    }


    public void NextButtonSpaceShipChooserAction(View v)
    {

        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }

        if(myShipNo<=6)myShipNo++;
        if(myShipNo==1)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss1);
        else if(myShipNo==2)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss2);
        else if(myShipNo==3)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss3);
        else if(myShipNo==4)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss4);
        else if(myShipNo==5)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss5);
        else if(myShipNo==6)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss6);
        else if(myShipNo==7)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss7);

        mySpaceShipImage.setImageBitmap(spaceShipChooserBitmap);

        dataBaseHandlerForSettingsManager.updateMyShipNo(myShipNo);

    }

    public void PreviousButtonSpaceShipChooserAction(View v)
    {
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if( settingsManagerObject.getButtonSound()==1)
        {
            mediaPlayerButtonClickSoundOnOrOff = MediaPlayer.create(this, R.raw.perf);
            mediaPlayerButtonClickSoundOnOrOff.start();
        }

        if(myShipNo>=2)myShipNo--;
        if(myShipNo==1)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss1);
        else if(myShipNo==2)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss2);
        else if(myShipNo==3)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss3);
        else if(myShipNo==4)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss4);
        else if(myShipNo==5)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss5);
        else if(myShipNo==6)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss6);
        else if(myShipNo==7)spaceShipChooserBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ss7);

        mySpaceShipImage.setImageBitmap(spaceShipChooserBitmap);

        dataBaseHandlerForSettingsManager.updateMyShipNo(myShipNo);


    }




    public void switchSoundOnOrOffAction(View v)
    {
      /*  int rowCount=dt.checkDatabaseIsEmptyOrNot();
        if (rowCount==0)dt.insertData(new ZzDoNotNeedSoundManager(1,1));

        ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);

        if(switchSoundOnOrOff.isChecked())
        {
           // dt.updateSound(new ZzDoNotNeedSoundManager(1,1));
            Toast.makeText(getApplicationContext(), "Button sound is ON ", Toast.LENGTH_LONG).show();
        }
        else
        {
            dt.updateSound(new ZzDoNotNeedSoundManager(0, soundManagerObject.getBackgroundMusic()));
            Toast.makeText(getApplicationContext(), "Button sound is OFF ", Toast.LENGTH_LONG).show();
        }*/

    }

    public void switchBackMusicOnOrOffAction(View v)
    {
       /* int rowCount=dt.checkDatabaseIsEmptyOrNot();
        if (rowCount==0)dt.insertData(new ZzDoNotNeedSoundManager(1,1));

        ZzDoNotNeedSoundManager soundManagerObject =dt.getSoundStatus(1);

        if(switchBackMusicOnOrOff.isChecked())
        {
            dt.updateSound( new ZzDoNotNeedSoundManager(soundManagerObject.getButtonSound(), 1) );
            Toast.makeText(getApplicationContext(), "Background Music is ON ", Toast.LENGTH_LONG).show();
        }
        else
        {
            dt.updateSound( new ZzDoNotNeedSoundManager(soundManagerObject.getButtonSound(), 0) );
            Toast.makeText(getApplicationContext(), "Background Music is OFF ", Toast.LENGTH_LONG).show();
        }*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about_Game_in_SettingsPage_in_Menu_id) {
            finish();
            Intent aboutGame_intent_from_Settings_Activity=new Intent(this,AboutGameActivity.class);
            startActivity(aboutGame_intent_from_Settings_Activity);
        }

        else if (id == R.id.instructions_in_SettingsPage_in_Menu_id) {

            finish();
            Intent instructions_intent_from_Settings_Activity=new Intent(this,InstructionsActivity.class);
            startActivity(instructions_intent_from_Settings_Activity);
        }

        else if (id == R.id.play_in_SettingsPage_in_Menu_id) {
            finish();
            Intent play_intent_from_Settings_Activity=new Intent(this,PlayActivity.class);
            startActivity(play_intent_from_Settings_Activity);
        }

        else if (id == R.id.scores_in_SettingsPage_in_Menu_id) {
            if(databaseHandlerForScoresManager.checkDatabaseIsEmptyOrNot()>0)
            {
                finish();
                Intent scores_intent=new Intent(this,ScoresActivity.class);
                startActivity(scores_intent);
            }
            else Toast.makeText(getApplicationContext(), "The game is not played yet", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.startpage_in_SettingsPage_in_Menu_id) {
            finish();
          //  System.exit(0);
            //Intent startpage_intent_from_Settings_Activity=new Intent(this,MainActivityStartPageActivity.class);
            //startActivity(startpage_intent_from_Settings_Activity);
        }

        return super.onOptionsItemSelected(item);
    }



}

