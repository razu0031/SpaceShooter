package com.example.razu.space_shooter_api_15;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class PlayActivity extends Activity  {

    DatabaseHandlerForScoresManager databaseHandlerForScoresManager=new DatabaseHandlerForScoresManager(this);
    DataBaseHandlerForSettingsManager dataBaseHandlerForSettingsManager= new DataBaseHandlerForSettingsManager(this);

    FrameLayout touchToStartGamePage;

    MediaPlayer mediaPlayerBackMusic;
    MediaPlayer mediaPlayerExplosionEnemy;
    MediaPlayer mediaPlayerExplosionMyPlayer;
    MediaPlayer mediaPlayerBulletMyPlayer;
    MediaPlayer mediaPlayerBulletEnemy;

    Button pLayPauseButton;

    ImageView backGround1InPlayActivity;
    ImageView backGround2InPlayActivity;
    float xBg1=0,yBg1;
    float xBg2=0,yBg2;
    float tempYBg1=0;
    float tempYBg2=0;
    float screenHeight =0;
    float screenWidth =0;

    ImageView myShip1;
    ImageView myShip2;
    ImageView myShip3;
    ImageView myShip4;
    ImageView myShip;
    int myShipNoFromDatabase=1;
    float xMyShip=0,yMyShip=0;
    float xMyShipTemp=0,yMyShipTemp=0;

    int move=0;
    int flagForGameStarted=0;
    int gameOverDetector=0;
    int delayGameOverShow=0;
    int gameOverPageCalledOrNot=0;
    int flagDelayGameOverShowForThread=1;
    int touchDownOrUp=1;
    int t=0;
    Thread th;


    ImageView myBullet1,myBullet2,myBullet3,myBullet4,myBullet5;
    ImageView myBullet6,myBullet7,myBullet8,myBullet9,myBullet10;
    ImageView myBullet11,myBullet12,myBullet13,myBullet14,myBullet15;
    ImageView myBullet16,myBullet17;
    float xMyBullet=-200, yMyBullet=-200;
    float xMyBullet1=-200, yMyBullet1=-200, flagMyBullet1=0;
    float xMyBullet2=-200, yMyBullet2=-200, flagMyBullet2=0;
    float xMyBullet3=-200, yMyBullet3=-200, flagMyBullet3=0;
    float xMyBullet4=-200, yMyBullet4=-200, flagMyBullet4=0;
    float xMyBullet5=-200, yMyBullet5=-200, flagMyBullet5=0;
    float xMyBullet6=-200, yMyBullet6=-200, flagMyBullet6=0;
    float xMyBullet7=-200, yMyBullet7=-200, flagMyBullet7=0;
    float xMyBullet8=-200, yMyBullet8=-200, flagMyBullet8=0;
    float xMyBullet9=-200, yMyBullet9=-200, flagMyBullet9=0;
    float xMyBullet10=-200, yMyBullet10=-200, flagMyBullet10=0;
    float xMyBullet11=-200, yMyBullet11=-200, flagMyBullet11=0;
    float xMyBullet12=-200, yMyBullet12=-200, flagMyBullet12=0;
    float xMyBullet13=-200, yMyBullet13=-200, flagMyBullet13=0;
    float xMyBullet14=-200, yMyBullet14=-200, flagMyBullet14=0;
    float xMyBullet15=-200, yMyBullet15=-200, flagMyBullet15=0;
    float xMyBullet16=-200, yMyBullet16=-200, flagMyBullet16=0;
    float xMyBullet17=-200, yMyBullet17=-200, flagMyBullet17=0;
    //special bullet
    ImageView myBullet18,myBullet19,myBullet20, myBullet21,myBullet22,myBullet23;
    float xMyBullet18=-200, yMyBullet18=-200, flagMyBullet18=0;
    float xMyBullet19=-200, yMyBullet19=-200, flagMyBullet19=0;
    float xMyBullet20=-200, yMyBullet20=-200, flagMyBullet20=0;
    float xMyBullet21=-200, yMyBullet21=-200, flagMyBullet21=0;
    float xMyBullet22=-200, yMyBullet22=-200, flagMyBullet22=0;
    float xMyBullet23=-200, yMyBullet23=-200, flagMyBullet23=0;


    //enemy ship
    ImageView enemyShip1,enemyShip2,enemyShip3,enemyShip4,enemyShip5;
    ImageView enemyShip6,enemyShip7,enemyShip8;
    float xEnemyShip1=-300, yEnemyShip1=-300, flagEnemyShip1=0, flagEnemyShip1ForHorizontalMove=0; int flagEnemyShip1ForLeftRightMove=-1;
    float xEnemyShip2=-300, yEnemyShip2=-300, flagEnemyShip2=0, flagEnemyShip2ForHorizontalMove=0; int flagEnemyShip2ForLeftRightMove=-1;
    float xEnemyShip3=-300, yEnemyShip3=-300, flagEnemyShip3=0, flagEnemyShip3ForHorizontalMove=0; int flagEnemyShip3ForLeftRightMove=-1;
    float xEnemyShip4=-300, yEnemyShip4=-300, flagEnemyShip4=0, flagEnemyShip4ForHorizontalMove=0; int flagEnemyShip4ForLeftRightMove=-1;
    float xEnemyShip5=-300, yEnemyShip5=-300, flagEnemyShip5=0, flagEnemyShip5ForHorizontalMove=0; int flagEnemyShip5ForLeftRightMove=-1;
    float xEnemyShip6=-300, yEnemyShip6=-300, flagEnemyShip6=0, flagEnemyShip6ForHorizontalMove=0; int flagEnemyShip6ForLeftRightMove=-1;
    float xEnemyShip7=-300, yEnemyShip7=-300, flagEnemyShip7=0, flagEnemyShip7ForHorizontalMove=0; int flagEnemyShip7ForLeftRightMove=-1;
    float xEnemyShip8=-300, yEnemyShip8=-300, flagEnemyShip8=0, flagEnemyShip8ForHorizontalMove=0; int flagEnemyShip8ForLeftRightMove=-1;

    //bullet for enemyShip(2 per each)
    ImageView eBullet1ForEnemyShip1,eBullet2ForEnemyShip1, eBullet1ForEnemyShip2,eBullet2ForEnemyShip2;
    ImageView eBullet1ForEnemyShip3,eBullet2ForEnemyShip3, eBullet1ForEnemyShip4,eBullet2ForEnemyShip4;
    ImageView eBullet1ForEnemyShip5,eBullet2ForEnemyShip5, eBullet1ForEnemyShip6,eBullet2ForEnemyShip6;
    ImageView eBullet1ForEnemyShip7,eBullet2ForEnemyShip7, eBullet1ForEnemyShip8,eBullet2ForEnemyShip8;
    float xEBullet1ForEnemyShip1=-400, yEBullet1ForEnemyShip1=-400, flagEBullet1ForEnemyShip1=0;
    float xEBullet2ForEnemyShip1=-400, yEBullet2ForEnemyShip1=-400, flagEBullet2ForEnemyShip1=0;

    float xEBullet1ForEnemyShip2=-400, yEBullet1ForEnemyShip2=-400, flagEBullet1ForEnemyShip2=0;
    float xEBullet2ForEnemyShip2=-400, yEBullet2ForEnemyShip2=-400, flagEBullet2ForEnemyShip2=0;

    float xEBullet1ForEnemyShip3=-400, yEBullet1ForEnemyShip3=-400, flagEBullet1ForEnemyShip3=0;
    float xEBullet2ForEnemyShip3=-400, yEBullet2ForEnemyShip3=-400, flagEBullet2ForEnemyShip3=0;

    float xEBullet1ForEnemyShip4=-400, yEBullet1ForEnemyShip4=-400, flagEBullet1ForEnemyShip4=0;
    float xEBullet2ForEnemyShip4=-400, yEBullet2ForEnemyShip4=-400, flagEBullet2ForEnemyShip4=0;

    float xEBullet1ForEnemyShip5=-400, yEBullet1ForEnemyShip5=-400, flagEBullet1ForEnemyShip5=0;
    float xEBullet2ForEnemyShip5=-400, yEBullet2ForEnemyShip5=-400, flagEBullet2ForEnemyShip5=0;

    float xEBullet1ForEnemyShip6=-400, yEBullet1ForEnemyShip6=-400, flagEBullet1ForEnemyShip6=0;
    float xEBullet2ForEnemyShip6=-400, yEBullet2ForEnemyShip6=-400, flagEBullet2ForEnemyShip6=0;

    float xEBullet1ForEnemyShip7=-400, yEBullet1ForEnemyShip7=-400, flagEBullet1ForEnemyShip7=0;
    float xEBullet2ForEnemyShip7=-400, yEBullet2ForEnemyShip7=-400, flagEBullet2ForEnemyShip7=0;

    float xEBullet1ForEnemyShip8=-400, yEBullet1ForEnemyShip8=-400, flagEBullet1ForEnemyShip8=0;
    float xEBullet2ForEnemyShip8=-400, yEBullet2ForEnemyShip8=-400, flagEBullet2ForEnemyShip8=0;


    //enemy boss ship and bullets
    ImageView enemyBossShip;
    double enemyBossLifeTotal=13;
    double enemyBossLifeTemp=13;
    String enemyBossLifePercentage ="";
    LinearLayout enemyBossLifeLinearLayout;
    TextView enemyBossLifeTextView;

    float xEnemyBossShip=-600, yEnemyBossShip=-600, flagEnemyBossShip=0, flagEnemyBossShipForHorizontalMove=1;
    int flagEnemyBossShipForLeftRightMove=-1, flagEnemyBossShipForLeftRightMoveTargetingMyShip=-1;
    int flagBossCame=0;
    int delayForBoseCome=0;
    int flagForContinueGameWhenBossCome=1;
    ImageView eBullet1ForBoss,eBullet2ForBoss,eBullet3ForBoss;
    ImageView eBullet4ForBoss,eBullet5ForBoss,eBullet6ForBoss;
    ImageView eBullet7ForBoss;
    float xEBullet1ForBoss=-700, yEBullet1ForBoss=-700, flagEBullet1ForBoss=0;
    float xEBullet2ForBoss=-700, yEBullet2ForBoss=-700, flagEBullet2ForBoss=0;
    float xEBullet3ForBoss=-700, yEBullet3ForBoss=-700, flagEBullet3ForBoss=0;
    float xEBullet4ForBoss=-700, yEBullet4ForBoss=-700, flagEBullet4ForBoss=0;
    float xEBullet5ForBoss=-700, yEBullet5ForBoss=-700, flagEBullet5ForBoss=0;
    float xEBullet6ForBoss=-700, yEBullet6ForBoss=-700, flagEBullet6ForBoss=0;
    float xEBullet7ForBoss=-700, yEBullet7ForBoss=-700, flagEBullet7ForBoss=0;
    

    TextView myScoreTextView;
    int myScore=0;
    int myScoreFinalAtGameOver=0;
    TextView myScoreFinalAtGameOverTextView;
    EditText myNameEditText;
    int myNameIsEnteredOrNo=0;
    int enterMyNameOkButtonClickCounter=0;

    TextView myLifeTextView;
    int myLife=9;
    int preLife=0;

    FrameLayout reminderPageFrameLayout;
    FrameLayout gameOverPage;

    int backButtonClickCounter=0;
    int backButtonInterruptionDetectorWhileGamingAndPauseNeedDetector =0;
    FrameLayout backButtonInterruptionPageWhileGamingFrameLayout;

    int flagForOnPause=0;
    int flagForOnResume=0;

    float xUpTemp=0, yUpTemp=0;
    float xDownTemp=0, yDownTemp=0;
    int matchDownAndUP=0;

    int  levelFinished=0;
    FrameLayout levelFinishedPage;

    int time=0;
    int totalTime=151;
    int tReminderViewHelper=0;
    int flagForReminderView=0;
    TextView enemyLeftTextView;
    TextView timeLeftTextView;







    public PlayActivity() {

        component_move();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_layout);

        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);

       // if( settingsManagerObject.getBackgroundMusic()==1)
        mediaPlayerBackMusic=MediaPlayer.create(this, R.raw.back_music1);
        mediaPlayerBackMusic.setLooping(true);

        touchToStartGamePage=(FrameLayout)findViewById(R.id.touchToStartGamePageId);
        touchToStartGamePage.setVisibility(View.VISIBLE);

        mediaPlayerExplosionEnemy=MediaPlayer.create(this,R.raw.explosion_enemy3);
        mediaPlayerExplosionMyPlayer=MediaPlayer.create(this,R.raw.explosion_player);
        mediaPlayerBulletMyPlayer=MediaPlayer.create(this,R.raw.bullet_player3);
        mediaPlayerBulletMyPlayer.setVolume((float).5, (float).5);
        mediaPlayerBulletEnemy=MediaPlayer.create(this,R.raw.bullet_enemy);

        pLayPauseButton=(Button)findViewById(R.id.playPauseButton);

        backGround1InPlayActivity=(ImageView)findViewById(R.id.backGround1InPlayPageId);
        backGround2InPlayActivity=(ImageView)findViewById(R.id.backGround2InPlayPageId);

        myShipNoFromDatabase=settingsManagerObject.getMyShipNo();
        if(myShipNoFromDatabase==1)myShip=(ImageView)findViewById(R.id.myShip1Id);
        else if(myShipNoFromDatabase==2)myShip=(ImageView)findViewById(R.id.myShip2Id);
        else if(myShipNoFromDatabase==3)myShip=(ImageView)findViewById(R.id.myShip3Id);
        else if(myShipNoFromDatabase==4)myShip=(ImageView)findViewById(R.id.myShip4Id);
        else if(myShipNoFromDatabase==5)myShip=(ImageView)findViewById(R.id.myShip5Id);
        else if(myShipNoFromDatabase==6)myShip=(ImageView)findViewById(R.id.myShip6Id);
        else if(myShipNoFromDatabase==7)myShip=(ImageView)findViewById(R.id.myShip7Id);

        myShip.setVisibility(View.VISIBLE);

        myBullet1=(ImageView)findViewById(R.id.myBullet1Id);
        myBullet2=(ImageView)findViewById(R.id.myBullet2Id);
        myBullet3=(ImageView)findViewById(R.id.myBullet3Id);
        myBullet4=(ImageView)findViewById(R.id.myBullet4Id);
        myBullet5=(ImageView)findViewById(R.id.myBullet5Id);
        myBullet6=(ImageView)findViewById(R.id.myBullet6Id);
        myBullet7=(ImageView)findViewById(R.id.myBullet7Id);
        myBullet8=(ImageView)findViewById(R.id.myBullet8Id);
        myBullet9=(ImageView)findViewById(R.id.myBullet9Id);
        myBullet10=(ImageView)findViewById(R.id.myBullet10Id);
        myBullet11=(ImageView)findViewById(R.id.myBullet11Id);
        myBullet12=(ImageView)findViewById(R.id.myBullet12Id);
        myBullet13=(ImageView)findViewById(R.id.myBullet13Id);
        myBullet14=(ImageView)findViewById(R.id.myBullet14Id);
        myBullet15=(ImageView)findViewById(R.id.myBullet15Id);
        myBullet16=(ImageView)findViewById(R.id.myBullet16Id);
        myBullet17=(ImageView)findViewById(R.id.myBullet17Id);
        //special bullet
        myBullet18=(ImageView)findViewById(R.id.myBullet18Id);
        myBullet19=(ImageView)findViewById(R.id.myBullet19Id);
        myBullet20=(ImageView)findViewById(R.id.myBullet20Id);
        myBullet21=(ImageView)findViewById(R.id.myBullet21Id);
        myBullet22=(ImageView)findViewById(R.id.myBullet22Id);
        myBullet23=(ImageView)findViewById(R.id.myBullet23Id);


        //enemy ship
        enemyShip1=(ImageView)findViewById(R.id.enemyShip1Id);
        enemyShip2=(ImageView)findViewById(R.id.enemyShip2Id);
        enemyShip3=(ImageView)findViewById(R.id.enemyShip3Id);
        enemyShip4=(ImageView)findViewById(R.id.enemyShip4Id);
        enemyShip5=(ImageView)findViewById(R.id.enemyShip5Id);
        enemyShip6=(ImageView)findViewById(R.id.enemyShip6Id);
        enemyShip7=(ImageView)findViewById(R.id.enemyShip7Id);
        enemyShip8=(ImageView)findViewById(R.id.enemyShip8Id);

        //enemyShipBullet
        eBullet1ForEnemyShip1=(ImageView)findViewById(R.id.eBullet1ForEShip1Id);
        eBullet2ForEnemyShip1=(ImageView)findViewById(R.id.eBullet2ForEShip1Id);

        eBullet1ForEnemyShip2=(ImageView)findViewById(R.id.eBullet1ForEShip2Id);
        eBullet2ForEnemyShip2=(ImageView)findViewById(R.id.eBullet2ForEShip2Id);

        eBullet1ForEnemyShip3=(ImageView)findViewById(R.id.eBullet1ForEShip3Id);
        eBullet2ForEnemyShip3=(ImageView)findViewById(R.id.eBullet2ForEShip3Id);

        eBullet1ForEnemyShip4=(ImageView)findViewById(R.id.eBullet1ForEShip4Id);
        eBullet2ForEnemyShip4=(ImageView)findViewById(R.id.eBullet2ForEShip4Id);

        eBullet1ForEnemyShip5=(ImageView)findViewById(R.id.eBullet1ForEShip5Id);
        eBullet2ForEnemyShip5=(ImageView)findViewById(R.id.eBullet2ForEShip5Id);

        eBullet1ForEnemyShip6=(ImageView)findViewById(R.id.eBullet1ForEShip6Id);
        eBullet2ForEnemyShip6=(ImageView)findViewById(R.id.eBullet2ForEShip6Id);

        eBullet1ForEnemyShip7=(ImageView)findViewById(R.id.eBullet1ForEShip7Id);
        eBullet2ForEnemyShip7=(ImageView)findViewById(R.id.eBullet2ForEShip7Id);

        eBullet1ForEnemyShip8=(ImageView)findViewById(R.id.eBullet1ForEShip8Id);
        eBullet2ForEnemyShip8=(ImageView)findViewById(R.id.eBullet2ForEShip8Id);


        //enemy boss ship and bullets
        enemyBossShip=(ImageView)findViewById(R.id.enemyBossShipId);
        eBullet1ForBoss=(ImageView)findViewById(R.id.enemyBossBullet1Id);
        eBullet2ForBoss=(ImageView)findViewById(R.id.enemyBossBullet2Id);
        eBullet3ForBoss=(ImageView)findViewById(R.id.enemyBossBullet3Id);
        eBullet4ForBoss=(ImageView)findViewById(R.id.enemyBossBullet4Id);
        eBullet5ForBoss=(ImageView)findViewById(R.id.enemyBossBullet5Id);
        eBullet6ForBoss=(ImageView)findViewById(R.id.enemyBossBullet6Id);
        eBullet7ForBoss=(ImageView)findViewById(R.id.enemyBossBullet7Id);



        myScoreTextView=(TextView)findViewById(R.id.myScoreId);
        myLifeTextView=(TextView)findViewById(R.id.myLifeId);

        enemyBossLifeLinearLayout=(LinearLayout)findViewById(R.id.enemyBossLifeLinearLayout);
        enemyBossLifeLinearLayout.setVisibility(View.INVISIBLE);
        enemyBossLifeTextView=(TextView)findViewById(R.id.enemyBossLifeId);

        reminderPageFrameLayout=(FrameLayout)findViewById(R.id.reminderId);
        reminderPageFrameLayout.setVisibility(View.INVISIBLE);

        gameOverPage=(FrameLayout)findViewById(R.id.gameOverPageId);
        gameOverPage.setVisibility(View.INVISIBLE);

        myScoreFinalAtGameOverTextView=(TextView)findViewById(R.id.myScoreAtGcameOverId);
        myNameEditText=(EditText)findViewById(R.id.myNameId);

        backButtonInterruptionPageWhileGamingFrameLayout=(FrameLayout)findViewById(R.id.backButtonPressPageWhileGamingId);
        backButtonInterruptionPageWhileGamingFrameLayout.setVisibility(View.INVISIBLE);

        levelFinishedPage=(FrameLayout)findViewById(R.id.levelCompletedPageId);
        levelFinishedPage.setVisibility(View.INVISIBLE);



        //   myShip2=(ImageView)findViewById(R.id.myShip2Id);
      //  myShip3=(ImageView)findViewById(R.id.myShip3Id);
       // myShip4=(ImageView)findViewById(R.id.myShip4Id);

        enemyLeftTextView=(TextView)findViewById(R.id.enemyLeftTextViewId);
        timeLeftTextView=(TextView)findViewById(R.id.timeLeftTextViewId);





        //component_move();


    }


    @Override
 /*   public void onWindowFocusChanged(boolean hasFocus){

        screenHeight =backGround1InPlayActivity.getHeight();
        yBg2=-screenHeight;



    }*/

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        screenHeight =backGround1InPlayActivity.getHeight();
        screenWidth=backGround1InPlayActivity.getWidth();

        yBg2=-screenHeight;
        yBg1=0;

        if(flagForOnPause==0) {
            tempYBg1 = yBg1;
            tempYBg2 = yBg2;

            xMyShip=screenWidth/2;
            yMyShip=screenHeight-myShip.getHeight();

            xUpTemp=xMyShip;
            yUpTemp=yMyShip;
        }

        else if(flagForOnPause==1){
            yBg1=tempYBg1;
            yBg2=tempYBg2;

            xMyShip=xMyShipTemp;
            yMyShip=yMyShipTemp;

            xUpTemp=xMyShip;
            yUpTemp=yMyShip;

        }

        myShip.setX(xMyShip);  myShip.setY(yMyShip);




     /*   Toast.makeText(getApplicationContext(), "focas changed", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "enemyXPosition"+enemyShip1.getWidth(), Toast.LENGTH_LONG).show();

        if(!hasFocus) {
            Toast.makeText(getApplicationContext(), "lost focus", Toast.LENGTH_LONG).show();

       //     Intent closeDialog = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
         //   sendBroadcast(closeDialog);
        }*/
    }


    public void component_move()
    {
       // move=1;

        final SettingsManager settingsManagerObject=dataBaseHandlerForSettingsManager.getAllSettingsData(1);

        final Handler bgMoveHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(5);
                        bgMoveHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                // Write your code here to update the UI.
                          /*      if(yBg1==screenHeight){
                                    yBg1=0;
                                    yBg2=-screenHeight;
                                }
                                if(yBg1<screenHeight){
                                    yBg1++;
                                    yBg2++;
                                }*/

                                if(yBg1== screenHeight)yBg1=-screenHeight;
                                if(yBg1< screenHeight)yBg1++;

                                if(yBg2== screenHeight)yBg2=-screenHeight;
                                if(yBg2< screenHeight)yBg2++;

                            //    System.out.println("Count="+ screenHeight);
                              //  System.out.println("Bg1="+yBg1+ "Bg2="+yBg2);

                                backGround1InPlayActivity.setY(yBg1);
                                backGround2InPlayActivity.setY(yBg2);





                            }
                        });
                    } catch (Exception e) {
                        System.out.println("bgMoveHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "bgMoveHandler ", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }).start();


        final Handler myBulletMoveAndEnemyBulletMoveHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub

                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0){
                    try
                    {
                        Thread.sleep(3);
                        myBulletMoveAndEnemyBulletMoveHandler.post(new Runnable() {

                            @Override
                            public void run() {


                                //My Bullet Move
                                if(flagMyBullet1==1)yMyBullet1--;
                                if(yMyBullet1<=0){ flagMyBullet1=0;  myBullet1.setX(-200);  myBullet1.setY(-200);  myBullet1.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet2==1)yMyBullet2--;
                                if(yMyBullet2<=0){ flagMyBullet2=0;  myBullet2.setX(-200);  myBullet2.setY(-200);  myBullet2.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet3==1)yMyBullet3--;
                                if(yMyBullet3<=0){ flagMyBullet3=0;  myBullet3.setX(-200);  myBullet3.setY(-200);  myBullet3.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet4==1)yMyBullet4--;
                                if(yMyBullet4<=0){ flagMyBullet4=0;  myBullet4.setX(-200);  myBullet4.setY(-200);  myBullet4.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet5==1)yMyBullet5--;
                                if(yMyBullet5<=0){ flagMyBullet5=0;  myBullet5.setX(-200);  myBullet5.setY(-200);  myBullet5.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet6==1)yMyBullet6--;
                                if(yMyBullet6<=0){ flagMyBullet6=0;  myBullet6.setX(-200);  myBullet6.setY(-200);  myBullet6.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet7==1)yMyBullet7--;
                                if(yMyBullet7<=0){ flagMyBullet7=0;  myBullet7.setX(-200);  myBullet7.setY(-200);  myBullet7.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet8==1)yMyBullet8--;
                                if(yMyBullet8<=0){ flagMyBullet8=0;  myBullet8.setX(-200);  myBullet8.setY(-200);  myBullet8.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet9==1)yMyBullet9--;
                                if(yMyBullet9<=0){ flagMyBullet9=0;  myBullet9.setX(-200);  myBullet9.setY(-200);  myBullet9.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet10==1)yMyBullet10--;
                                if(yMyBullet10<=0){ flagMyBullet10=0;  myBullet10.setX(-200);  myBullet10.setY(-200);  myBullet10.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet11==1)yMyBullet11--;
                                if(yMyBullet11<=0){ flagMyBullet11=0;  myBullet11.setX(-200);  myBullet11.setY(-200);  myBullet11.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet12==1)yMyBullet12--;
                                if(yMyBullet12<=0){ flagMyBullet12=0;  myBullet12.setX(-200);  myBullet12.setY(-200);  myBullet12.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet13==1)yMyBullet13--;
                                if(yMyBullet13<=0){ flagMyBullet13=0;  myBullet13.setX(-200);  myBullet13.setY(-200);  myBullet13.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet14==1)yMyBullet14--;
                                if(yMyBullet14<=0){ flagMyBullet14=0;  myBullet14.setX(-200);  myBullet14.setY(-200);  myBullet14.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet15==1)yMyBullet15--;
                                if(yMyBullet15<=0){ flagMyBullet15=0;  myBullet15.setX(-200);  myBullet15.setY(-200);  myBullet15.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet16==1)yMyBullet16--;
                                if(yMyBullet16<=0){ flagMyBullet16=0;  myBullet16.setX(-200);  myBullet16.setY(-200);  myBullet16.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet17==1)yMyBullet17--;
                                if(yMyBullet17<=0){ flagMyBullet17=0;  myBullet17.setX(-200);  myBullet17.setY(-200);  myBullet17.setVisibility(View.INVISIBLE); }


                                myBullet1.setX(xMyBullet1);   myBullet1.setY(yMyBullet1);

                                myBullet2.setX(xMyBullet2);   myBullet2.setY(yMyBullet2);

                                myBullet3.setX(xMyBullet3);   myBullet3.setY(yMyBullet3);

                                myBullet4.setX(xMyBullet4);   myBullet4.setY(yMyBullet4);

                                myBullet5.setX(xMyBullet5);   myBullet5.setY(yMyBullet5);

                                myBullet6.setX(xMyBullet6);   myBullet6.setY(yMyBullet6);

                                myBullet7.setX(xMyBullet7);   myBullet7.setY(yMyBullet7);

                                myBullet8.setX(xMyBullet8);   myBullet8.setY(yMyBullet8);

                                myBullet9.setX(xMyBullet9);   myBullet9.setY(yMyBullet9);

                                myBullet10.setX(xMyBullet10); myBullet10.setY(yMyBullet10);

                                myBullet11.setX(xMyBullet11); myBullet11.setY(yMyBullet11);

                                myBullet12.setX(xMyBullet12); myBullet12.setY(yMyBullet12);

                                myBullet13.setX(xMyBullet13); myBullet13.setY(yMyBullet13);

                                myBullet14.setX(xMyBullet14); myBullet14.setY(yMyBullet14);

                                myBullet15.setX(xMyBullet15); myBullet15.setY(yMyBullet15);

                                myBullet16.setX(xMyBullet16); myBullet16.setY(yMyBullet16);

                                myBullet17.setX(xMyBullet17); myBullet17.setY(yMyBullet17);



                                //  myBulletVisibility();


                                //Enemy Bullet Move

                                    if (flagEBullet1ForEnemyShip1 == 1) yEBullet1ForEnemyShip1++;
                                    if (yEBullet1ForEnemyShip1 > screenHeight)
                                        flagEBullet1ForEnemyShip1 = 0;

                                    if (flagEBullet2ForEnemyShip1 == 1) yEBullet2ForEnemyShip1++;
                                    if (yEBullet2ForEnemyShip1 > screenHeight)
                                        flagEBullet2ForEnemyShip1 = 0;


                                    if (flagEBullet1ForEnemyShip2 == 1) yEBullet1ForEnemyShip2++;
                                    if (yEBullet1ForEnemyShip2 > screenHeight)
                                        flagEBullet1ForEnemyShip2 = 0;

                                    if (flagEBullet2ForEnemyShip2 == 1) yEBullet2ForEnemyShip2++;
                                    if (yEBullet2ForEnemyShip2 > screenHeight)
                                        flagEBullet2ForEnemyShip2 = 0;


                                    if (flagEBullet1ForEnemyShip3 == 1) yEBullet1ForEnemyShip3++;
                                    if (yEBullet1ForEnemyShip3 > screenHeight)
                                        flagEBullet1ForEnemyShip3 = 0;

                                    if (flagEBullet2ForEnemyShip3 == 1) yEBullet2ForEnemyShip3++;
                                    if (yEBullet2ForEnemyShip3 > screenHeight)
                                        flagEBullet2ForEnemyShip3 = 0;


                                    if (flagEBullet1ForEnemyShip4 == 1) yEBullet1ForEnemyShip4++;
                                    if (yEBullet1ForEnemyShip4 > screenHeight)
                                        flagEBullet1ForEnemyShip4 = 0;

                                    if (flagEBullet2ForEnemyShip4 == 1) yEBullet2ForEnemyShip4++;
                                    if (yEBullet2ForEnemyShip4 > screenHeight)
                                        flagEBullet2ForEnemyShip4 = 0;


                                    if (flagEBullet1ForEnemyShip5 == 1) yEBullet1ForEnemyShip5++;
                                    if (yEBullet1ForEnemyShip5 > screenHeight)
                                        flagEBullet1ForEnemyShip5 = 0;

                                    if (flagEBullet2ForEnemyShip5 == 1) yEBullet2ForEnemyShip5++;
                                    if (yEBullet2ForEnemyShip5 > screenHeight)
                                        flagEBullet2ForEnemyShip5 = 0;


                                    if (flagEBullet1ForEnemyShip6 == 1) yEBullet1ForEnemyShip6++;
                                    if (yEBullet1ForEnemyShip6 > screenHeight)
                                        flagEBullet1ForEnemyShip6 = 0;

                                    if (flagEBullet2ForEnemyShip6 == 1) yEBullet2ForEnemyShip6++;
                                    if (yEBullet2ForEnemyShip6 > screenHeight)
                                        flagEBullet2ForEnemyShip6 = 0;


                                    if (flagEBullet1ForEnemyShip7 == 1) yEBullet1ForEnemyShip7++;
                                    if (yEBullet1ForEnemyShip7 > screenHeight)
                                        flagEBullet1ForEnemyShip7 = 0;

                                    if (flagEBullet2ForEnemyShip7 == 1) yEBullet2ForEnemyShip7++;
                                    if (yEBullet2ForEnemyShip7 > screenHeight)
                                        flagEBullet2ForEnemyShip7 = 0;


                                    if (flagEBullet1ForEnemyShip8 == 1) yEBullet1ForEnemyShip8++;
                                    if (yEBullet1ForEnemyShip8 > screenHeight)
                                        flagEBullet1ForEnemyShip8 = 0;

                                    if (flagEBullet2ForEnemyShip8 == 1) yEBullet2ForEnemyShip8++;
                                    if (yEBullet2ForEnemyShip8 > screenHeight)
                                        flagEBullet2ForEnemyShip8 = 0;


                                    eBullet1ForEnemyShip1.setX(xEBullet1ForEnemyShip1);
                                    eBullet1ForEnemyShip1.setY(yEBullet1ForEnemyShip1);
                                    eBullet2ForEnemyShip1.setX(xEBullet2ForEnemyShip1);
                                    eBullet2ForEnemyShip1.setY(yEBullet2ForEnemyShip1);

                                    eBullet1ForEnemyShip2.setX(xEBullet1ForEnemyShip2);
                                    eBullet1ForEnemyShip2.setY(yEBullet1ForEnemyShip2);
                                    eBullet2ForEnemyShip2.setX(xEBullet2ForEnemyShip2);
                                    eBullet2ForEnemyShip2.setY(yEBullet2ForEnemyShip2);

                                    eBullet1ForEnemyShip3.setX(xEBullet1ForEnemyShip3);
                                    eBullet1ForEnemyShip3.setY(yEBullet1ForEnemyShip3);
                                    eBullet2ForEnemyShip3.setX(xEBullet2ForEnemyShip3);
                                    eBullet2ForEnemyShip3.setY(yEBullet2ForEnemyShip3);

                                    eBullet1ForEnemyShip4.setX(xEBullet1ForEnemyShip4);
                                    eBullet1ForEnemyShip4.setY(yEBullet1ForEnemyShip4);
                                    eBullet2ForEnemyShip4.setX(xEBullet2ForEnemyShip4);
                                    eBullet2ForEnemyShip4.setY(yEBullet2ForEnemyShip4);

                                    eBullet1ForEnemyShip5.setX(xEBullet1ForEnemyShip5);
                                    eBullet1ForEnemyShip5.setY(yEBullet1ForEnemyShip5);
                                    eBullet2ForEnemyShip5.setX(xEBullet2ForEnemyShip5);
                                    eBullet2ForEnemyShip5.setY(yEBullet2ForEnemyShip5);

                                    eBullet1ForEnemyShip6.setX(xEBullet1ForEnemyShip6);
                                    eBullet1ForEnemyShip6.setY(yEBullet1ForEnemyShip6);
                                    eBullet2ForEnemyShip6.setX(xEBullet2ForEnemyShip6);
                                    eBullet2ForEnemyShip6.setY(yEBullet2ForEnemyShip6);

                                    eBullet1ForEnemyShip7.setX(xEBullet1ForEnemyShip7);
                                    eBullet1ForEnemyShip7.setY(yEBullet1ForEnemyShip7);
                                    eBullet2ForEnemyShip7.setX(xEBullet2ForEnemyShip7);
                                    eBullet2ForEnemyShip7.setY(yEBullet2ForEnemyShip7);

                                    eBullet1ForEnemyShip8.setX(xEBullet1ForEnemyShip8);
                                    eBullet1ForEnemyShip8.setY(yEBullet1ForEnemyShip8);
                                    eBullet2ForEnemyShip8.setX(xEBullet2ForEnemyShip8);
                                    eBullet2ForEnemyShip8.setY(yEBullet2ForEnemyShip8);





                            }
                        });
                    } catch (Exception e) {
                        System.out.println("myBulletMoveHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "myBulletMoveHandler ", Toast.LENGTH_LONG).show();


                    }
                }
            }
        }).start();


        final Handler myBulletSelectionHandler= new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0) {
                    try
                    {
                        Thread.sleep(350);
                        myBulletSelectionHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                if(touchDownOrUp==1)myBulletSelection();
                            //    System.out.println("my BulletSelectionHandler my 1: ");

                            }
                        });

                    } catch (Exception e) {
                        System.out.println("myBulletSelectionHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "myBulletSelectionHandler", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }).start();


        final Handler enemyShipMoveVerticalHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(20);
                        enemyShipMoveVerticalHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                if(flagEnemyShip1==1)yEnemyShip1++;
                                if(yEnemyShip1>=screenHeight){ enemyShip1.setVisibility(View.INVISIBLE);  flagEnemyShip1=0;  flagEnemyShip1ForHorizontalMove=0; }

                                if(flagEnemyShip2==1)yEnemyShip2++;
                                if(yEnemyShip2>=screenHeight){ enemyShip2.setVisibility(View.INVISIBLE);  flagEnemyShip2=0;  flagEnemyShip2ForHorizontalMove=0; }

                                if(flagEnemyShip3==1)yEnemyShip3++;
                                if(yEnemyShip3>=screenHeight){ enemyShip3.setVisibility(View.INVISIBLE);  flagEnemyShip3=0;  flagEnemyShip3ForHorizontalMove=0; }

                                if(flagEnemyShip4==1)yEnemyShip4++;
                                if(yEnemyShip4>=screenHeight){ enemyShip4.setVisibility(View.INVISIBLE);  flagEnemyShip4=0; flagEnemyShip4ForHorizontalMove=0; }

                                if(flagEnemyShip5==1)yEnemyShip5++;
                                if(yEnemyShip5>=screenHeight){ enemyShip5.setVisibility(View.INVISIBLE);  flagEnemyShip5=0;  flagEnemyShip5ForHorizontalMove=0; }

                                if(flagEnemyShip6==1)yEnemyShip6++;
                                if(yEnemyShip6>=screenHeight){ enemyShip6.setVisibility(View.INVISIBLE);  flagEnemyShip6=0;  flagEnemyShip6ForHorizontalMove=0; }

                                if(flagEnemyShip7==1)yEnemyShip7++;
                                if(yEnemyShip7>=screenHeight){ enemyShip7.setVisibility(View.INVISIBLE);  flagEnemyShip7=0;  flagEnemyShip7ForHorizontalMove=0; }

                                if(flagEnemyShip8==1)yEnemyShip8++;
                                if(yEnemyShip8>=screenHeight){ enemyShip8.setVisibility(View.INVISIBLE);  flagEnemyShip8=0;  flagEnemyShip8ForHorizontalMove=0; }


                                enemyShip1.setX(xEnemyShip1);  enemyShip1.setY(yEnemyShip1);

                                enemyShip2.setX(xEnemyShip2);  enemyShip2.setY(yEnemyShip2);

                                enemyShip3.setX(xEnemyShip3);  enemyShip3.setY(yEnemyShip3);

                                enemyShip4.setX(xEnemyShip4);  enemyShip4.setY(yEnemyShip4);

                                enemyShip5.setX(xEnemyShip5);  enemyShip5.setY(yEnemyShip5);

                                enemyShip6.setX(xEnemyShip6);  enemyShip6.setY(yEnemyShip6);

                                enemyShip7.setX(xEnemyShip7);  enemyShip7.setY(yEnemyShip7);

                                enemyShip8.setX(xEnemyShip8);  enemyShip8.setY(yEnemyShip8);











                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyShipMoveVerticalHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyShipMoveVerticalHandler", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }).start();


       final Handler enemyShipSelectionForVerticalMoveHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(1000);
                        enemyShipSelectionForVerticalMoveHandler.post(new Runnable() {

                            @Override
                            public void run() {


                                //enemyShipSelectionForVerticalMove
                                if(flagEnemyShip1==0){ xEnemyShip1=enemyXPosition(1);  yEnemyShip1=-80;  flagEnemyShip1=1;
                                                       enemyShip1.setVisibility(View.VISIBLE); }

                                else if(flagEnemyShip2==0){ xEnemyShip2=enemyXPosition(2);  yEnemyShip2=-80;  flagEnemyShip2=1;
                                                            enemyShip2.setVisibility(View.VISIBLE); }

                                else if(flagEnemyShip3==0){ xEnemyShip3=enemyXPosition(3);  yEnemyShip3=-80;  flagEnemyShip3=1;
                                                            enemyShip3.setVisibility(View.VISIBLE); }

                                else if(flagEnemyShip4==0){ xEnemyShip4=enemyXPosition(4);  yEnemyShip4=-80;  flagEnemyShip4=1;
                                                            enemyShip4.setVisibility(View.VISIBLE); }

                                else if(myScore>300 && flagEnemyShip5==0){ xEnemyShip5=enemyXPosition(5);  yEnemyShip5=-80;  flagEnemyShip5=1;
                                                            enemyShip5.setVisibility(View.VISIBLE); }

                                else if(myScore>410 && flagEnemyShip6==0){ xEnemyShip6=enemyXPosition(6);  yEnemyShip6=-80;  flagEnemyShip6=1;
                                                            enemyShip6.setVisibility(View.VISIBLE); }

                                else if(myScore>550 && flagEnemyShip7==0){ xEnemyShip7=enemyXPosition(7);  yEnemyShip7=-80;  flagEnemyShip7=1;
                                                            enemyShip7.setVisibility(View.VISIBLE); }

                                else if(myScore>690 && flagEnemyShip8==0){ xEnemyShip8=enemyXPosition(8);  yEnemyShip8=-80;  flagEnemyShip8=1;
                                                            enemyShip8.setVisibility(View.VISIBLE); }


                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyShipSelectionForVerticalMoveHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyShipSelectionForVerticalMoveHandler", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }).start();



        final Handler enemyShipMoveHorizontalHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(15);
                        enemyShipMoveHorizontalHandler.post(new Runnable() {

                            @Override
                            public void run() {


                                    if (flagEnemyShip1 == 1 && flagEnemyShip1ForHorizontalMove == 1 && flagEnemyShip1ForLeftRightMove == 1) {
                                        if (xEnemyShip1 < screenWidth - enemyShip1.getWidth())
                                            xEnemyShip1++;
                                        else xEnemyShip1--;
                                    } else if (flagEnemyShip1 == 1 && flagEnemyShip1ForHorizontalMove == 1 && flagEnemyShip1ForLeftRightMove == 0 && xEnemyShip1 > -10)
                                        xEnemyShip1--;
                                    else if (flagEnemyShip1 == 1 && xEnemyShip1 > screenWidth - enemyShip1.getWidth()) {
                                        xEnemyShip1--;
                                        flagEnemyShip1ForHorizontalMove = 1;
                                    }


                                    if (flagEnemyShip2 == 1 && flagEnemyShip2ForHorizontalMove == 1 && flagEnemyShip2ForLeftRightMove == 1) {
                                        if (xEnemyShip2 < screenWidth - enemyShip2.getWidth())
                                            xEnemyShip2++;
                                        else xEnemyShip2--;
                                    } else if (flagEnemyShip2 == 1 && flagEnemyShip2ForHorizontalMove == 1 && flagEnemyShip2ForLeftRightMove == 0 && xEnemyShip2 > -10)
                                        xEnemyShip2--;
                                    else if (flagEnemyShip2 == 1 && xEnemyShip2 > screenWidth - enemyShip2.getWidth() - 20) {
                                        xEnemyShip2--;
                                        flagEnemyShip2ForHorizontalMove = 1;
                                    }


                                    if (flagEnemyShip3 == 1 && xEnemyShip3 < screenWidth - enemyShip3.getWidth() && yEnemyShip3 > 15) {
                                        if (xEnemyShip3 < myShip.getX()) xEnemyShip3++;
                                        else xEnemyShip3--;
                                    } else if (flagEnemyShip3 == 1 && xEnemyShip3 > -10)
                                        xEnemyShip3--;


                                    if (flagEnemyShip4 == 1 && flagEnemyShip4ForHorizontalMove == 1 && flagEnemyShip4ForLeftRightMove == 1) {
                                        if (xEnemyShip4 < screenWidth - enemyShip4.getWidth())
                                            xEnemyShip4++;
                                        else xEnemyShip4--;
                                    } else if (flagEnemyShip4 == 1 && flagEnemyShip4ForHorizontalMove == 1 && flagEnemyShip4ForLeftRightMove == 0 && xEnemyShip4 > -10)
                                        xEnemyShip4--;
                                    else if (flagEnemyShip4 == 1 && xEnemyShip4 > screenWidth - enemyShip4.getWidth() - 35) {
                                        xEnemyShip4--;
                                        flagEnemyShip4ForHorizontalMove = 1;
                                    }


                                    if (flagEnemyShip5 == 1 && flagEnemyShip5ForHorizontalMove == 1 && flagEnemyShip5ForLeftRightMove == 1) {
                                        if (xEnemyShip5 < screenWidth - enemyShip5.getWidth())
                                            xEnemyShip5++;
                                        else xEnemyShip5--;
                                    } else if (flagEnemyShip5 == 1 && flagEnemyShip5ForHorizontalMove == 1 && flagEnemyShip5ForLeftRightMove == 0 && xEnemyShip5 > -10)
                                        xEnemyShip5--;
                                    else if (flagEnemyShip5 == 1 && xEnemyShip5 > screenWidth - enemyShip5.getWidth() - 10) {
                                        xEnemyShip5--;
                                        flagEnemyShip5ForHorizontalMove = 1;
                                    }


                                    if (flagEnemyShip6 == 1 && flagEnemyShip6ForHorizontalMove == 1 && flagEnemyShip6ForLeftRightMove == 1) {
                                        if (xEnemyShip6 < screenWidth - enemyShip6.getWidth())
                                            xEnemyShip6++;
                                        else xEnemyShip6--;
                                    } else if (flagEnemyShip6 == 1 && flagEnemyShip6ForHorizontalMove == 1 && flagEnemyShip6ForLeftRightMove == 0 && xEnemyShip6 > -10)
                                        xEnemyShip6--;
                                    else if (flagEnemyShip6 == 1 && xEnemyShip6 > screenWidth - enemyShip6.getWidth() - 5) {
                                        xEnemyShip6--;
                                        flagEnemyShip6ForHorizontalMove = 1;
                                    }


                                    if (flagEnemyShip7 == 1 && flagEnemyShip7ForHorizontalMove == 1 && xEnemyShip7 < screenWidth - enemyShip7.getWidth() && yEnemyShip7 > 15) {
                                        if (xEnemyShip7 < myShip.getX()) xEnemyShip7++;
                                        else xEnemyShip7--;
                                    } else if (flagEnemyShip7 == 1 && xEnemyShip7 > screenWidth - enemyShip7.getWidth() - 25)
                                        xEnemyShip7--;


                                    if (flagEnemyShip8 == 1 && flagEnemyShip8ForHorizontalMove == 1 && flagEnemyShip8ForLeftRightMove == 1) {
                                        if (xEnemyShip8 < screenWidth - enemyShip8.getWidth())
                                            xEnemyShip8++;
                                        else xEnemyShip8--;
                                    } else if (flagEnemyShip8 == 1 && flagEnemyShip8ForHorizontalMove == 1 && flagEnemyShip8ForLeftRightMove == 0 && xEnemyShip8 > -10)
                                        xEnemyShip8--;
                                    else if (flagEnemyShip8 == 1 && xEnemyShip8 > screenWidth - enemyShip8.getWidth() - 15) {
                                        xEnemyShip8--;
                                        flagEnemyShip8ForHorizontalMove = 1;
                                    }






                              //  enemyShipVisibility();

                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyShipMoveHorizontalHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyShipMoveHorizontalHandler ", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }).start();

        final Handler enemyShipLeftOrRightMoveSelectionAndEnemyBulletSelectionHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(1000);
                        enemyShipLeftOrRightMoveSelectionAndEnemyBulletSelectionHandler.post(new Runnable() {

                            @Override
                            public void run() {



                                    if (flagEnemyShip1 == 1 && flagEnemyShip1ForHorizontalMove == 1)
                                        flagEnemyShip1ForLeftRightMove = randomEnemyShipLeftRightMoveSelector();
                                    if (flagEnemyShip2 == 1 && flagEnemyShip2ForHorizontalMove == 1)
                                        flagEnemyShip2ForLeftRightMove = randomEnemyShipLeftRightMoveSelector();
                                    if (flagEnemyShip3 == 1 && flagEnemyShip3ForHorizontalMove == 1)
                                        flagEnemyShip3ForLeftRightMove = randomEnemyShipLeftRightMoveSelector();
                                    if (flagEnemyShip4 == 1 && flagEnemyShip4ForHorizontalMove == 1)
                                        flagEnemyShip4ForLeftRightMove = randomEnemyShipLeftRightMoveSelector();
                                    if (flagEnemyShip5 == 1 && flagEnemyShip5ForHorizontalMove == 1)
                                        flagEnemyShip5ForLeftRightMove = randomEnemyShipLeftRightMoveSelector();
                                    if (flagEnemyShip6 == 1 && flagEnemyShip6ForHorizontalMove == 1)
                                        flagEnemyShip6ForLeftRightMove = randomEnemyShipLeftRightMoveSelector();
                                    if (flagEnemyShip7 == 1 && flagEnemyShip7ForHorizontalMove == 1)
                                        flagEnemyShip7ForLeftRightMove = randomEnemyShipLeftRightMoveSelector();
                                    if (flagEnemyShip8 == 1 && flagEnemyShip8ForHorizontalMove == 1)
                                        flagEnemyShip8ForLeftRightMove = randomEnemyShipLeftRightMoveSelector();


                                    //Enemy Bullet Selection
                                    if (flagEnemyShip1 == 1 && flagEBullet1ForEnemyShip1 == 0) {
                                        xEBullet1ForEnemyShip1 = xEnemyShip1 + enemyShip1.getWidth() / 2 - 7;
                                        yEBullet1ForEnemyShip1 = yEnemyShip1 + enemyShip1.getHeight();
                                        flagEBullet1ForEnemyShip1 = 1;
                                    } else if (myScore > 200 && flagEnemyShip1 == 1 && flagEBullet2ForEnemyShip1 == 0) {
                                        xEBullet2ForEnemyShip1 = xEnemyShip1 + enemyShip1.getWidth() / 2 - 7;
                                        yEBullet2ForEnemyShip1 = yEnemyShip1 + enemyShip1.getHeight();
                                        flagEBullet2ForEnemyShip1 = 1;
                                    }

                                    if (flagEnemyShip2 == 1 && flagEBullet1ForEnemyShip2 == 0) {
                                        xEBullet1ForEnemyShip2 = xEnemyShip2 + enemyShip2.getWidth() / 2 - 7;
                                        yEBullet1ForEnemyShip2 = yEnemyShip2 + enemyShip2.getHeight();
                                        flagEBullet1ForEnemyShip2 = 1;
                                    } else if (myScore > 290 && flagEnemyShip2 == 1 && flagEBullet2ForEnemyShip2 == 0) {
                                        xEBullet2ForEnemyShip2 = xEnemyShip2 + enemyShip2.getWidth() / 2 - 7;
                                        yEBullet2ForEnemyShip2 = yEnemyShip2 + enemyShip2.getHeight();
                                        flagEBullet2ForEnemyShip2 = 1;
                                    }

                                    if (flagEnemyShip3 == 1 && flagEBullet1ForEnemyShip3 == 0) {
                                        xEBullet1ForEnemyShip3 = xEnemyShip3 + enemyShip3.getWidth() / 2 - 7;
                                        yEBullet1ForEnemyShip3 = yEnemyShip3 + enemyShip3.getHeight();
                                        flagEBullet1ForEnemyShip3 = 1;
                                    } else if (myScore > 380 && flagEnemyShip3 == 1 && flagEBullet2ForEnemyShip3 == 0) {
                                        xEBullet2ForEnemyShip3 = xEnemyShip3 + enemyShip3.getWidth() / 2 - 7;
                                        yEBullet2ForEnemyShip3 = yEnemyShip3 + enemyShip3.getHeight();
                                        flagEBullet2ForEnemyShip3 = 1;
                                    }

                                    if (flagEnemyShip4 == 1 && flagEBullet1ForEnemyShip4 == 0) {
                                        xEBullet1ForEnemyShip4 = xEnemyShip4 + enemyShip4.getWidth() / 2 - 7;
                                        yEBullet1ForEnemyShip4 = yEnemyShip4 + enemyShip4.getHeight();
                                        flagEBullet1ForEnemyShip4 = 1;
                                    } else if (myScore > 570 && flagEnemyShip4 == 1 && flagEBullet2ForEnemyShip4 == 0) {
                                        xEBullet2ForEnemyShip4 = xEnemyShip4 + enemyShip4.getWidth() / 2 - 7;
                                        yEBullet2ForEnemyShip4 = yEnemyShip4 + enemyShip4.getHeight();
                                        flagEBullet2ForEnemyShip4 = 1;
                                    }

                                    if (flagEnemyShip5 == 1 && flagEBullet1ForEnemyShip5 == 0) {
                                        xEBullet1ForEnemyShip5 = xEnemyShip5 + enemyShip5.getWidth() / 2 - 7;
                                        yEBullet1ForEnemyShip5 = yEnemyShip5 + enemyShip5.getHeight();
                                        flagEBullet1ForEnemyShip5 = 1;
                                    } else if (myScore > 690 && flagEnemyShip5 == 1 && flagEBullet2ForEnemyShip5 == 0) {
                                        xEBullet2ForEnemyShip5 = xEnemyShip5 + enemyShip5.getWidth() / 2 - 7;
                                        yEBullet2ForEnemyShip5 = yEnemyShip5 + enemyShip5.getHeight();
                                        flagEBullet2ForEnemyShip5 = 1;
                                    }

                                    if (flagEnemyShip6 == 1 && flagEBullet1ForEnemyShip6 == 0) {
                                        xEBullet1ForEnemyShip6 = xEnemyShip6 + enemyShip6.getWidth() / 2 - 7;
                                        yEBullet1ForEnemyShip6 = yEnemyShip6 + enemyShip6.getHeight();
                                        flagEBullet1ForEnemyShip6 = 1;
                                    } else if (myScore > 780 && flagEnemyShip6 == 1 && flagEBullet2ForEnemyShip6 == 0) {
                                        xEBullet2ForEnemyShip6 = xEnemyShip6 + enemyShip6.getWidth() / 2 - 7;
                                        yEBullet2ForEnemyShip6 = yEnemyShip6 + enemyShip6.getHeight();
                                        flagEBullet2ForEnemyShip6 = 1;
                                    }

                                    if (flagEnemyShip7 == 1 && flagEBullet1ForEnemyShip7 == 0) {
                                        xEBullet1ForEnemyShip7 = xEnemyShip7 + enemyShip7.getWidth() / 2 - 7;
                                        yEBullet1ForEnemyShip7 = yEnemyShip7 + enemyShip7.getHeight();
                                        flagEBullet1ForEnemyShip7 = 1;
                                    } else if (myScore > 1010 && flagEnemyShip7 == 1 && flagEBullet2ForEnemyShip7 == 0) {
                                        xEBullet2ForEnemyShip7 = xEnemyShip7 + enemyShip7.getWidth() / 2 - 7;
                                        yEBullet2ForEnemyShip7 = yEnemyShip7 + enemyShip7.getHeight();
                                        flagEBullet2ForEnemyShip7 = 1;
                                    }

                                    if (flagEnemyShip8 == 1 && flagEBullet1ForEnemyShip8 == 0) {
                                        xEBullet1ForEnemyShip8 = xEnemyShip8 + enemyShip8.getWidth() / 2 - 7;
                                        yEBullet1ForEnemyShip8 = yEnemyShip8 + enemyShip8.getHeight();
                                        flagEBullet1ForEnemyShip8 = 1;
                                    } else if (myScore > 1150 && flagEnemyShip8 == 1 && flagEBullet2ForEnemyShip8 == 0) {
                                        xEBullet2ForEnemyShip8 = xEnemyShip8 + enemyShip8.getWidth() / 2 - 7;
                                        yEBullet2ForEnemyShip8 = yEnemyShip8 + enemyShip8.getHeight();
                                        flagEBullet2ForEnemyShip8 = 1;
                                    }


                                enemyBulletVisibility();

                                }

                        });
                    } catch (Exception e) {
                        System.out.println("enemyShipLeftOrRightMoveSelectionHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyShipLeftOrRightMoveSelectionHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();

        final Handler enemyShipSelectionForHorizontalHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(4000);
                        enemyShipSelectionForHorizontalHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                int enemyShipNumber=randomEnemyShipSelectionForHorizontalMove();

                                if(enemyShipNumber==1 && flagEnemyShip1==1 && flagEnemyShip1ForHorizontalMove==0){ flagEnemyShip1ForHorizontalMove=1; }

                                else if(enemyShipNumber==2 && flagEnemyShip2==1 && flagEnemyShip2ForHorizontalMove==0){ flagEnemyShip2ForHorizontalMove=1; }

                                else if(enemyShipNumber==3 && flagEnemyShip3==1 && flagEnemyShip3ForHorizontalMove==0){ flagEnemyShip3ForHorizontalMove=1; }

                                //enemyShipNumber=randomEnemyShipSelectionForHorizontalMove();
                                else if(enemyShipNumber==4 && flagEnemyShip4==1 && flagEnemyShip4ForHorizontalMove==0){ flagEnemyShip4ForHorizontalMove=1; }

                                else if(enemyShipNumber==5 && flagEnemyShip5==1 && flagEnemyShip5ForHorizontalMove==0){ flagEnemyShip5ForHorizontalMove=1; }

                                else if(enemyShipNumber==6 && flagEnemyShip6==1 && flagEnemyShip6ForHorizontalMove==0){ flagEnemyShip6ForHorizontalMove=1; }

                                //enemyShipNumber=randomEnemyShipSelectionForHorizontalMove();
                                else if(enemyShipNumber==7 && flagEnemyShip7==1 && flagEnemyShip7ForHorizontalMove==0){ flagEnemyShip7ForHorizontalMove=1; }

                                else if(enemyShipNumber==8 && flagEnemyShip8==1 && flagEnemyShip8ForHorizontalMove==0){ flagEnemyShip8ForHorizontalMove=1; }



                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyShipSelectionForHorizontalHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyShipSelectionForHorizontalHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();




        final Handler myBulletHitWithEnemyShipAndEnemyBulletHitWithMyShipHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(3);
                        myBulletHitWithEnemyShipAndEnemyBulletHitWithMyShipHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                   //My Bullet Hit With EnemyShip

                                    //Action when myBullet hit enemyShip1
                                    if(flagEnemyShip1==1 && flagMyBullet1==1 && xMyBullet1>=xEnemyShip1 && xMyBullet1<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet1>=yEnemyShip1+20 && yMyBullet1<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet1=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet2==1 && xMyBullet2>=xEnemyShip1 && xMyBullet2<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet2>=yEnemyShip1+20 && yMyBullet2<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet2=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet3==1 && xMyBullet3>=xEnemyShip1 && xMyBullet3<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet3>=yEnemyShip1+20 && yMyBullet3<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet3=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet4==1 && xMyBullet4>=xEnemyShip1 && xMyBullet4<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet4>=yEnemyShip1+20 && yMyBullet4<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet4=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet5==1 && xMyBullet5>=xEnemyShip1 && xMyBullet5<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet5>=yEnemyShip1+20 && yMyBullet5<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet5=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet6==1 && xMyBullet6>=xEnemyShip1 && xMyBullet6<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet6>=yEnemyShip1+20 && yMyBullet6<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet6=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet7==1 && xMyBullet7>=xEnemyShip1 && xMyBullet7<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet7>=yEnemyShip1+20 && yMyBullet7<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet7=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+7;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet8==1 && xMyBullet8>=xEnemyShip1 && xMyBullet8<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet8>=yEnemyShip1+20 && yMyBullet8<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet8=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet9==1 && xMyBullet9>=xEnemyShip1 && xMyBullet9<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet9>=yEnemyShip1+20 && yMyBullet9<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet9=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet10==1 && xMyBullet10>=xEnemyShip1 && xMyBullet10<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet10>=yEnemyShip1+20 && yMyBullet10<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet10=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet11==1 && xMyBullet11>=xEnemyShip1 && xMyBullet11<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet11>=yEnemyShip1+20 && yMyBullet11<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet11=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet12==1 && xMyBullet12>=xEnemyShip1 && xMyBullet12<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet12>=yEnemyShip1+20 && yMyBullet12<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet12=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet13==1 && xMyBullet13>=xEnemyShip1 && xMyBullet13<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet13>=yEnemyShip1+20 && yMyBullet13<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet13=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet14==1 && xMyBullet14>=xEnemyShip1 && xMyBullet14<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet14>=yEnemyShip1+20 && yMyBullet14<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet14=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet15==1 && xMyBullet15>=xEnemyShip1 && xMyBullet15<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet15>=yEnemyShip1+20 && yMyBullet15<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet15=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet16==1 && xMyBullet16>=xEnemyShip1 && xMyBullet16<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet16>=yEnemyShip1+20 && yMyBullet16<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet16=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip1==1 && flagMyBullet17==1 && xMyBullet17>=xEnemyShip1 && xMyBullet17<=xEnemyShip1+enemyShip1.getWidth()-5 && yMyBullet17>=yEnemyShip1+20 && yMyBullet17<=yEnemyShip1+enemyShip1.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip1=0; flagMyBullet17=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }




                                    //Action when myBullet hit enemyShip2
                                    if(flagEnemyShip2==1 && flagMyBullet1==1 && xMyBullet1>=xEnemyShip2 && xMyBullet1<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet1>=yEnemyShip2+20 && yMyBullet1<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet1=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet2==1 && xMyBullet2>=xEnemyShip2 && xMyBullet2<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet2>=yEnemyShip2+20 && yMyBullet2<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();    flagEnemyShip2=0; flagMyBullet2=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet3==1 && xMyBullet3>=xEnemyShip2 && xMyBullet3<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet3>=yEnemyShip2+20 && yMyBullet3<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet3=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet4==1 && xMyBullet4>=xEnemyShip2 && xMyBullet4<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet4>=yEnemyShip2+20 && yMyBullet4<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet4=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet5==1 && xMyBullet5>=xEnemyShip2 && xMyBullet5<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet5>=yEnemyShip2+20 && yMyBullet5<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet5=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet6==1 && xMyBullet6>=xEnemyShip2 && xMyBullet6<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet6>=yEnemyShip2+20 && yMyBullet6<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet6=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet7==1 && xMyBullet7>=xEnemyShip2 && xMyBullet7<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet7>=yEnemyShip2+20 && yMyBullet7<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet7=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet8==1 && xMyBullet8>=xEnemyShip2 && xMyBullet8<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet8>=yEnemyShip2+20 && yMyBullet8<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet8=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet9==1 && xMyBullet9>=xEnemyShip2 && xMyBullet9<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet9>=yEnemyShip2+20 && yMyBullet9<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet9=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet10==1 && xMyBullet10>=xEnemyShip2 && xMyBullet10<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet10>=yEnemyShip2+20 && yMyBullet10<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet10=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet11==1 && xMyBullet11>=xEnemyShip2 && xMyBullet11<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet11>=yEnemyShip2+20 && yMyBullet11<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet11=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet12==1 && xMyBullet12>=xEnemyShip2 && xMyBullet12<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet12>=yEnemyShip2+20 && yMyBullet12<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet12=0;  enemyShipVisibility();  myBulletVisibility(); myScore=myScore+7;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet13==1 && xMyBullet13>=xEnemyShip2 && xMyBullet13<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet13>=yEnemyShip2+20 && yMyBullet13<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet13=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet14==1 && xMyBullet14>=xEnemyShip2 && xMyBullet14<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet14>=yEnemyShip2+20 && yMyBullet14<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet14=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet15==1 && xMyBullet15>=xEnemyShip2 && xMyBullet15<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet15>=yEnemyShip2+20 && yMyBullet15<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet15=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet16==1 && xMyBullet16>=xEnemyShip2 && xMyBullet16<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet16>=yEnemyShip2+20 && yMyBullet16<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet16=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip2==1 && flagMyBullet17==1 && xMyBullet17>=xEnemyShip2 && xMyBullet17<=xEnemyShip2+enemyShip2.getWidth()-5 && yMyBullet17>=yEnemyShip2+20 && yMyBullet17<=yEnemyShip2+enemyShip2.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip2=0; flagMyBullet17=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }




                                    //Action when myBullet hit enemyShip3
                                    if(flagEnemyShip3==1 && flagMyBullet1==1 && xMyBullet1>=xEnemyShip3 && xMyBullet1<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet1>=yEnemyShip3+20 && yMyBullet1<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet1=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet2==1 && xMyBullet2>=xEnemyShip3 && xMyBullet2<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet2>=yEnemyShip3+20 && yMyBullet2<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet2=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet3==1 && xMyBullet3>=xEnemyShip3 && xMyBullet3<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet3>=yEnemyShip3+20 && yMyBullet3<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet3=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet4==1 && xMyBullet4>=xEnemyShip3 && xMyBullet4<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet4>=yEnemyShip3+20 && yMyBullet4<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet4=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet5==1 && xMyBullet5>=xEnemyShip3 && xMyBullet5<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet5>=yEnemyShip3+20 && yMyBullet5<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet5=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet6==1 && xMyBullet6>=xEnemyShip3 && xMyBullet6<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet6>=yEnemyShip3+20 && yMyBullet6<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet6=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet7==1 && xMyBullet7>=xEnemyShip3 && xMyBullet7<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet7>=yEnemyShip3+20 && yMyBullet7<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet7=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet8==1 && xMyBullet8>=xEnemyShip3 && xMyBullet8<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet8>=yEnemyShip3+20 && yMyBullet8<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet8=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet9==1 && xMyBullet9>=xEnemyShip3 && xMyBullet9<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet9>=yEnemyShip3+20 && yMyBullet9<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet9=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet10==1 && xMyBullet10>=xEnemyShip3 && xMyBullet10<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet10>=yEnemyShip3+20 && yMyBullet10<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet10=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet11==1 && xMyBullet11>=xEnemyShip3 && xMyBullet11<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet11>=yEnemyShip3+20 && yMyBullet11<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet11=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet12==1 && xMyBullet12>=xEnemyShip3 && xMyBullet12<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet12>=yEnemyShip3+20 && yMyBullet12<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet12=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet13==1 && xMyBullet13>=xEnemyShip3 && xMyBullet13<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet13>=yEnemyShip3+20 && yMyBullet13<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet13=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet14==1 && xMyBullet14>=xEnemyShip3 && xMyBullet14<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet14>=yEnemyShip3+20 && yMyBullet14<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet14=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet15==1 && xMyBullet15>=xEnemyShip3 && xMyBullet15<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet15>=yEnemyShip3+20 && yMyBullet15<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet15=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet16==1 && xMyBullet16>=xEnemyShip3 && xMyBullet16<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet16>=yEnemyShip3+20 && yMyBullet16<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet16=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip3==1 && flagMyBullet17==1 && xMyBullet17>=xEnemyShip3 && xMyBullet17<=xEnemyShip3+enemyShip3.getWidth()-5 && yMyBullet17>=yEnemyShip3+20 && yMyBullet17<=yEnemyShip3+enemyShip3.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip3=0; flagMyBullet17=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }




                                    //Action when myBullet hit enemyShip4
                                    if(flagEnemyShip4==1 && flagMyBullet1==1 && xMyBullet1>=xEnemyShip4 && xMyBullet1<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet1>=yEnemyShip4+20 && yMyBullet1<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet1=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;       }

                                    else if(flagEnemyShip4==1 && flagMyBullet2==1 && xMyBullet2>=xEnemyShip4 && xMyBullet2<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet2>=yEnemyShip4+20 && yMyBullet2<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet2=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet3==1 && xMyBullet3>=xEnemyShip4 && xMyBullet3<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet3>=yEnemyShip4+20 && yMyBullet3<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet3=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet4==1 && xMyBullet4>=xEnemyShip4 && xMyBullet4<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet4>=yEnemyShip4+20 && yMyBullet4<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet4=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet5==1 && xMyBullet5>=xEnemyShip4 && xMyBullet5<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet5>=yEnemyShip4+20 && yMyBullet5<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet5=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet6==1 && xMyBullet6>=xEnemyShip4 && xMyBullet6<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet6>=yEnemyShip4+20 && yMyBullet6<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet6=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet7==1 && xMyBullet7>=xEnemyShip4 && xMyBullet7<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet7>=yEnemyShip4+20 && yMyBullet7<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet7=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet8==1 && xMyBullet8>=xEnemyShip4 && xMyBullet8<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet8>=yEnemyShip4+20 && yMyBullet8<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet8=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet9==1 && xMyBullet9>=xEnemyShip4 && xMyBullet9<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet9>=yEnemyShip4+20 && yMyBullet9<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet9=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet10==1 && xMyBullet10>=xEnemyShip4 && xMyBullet10<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet10>=yEnemyShip4+20 && yMyBullet10<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet10=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet11==1 && xMyBullet11>=xEnemyShip4 && xMyBullet11<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet11>=yEnemyShip4+20 && yMyBullet11<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet11=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet12==1 && xMyBullet12>=xEnemyShip4 && xMyBullet12<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet12>=yEnemyShip4+20 && yMyBullet12<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet12=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet13==1 && xMyBullet13>=xEnemyShip4 && xMyBullet13<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet13>=yEnemyShip4+20 && yMyBullet13<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet13=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet14==1 && xMyBullet14>=xEnemyShip4 && xMyBullet14<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet14>=yEnemyShip4+20 && yMyBullet14<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet14=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet15==1 && xMyBullet15>=xEnemyShip4 && xMyBullet15<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet15>=yEnemyShip4+20 && yMyBullet15<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet15=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet16==1 && xMyBullet16>=xEnemyShip4 && xMyBullet16<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet16>=yEnemyShip4+20 && yMyBullet16<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet16=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip4==1 && flagMyBullet17==1 && xMyBullet17>=xEnemyShip4 && xMyBullet17<=xEnemyShip4+enemyShip4.getWidth()-5 && yMyBullet17>=yEnemyShip4+20 && yMyBullet17<=yEnemyShip4+enemyShip4.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip4=0; flagMyBullet17=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }




                                    //Action when myBullet hit enemyShip5
                                    if(flagEnemyShip5==1 && flagMyBullet1==1 && xMyBullet1>=xEnemyShip5 && xMyBullet1<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet1>=yEnemyShip5+20 && yMyBullet1<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet1=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet2==1 && xMyBullet2>=xEnemyShip5 && xMyBullet2<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet2>=yEnemyShip5+20 && yMyBullet2<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet2=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet3==1 && xMyBullet3>=xEnemyShip5 && xMyBullet3<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet3>=yEnemyShip5+20 && yMyBullet3<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet3=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet4==1 && xMyBullet4>=xEnemyShip5 && xMyBullet4<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet4>=yEnemyShip5+20 && yMyBullet4<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet4=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet5==1 && xMyBullet5>=xEnemyShip5 && xMyBullet5<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet5>=yEnemyShip5+20 && yMyBullet5<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet5=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet6==1 && xMyBullet6>=xEnemyShip5 && xMyBullet6<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet6>=yEnemyShip5+20 && yMyBullet6<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet6=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet7==1 && xMyBullet7>=xEnemyShip5 && xMyBullet7<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet7>=yEnemyShip5+20 && yMyBullet7<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet7=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet8==1 && xMyBullet8>=xEnemyShip5 && xMyBullet8<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet8>=yEnemyShip5+20 && yMyBullet8<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet8=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet9==1 && xMyBullet9>=xEnemyShip5 && xMyBullet9<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet9>=yEnemyShip5+20 && yMyBullet9<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet9=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet10==1 && xMyBullet10>=xEnemyShip5 && xMyBullet10<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet10>=yEnemyShip5+20 && yMyBullet10<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet10=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet11==1 && xMyBullet11>=xEnemyShip5 && xMyBullet11<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet11>=yEnemyShip5+20 && yMyBullet11<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet11=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet12==1 && xMyBullet12>=xEnemyShip5 && xMyBullet12<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet12>=yEnemyShip5+20 && yMyBullet12<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet12=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet13==1 && xMyBullet13>=xEnemyShip5 && xMyBullet13<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet13>=yEnemyShip5+20 && yMyBullet13<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet13=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet14==1 && xMyBullet14>=xEnemyShip5 && xMyBullet14<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet14>=yEnemyShip5+20 && yMyBullet14<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet14=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet15==1 && xMyBullet15>=xEnemyShip5 && xMyBullet15<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet15>=yEnemyShip5+20 && yMyBullet15<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet15=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet16==1 && xMyBullet16>=xEnemyShip5 && xMyBullet16<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet16>=yEnemyShip5+20 && yMyBullet16<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet16=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip5==1 && flagMyBullet17==1 && xMyBullet17>=xEnemyShip5 && xMyBullet17<=xEnemyShip5+enemyShip5.getWidth()-5 && yMyBullet17>=yEnemyShip5+20 && yMyBullet17<=yEnemyShip5+enemyShip5.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip5=0; flagMyBullet17=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }




                                    //Action when myBullet hit enemyShip6
                                    if(flagEnemyShip6==1 && flagMyBullet1==1 && xMyBullet1>=xEnemyShip6 && xMyBullet1<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet1>=yEnemyShip6+20 && yMyBullet1<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet1=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet2==1 && xMyBullet2>=xEnemyShip6 && xMyBullet2<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet2>=yEnemyShip6+20 && yMyBullet2<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet2=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet3==1 && xMyBullet3>=xEnemyShip6 && xMyBullet3<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet3>=yEnemyShip6+20 && yMyBullet3<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet3=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet4==1 && xMyBullet4>=xEnemyShip6 && xMyBullet4<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet4>=yEnemyShip6+20 && yMyBullet4<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet4=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet5==1 && xMyBullet5>=xEnemyShip6 && xMyBullet5<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet5>=yEnemyShip6+20 && yMyBullet5<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet5=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet6==1 && xMyBullet6>=xEnemyShip6 && xMyBullet6<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet6>=yEnemyShip6+20 && yMyBullet6<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet6=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet7==1 && xMyBullet7>=xEnemyShip6 && xMyBullet7<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet7>=yEnemyShip6+20 && yMyBullet7<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet7=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet8==1 && xMyBullet8>=xEnemyShip6 && xMyBullet8<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet8>=yEnemyShip6+20 && yMyBullet8<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet8=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet9==1 && xMyBullet9>=xEnemyShip6 && xMyBullet9<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet9>=yEnemyShip6+20 && yMyBullet9<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet9=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet10==1 && xMyBullet10>=xEnemyShip6 && xMyBullet10<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet10>=yEnemyShip6+20 && yMyBullet10<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet10=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet11==1 && xMyBullet11>=xEnemyShip6 && xMyBullet11<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet11>=yEnemyShip6+20 && yMyBullet11<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet11=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet12==1 && xMyBullet12>=xEnemyShip6 && xMyBullet12<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet12>=yEnemyShip6+20 && yMyBullet12<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet12=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet13==1 && xMyBullet13>=xEnemyShip6 && xMyBullet13<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet13>=yEnemyShip6+20 && yMyBullet13<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet13=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet14==1 && xMyBullet14>=xEnemyShip6 && xMyBullet14<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet14>=yEnemyShip6+20 && yMyBullet14<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet14=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet15==1 && xMyBullet15>=xEnemyShip6 && xMyBullet15<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet15>=yEnemyShip6+20 && yMyBullet15<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet15=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet16==1 && xMyBullet16>=xEnemyShip6 && xMyBullet16<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet16>=yEnemyShip6+20 && yMyBullet16<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet16=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip6==1 && flagMyBullet17==1 && xMyBullet17>=xEnemyShip6 && xMyBullet17<=xEnemyShip6+enemyShip6.getWidth()-5 && yMyBullet17>=yEnemyShip6+20 && yMyBullet17<=yEnemyShip6+enemyShip6.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip6=0; flagMyBullet17=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }




                                    //Action when myBullet hit enemyShip7
                                    if(flagEnemyShip7==1 && flagMyBullet1==1 && xMyBullet1>=xEnemyShip7 && xMyBullet1<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet1>=yEnemyShip7+20 && yMyBullet1<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet1=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet2==1 && xMyBullet2>=xEnemyShip7 && xMyBullet2<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet2>=yEnemyShip7+20 && yMyBullet2<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet2=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet3==1 && xMyBullet3>=xEnemyShip7 && xMyBullet3<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet3>=yEnemyShip7+20 && yMyBullet3<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet3=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet4==1 && xMyBullet4>=xEnemyShip7 && xMyBullet4<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet4>=yEnemyShip7+20 && yMyBullet4<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet4=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet5==1 && xMyBullet5>=xEnemyShip7 && xMyBullet5<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet5>=yEnemyShip7+20 && yMyBullet5<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet5=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet6==1 && xMyBullet6>=xEnemyShip7 && xMyBullet6<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet6>=yEnemyShip7+20 && yMyBullet6<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet6=0;  enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet7==1 && xMyBullet7>=xEnemyShip7 && xMyBullet7<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet7>=yEnemyShip7+20 && yMyBullet7<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet7=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet8==1 && xMyBullet8>=xEnemyShip7 && xMyBullet8<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet8>=yEnemyShip7+20 && yMyBullet8<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet8=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet9==1 && xMyBullet9>=xEnemyShip7 && xMyBullet9<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet9>=yEnemyShip7+20 && yMyBullet9<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet9=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet10==1 && xMyBullet10>=xEnemyShip7 && xMyBullet10<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet10>=yEnemyShip7+20 && yMyBullet10<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet10=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet11==1 && xMyBullet11>=xEnemyShip7 && xMyBullet11<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet11>=yEnemyShip7+20 && yMyBullet11<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet11=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet12==1 && xMyBullet12>=xEnemyShip7 && xMyBullet12<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet12>=yEnemyShip7+20 && yMyBullet12<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet12=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet13==1 && xMyBullet13>=xEnemyShip7 && xMyBullet13<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet13>=yEnemyShip7+20 && yMyBullet13<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet13=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet14==1 && xMyBullet14>=xEnemyShip7 && xMyBullet14<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet14>=yEnemyShip7+20 && yMyBullet14<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet14=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet15==1 && xMyBullet15>=xEnemyShip7 && xMyBullet15<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet15>=yEnemyShip7+20 && yMyBullet15<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet15=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet16==1 && xMyBullet16>=xEnemyShip7 && xMyBullet16<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet16>=yEnemyShip7+20 && yMyBullet16<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet16=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip7==1 && flagMyBullet17==1 && xMyBullet17>=xEnemyShip7 && xMyBullet17<=xEnemyShip7+enemyShip7.getWidth()-5 && yMyBullet17>=yEnemyShip7+20 && yMyBullet17<=yEnemyShip7+enemyShip7.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip7=0; flagMyBullet17=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }




                                    //Action when myBullet hit enemyShip8
                                    if(flagEnemyShip8==1 && flagMyBullet1==1 && xMyBullet1>=xEnemyShip8 && xMyBullet1<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet1>=yEnemyShip8+20 && yMyBullet1<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet1=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet2==1 && xMyBullet2>=xEnemyShip8 && xMyBullet2<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet2>=yEnemyShip8+20 && yMyBullet2<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet2=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet3==1 && xMyBullet3>=xEnemyShip8 && xMyBullet3<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet3>=yEnemyShip8+20 && yMyBullet3<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet3=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet4==1 && xMyBullet4>=xEnemyShip8 && xMyBullet4<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet4>=yEnemyShip8+20 && yMyBullet4<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet4=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet5==1 && xMyBullet5>=xEnemyShip8 && xMyBullet5<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet5>=yEnemyShip8+20 && yMyBullet5<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet5=0;  enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet6==1 && xMyBullet6>=xEnemyShip8 && xMyBullet6<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet6>=yEnemyShip8+20 && yMyBullet6<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet6=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet7==1 && xMyBullet7>=xEnemyShip8 && xMyBullet7<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet7>=yEnemyShip8+20 && yMyBullet7<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet7=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet8==1 && xMyBullet8>=xEnemyShip8 && xMyBullet8<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet8>=yEnemyShip8+20 && yMyBullet8<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet8=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet9==1 && xMyBullet9>=xEnemyShip8 && xMyBullet9<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet9>=yEnemyShip8+20 && yMyBullet9<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet9=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet10==1 && xMyBullet10>=xEnemyShip8 && xMyBullet10<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet10>=yEnemyShip8+20 && yMyBullet10<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet10=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet11==1 && xMyBullet11>=xEnemyShip8 && xMyBullet11<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet11>=yEnemyShip8+20 && yMyBullet11<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet11=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet12==1 && xMyBullet12>=xEnemyShip8 && xMyBullet12<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet12>=yEnemyShip8+20 && yMyBullet12<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet12=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet13==1 && xMyBullet13>=xEnemyShip8 && xMyBullet13<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet13>=yEnemyShip8+20 && yMyBullet13<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet13=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet14==1 && xMyBullet14>=xEnemyShip8 && xMyBullet14<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet14>=yEnemyShip8+20 && yMyBullet14<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet14=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet15==1 && xMyBullet15>=xEnemyShip8 && xMyBullet15<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet15>=yEnemyShip8+20 && yMyBullet15<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet15=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet16==1 && xMyBullet16>=xEnemyShip8 && xMyBullet16<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet16>=yEnemyShip8+20 && yMyBullet16<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet16=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }

                                    else if(flagEnemyShip8==1 && flagMyBullet17==1 && xMyBullet17>=xEnemyShip8 && xMyBullet17<=xEnemyShip8+enemyShip8.getWidth()-5 && yMyBullet17>=yEnemyShip8+20 && yMyBullet17<=yEnemyShip8+enemyShip8.getHeight()){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagEnemyShip8=0; flagMyBullet17=0;
                                        enemyShipVisibility();  myBulletVisibility(); myScore=myScore+17;      }




                                    enemyShipVisibility();
                                    myScoreTextView.setText(myScore+"");


                                    //Enemy Bullet Hit with My Ship

                                    //Action when EBulletsForEnemyShip1 hit myShip
                                    if(flagEBullet1ForEnemyShip1==1 && xEBullet1ForEnemyShip1>=xMyShip-3 && xEBullet1ForEnemyShip1<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip1>=yMyShip+2 && yEBullet1ForEnemyShip1<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet1ForEnemyShip1=0; eBullet1ForEnemyShip1.setX(-400);  eBullet1ForEnemyShip1.setY(-400);
                                        eBullet1ForEnemyShip1.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;   enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");

                                    if(flagEBullet2ForEnemyShip1==1 && xEBullet2ForEnemyShip1>=xMyShip-3 && xEBullet2ForEnemyShip1<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip1>=yMyShip+2 && yEBullet2ForEnemyShip1<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet2ForEnemyShip1=0; eBullet2ForEnemyShip1.setX(-400);  eBullet2ForEnemyShip1.setY(-400);
                                        eBullet2ForEnemyShip1.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");


                                    //Action when EBulletsForEnemyShip2 hit myShip
                                    if(flagEBullet1ForEnemyShip2==1 && xEBullet1ForEnemyShip2>=xMyShip-3 && xEBullet1ForEnemyShip2<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip2>=yMyShip+2 && yEBullet1ForEnemyShip2<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet1ForEnemyShip2=0; eBullet1ForEnemyShip2.setX(-400);  eBullet1ForEnemyShip2.setY(-400);
                                        eBullet1ForEnemyShip2.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");

                                    if(flagEBullet2ForEnemyShip2==1 && xEBullet2ForEnemyShip2>=xMyShip-3 && xEBullet2ForEnemyShip2<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip2>=yMyShip+2 && yEBullet2ForEnemyShip2<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet2ForEnemyShip2=0; eBullet2ForEnemyShip2.setX(-400);  eBullet2ForEnemyShip2.setY(-400);
                                        eBullet2ForEnemyShip2.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");


                                    //Action when EBulletsForEnemyShip3 hit myShip
                                    if(flagEBullet1ForEnemyShip3==1 && xEBullet1ForEnemyShip3>=xMyShip-3 && xEBullet1ForEnemyShip3<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip3>=yMyShip+2 && yEBullet1ForEnemyShip3<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet1ForEnemyShip3=0; eBullet1ForEnemyShip3.setX(-400);  eBullet1ForEnemyShip3.setY(-400);
                                        eBullet1ForEnemyShip3.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");

                                    if(flagEBullet2ForEnemyShip3==1 && xEBullet2ForEnemyShip3>=xMyShip-3 && xEBullet2ForEnemyShip3<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip3>=yMyShip+2 && yEBullet2ForEnemyShip3<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet2ForEnemyShip3=0; eBullet2ForEnemyShip3.setX(-400);  eBullet2ForEnemyShip3.setY(-400);
                                        eBullet2ForEnemyShip3.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");


                                    //Action when EBulletsForEnemyShip4 hit myShip
                                    if(flagEBullet1ForEnemyShip4==1 && xEBullet1ForEnemyShip4>=xMyShip-3 && xEBullet1ForEnemyShip4<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip4>=yMyShip+2 && yEBullet1ForEnemyShip4<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet1ForEnemyShip4=0; eBullet1ForEnemyShip4.setX(-400);  eBullet1ForEnemyShip4.setY(-400);
                                        eBullet1ForEnemyShip4.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");

                                    if(flagEBullet2ForEnemyShip4==1 && xEBullet2ForEnemyShip4>=xMyShip-3 && xEBullet2ForEnemyShip4<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip4>=yMyShip+2 && yEBullet2ForEnemyShip4<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet2ForEnemyShip4=0; eBullet2ForEnemyShip4.setX(-400);  eBullet2ForEnemyShip4.setY(-400);
                                        eBullet2ForEnemyShip4.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");


                                    //Action when EBulletsForEnemyShip5 hit myShip
                                    if(flagEBullet1ForEnemyShip5==1 && xEBullet1ForEnemyShip5>=xMyShip-3 && xEBullet1ForEnemyShip5<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip5>=yMyShip+2 && yEBullet1ForEnemyShip5<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet1ForEnemyShip5=0; eBullet1ForEnemyShip5.setX(-400);  eBullet1ForEnemyShip5.setY(-400);
                                        eBullet1ForEnemyShip5.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");

                                    if(flagEBullet2ForEnemyShip5==1 && xEBullet2ForEnemyShip5>=xMyShip-3 && xEBullet2ForEnemyShip5<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip5>=yMyShip+2 && yEBullet2ForEnemyShip5<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet2ForEnemyShip5=0; eBullet2ForEnemyShip5.setX(-400);  eBullet2ForEnemyShip5.setY(-400);
                                        eBullet2ForEnemyShip5.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");


                                    //Action when EBulletsForEnemyShip6 hit myShip
                                    if(flagEBullet1ForEnemyShip6==1 && xEBullet1ForEnemyShip6>=xMyShip-3 && xEBullet1ForEnemyShip6<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip6>=yMyShip+2 && yEBullet1ForEnemyShip6<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet1ForEnemyShip6=0; eBullet1ForEnemyShip6.setX(-400);  eBullet1ForEnemyShip6.setY(-400);
                                        eBullet1ForEnemyShip6.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");

                                    if(flagEBullet2ForEnemyShip6==1 && xEBullet2ForEnemyShip6>=xMyShip-3 && xEBullet2ForEnemyShip6<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip6>=yMyShip+2 && yEBullet2ForEnemyShip6<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet2ForEnemyShip6=0; eBullet2ForEnemyShip6.setX(-400);  eBullet2ForEnemyShip6.setY(-400);
                                        eBullet2ForEnemyShip6.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");


                                    //Action when EBulletsForEnemyShip7 hit myShip
                                    if(flagEBullet1ForEnemyShip7==1 && xEBullet1ForEnemyShip7>=xMyShip-3 && xEBullet1ForEnemyShip7<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip7>=yMyShip+2 && yEBullet1ForEnemyShip7<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet1ForEnemyShip7=0; eBullet1ForEnemyShip7.setX(-400);  eBullet1ForEnemyShip7.setY(-400);
                                        eBullet1ForEnemyShip7.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");

                                    if(flagEBullet2ForEnemyShip7==1 && xEBullet2ForEnemyShip7>=xMyShip-3 && xEBullet2ForEnemyShip7<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip7>=yMyShip+2 && yEBullet2ForEnemyShip7<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet2ForEnemyShip7=0; eBullet2ForEnemyShip7.setX(-400);  eBullet2ForEnemyShip7.setY(-400);
                                        eBullet2ForEnemyShip7.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");


                                    //Action when EBulletsForEnemyShip8 hit myShip
                                    if(flagEBullet1ForEnemyShip8==1 && xEBullet1ForEnemyShip8>=xMyShip-3 && xEBullet1ForEnemyShip8<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip8>=yMyShip+2 && yEBullet1ForEnemyShip8<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet1ForEnemyShip8=0; eBullet1ForEnemyShip8.setX(-400);  eBullet1ForEnemyShip8.setY(-400);
                                        eBullet1ForEnemyShip8.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");

                                    if(flagEBullet2ForEnemyShip8==1 && xEBullet2ForEnemyShip8>=xMyShip-3 && xEBullet2ForEnemyShip8<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip8>=yMyShip+2 && yEBullet2ForEnemyShip8<=yMyShip+5){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                        flagEBullet2ForEnemyShip8=0; eBullet2ForEnemyShip8.setX(-400);  eBullet2ForEnemyShip8.setY(-400);
                                        eBullet2ForEnemyShip8.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBulletVisibility(); }

                                    myLifeTextView.setText(myLife+"");




                                    //My Ship And Enemy Ship Hit

                                    if(flagEnemyShip1==1 &&  (xEnemyShip1+enemyShip1.getWidth() ) >=xMyShip && xEnemyShip1<= (xMyShip+myShip.getWidth() ) && (yEnemyShip1+enemyShip1.getHeight()) >=yMyShip && yEnemyShip1<= (yMyShip+myShip.getHeight()) ){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();  flagEnemyShip1=0; if(myLife>0) myLife--;
                                        myScore=myScore+17;     enemyShipVisibility(); myLifeTextView.setText(myLife+"");  }

                                    if(flagEnemyShip2==1 &&  (xEnemyShip2+enemyShip2.getWidth() ) >=xMyShip && xEnemyShip2<= (xMyShip+myShip.getWidth()) && (yEnemyShip2+enemyShip2.getHeight()) >=yMyShip && yEnemyShip2<= (yMyShip+myShip.getHeight()) ){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();  flagEnemyShip2=0; if(myLife>0) myLife--;
                                        myScore=myScore+17;     enemyShipVisibility(); myLifeTextView.setText(myLife+"");  }

                                    if(flagEnemyShip3==1 &&  (xEnemyShip3+enemyShip3.getWidth()) >=xMyShip && xEnemyShip3<= (xMyShip+myShip.getWidth()) && (yEnemyShip3+enemyShip3.getHeight()) >=yMyShip && yEnemyShip3<= (yMyShip+myShip.getHeight()) ){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();  flagEnemyShip3=0; if(myLife>0) myLife--;
                                        myScore=myScore+17;     enemyShipVisibility(); myLifeTextView.setText(myLife+"");  }

                                    if(flagEnemyShip4==1 &&  (xEnemyShip4+enemyShip4.getWidth()) >=xMyShip && xEnemyShip4<= (xMyShip+myShip.getWidth()) && (yEnemyShip4+enemyShip4.getHeight()) >=yMyShip && yEnemyShip4<= (yMyShip+myShip.getHeight()) ){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();  flagEnemyShip4=0; if(myLife>0) myLife--;
                                        myScore=myScore+17;     enemyShipVisibility(); myLifeTextView.setText(myLife+"");  }

                                    if(flagEnemyShip5==1 &&  (xEnemyShip5+enemyShip5.getWidth()) >=xMyShip && xEnemyShip5<= (xMyShip+myShip.getWidth()) && (yEnemyShip5+enemyShip5.getHeight()) >=yMyShip && yEnemyShip5<= (yMyShip+myShip.getHeight()) ){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();  flagEnemyShip5=0; if(myLife>0) myLife--;
                                        myScore=myScore+17;     enemyShipVisibility(); myLifeTextView.setText(myLife+"");  }

                                    if(flagEnemyShip6==1 &&  (xEnemyShip6+enemyShip6.getWidth()) >=xMyShip && xEnemyShip6<= (xMyShip+myShip.getWidth()) && (yEnemyShip6+enemyShip6.getHeight()) >=yMyShip && yEnemyShip6<= (yMyShip+myShip.getHeight()) ){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();  flagEnemyShip6=0; if(myLife>0) myLife--;
                                        myScore=myScore+17;     enemyShipVisibility(); myLifeTextView.setText(myLife+"");  }

                                    if(flagEnemyShip7==1 &&  (xEnemyShip7+enemyShip7.getWidth()) >=xMyShip && xEnemyShip7<= (xMyShip+myShip.getWidth()) && (yEnemyShip7+enemyShip7.getHeight()) >=yMyShip && yEnemyShip7<= (yMyShip+myShip.getHeight()) ){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();  flagEnemyShip7=0; if(myLife>0) myLife--;
                                        myScore=myScore+17;     enemyShipVisibility(); myLifeTextView.setText(myLife+"");  }

                                    if(flagEnemyShip8==1 &&  (xEnemyShip8+enemyShip8.getWidth()) >=xMyShip && xEnemyShip8<= (xMyShip+myShip.getWidth()) && (yEnemyShip8+enemyShip8.getHeight()) >=yMyShip && yEnemyShip8<= (yMyShip+myShip.getHeight()) ){
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
                                        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();  flagEnemyShip8=0; if(myLife>0) myLife--;
                                        myScore=myScore+17;     enemyShipVisibility(); myLifeTextView.setText(myLife+"");  }





                                if(myScore/13>30)
                                {
                                    flagForContinueGameWhenBossCome=0;
                                    move=0;
                                    pLayPauseButton.setVisibility(View.INVISIBLE);
                                    reminderPageFrameLayout.setVisibility(View.INVISIBLE);
                                    delayThreadForBossCome();
                                }



                                if(myLife==0)
                                {
                                    gameOverDetector=1;
                                    move=0;
                                    myBulletVisibility();
                                    enemyShipVisibility();
                                    enemyBulletVisibility();

                                    pLayPauseButton.setVisibility(View.INVISIBLE);
                                   // gameOverPageActivity();
                                    threadForGameOverShow();




                                }


                            }
                        });
                    } catch (Exception e) {
                        System.out.println("myBulletHitWithEnemyShipHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "myBulletHitWithEnemyShipHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();






        final Handler timeCounterAndReminderViewHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==0 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(1000);
                        timeCounterAndReminderViewHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                time++;

                                enemyLeftTextView.setText( (30-(myScore/13)) +"");
                                timeLeftTextView.setText( (totalTime-time) +"");

                                if(time%15==0){
                                    reminderPageFrameLayout.setVisibility(View.VISIBLE);
                                    flagForReminderView=1;
                                    tReminderViewHelper=time;
                                }

                                if(flagForReminderView==1 && time-tReminderViewHelper==3){
                                    reminderPageFrameLayout.setVisibility(View.INVISIBLE);
                                    flagForReminderView=0;
                                    tReminderViewHelper=0;
                                }



                            }
                        });
                    } catch (Exception e) {
                        System.out.println("timeCounterAndReminderViewHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "timeCounterAndReminderViewHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();

        /*Thread timeCounter=new Thread(){
            public void run()
            {
                while(move==1 && flagEnemyBossShip==0 && gameOverDetector==0)
                {

                    time++;
                    if(flagForReminderView==1)tReminderViewHelper++;

                    enemyLeftTextView.setText( (40-(myScore/13)) +"");
                    timeLeftTextView.setText( (totalTime-time) +"");

                    if(time%10==0){
                        reminderPageFrameLayout.setVisibility(View.VISIBLE);
                        flagForReminderView=1;
                    }

                    if(tReminderViewHelper%3==0){
                        reminderPageFrameLayout.setVisibility(View.INVISIBLE);
                        flagForReminderView=0;
                        tReminderViewHelper=0;
                    }


                    try
                    {
                        sleep(1000);
                    }
                    catch (InterruptedException ex)
                    {
                        System.out.println("timeCount Error : "+ex);
                    }
                }
            }

        };timeCounter.start();*/



    }



    public void  unNeed()
    {
        /*      final Handler enemyBulletHitWithMyShipHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(3);
                        enemyBulletHitWithMyShipHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                //Action when EBulletsForEnemyShip1 hit myShip
                                if(flagEBullet1ForEnemyShip1==1 && xEBullet1ForEnemyShip1>=xMyShip && xEBullet1ForEnemyShip1<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip1>=yMyShip+2 && yEBullet1ForEnemyShip1<=yMyShip+myShip.getHeight()){
                                    flagEBullet1ForEnemyShip1=0; eBullet1ForEnemyShip1.setX(-400);  eBullet1ForEnemyShip1.setY(-400);
                                    eBullet1ForEnemyShip1.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }

                                if(flagEBullet2ForEnemyShip1==1 && xEBullet2ForEnemyShip1>=xMyShip && xEBullet2ForEnemyShip1<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip1>=yMyShip+2 && yEBullet2ForEnemyShip1<=yMyShip+myShip.getHeight()){
                                    flagEBullet2ForEnemyShip1=0; eBullet2ForEnemyShip1.setX(-400);  eBullet2ForEnemyShip1.setY(-400);
                                    eBullet2ForEnemyShip1.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }


                                //Action when EBulletsForEnemyShip2 hit myShip
                                if(flagEBullet1ForEnemyShip2==1 && xEBullet1ForEnemyShip2>=xMyShip && xEBullet1ForEnemyShip2<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip2>=yMyShip+2 && yEBullet1ForEnemyShip2<=yMyShip+myShip.getHeight()){
                                    flagEBullet1ForEnemyShip2=0; eBullet1ForEnemyShip2.setX(-400);  eBullet1ForEnemyShip2.setY(-400);
                                    eBullet1ForEnemyShip2.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }

                                if(flagEBullet2ForEnemyShip2==1 && xEBullet2ForEnemyShip2>=xMyShip && xEBullet2ForEnemyShip2<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip2>=yMyShip+2 && yEBullet2ForEnemyShip2<=yMyShip+myShip.getHeight()){
                                    flagEBullet2ForEnemyShip2=0; eBullet2ForEnemyShip2.setX(-400);  eBullet2ForEnemyShip2.setY(-400);
                                    eBullet2ForEnemyShip2.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }


                                //Action when EBulletsForEnemyShip3 hit myShip
                                if(flagEBullet1ForEnemyShip3==1 && xEBullet1ForEnemyShip3>=xMyShip && xEBullet1ForEnemyShip3<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip3>=yMyShip+2 && yEBullet1ForEnemyShip3<=yMyShip+myShip.getHeight()){
                                    flagEBullet1ForEnemyShip3=0; eBullet1ForEnemyShip3.setX(-400);  eBullet1ForEnemyShip3.setY(-400);
                                    eBullet1ForEnemyShip3.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }

                                if(flagEBullet2ForEnemyShip3==1 && xEBullet2ForEnemyShip3>=xMyShip && xEBullet2ForEnemyShip3<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip3>=yMyShip+2 && yEBullet2ForEnemyShip3<=yMyShip+myShip.getHeight()){
                                    flagEBullet2ForEnemyShip3=0; eBullet2ForEnemyShip3.setX(-400);  eBullet2ForEnemyShip3.setY(-400);
                                    eBullet2ForEnemyShip3.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }


                                //Action when EBulletsForEnemyShip4 hit myShip
                                if(flagEBullet1ForEnemyShip4==1 && xEBullet1ForEnemyShip4>=xMyShip && xEBullet1ForEnemyShip4<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip4>=yMyShip+2 && yEBullet1ForEnemyShip4<=yMyShip+myShip.getHeight()){
                                    flagEBullet1ForEnemyShip4=0; eBullet1ForEnemyShip4.setX(-400);  eBullet1ForEnemyShip4.setY(-400);
                                    eBullet1ForEnemyShip4.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }

                                if(flagEBullet2ForEnemyShip4==1 && xEBullet2ForEnemyShip4>=xMyShip && xEBullet2ForEnemyShip4<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip4>=yMyShip+2 && yEBullet2ForEnemyShip4<=yMyShip+myShip.getHeight()){
                                    flagEBullet2ForEnemyShip4=0; eBullet2ForEnemyShip4.setX(-400);  eBullet2ForEnemyShip4.setY(-400);
                                    eBullet2ForEnemyShip4.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }


                                //Action when EBulletsForEnemyShip5 hit myShip
                                if(flagEBullet1ForEnemyShip5==1 && xEBullet1ForEnemyShip5>=xMyShip && xEBullet1ForEnemyShip5<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip5>=yMyShip+2 && yEBullet1ForEnemyShip5<=yMyShip+myShip.getHeight()){
                                    flagEBullet1ForEnemyShip5=0; eBullet1ForEnemyShip5.setX(-400);  eBullet1ForEnemyShip5.setY(-400);
                                    eBullet1ForEnemyShip5.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }

                                if(flagEBullet2ForEnemyShip5==1 && xEBullet2ForEnemyShip5>=xMyShip && xEBullet2ForEnemyShip5<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip5>=yMyShip+2 && yEBullet2ForEnemyShip5<=yMyShip+myShip.getHeight()){
                                    flagEBullet2ForEnemyShip5=0; eBullet2ForEnemyShip5.setX(-400);  eBullet2ForEnemyShip5.setY(-400);
                                    eBullet2ForEnemyShip5.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }


                                //Action when EBulletsForEnemyShip6 hit myShip
                                if(flagEBullet1ForEnemyShip6==1 && xEBullet1ForEnemyShip6>=xMyShip && xEBullet1ForEnemyShip6<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip6>=yMyShip+2 && yEBullet1ForEnemyShip6<=yMyShip+myShip.getHeight()){
                                    flagEBullet1ForEnemyShip6=0; eBullet1ForEnemyShip6.setX(-400);  eBullet1ForEnemyShip6.setY(-400);
                                    eBullet1ForEnemyShip6.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }

                                if(flagEBullet2ForEnemyShip6==1 && xEBullet2ForEnemyShip6>=xMyShip && xEBullet2ForEnemyShip6<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip6>=yMyShip+2 && yEBullet2ForEnemyShip6<=yMyShip+myShip.getHeight()){
                                    flagEBullet2ForEnemyShip6=0; eBullet2ForEnemyShip6.setX(-400);  eBullet2ForEnemyShip6.setY(-400);
                                    eBullet2ForEnemyShip6.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }


                                //Action when EBulletsForEnemyShip7 hit myShip
                                if(flagEBullet1ForEnemyShip7==1 && xEBullet1ForEnemyShip7>=xMyShip && xEBullet1ForEnemyShip7<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip7>=yMyShip+2 && yEBullet1ForEnemyShip7<=yMyShip+myShip.getHeight()){
                                    flagEBullet1ForEnemyShip7=0; eBullet1ForEnemyShip7.setX(-400);  eBullet1ForEnemyShip7.setY(-400);
                                    eBullet1ForEnemyShip7.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }

                                if(flagEBullet2ForEnemyShip7==1 && xEBullet2ForEnemyShip7>=xMyShip && xEBullet2ForEnemyShip7<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip7>=yMyShip+2 && yEBullet2ForEnemyShip7<=yMyShip+myShip.getHeight()){
                                    flagEBullet2ForEnemyShip7=0; eBullet2ForEnemyShip7.setX(-400);  eBullet2ForEnemyShip7.setY(-400);
                                    eBullet2ForEnemyShip7.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }


                                //Action when EBulletsForEnemyShip8 hit myShip
                                if(flagEBullet1ForEnemyShip8==1 && xEBullet1ForEnemyShip8>=xMyShip && xEBullet1ForEnemyShip8<=xMyShip+myShip.getWidth()-5 && yEBullet1ForEnemyShip8>=yMyShip+2 && yEBullet1ForEnemyShip8<=yMyShip+myShip.getHeight()){
                                    flagEBullet1ForEnemyShip8=0; eBullet1ForEnemyShip8.setX(-400);  eBullet1ForEnemyShip8.setY(-400);
                                    eBullet1ForEnemyShip8.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }

                                if(flagEBullet2ForEnemyShip8==1 && xEBullet2ForEnemyShip8>=xMyShip && xEBullet2ForEnemyShip8<=xMyShip+myShip.getWidth()-5 && yEBullet2ForEnemyShip8>=yMyShip+2 && yEBullet2ForEnemyShip8<=yMyShip+myShip.getHeight()){
                                    flagEBullet2ForEnemyShip8=0; eBullet2ForEnemyShip8.setX(-400);  eBullet2ForEnemyShip8.setY(-400);
                                    eBullet2ForEnemyShip8.setVisibility(View.INVISIBLE);  if(myLife>0)myLife--;  enemyBulletVisibility(); }



                                myLifeTextView.setText(myLife+"");


                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBulletVisibilityHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBulletVisibilityHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();*/





     /*   final Handler enemyBulletMoveHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(7);
                        enemyBulletMoveHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                if(flagEBullet1ForEnemyShip1==1)yEBullet1ForEnemyShip1++;
                                if(yEBullet1ForEnemyShip1>screenHeight)flagEBullet1ForEnemyShip1=0;

                                if(flagEBullet2ForEnemyShip1==1)yEBullet2ForEnemyShip1++;
                                if(yEBullet2ForEnemyShip1>screenHeight)flagEBullet2ForEnemyShip1=0;


                                if(flagEBullet1ForEnemyShip2==1)yEBullet1ForEnemyShip2++;
                                if(yEBullet1ForEnemyShip2>screenHeight)flagEBullet1ForEnemyShip2=0;

                                if(flagEBullet2ForEnemyShip2==1)yEBullet2ForEnemyShip2++;
                                if(yEBullet2ForEnemyShip2>screenHeight)flagEBullet2ForEnemyShip2=0;


                                if(flagEBullet1ForEnemyShip3==1)yEBullet1ForEnemyShip3++;
                                if(yEBullet1ForEnemyShip3>screenHeight)flagEBullet1ForEnemyShip3=0;

                                if(flagEBullet2ForEnemyShip3==1)yEBullet2ForEnemyShip3++;
                                if(yEBullet2ForEnemyShip3>screenHeight)flagEBullet2ForEnemyShip3=0;


                                if(flagEBullet1ForEnemyShip4==1)yEBullet1ForEnemyShip4++;
                                if(yEBullet1ForEnemyShip4>screenHeight)flagEBullet1ForEnemyShip4=0;

                                if(flagEBullet2ForEnemyShip4==1)yEBullet2ForEnemyShip4++;
                                if(yEBullet2ForEnemyShip4>screenHeight)flagEBullet2ForEnemyShip4=0;


                                if(flagEBullet1ForEnemyShip5==1)yEBullet1ForEnemyShip5++;
                                if(yEBullet1ForEnemyShip5>screenHeight)flagEBullet1ForEnemyShip5=0;

                                if(flagEBullet2ForEnemyShip5==1)yEBullet2ForEnemyShip5++;
                                if(yEBullet2ForEnemyShip5>screenHeight)flagEBullet2ForEnemyShip5=0;


                                if(flagEBullet1ForEnemyShip6==1)yEBullet1ForEnemyShip6++;
                                if(yEBullet1ForEnemyShip6>screenHeight)flagEBullet1ForEnemyShip6=0;

                                if(flagEBullet2ForEnemyShip6==1)yEBullet2ForEnemyShip6++;
                                if(yEBullet2ForEnemyShip6>screenHeight)flagEBullet2ForEnemyShip6=0;


                                if(flagEBullet1ForEnemyShip7==1)yEBullet1ForEnemyShip7++;
                                if(yEBullet1ForEnemyShip7>screenHeight)flagEBullet1ForEnemyShip7=0;

                                if(flagEBullet2ForEnemyShip7==1)yEBullet2ForEnemyShip7++;
                                if(yEBullet2ForEnemyShip7>screenHeight)flagEBullet2ForEnemyShip7=0;


                                if(flagEBullet1ForEnemyShip8==1)yEBullet1ForEnemyShip8++;
                                if(yEBullet1ForEnemyShip8>screenHeight)flagEBullet1ForEnemyShip8=0;

                                if(flagEBullet2ForEnemyShip8==1)yEBullet2ForEnemyShip8++;
                                if(yEBullet2ForEnemyShip8>screenHeight)flagEBullet2ForEnemyShip8=0;




                                eBullet1ForEnemyShip1.setX(xEBullet1ForEnemyShip1);  eBullet1ForEnemyShip1.setY(yEBullet1ForEnemyShip1);
                                eBullet2ForEnemyShip1.setX(xEBullet2ForEnemyShip1);  eBullet2ForEnemyShip1.setY(yEBullet2ForEnemyShip1);

                                eBullet1ForEnemyShip2.setX(xEBullet1ForEnemyShip2);  eBullet1ForEnemyShip2.setY(yEBullet1ForEnemyShip2);
                                eBullet2ForEnemyShip2.setX(xEBullet2ForEnemyShip2);  eBullet2ForEnemyShip2.setY(yEBullet2ForEnemyShip2);

                                eBullet1ForEnemyShip3.setX(xEBullet1ForEnemyShip3);  eBullet1ForEnemyShip3.setY(yEBullet1ForEnemyShip3);
                                eBullet2ForEnemyShip3.setX(xEBullet2ForEnemyShip3);  eBullet2ForEnemyShip3.setY(yEBullet2ForEnemyShip3);

                                eBullet1ForEnemyShip4.setX(xEBullet1ForEnemyShip4);  eBullet1ForEnemyShip4.setY(yEBullet1ForEnemyShip4);
                                eBullet2ForEnemyShip4.setX(xEBullet2ForEnemyShip4);  eBullet2ForEnemyShip4.setY(yEBullet2ForEnemyShip4);

                                eBullet1ForEnemyShip5.setX(xEBullet1ForEnemyShip5);  eBullet1ForEnemyShip5.setY(yEBullet1ForEnemyShip5);
                                eBullet2ForEnemyShip5.setX(xEBullet2ForEnemyShip5);  eBullet2ForEnemyShip5.setY(yEBullet2ForEnemyShip5);

                                eBullet1ForEnemyShip6.setX(xEBullet1ForEnemyShip6);  eBullet1ForEnemyShip6.setY(yEBullet1ForEnemyShip6);
                                eBullet2ForEnemyShip6.setX(xEBullet2ForEnemyShip6);  eBullet2ForEnemyShip6.setY(yEBullet2ForEnemyShip6);

                                eBullet1ForEnemyShip7.setX(xEBullet1ForEnemyShip7);  eBullet1ForEnemyShip7.setY(yEBullet1ForEnemyShip7);
                                eBullet2ForEnemyShip7.setX(xEBullet2ForEnemyShip7);  eBullet2ForEnemyShip7.setY(yEBullet2ForEnemyShip7);

                                eBullet1ForEnemyShip8.setX(xEBullet1ForEnemyShip8);  eBullet1ForEnemyShip8.setY(yEBullet1ForEnemyShip8);
                                eBullet2ForEnemyShip8.setX(xEBullet2ForEnemyShip8);  eBullet2ForEnemyShip8.setY(yEBullet2ForEnemyShip8);




                               // enemyBulletVisibility();


                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBulletMoveHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBulletMoveHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();*/


      /*  final Handler enemyBulletSelectionForMoveHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(1000);
                        enemyBulletSelectionForMoveHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                if(flagEnemyShip1==1 && flagEBullet1ForEnemyShip1==0){ xEBullet1ForEnemyShip1=xEnemyShip1+enemyShip1.getWidth()/2;  yEBullet1ForEnemyShip1=yEnemyShip1+enemyShip1.getHeight();
                                                                                       flagEBullet1ForEnemyShip1=1; }
                                if(flagEnemyShip1==1 && flagEBullet2ForEnemyShip1==0){ xEBullet2ForEnemyShip1=xEnemyShip1+enemyShip1.getWidth()/2;  yEBullet2ForEnemyShip1=yEnemyShip1+enemyShip1.getHeight();
                                                                                       flagEBullet2ForEnemyShip1=1; }

                                if(flagEnemyShip2==1 && flagEBullet1ForEnemyShip2==0){ xEBullet1ForEnemyShip2=xEnemyShip2+enemyShip2.getWidth()/2;  yEBullet1ForEnemyShip2=yEnemyShip2+enemyShip2.getHeight();
                                                                                       flagEBullet1ForEnemyShip2=1; }
                                if(flagEnemyShip2==1 && flagEBullet2ForEnemyShip2==0){ xEBullet2ForEnemyShip2=xEnemyShip2+enemyShip2.getWidth()/2;  yEBullet2ForEnemyShip2=yEnemyShip2+enemyShip2.getHeight();
                                                                                       flagEBullet2ForEnemyShip2=1; }

                                if(flagEnemyShip3==1 && flagEBullet1ForEnemyShip3==0){ xEBullet1ForEnemyShip3=xEnemyShip3+enemyShip3.getWidth()/2;  yEBullet1ForEnemyShip3=yEnemyShip3+enemyShip3.getHeight();
                                                                                       flagEBullet1ForEnemyShip3=1; }
                                if(flagEnemyShip3==1 && flagEBullet2ForEnemyShip3==0){ xEBullet2ForEnemyShip3=xEnemyShip3+enemyShip3.getWidth()/2;  yEBullet2ForEnemyShip3=yEnemyShip3+enemyShip3.getHeight();
                                                                                       flagEBullet2ForEnemyShip3=1; }

                                if(flagEnemyShip4==1 && flagEBullet1ForEnemyShip4==0){ xEBullet1ForEnemyShip4=xEnemyShip4+enemyShip4.getWidth()/2;  yEBullet1ForEnemyShip4=yEnemyShip4+enemyShip4.getHeight();
                                                                                       flagEBullet1ForEnemyShip4=1; }
                                if(flagEnemyShip4==1 && flagEBullet2ForEnemyShip4==0){ xEBullet2ForEnemyShip4=xEnemyShip4+enemyShip4.getWidth()/2;  yEBullet2ForEnemyShip4=yEnemyShip4+enemyShip4.getHeight();
                                                                                       flagEBullet2ForEnemyShip4=1; }

                                if(flagEnemyShip5==1 && flagEBullet1ForEnemyShip5==0){ xEBullet1ForEnemyShip5=xEnemyShip5+enemyShip5.getWidth()/2;  yEBullet1ForEnemyShip5=yEnemyShip5+enemyShip5.getHeight();
                                                                                       flagEBullet1ForEnemyShip5=1; }
                                if(flagEnemyShip5==1 && flagEBullet2ForEnemyShip5==0){ xEBullet2ForEnemyShip5=xEnemyShip5+enemyShip5.getWidth()/2;  yEBullet2ForEnemyShip5=yEnemyShip5+enemyShip5.getHeight();
                                                                                       flagEBullet2ForEnemyShip5=1; }

                                if(flagEnemyShip6==1 && flagEBullet1ForEnemyShip6==0){ xEBullet1ForEnemyShip6=xEnemyShip6+enemyShip6.getWidth()/2;  yEBullet1ForEnemyShip6=yEnemyShip6+enemyShip6.getHeight();
                                                                                       flagEBullet1ForEnemyShip6=1; }
                                if(flagEnemyShip6==1 && flagEBullet2ForEnemyShip6==0){ xEBullet2ForEnemyShip6=xEnemyShip6+enemyShip6.getWidth()/2;  yEBullet2ForEnemyShip6=yEnemyShip6+enemyShip6.getHeight();
                                                                                       flagEBullet2ForEnemyShip6=1; }

                                if(flagEnemyShip7==1 && flagEBullet1ForEnemyShip7==0){ xEBullet1ForEnemyShip7=xEnemyShip7+enemyShip7.getWidth()/2;  yEBullet1ForEnemyShip7=yEnemyShip7+enemyShip7.getHeight();
                                                                                       flagEBullet1ForEnemyShip7=1; }
                                if(flagEnemyShip7==1 && flagEBullet2ForEnemyShip7==0){ xEBullet2ForEnemyShip7=xEnemyShip7+enemyShip7.getWidth()/2;  yEBullet2ForEnemyShip7=yEnemyShip7+enemyShip7.getHeight();
                                                                                       flagEBullet2ForEnemyShip7=1; }

                                if(flagEnemyShip8==1 && flagEBullet1ForEnemyShip8==0){ xEBullet1ForEnemyShip8=xEnemyShip8+enemyShip8.getWidth()/2;  yEBullet1ForEnemyShip8=yEnemyShip8+enemyShip8.getHeight();
                                                                                       flagEBullet1ForEnemyShip8=1; }
                                if(flagEnemyShip8==1 && flagEBullet2ForEnemyShip8==0){ xEBullet2ForEnemyShip8=xEnemyShip8+enemyShip8.getWidth()/2;  yEBullet2ForEnemyShip8=yEnemyShip8+enemyShip8.getHeight();
                                                                                       flagEBullet2ForEnemyShip8=1; }


                                enemyBulletVisibility();

                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBulletMoveHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBulletMoveHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();*/


    /*    final Handler enemyBulletHitWithMyShipHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(3);
                        enemyBulletHitWithMyShipHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                //if

                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBulletVisibilityHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBulletVisibilityHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();*/



    /*    Thread myBulletSelection=new Thread(){
            public void run()
            {
                while(move==1)
                {



                    try
                    {
                        sleep(500);

                    }
                    catch (InterruptedException ex)
                    {

                    }
                }
            }

        };myBulletSelection.start();*/







     /*   final Handler enemyBulletVisibilityHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(3);
                        enemyBulletVisibilityHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                enemyBulletVisibility();

                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBulletVisibilityHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBulletVisibilityHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();*/

        /* Thread gameOverShow=new Thread(){
            public void run()
            {
                while(true)
                {

                    delayGameOverShow++;
                    if(delayGameOverShow>25)System.exit(0);


                    try
                    {
                        sleep(1000);
                    }
                    catch (InterruptedException ex)
                    {
                        System.out.println("gameOverThread Error : "+ex);
                    }
                }
            }

        };gameOverShow.start();*/
    }


    public void delayThreadForBossCome()
    {
        final Handler delayThreadForBossComeHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (flagForContinueGameWhenBossCome==0) {
                    try
                    {
                        Thread.sleep(1000);
                        delayThreadForBossComeHandler.post(new Runnable() {

                            @Override
                            public void run() {



                                delayForBoseCome++;

                                enemyShipInvisible();
                                enemyBulletInvisible();
                                myBulletInvisible();




                                if(delayForBoseCome>27)
                                {


                                    flagBossCame=1;
                                    flagEnemyBossShip=1;

                                    xEnemyBossShip=randomXPosition();
                                    yEnemyBossShip=10;
                                    flagEnemyBossShipForLeftRightMoveTargetingMyShip=0;

                                    enemyBossShip.setX(xEnemyBossShip); enemyBossShip.setY(yEnemyBossShip);
                                    enemyBossShip.setVisibility(View.VISIBLE);

                                    enemyBossLifeLinearLayout.setVisibility(View.VISIBLE);
                                    enemyBossLifeTextView.setText(100+"%");

                                    touchToStartGamePage.setVisibility(View.VISIBLE);

                                    flagForContinueGameWhenBossCome=1;
                                }

                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBulletVisibilityHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBulletVisibilityHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();
    }


    public void componentsMoveWhenAllEnemiesDestroyedExceptBoss()
    {
        touchToStartGamePage.setVisibility(View.INVISIBLE);

        final SettingsManager settingsManagerObject=dataBaseHandlerForSettingsManager.getAllSettingsData(1);

        final Handler bgMoveHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(5);
                        bgMoveHandler.post(new Runnable() {

                            @Override
                            public void run() {


                                if(yBg1== screenHeight)yBg1=-screenHeight;
                                if(yBg1< screenHeight)yBg1++;

                                if(yBg2== screenHeight)yBg2=-screenHeight;
                                if(yBg2< screenHeight)yBg2++;

                                backGround1InPlayActivity.setY(yBg1);
                                backGround2InPlayActivity.setY(yBg2);

                            }
                        });
                    } catch (Exception e) {
                        System.out.println("bgMoveHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "bgMoveHandler ", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }).start();


        final Handler myBulletMoveAndEnemyBossBulletMoveHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub

                while (move==1 && flagEnemyBossShip==1 && gameOverDetector==0){
                    try
                    {
                        Thread.sleep(3);
                        myBulletMoveAndEnemyBossBulletMoveHandler.post(new Runnable() {

                            @Override
                            public void run() {


                                //My Bullet Move
                                if(flagMyBullet1==1)yMyBullet1--;
                                if(yMyBullet1<=0){ flagMyBullet1=0;  myBullet1.setX(-200);  myBullet1.setY(-200);  myBullet1.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet2==1)yMyBullet2--;
                                if(yMyBullet2<=0){ flagMyBullet2=0;  myBullet2.setX(-200);  myBullet2.setY(-200);  myBullet2.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet3==1)yMyBullet3--;
                                if(yMyBullet3<=0){ flagMyBullet3=0;  myBullet3.setX(-200);  myBullet3.setY(-200);  myBullet3.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet4==1)yMyBullet4--;
                                if(yMyBullet4<=0){ flagMyBullet4=0;  myBullet4.setX(-200);  myBullet4.setY(-200);  myBullet4.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet5==1)yMyBullet5--;
                                if(yMyBullet5<=0){ flagMyBullet5=0;  myBullet5.setX(-200);  myBullet5.setY(-200);  myBullet5.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet6==1)yMyBullet6--;
                                if(yMyBullet6<=0){ flagMyBullet6=0;  myBullet6.setX(-200);  myBullet6.setY(-200);  myBullet6.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet7==1)yMyBullet7--;
                                if(yMyBullet7<=0){ flagMyBullet7=0;  myBullet7.setX(-200);  myBullet7.setY(-200);  myBullet7.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet8==1)yMyBullet8--;
                                if(yMyBullet8<=0){ flagMyBullet8=0;  myBullet8.setX(-200);  myBullet8.setY(-200);  myBullet8.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet9==1)yMyBullet9--;
                                if(yMyBullet9<=0){ flagMyBullet9=0;  myBullet9.setX(-200);  myBullet9.setY(-200);  myBullet9.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet10==1)yMyBullet10--;
                                if(yMyBullet10<=0){ flagMyBullet10=0;  myBullet10.setX(-200);  myBullet10.setY(-200);  myBullet10.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet11==1)yMyBullet11--;
                                if(yMyBullet11<=0){ flagMyBullet11=0;  myBullet11.setX(-200);  myBullet11.setY(-200);  myBullet11.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet12==1)yMyBullet12--;
                                if(yMyBullet12<=0){ flagMyBullet12=0;  myBullet12.setX(-200);  myBullet12.setY(-200);  myBullet12.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet13==1)yMyBullet13--;
                                if(yMyBullet13<=0){ flagMyBullet13=0;  myBullet13.setX(-200);  myBullet13.setY(-200);  myBullet13.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet14==1)yMyBullet14--;
                                if(yMyBullet14<=0){ flagMyBullet14=0;  myBullet14.setX(-200);  myBullet14.setY(-200);  myBullet14.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet15==1)yMyBullet15--;
                                if(yMyBullet15<=0){ flagMyBullet15=0;  myBullet15.setX(-200);  myBullet15.setY(-200);  myBullet15.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet16==1)yMyBullet16--;
                                if(yMyBullet16<=0){ flagMyBullet16=0;  myBullet16.setX(-200);  myBullet16.setY(-200);  myBullet16.setVisibility(View.INVISIBLE); }

                                if(flagMyBullet17==1)yMyBullet17--;
                                if(yMyBullet17<=0){ flagMyBullet17=0;  myBullet17.setX(-200);  myBullet17.setY(-200);  myBullet17.setVisibility(View.INVISIBLE); }


                                myBullet1.setX(xMyBullet1);   myBullet1.setY(yMyBullet1);

                                myBullet2.setX(xMyBullet2);   myBullet2.setY(yMyBullet2);

                                myBullet3.setX(xMyBullet3);   myBullet3.setY(yMyBullet3);

                                myBullet4.setX(xMyBullet4);   myBullet4.setY(yMyBullet4);

                                myBullet5.setX(xMyBullet5);   myBullet5.setY(yMyBullet5);

                                myBullet6.setX(xMyBullet6);   myBullet6.setY(yMyBullet6);

                                myBullet7.setX(xMyBullet7);   myBullet7.setY(yMyBullet7);

                                myBullet8.setX(xMyBullet8);   myBullet8.setY(yMyBullet8);

                                myBullet9.setX(xMyBullet9);   myBullet9.setY(yMyBullet9);

                                myBullet10.setX(xMyBullet10); myBullet10.setY(yMyBullet10);

                                myBullet11.setX(xMyBullet11); myBullet11.setY(yMyBullet11);

                                myBullet12.setX(xMyBullet12); myBullet12.setY(yMyBullet12);

                                myBullet13.setX(xMyBullet13); myBullet13.setY(yMyBullet13);

                                myBullet14.setX(xMyBullet14); myBullet14.setY(yMyBullet14);

                                myBullet15.setX(xMyBullet15); myBullet15.setY(yMyBullet15);

                                myBullet16.setX(xMyBullet16); myBullet16.setY(yMyBullet16);

                                myBullet17.setX(xMyBullet17); myBullet17.setY(yMyBullet17);



                                //  myBulletVisibility();


                                //Enemy Boss Bullet Move

                                if (flagEBullet1ForBoss == 1) yEBullet1ForBoss++;
                                if (yEBullet1ForBoss > screenHeight)
                                    flagEBullet1ForBoss = 0;

                                if (flagEBullet2ForBoss == 1) yEBullet2ForBoss++;
                                if (yEBullet2ForBoss > screenHeight)
                                    flagEBullet2ForBoss = 0;

                                if (flagEBullet3ForBoss == 1) yEBullet3ForBoss++;
                                if (yEBullet3ForBoss > screenHeight)
                                    flagEBullet3ForBoss = 0;

                                if (flagEBullet4ForBoss == 1) yEBullet4ForBoss++;
                                if (yEBullet4ForBoss > screenHeight)
                                    flagEBullet4ForBoss = 0;

                                if (flagEBullet5ForBoss == 1) yEBullet5ForBoss++;
                                if (yEBullet5ForBoss > screenHeight)
                                    flagEBullet5ForBoss = 0;

                                if (flagEBullet6ForBoss == 1) yEBullet6ForBoss++;
                                if (yEBullet6ForBoss > screenHeight)
                                    flagEBullet6ForBoss = 0;

                                if (flagEBullet7ForBoss == 1) yEBullet7ForBoss++;
                                if (yEBullet7ForBoss > screenHeight)
                                    flagEBullet7ForBoss = 0;


                                eBullet1ForBoss.setX(xEBullet1ForBoss);  eBullet1ForBoss.setY(yEBullet1ForBoss);
                                eBullet2ForBoss.setX(xEBullet2ForBoss);  eBullet2ForBoss.setY(yEBullet2ForBoss);
                                eBullet3ForBoss.setX(xEBullet3ForBoss);  eBullet3ForBoss.setY(yEBullet3ForBoss);
                                eBullet4ForBoss.setX(xEBullet4ForBoss);  eBullet4ForBoss.setY(yEBullet4ForBoss);
                                eBullet5ForBoss.setX(xEBullet5ForBoss);  eBullet5ForBoss.setY(yEBullet5ForBoss);
                                eBullet6ForBoss.setX(xEBullet6ForBoss);  eBullet6ForBoss.setY(yEBullet6ForBoss);
                                eBullet7ForBoss.setX(xEBullet7ForBoss);  eBullet7ForBoss.setY(yEBullet7ForBoss);





                            }
                        });
                    } catch (Exception e) {
                        System.out.println("myBulletMoveAndEnemyBossBulletMoveHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "myBulletMoveAndEnemyBossBulletMoveHandler ", Toast.LENGTH_LONG).show();


                    }
                }
            }
        }).start();


        final Handler myBulletSelectionHandler= new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==1 && gameOverDetector==0 ) {
                    try
                    {
                        Thread.sleep(350);
                        myBulletSelectionHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                if(touchDownOrUp==1)myBulletSelection();

                                //Enemy Boss Bullet Selection
                                if (flagEBullet1ForBoss == 0) {
                                    xEBullet1ForBoss = xEnemyBossShip + enemyBossShip.getWidth() / 2 - 5;
                                    yEBullet1ForBoss = yEnemyBossShip + enemyBossShip.getHeight()-21;  flagEBullet1ForBoss = 1;
                                }

                                else if (flagEBullet2ForBoss == 0) {
                                    xEBullet2ForBoss = xEnemyBossShip + enemyBossShip.getWidth() / 2 - 5;
                                    yEBullet2ForBoss = yEnemyBossShip + enemyBossShip.getHeight()-25;  flagEBullet2ForBoss = 1;
                                }

                                else if (flagEBullet3ForBoss == 0) {
                                    xEBullet3ForBoss = xEnemyBossShip + enemyBossShip.getWidth() / 2 - 5;
                                    yEBullet3ForBoss = yEnemyBossShip + enemyBossShip.getHeight()-25;  flagEBullet3ForBoss = 1;
                                }

                                else if (flagEBullet4ForBoss == 0) {
                                    xEBullet4ForBoss = xEnemyBossShip + enemyBossShip.getWidth() / 2 - 5;
                                    yEBullet4ForBoss = yEnemyBossShip + enemyBossShip.getHeight()-25;  flagEBullet4ForBoss = 1;
                                }

                                else if (flagEBullet5ForBoss == 0) {
                                    xEBullet5ForBoss = xEnemyBossShip + enemyBossShip.getWidth() / 2 - 5;
                                    yEBullet5ForBoss = yEnemyBossShip + enemyBossShip.getHeight()-25;  flagEBullet5ForBoss = 1;
                                }

                                else if (flagEBullet6ForBoss == 0) {
                                    xEBullet6ForBoss = xEnemyBossShip + enemyBossShip.getWidth() / 2 - 5;
                                    yEBullet6ForBoss = yEnemyBossShip + enemyBossShip.getHeight()-21;  flagEBullet6ForBoss = 1;
                                }

                                else if (flagEBullet7ForBoss == 0) {
                                    xEBullet7ForBoss = xEnemyBossShip + enemyBossShip.getWidth() / 2 - 5;
                                    yEBullet7ForBoss = yEnemyBossShip + enemyBossShip.getHeight()-25;  flagEBullet7ForBoss = 1;
                                }


                                enemyBossBulletVisibility();

                                System.out.println("my BulletSelectionHandler my 2: ");


                            }
                        });

                    } catch (Exception e) {
                        System.out.println("myBulletSelectionHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "myBulletSelectionHandler", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }).start();


        final Handler enemyBossShipMoveHorizontalHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(15);
                        enemyBossShipMoveHorizontalHandler.post(new Runnable() {

                            @Override
                            public void run() {


                                if (flagEnemyBossShipForHorizontalMove == 1) {

                                    if (flagEnemyBossShipForLeftRightMoveTargetingMyShip == 1)
                                    {
                                        if (xEnemyBossShip>-10 && xEnemyBossShip < screenWidth - enemyBossShip.getWidth()+10 )
                                        {
                                            if ( (xEnemyBossShip+enemyBossShip.getWidth()/2) < myShip.getX()+(myShip.getWidth()/2) ) xEnemyBossShip++;
                                            else xEnemyBossShip--;
                                        }
                                        else if (xEnemyBossShip > (screenWidth-enemyBossShip.getWidth()+10)) xEnemyBossShip--;
                                        else xEnemyBossShip++;

                                    }

                                    else if (flagEnemyBossShipForLeftRightMoveTargetingMyShip == 0)
                                    {
                                        if (xEnemyBossShip>-10 && xEnemyBossShip < screenWidth - enemyBossShip.getWidth()+10 )
                                        {
                                            if (flagEnemyBossShipForLeftRightMove == 1) {
                                              //  if (xEnemyBossShip < screenWidth - enemyBossShip.getWidth() + 10)
                                                    xEnemyBossShip++;
                                               // else xEnemyBossShip--;

                                            }
                                            else if (flagEnemyBossShipForLeftRightMove == 0)
                                            {
                                               // if (xEnemyBossShip > -10)
                                                    xEnemyBossShip--;
                                               // else xEnemyBossShip++;
                                            }

                                        }
                                        else if (xEnemyBossShip > (screenWidth-enemyBossShip.getWidth()+10)) xEnemyBossShip--;
                                        else xEnemyBossShip++;


                                        //else xEnemyBossShip++;
                                    }


                                }


                                enemyBossShip.setX(xEnemyBossShip);  enemyBossShip.setY(yEnemyBossShip);


                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBossShipMoveHorizontalHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBossShipMoveHorizontalHandler ", Toast.LENGTH_LONG).show();

                    }
                }
            }
        }).start();



        final Handler enemyBossShipLeftOrRightMoveSelectionHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(1000);
                        enemyBossShipLeftOrRightMoveSelectionHandler.post(new Runnable() {

                            @Override
                            public void run() {



                              //  if (flagEnemyBossShipForHorizontalMove == 1)
                                {
                              //      if(flagEnemyBossShipForLeftRightMoveTargetingMyShip==0)flagEnemyBossShipForLeftRightMove = randomEnemyShipLeftRightMoveSelector();

                                }
                                flagEnemyBossShipForLeftRightMove = randomEnemyShipLeftRightMoveSelector();






                            }

                        });
                    } catch (Exception e) {
                        System.out.println("enemyBossShipLeftOrRightMoveSelectionAndEnemyBossBulletSelectionHandler "+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBossShipLeftOrRightMoveSelectionAndEnemyBossBulletSelectionHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();


        final Handler enemyBossShipSelectionForHorizontalHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(4000);
                        enemyBossShipSelectionForHorizontalHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                flagEnemyBossShipForHorizontalMove=1;//randomEnemyBossShipMoveHorizontallyOrNot();
                                if(flagEnemyBossShipForHorizontalMove==1)flagEnemyBossShipForLeftRightMoveTargetingMyShip=randomEnemyBossShipMoveHorizontallyOrNot();

                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBossShipSelectionForHorizontalHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBossShipSelectionForHorizontalHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();



        final float eBossWeakPortion=enemyBossShip.getWidth()/6;
        final NumberFormat numberFormat = new DecimalFormat("#0.00");
        final Handler enemyBossBulletHitAndMyBulletHitWithOneAnotherShipHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (move==1 && flagEnemyBossShip==1 && gameOverDetector==0) {
                    try
                    {
                        Thread.sleep(3);
                        enemyBossBulletHitAndMyBulletHitWithOneAnotherShipHandler.post(new Runnable() {

                            @Override
                            public void run() {


                                //Action when myBullet1 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet1==1
                                        && xMyBullet1>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet1<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet1>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet1<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet1=0;
                                    myBulletVisibility(); myScore=myScore+17; enemyBossLifeTemp= enemyBossLifeTemp-0.5;   }

                                //all portion
                                else if(flagMyBullet1==1
                                        && xMyBullet1>=(xEnemyBossShip+3)
                                        && xMyBullet1<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet1>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet1<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet1=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }


                             //   enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet2 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet2==1
                                        && xMyBullet2>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet2<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet2>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet2<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet2=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet2==1
                                        && xMyBullet2>=(xEnemyBossShip+3)
                                        && xMyBullet2<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet2>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet2<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet2=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                             //   enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                             //   enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet3 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet3==1
                                        && xMyBullet3>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet3<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet3>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet3<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet3=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet3==1
                                        && xMyBullet3>=(xEnemyBossShip+3)
                                        && xMyBullet3<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet3>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet3<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet3=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                             //   enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                             //   enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet4 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet4==1
                                        && xMyBullet4>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet4<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet4>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet4<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet4=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet4==1
                                        && xMyBullet4>=(xEnemyBossShip+3)
                                        && xMyBullet4<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet4>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet4<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet4=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                                enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                                enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet5 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet5==1
                                        && xMyBullet5>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet5<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet5>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet5<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet5=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet5==1
                                        && xMyBullet5>=(xEnemyBossShip+3)
                                        && xMyBullet5<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet5>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet5<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet5=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet6 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet6==1
                                        && xMyBullet6>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet6<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet6>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet6<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet6=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet6==1
                                        && xMyBullet6>=(xEnemyBossShip+3)
                                        && xMyBullet6<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet6>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet6<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet6=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                               // enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet7 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet7==1
                                        && xMyBullet7>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet7<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet7>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet7<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet7=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet7==1
                                        && xMyBullet7>=(xEnemyBossShip+3)
                                        && xMyBullet7<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet7>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet7<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet7=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                               // enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet8 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet8==1
                                        && xMyBullet8>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet8<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet8>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet8<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet8=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet8==1
                                        && xMyBullet8>=(xEnemyBossShip+3)
                                        && xMyBullet8<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet8>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet8<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet8=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                                if(enemyBossLifeTemp>0.00) enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                                if(enemyBossLifeTemp>0.00)enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet9 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet9==1
                                        && xMyBullet9>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet9<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet9>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet9<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet9=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet9==1
                                        && xMyBullet9>=(xEnemyBossShip+3)
                                        && xMyBullet9<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet9>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet9<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet9=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet10 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet10==1
                                        && xMyBullet10>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet10<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet10>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet10<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet10=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet10==1
                                        && xMyBullet10>=(xEnemyBossShip+3)
                                        && xMyBullet10<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet10>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet10<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet10=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet11 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet11==1
                                        && xMyBullet11>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet11<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet11>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet11<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet11=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet11==1
                                        && xMyBullet11>=(xEnemyBossShip+3)
                                        && xMyBullet11<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet11>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet11<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet11=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                               // enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet12 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet12==1
                                        && xMyBullet12>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet12<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet12>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet12<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet12=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet12==1
                                        && xMyBullet12>=(xEnemyBossShip+3)
                                        && xMyBullet12<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet12>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet12<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet12=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet13 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet13==1
                                        && xMyBullet13>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet13<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet13>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet13<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet13=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet13==1
                                        && xMyBullet13>=(xEnemyBossShip+3)
                                        && xMyBullet13<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet13>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet13<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet13=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                             //   enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                             //   enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet14 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet14==1
                                        && xMyBullet14>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet14<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet14>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet14<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet14=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet14==1
                                        && xMyBullet14>=(xEnemyBossShip+3)
                                        && xMyBullet14<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet14>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet14<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet14=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet15 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet15==1
                                        && xMyBullet15>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet15<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet15>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet15<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet15=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet15==1
                                        && xMyBullet15>=(xEnemyBossShip+3)
                                        && xMyBullet15<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet15>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet15<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet15=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet16 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet16==1
                                        && xMyBullet16>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet16<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet16>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet16<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet16=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet16==1
                                        && xMyBullet16>=(xEnemyBossShip+3)
                                        && xMyBullet16<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet16>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet16<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet16=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                              //  enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                              //  enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");



                                //Action when myBullet17 hit enemyBossShip
                                //weak portion
                                if(flagMyBullet17==1
                                        && xMyBullet17>=(xEnemyBossShip+enemyBossShip.getWidth()/2)-eBossWeakPortion
                                        && xMyBullet17<=(xEnemyBossShip+enemyBossShip.getWidth()/2)+eBossWeakPortion
                                        && yMyBullet17>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet17<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet17=0;
                                    myBulletVisibility(); myScore=myScore+17;  enemyBossLifeTemp= enemyBossLifeTemp-0.5;    }

                                //all portion
                                else if(flagMyBullet17==1
                                        && xMyBullet17>=(xEnemyBossShip+3)
                                        && xMyBullet17<=(xEnemyBossShip+enemyBossShip.getWidth())-19
                                        && yMyBullet17>=yEnemyBossShip+enemyBossShip.getHeight()-35
                                        && yMyBullet17<=yEnemyBossShip+enemyBossShip.getHeight()){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();  flagMyBullet17=0;
                                    myBulletVisibility(); myScore=myScore+1;  enemyBossLifeTemp= enemyBossLifeTemp-0.05;    }

                                if(enemyBossLifeTemp>0.00)enemyBossLifePercentage =numberFormat.format( ((enemyBossLifeTemp/enemyBossLifeTotal)*100) );
                                if(enemyBossLifeTemp>0.00)enemyBossLifeTextView.setText(enemyBossLifePercentage +"%");




                                myScoreTextView.setText(myScore+"");



                                //bossBulletHitWithMyShip();
                                //Action when eBulletsForBoss hit myShip

                                //Action when eBullet1ForBoss hit myShip
                                if(flagEBullet1ForBoss==1
                                        && xEBullet1ForBoss>=( xMyShip-eBullet1ForBoss.getWidth() )+4 && xEBullet1ForBoss+3<=xMyShip+myShip.getWidth()-5
                                        && yEBullet1ForBoss>=yMyShip+(myShip.getHeight()/2) && yEBullet1ForBoss<=yMyShip+(myShip.getHeight()/2)+7){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                    flagEBullet1ForBoss=0; eBullet1ForBoss.setX(-700);  eBullet1ForBoss.setY(-700);
                                    eBullet1ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

                                myLifeTextView.setText(myLife+"");


                                //Action when eBullet2ForBoss hit myShip
                                if(flagEBullet2ForBoss==1
                                        && xEBullet2ForBoss>=( xMyShip-eBullet2ForBoss.getWidth() )+4 && xEBullet2ForBoss+3<=xMyShip+myShip.getWidth()-5
                                        && yEBullet2ForBoss>=yMyShip+(myShip.getHeight()/2) && yEBullet2ForBoss<=yMyShip+(myShip.getHeight()/2)+7){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                    flagEBullet2ForBoss=0; eBullet2ForBoss.setX(-700);  eBullet2ForBoss.setY(-700);
                                    eBullet2ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

                                myLifeTextView.setText(myLife+"");


                                //Action when eBullet3ForBoss hit myShip
                                if(flagEBullet3ForBoss==1
                                        && xEBullet3ForBoss>=( xMyShip-eBullet3ForBoss.getWidth() )+4 && xEBullet3ForBoss+3<=xMyShip+myShip.getWidth()-5
                                        && yEBullet3ForBoss>=yMyShip+(myShip.getHeight()/2) && yEBullet3ForBoss<=yMyShip+(myShip.getHeight()/2)+7){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                    flagEBullet3ForBoss=0; eBullet3ForBoss.setX(-700);  eBullet3ForBoss.setY(-700);
                                    eBullet3ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

                                myLifeTextView.setText(myLife+"");


                                //Action when eBullet4ForBoss hit myShip
                                if(flagEBullet4ForBoss==1
                                        && xEBullet4ForBoss>=( xMyShip-eBullet4ForBoss.getWidth() )+4 && xEBullet4ForBoss+3<=xMyShip+myShip.getWidth()-5
                                        && yEBullet4ForBoss>=yMyShip+(myShip.getHeight()/2) && yEBullet4ForBoss<=yMyShip+(myShip.getHeight()/2)+7){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                    flagEBullet4ForBoss=0; eBullet4ForBoss.setX(-700);  eBullet4ForBoss.setY(-700);
                                    eBullet4ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

                                myLifeTextView.setText(myLife+"");


                                //Action when eBullet5ForBoss hit myShip
                                if(flagEBullet5ForBoss==1
                                        && xEBullet5ForBoss>=( xMyShip-eBullet5ForBoss.getWidth() )+4 && xEBullet5ForBoss+3<=xMyShip+myShip.getWidth()-5
                                        && yEBullet5ForBoss>=yMyShip+(myShip.getHeight()/2) && yEBullet5ForBoss<=yMyShip+(myShip.getHeight()/2)+7){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                    flagEBullet5ForBoss=0; eBullet5ForBoss.setX(-700);  eBullet5ForBoss.setY(-700);
                                    eBullet5ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

                                myLifeTextView.setText(myLife+"");


                                //Action when eBullet6ForBoss hit myShip
                                if(flagEBullet6ForBoss==1
                                        && xEBullet6ForBoss>=( xMyShip-eBullet6ForBoss.getWidth() )+4 && xEBullet6ForBoss+3<=xMyShip+myShip.getWidth()-5
                                        && yEBullet6ForBoss>=yMyShip+(myShip.getHeight()/2) && yEBullet6ForBoss<=yMyShip+(myShip.getHeight()/2)+7){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                    flagEBullet6ForBoss=0; eBullet6ForBoss.setX(-700);  eBullet6ForBoss.setY(-700);
                                    eBullet6ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

                                myLifeTextView.setText(myLife+"");


                                //Action when eBullet7ForBoss hit myShip
                                if(flagEBullet7ForBoss==1
                                        && xEBullet7ForBoss>=( xMyShip-eBullet7ForBoss.getWidth() )+4 && xEBullet7ForBoss+3<=xMyShip+myShip.getWidth()-5
                                        && yEBullet7ForBoss>=yMyShip+(myShip.getHeight()/2) && yEBullet7ForBoss<=yMyShip+(myShip.getHeight()/2)+7){

                                    if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
                                    flagEBullet7ForBoss=0; eBullet7ForBoss.setX(-700);  eBullet7ForBoss.setY(-700);
                                    eBullet7ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

                                myLifeTextView.setText(myLife+"");




                              /*  if(myLife==0)
                                {
                                    gameOverDetector=1;
                                    move=0;
                                    myBulletVisibility();
                                    enemyShipVisibility();
                                    enemyBulletVisibility();

                                    pLayPauseButton.setVisibility(View.INVISIBLE);
                                    // gameOverPageActivity();
                                    threadForGameOverShow();




                                }*/

                                if(enemyBossLifeTemp<0.00 && myLife>0)
                                {
                                    enemyBossLifeTextView.setText(00.00+"%");

                                    gameOverDetector=1;
                                    move=0;

                                    levelFinished=1;

                                    myBulletVisibility();
                                    enemyShipVisibility();
                                    enemyBulletVisibility();

                                    pLayPauseButton.setVisibility(View.INVISIBLE);
                                    // gameOverPageActivity();
                                    threadForGameOverShow();
                                }




                                if(myLife==0)
                                {
                                    gameOverDetector=1;
                                    move=0;
                                    myBulletVisibility();
                                    enemyShipVisibility();
                                    enemyBulletVisibility();

                                    pLayPauseButton.setVisibility(View.INVISIBLE);
                                    // gameOverPageActivity();
                                    threadForGameOverShow();




                                }


                            }
                        });
                    } catch (Exception e) {
                        System.out.println("enemyBossShipSelectionForHorizontalHandler"+"my : "+e);
                        Toast.makeText(getApplicationContext(), "enemyBossShipSelectionForHorizontalHandler", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();




        Thread timeCounter2=new Thread(){
            public void run()
            {
                while(move==1 && flagEnemyBossShip==1 && gameOverDetector==0)
                {

                    time++;


                    try
                    {
                        sleep(1000);
                    }
                    catch (InterruptedException ex)
                    {
                        System.out.println("timeCount Error : "+ex);
                    }
                }
            }

        };timeCounter2.start();





    }


    public void threadForGameOverShow()
    {

        final Handler gameOverShowHandler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (flagDelayGameOverShowForThread==1) {
                    try
                    {
                        Thread.sleep(1000);
                        gameOverShowHandler.post(new Runnable() {

                            @Override
                            public void run() {

                                delayGameOverShow++;
                                if(delayGameOverShow>21){
                                    flagDelayGameOverShowForThread=0;
                                    gameOverPageActivity();
                                }
                                   // System.exit(0);
                                  //  onBackPressed();



                                //allComponentsInvisible();

                            }
                        });
                    } catch (Exception e) {
                        System.out.println("gameOverThread Error : "+e);
                        Toast.makeText(getApplicationContext(), "gameOverThread Error : "+e, Toast.LENGTH_LONG).show();
                    }
                }
            }
        }).start();

    }

    public void allComponentsInvisible()
    {
        myShip.setVisibility(View.INVISIBLE);

       myBullet1.setVisibility(View.INVISIBLE);
       myBullet2.setVisibility(View.INVISIBLE);
       myBullet3.setVisibility(View.INVISIBLE);
       myBullet4.setVisibility(View.INVISIBLE);
       myBullet5.setVisibility(View.INVISIBLE);
       myBullet6.setVisibility(View.INVISIBLE);
       myBullet7.setVisibility(View.INVISIBLE);
       myBullet8.setVisibility(View.INVISIBLE);
       myBullet9.setVisibility(View.INVISIBLE);
       myBullet10.setVisibility(View.INVISIBLE);
       myBullet11.setVisibility(View.INVISIBLE);
       myBullet12.setVisibility(View.INVISIBLE);
       myBullet13.setVisibility(View.INVISIBLE);
       myBullet14.setVisibility(View.INVISIBLE);
       myBullet15.setVisibility(View.INVISIBLE);
       myBullet16.setVisibility(View.INVISIBLE);
       myBullet17.setVisibility(View.INVISIBLE);
       myBullet18.setVisibility(View.INVISIBLE);
       myBullet19.setVisibility(View.INVISIBLE);
       myBullet20.setVisibility(View.INVISIBLE);
       myBullet21.setVisibility(View.INVISIBLE);
       myBullet22.setVisibility(View.INVISIBLE);

        enemyShip1.setVisibility(View.INVISIBLE);
        enemyShip3.setVisibility(View.INVISIBLE);
        enemyShip3.setVisibility(View.INVISIBLE);
        enemyShip4.setVisibility(View.INVISIBLE);
        enemyShip5.setVisibility(View.INVISIBLE);
        enemyShip6.setVisibility(View.INVISIBLE);
        enemyShip7.setVisibility(View.INVISIBLE);
        enemyShip8.setVisibility(View.INVISIBLE);

        eBullet1ForEnemyShip1.setVisibility(View.INVISIBLE);
        eBullet2ForEnemyShip1.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip2.setVisibility(View.INVISIBLE);
        eBullet2ForEnemyShip2.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip3.setVisibility(View.INVISIBLE);
        eBullet2ForEnemyShip3.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip4.setVisibility(View.INVISIBLE);
        eBullet2ForEnemyShip4.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip5.setVisibility(View.INVISIBLE);
        eBullet2ForEnemyShip5.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip6.setVisibility(View.INVISIBLE);
        eBullet2ForEnemyShip6.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip7.setVisibility(View.INVISIBLE);
        eBullet2ForEnemyShip7.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip8.setVisibility(View.INVISIBLE);
        eBullet2ForEnemyShip8.setVisibility(View.INVISIBLE);

    }

    public void enemyShipInvisible()
    {
        flagEnemyShip1=0;
        flagEnemyShip2=0;
        flagEnemyShip3=0;
        flagEnemyShip4=0;
        flagEnemyShip5=0;
        flagEnemyShip6=0;
        flagEnemyShip7=0;
        flagEnemyShip8=0;

        enemyShip1.setX(-300);  enemyShip1.setY(-300);
        enemyShip2.setX(-300);  enemyShip2.setY(-300);
        enemyShip3.setX(-300);  enemyShip3.setY(-300);
        enemyShip4.setX(-300);  enemyShip4.setY(-300);
        enemyShip5.setX(-300);  enemyShip5.setY(-300);
        enemyShip6.setX(-300);  enemyShip6.setY(-300);
        enemyShip7.setX(-300);  enemyShip7.setY(-300);
        enemyShip7.setX(-300);  enemyShip8.setY(-300);

        enemyShip1.setVisibility(View.INVISIBLE);
        enemyShip3.setVisibility(View.INVISIBLE);
        enemyShip3.setVisibility(View.INVISIBLE);
        enemyShip4.setVisibility(View.INVISIBLE);
        enemyShip5.setVisibility(View.INVISIBLE);
        enemyShip6.setVisibility(View.INVISIBLE);
        enemyShip7.setVisibility(View.INVISIBLE);
        enemyShip8.setVisibility(View.INVISIBLE);

    }

    public void enemyBulletInvisible()
    {
        flagEBullet1ForEnemyShip1=0; flagEBullet2ForEnemyShip1=0;
        flagEBullet1ForEnemyShip2=0; flagEBullet2ForEnemyShip2=0;
        flagEBullet1ForEnemyShip3=0; flagEBullet2ForEnemyShip3=0;
        flagEBullet1ForEnemyShip4=0; flagEBullet2ForEnemyShip4=0;
        flagEBullet1ForEnemyShip5=0; flagEBullet2ForEnemyShip5=0;
        flagEBullet1ForEnemyShip6=0; flagEBullet2ForEnemyShip6=0;
        flagEBullet1ForEnemyShip7=0; flagEBullet2ForEnemyShip7=0;
        flagEBullet1ForEnemyShip8=0; flagEBullet2ForEnemyShip8=0;


        eBullet1ForEnemyShip1.setX(-400);  eBullet1ForEnemyShip1.setY(-400);
        eBullet2ForEnemyShip1.setX(-400);  eBullet2ForEnemyShip1.setY(-400);

        eBullet1ForEnemyShip2.setX(-400);  eBullet1ForEnemyShip2.setY(-400);
        eBullet2ForEnemyShip2.setX(-400);  eBullet2ForEnemyShip2.setY(-400);

        eBullet1ForEnemyShip3.setX(-400);  eBullet1ForEnemyShip3.setY(-400);
        eBullet2ForEnemyShip3.setX(-400);  eBullet2ForEnemyShip3.setY(-400);

        eBullet1ForEnemyShip4.setX(-400);  eBullet1ForEnemyShip4.setY(-400);
        eBullet2ForEnemyShip4.setX(-400);  eBullet2ForEnemyShip4.setY(-400);

        eBullet1ForEnemyShip5.setX(-400);  eBullet1ForEnemyShip5.setY(-400);
        eBullet2ForEnemyShip5.setX(-400);  eBullet2ForEnemyShip5.setY(-400);

        eBullet1ForEnemyShip6.setX(-400);  eBullet1ForEnemyShip6.setY(-400);
        eBullet2ForEnemyShip6.setX(-400);  eBullet2ForEnemyShip6.setY(-400);

        eBullet1ForEnemyShip7.setX(-400);  eBullet1ForEnemyShip7.setY(-400);
        eBullet2ForEnemyShip7.setX(-400);  eBullet2ForEnemyShip7.setY(-400);

        eBullet1ForEnemyShip8.setX(-400);  eBullet1ForEnemyShip8.setY(-400);
        eBullet2ForEnemyShip8.setX(-400);  eBullet2ForEnemyShip8.setY(-400);


        eBullet1ForEnemyShip1.setVisibility(View.INVISIBLE);  eBullet2ForEnemyShip1.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip2.setVisibility(View.INVISIBLE);  eBullet2ForEnemyShip2.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip3.setVisibility(View.INVISIBLE);  eBullet2ForEnemyShip3.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip4.setVisibility(View.INVISIBLE);  eBullet2ForEnemyShip4.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip5.setVisibility(View.INVISIBLE);  eBullet2ForEnemyShip5.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip6.setVisibility(View.INVISIBLE);  eBullet2ForEnemyShip6.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip7.setVisibility(View.INVISIBLE);  eBullet2ForEnemyShip7.setVisibility(View.INVISIBLE);
        eBullet1ForEnemyShip8.setVisibility(View.INVISIBLE);  eBullet2ForEnemyShip8.setVisibility(View.INVISIBLE);


    }

    public void gameOverPageActivity()
    {
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.stop();
        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.stop();
        if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.stop();

        gameOverPageCalledOrNot=1;

        gameOverPage.setVisibility(View.VISIBLE);

        if(myScore>time)myScoreFinalAtGameOver=myScore+(int)(myScore*1.5)-time;
        else if(myScore==0)myScoreFinalAtGameOver=myScore;
        else myScoreFinalAtGameOver=myScore+50;

        myScoreFinalAtGameOverTextView.setText(myScoreFinalAtGameOver+"");
    }

    public void enterYourNameOKButtonClickAction(View v)
    {
       // threadForGameOverShow();
        enterMyNameOkButtonClickCounter++;
        if(myNameEditText.getText().toString().trim().length()>0)myNameIsEnteredOrNo=1;
        else myNameIsEnteredOrNo=0;

        if(myNameIsEnteredOrNo==0)Toast.makeText(getApplicationContext(), "Enter Your Name First", Toast.LENGTH_LONG).show();
        else if(myNameIsEnteredOrNo==1 )//&& enterMyNameOkButtonClickCounter==1)
        {
            databaseHandlerForScoresManager.insertScoresData(new ScoresManager(myNameEditText.getText().toString(),
                    myScoreFinalAtGameOver,myScoreFinalAtGameOver));
            Toast.makeText(getApplicationContext(), ""+myNameEditText.getText()+", your score is saved", Toast.LENGTH_SHORT).show();
           // threadForGameOverShow();
            finish();

            Intent scores_intent=new Intent(this,ScoresActivity.class);
            startActivity(scores_intent);
            finish();
        }

    }

    public void myBulletSelection()
    {

        SettingsManager settingsManagerObject=dataBaseHandlerForSettingsManager.getAllSettingsData(1);

            if(flagMyBullet1==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet1=1;  xMyBullet1=xMyBullet;  yMyBullet1=yMyBullet;
                myBullet1.setVisibility(View.VISIBLE); }

            else if(flagMyBullet2==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet2=1;  xMyBullet2=xMyBullet;  yMyBullet2=yMyBullet;
                myBullet2.setVisibility(View.VISIBLE); }

            else if(flagMyBullet3==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet3=1;  xMyBullet3=xMyBullet;  yMyBullet3=yMyBullet;
                myBullet3.setVisibility(View.VISIBLE); }

            else if(flagMyBullet4==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet4=1;  xMyBullet4=xMyBullet;  yMyBullet4=yMyBullet;
                myBullet4.setVisibility(View.VISIBLE); }

            else if(flagMyBullet5==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet5=1;  xMyBullet5=xMyBullet;  yMyBullet5=yMyBullet;
                myBullet5.setVisibility(View.VISIBLE); }

            else if(flagMyBullet6==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet6=1;  xMyBullet6=xMyBullet;  yMyBullet6=yMyBullet;
                myBullet6.setVisibility(View.VISIBLE); }

            else if(flagMyBullet7==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet7=1;  xMyBullet7=xMyBullet;  yMyBullet7=yMyBullet;
                myBullet7.setVisibility(View.VISIBLE); }

            else if(flagMyBullet8==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet8=1;  xMyBullet8=xMyBullet;  yMyBullet8=yMyBullet;
                myBullet8.setVisibility(View.VISIBLE); }

            else if(flagMyBullet9==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet9=1;  xMyBullet9=xMyBullet;  yMyBullet9=yMyBullet;
                myBullet9.setVisibility(View.VISIBLE); }

            else if(flagMyBullet10==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet10=1;  xMyBullet10=xMyBullet;  yMyBullet10=yMyBullet;
                myBullet10.setVisibility(View.VISIBLE); }

            else if(flagMyBullet11==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet11=1;  xMyBullet11=xMyBullet;  yMyBullet11=yMyBullet;
                myBullet11.setVisibility(View.VISIBLE); }

            else if(flagMyBullet12==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet12=1;  xMyBullet12=xMyBullet;  yMyBullet12=yMyBullet;
                myBullet12.setVisibility(View.VISIBLE); }

            else if(flagMyBullet13==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet13=1;  xMyBullet13=xMyBullet;  yMyBullet13=yMyBullet;
                myBullet13.setVisibility(View.VISIBLE); }

            else if(flagMyBullet14==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet14=1;  xMyBullet14=xMyBullet;  yMyBullet14=yMyBullet;
                myBullet14.setVisibility(View.VISIBLE); }

            else if(flagMyBullet15==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet15=1;  xMyBullet15=xMyBullet;  yMyBullet15=yMyBullet;
                myBullet15.setVisibility(View.VISIBLE); }

            else if(flagMyBullet16==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet16=1;  xMyBullet16=xMyBullet;  yMyBullet16=yMyBullet;
                myBullet16.setVisibility(View.VISIBLE); }

            else if(flagMyBullet17==0){ if(settingsManagerObject.getGamingSound()==1)mediaPlayerBulletMyPlayer.start();
                flagMyBullet17=1;  xMyBullet17=xMyBullet;  yMyBullet17=yMyBullet;
                myBullet17.setVisibility(View.VISIBLE); }


    }


    public void myBulletVisibility()
    {
        if(flagMyBullet1==1){ myBullet1.setVisibility(View.VISIBLE); }
        else if(flagMyBullet1==0){ myBullet1.setX(-200);  myBullet1.setY(-200);  myBullet1.setVisibility(View.INVISIBLE); }

        if(flagMyBullet2==1){ myBullet2.setVisibility(View.VISIBLE); }
        else if(flagMyBullet2==0){ myBullet2.setX(-200);  myBullet2.setY(-200);  myBullet2.setVisibility(View.INVISIBLE); }

        if(flagMyBullet3==1){ myBullet3.setVisibility(View.VISIBLE); }
        else if(flagMyBullet3==0){ myBullet3.setX(-200);  myBullet3.setY(-200);  myBullet3.setVisibility(View.INVISIBLE); }

        if(flagMyBullet4==1){ myBullet4.setVisibility(View.VISIBLE); }
        else if(flagMyBullet4==0){ myBullet4.setX(-200);  myBullet4.setY(-200);  myBullet4.setVisibility(View.INVISIBLE); }

        if(flagMyBullet5==1){ myBullet5.setVisibility(View.VISIBLE); }
        else if(flagMyBullet5==0){ myBullet5.setX(-200);  myBullet5.setY(-200);  myBullet5.setVisibility(View.INVISIBLE); }

        if(flagMyBullet6==1){ myBullet6.setVisibility(View.VISIBLE); }
        else if(flagMyBullet6==0){ myBullet6.setX(-200);  myBullet6.setY(-200);  myBullet6.setVisibility(View.INVISIBLE); }

        if(flagMyBullet7==1){ myBullet7.setVisibility(View.VISIBLE); }
        else if(flagMyBullet7==0){ myBullet7.setX(-200);  myBullet7.setY(-200);  myBullet7.setVisibility(View.INVISIBLE); }

        if(flagMyBullet8==1){ myBullet8.setVisibility(View.VISIBLE); }
        else if(flagMyBullet8==0){ myBullet8.setX(-200);  myBullet8.setY(-200);  myBullet8.setVisibility(View.INVISIBLE); }

        if(flagMyBullet9==1){ myBullet9.setVisibility(View.VISIBLE); }
        else if(flagMyBullet9==0){ myBullet9.setX(-200);  myBullet9.setY(-200);  myBullet9.setVisibility(View.INVISIBLE); }

        if(flagMyBullet10==1){ myBullet10.setVisibility(View.VISIBLE); }
        else if(flagMyBullet10==0){ myBullet10.setX(-200);  myBullet10.setY(-200);  myBullet10.setVisibility(View.INVISIBLE); }

        if(flagMyBullet11==1){ myBullet11.setVisibility(View.VISIBLE); }
        else if(flagMyBullet11==0){ myBullet11.setX(-200);  myBullet11.setY(-200);  myBullet11.setVisibility(View.INVISIBLE); }

        if(flagMyBullet12==1){ myBullet12.setVisibility(View.VISIBLE); }
        else if(flagMyBullet12==0){ myBullet12.setX(-200);  myBullet12.setY(-200);  myBullet12.setVisibility(View.INVISIBLE); }

        if(flagMyBullet13==1){ myBullet13.setVisibility(View.VISIBLE); }
        else if(flagMyBullet13==0){ myBullet13.setX(-200);  myBullet13.setY(-200);  myBullet13.setVisibility(View.INVISIBLE); }

        if(flagMyBullet14==1){ myBullet14.setVisibility(View.VISIBLE); }
        else if(flagMyBullet14==0){ myBullet14.setX(-200);  myBullet14.setY(-200);  myBullet14.setVisibility(View.INVISIBLE); }

        if(flagMyBullet15==1){ myBullet15.setVisibility(View.VISIBLE); }
        else if(flagMyBullet15==0){ myBullet15.setX(-200);  myBullet15.setY(-200);  myBullet15.setVisibility(View.INVISIBLE); }

        if(flagMyBullet16==1){ myBullet16.setVisibility(View.VISIBLE); }
        else if(flagMyBullet16==0){ myBullet16.setX(-200);  myBullet16.setY(-200);  myBullet16.setVisibility(View.INVISIBLE); }

        if(flagMyBullet17==1){ myBullet17.setVisibility(View.VISIBLE); }
        else if(flagMyBullet17==0){ myBullet17.setX(-200);  myBullet17.setY(-200);  myBullet17.setVisibility(View.INVISIBLE); }

        //special bullet
        if(flagMyBullet18==1){ myBullet18.setVisibility(View.VISIBLE); }
        else if(flagMyBullet18==0){ myBullet18.setX(-200);  myBullet18.setY(-200);  myBullet18.setVisibility(View.INVISIBLE); }

        if(flagMyBullet19==1){ myBullet19.setVisibility(View.VISIBLE); }
        else if(flagMyBullet19==0){ myBullet19.setX(-200);  myBullet19.setY(-200);  myBullet19.setVisibility(View.INVISIBLE); }

        if(flagMyBullet20==1){ myBullet20.setVisibility(View.VISIBLE); }
        else if(flagMyBullet20==0){ myBullet20.setX(-200);  myBullet20.setY(-200);  myBullet20.setVisibility(View.INVISIBLE); }

        if(flagMyBullet21==1){ myBullet21.setVisibility(View.VISIBLE); }
        else if(flagMyBullet21==0){ myBullet21.setX(-200);  myBullet21.setY(-200);  myBullet21.setVisibility(View.INVISIBLE); }

        if(flagMyBullet22==1){ myBullet22.setVisibility(View.VISIBLE); }
        else if(flagMyBullet22==0){ myBullet22.setX(-200);  myBullet22.setY(-200);  myBullet22.setVisibility(View.INVISIBLE); }

        if(flagMyBullet23==1){ myBullet23.setVisibility(View.VISIBLE); }
        else if(flagMyBullet23==0){ myBullet23.setX(-200);  myBullet23.setY(-200);  myBullet23.setVisibility(View.INVISIBLE); }


    }


    public void myBulletInvisible()
    {
        flagMyBullet1=0;
        flagMyBullet2=0;
        flagMyBullet3=0;
        flagMyBullet4=0;
        flagMyBullet5=0;
        flagMyBullet6=0;
        flagMyBullet7=0;
        flagMyBullet8=0;
        flagMyBullet9=0;
        flagMyBullet10=0;
        flagMyBullet11=0;
        flagMyBullet12=0;
        flagMyBullet13=0;
        flagMyBullet14=0;
        flagMyBullet15=0;
        flagMyBullet16=0;
        flagMyBullet17=0;

        myBullet1.setX(-200);  myBullet1.setY(-200);
        myBullet2.setX(-200);  myBullet2.setY(-200);
        myBullet3.setX(-200);  myBullet3.setY(-200);
        myBullet4.setX(-200);  myBullet4.setY(-200);
        myBullet5.setX(-200);  myBullet5.setY(-200);
        myBullet6.setX(-200);  myBullet6.setY(-200);
        myBullet7.setX(-200);  myBullet7.setY(-200);
        myBullet8.setX(-200);  myBullet8.setY(-200);
        myBullet9.setX(-200);  myBullet9.setY(-200);
        myBullet10.setX(-200);  myBullet10.setY(-200);
        myBullet11.setX(-200);  myBullet11.setY(-200);
        myBullet12.setX(-200);  myBullet12.setY(-200);
        myBullet13.setX(-200);  myBullet13.setY(-200);
        myBullet14.setX(-200);  myBullet14.setY(-200);
        myBullet15.setX(-200);  myBullet15.setY(-200);
        myBullet16.setX(-200);  myBullet16.setY(-200);
        myBullet17.setX(-200);  myBullet17.setY(-200);

        myBullet1.setVisibility(View.INVISIBLE);
        myBullet2.setVisibility(View.INVISIBLE);
        myBullet3.setVisibility(View.INVISIBLE);
        myBullet4.setVisibility(View.INVISIBLE);
        myBullet5.setVisibility(View.INVISIBLE);
        myBullet6.setVisibility(View.INVISIBLE);
        myBullet7.setVisibility(View.INVISIBLE);
        myBullet8.setVisibility(View.INVISIBLE);
        myBullet9.setVisibility(View.INVISIBLE);
        myBullet10.setVisibility(View.INVISIBLE);
        myBullet11.setVisibility(View.INVISIBLE);
        myBullet12.setVisibility(View.INVISIBLE);
        myBullet13.setVisibility(View.INVISIBLE);
        myBullet14.setVisibility(View.INVISIBLE);
        myBullet15.setVisibility(View.INVISIBLE);
        myBullet16.setVisibility(View.INVISIBLE);
        myBullet17.setVisibility(View.INVISIBLE);


    }


    public void enemyShipVisibility()
    {
        if(flagEnemyShip1==1){ enemyShip1.setVisibility(View.VISIBLE); }
        else if(flagEnemyShip1==0){ enemyShip1.setX(-300);  enemyShip1.setY(-300);  enemyShip1.setVisibility(View.INVISIBLE); }

        if(flagEnemyShip2==1){ enemyShip2.setVisibility(View.VISIBLE); }
        else if(flagEnemyShip2==0){ enemyShip2.setX(-300);  enemyShip2.setY(-300);  enemyShip2.setVisibility(View.INVISIBLE); }

        if(flagEnemyShip3==1){ enemyShip3.setVisibility(View.VISIBLE); }
        else if(flagEnemyShip3==0){ enemyShip3.setX(-300);  enemyShip3.setY(-300);  enemyShip3.setVisibility(View.INVISIBLE); }

        if(flagEnemyShip4==1){ enemyShip4.setVisibility(View.VISIBLE); }
        else if(flagEnemyShip4==0){ enemyShip4.setX(-300);  enemyShip4.setY(-300);  enemyShip4.setVisibility(View.INVISIBLE); }

        if(flagEnemyShip5==1){ enemyShip5.setVisibility(View.VISIBLE); }
        else if(flagEnemyShip5==0){ enemyShip5.setX(-300);  enemyShip5.setY(-300);  enemyShip5.setVisibility(View.INVISIBLE); }

        if(flagEnemyShip6==1){ enemyShip6.setVisibility(View.VISIBLE); }
        else if(flagEnemyShip6==0){ enemyShip6.setX(-300);  enemyShip6.setY(-300);  enemyShip6.setVisibility(View.INVISIBLE); }

        if(flagEnemyShip7==1){ enemyShip7.setVisibility(View.VISIBLE); }
        else if(flagEnemyShip7==0){ enemyShip7.setX(-300);  enemyShip7.setY(-300);  enemyShip7.setVisibility(View.INVISIBLE); }

        if(flagEnemyShip8==1){ enemyShip8.setVisibility(View.VISIBLE); }
        else if(flagEnemyShip8==0){ enemyShip8.setX(-300);  enemyShip8.setY(-300);  enemyShip8.setVisibility(View.INVISIBLE); }


    }

    public void enemyShipVisibility4()
    {int i=0;

        if(flagEnemyShip1==0){ enemyShip1.setX(0);  enemyShip1.setY(0);
            enemyShip1.setVisibility(View.VISIBLE); }
        if(flagEnemyShip2==0){ enemyShip2.setX(0);  enemyShip2.setY(0);
            enemyShip2.setVisibility(View.VISIBLE); }
        if(flagEnemyShip3==0){ enemyShip3.setX(0);  enemyShip3.setY(0);
            enemyShip3.setVisibility(View.VISIBLE); }
        if(flagEnemyShip4==0){// enemyShip4.setX(200);  enemyShip4.setY(500);
            enemyShip4.setVisibility(View.VISIBLE); }
        if(flagEnemyShip5==0){// enemyShip5.setX(200);  enemyShip5.setY(500);
            enemyShip5.setVisibility(View.VISIBLE); }
        if(flagEnemyShip6==0){// enemyShip6.setX(200);  enemyShip6.setY(500);
            enemyShip6.setVisibility(View.VISIBLE); }
        if(flagEnemyShip7==0){// enemyShip7.setX(200);  enemyShip7.setY(500);
            enemyShip7.setVisibility(View.VISIBLE); }
        if(flagEnemyShip8==0){// enemyShip8.setX(200);  enemyShip8.setY(500);
            enemyShip8.setVisibility(View.VISIBLE); }

    }


    public void enemyBulletVisibility()
    {
        if(flagEBullet1ForEnemyShip1==1){ eBullet1ForEnemyShip1.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForEnemyShip1==0){ eBullet1ForEnemyShip1.setX(-400);  eBullet1ForEnemyShip1.setY(-400);  eBullet1ForEnemyShip1.setVisibility(View.INVISIBLE); }
        if(flagEBullet2ForEnemyShip1==1){ eBullet2ForEnemyShip1.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForEnemyShip1==0){ eBullet2ForEnemyShip1.setX(-400);  eBullet2ForEnemyShip1.setY(-400);  eBullet2ForEnemyShip1.setVisibility(View.INVISIBLE); }

        if(flagEBullet1ForEnemyShip2==1){ eBullet1ForEnemyShip2.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForEnemyShip2==0){ eBullet1ForEnemyShip2.setX(-400);  eBullet1ForEnemyShip2.setY(-400);  eBullet1ForEnemyShip2.setVisibility(View.INVISIBLE); }
        if(flagEBullet2ForEnemyShip2==1){ eBullet2ForEnemyShip2.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForEnemyShip2==0){ eBullet2ForEnemyShip2.setX(-400);  eBullet2ForEnemyShip2.setY(-400);  eBullet2ForEnemyShip2.setVisibility(View.INVISIBLE); }

        if(flagEBullet1ForEnemyShip3==1){ eBullet1ForEnemyShip3.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForEnemyShip3==0){ eBullet1ForEnemyShip3.setX(-400);  eBullet1ForEnemyShip3.setY(-400);  eBullet1ForEnemyShip3.setVisibility(View.INVISIBLE); }
        if(flagEBullet2ForEnemyShip3==1){ eBullet2ForEnemyShip3.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForEnemyShip3==0){ eBullet2ForEnemyShip3.setX(-400);  eBullet2ForEnemyShip3.setY(-400);  eBullet2ForEnemyShip3.setVisibility(View.INVISIBLE); }

        if(flagEBullet1ForEnemyShip4==1){ eBullet1ForEnemyShip4.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForEnemyShip4==0){ eBullet1ForEnemyShip4.setX(-400);  eBullet1ForEnemyShip4.setY(-400);  eBullet1ForEnemyShip4.setVisibility(View.INVISIBLE); }
        if(flagEBullet2ForEnemyShip4==1){ eBullet2ForEnemyShip4.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForEnemyShip4==0){ eBullet2ForEnemyShip4.setX(-400);  eBullet2ForEnemyShip4.setY(-400);  eBullet2ForEnemyShip4.setVisibility(View.INVISIBLE); }

        if(flagEBullet1ForEnemyShip5==1){ eBullet1ForEnemyShip5.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForEnemyShip5==0){ eBullet1ForEnemyShip5.setX(-400);  eBullet1ForEnemyShip5.setY(-400);  eBullet1ForEnemyShip5.setVisibility(View.INVISIBLE); }
        if(flagEBullet2ForEnemyShip5==1){ eBullet2ForEnemyShip5.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForEnemyShip5==0){ eBullet2ForEnemyShip5.setX(-400);  eBullet2ForEnemyShip5.setY(-400);  eBullet2ForEnemyShip5.setVisibility(View.INVISIBLE); }

        if(flagEBullet1ForEnemyShip6==1){ eBullet1ForEnemyShip6.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForEnemyShip6==0){ eBullet1ForEnemyShip6.setX(-400);  eBullet1ForEnemyShip6.setY(-400);  eBullet1ForEnemyShip6.setVisibility(View.INVISIBLE); }
        if(flagEBullet2ForEnemyShip6==1){ eBullet2ForEnemyShip6.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForEnemyShip6==0){ eBullet2ForEnemyShip6.setX(-400);  eBullet2ForEnemyShip6.setY(-400);  eBullet2ForEnemyShip6.setVisibility(View.INVISIBLE); }

        if(flagEBullet1ForEnemyShip7==1){ eBullet1ForEnemyShip7.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForEnemyShip7==0){ eBullet1ForEnemyShip7.setX(-400);  eBullet1ForEnemyShip7.setY(-400);  eBullet1ForEnemyShip7.setVisibility(View.INVISIBLE); }
        if(flagEBullet2ForEnemyShip7==1){ eBullet2ForEnemyShip7.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForEnemyShip7==0){ eBullet2ForEnemyShip7.setX(-400);  eBullet2ForEnemyShip7.setY(-400);  eBullet2ForEnemyShip7.setVisibility(View.INVISIBLE); }

        if(flagEBullet1ForEnemyShip8==1){ eBullet1ForEnemyShip8.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForEnemyShip8==0){ eBullet1ForEnemyShip8.setX(-400);  eBullet1ForEnemyShip8.setY(-400);  eBullet1ForEnemyShip8.setVisibility(View.INVISIBLE); }
        if(flagEBullet2ForEnemyShip8==1){ eBullet2ForEnemyShip8.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForEnemyShip8==0){ eBullet2ForEnemyShip8.setX(-400);  eBullet2ForEnemyShip8.setY(-400);  eBullet2ForEnemyShip8.setVisibility(View.INVISIBLE); }



    }


    public void enemyBossBulletVisibility()
    {
        if(flagEBullet1ForBoss==1){ eBullet1ForBoss.setVisibility(View.VISIBLE); }
        else if(flagEBullet1ForBoss==0){ eBullet1ForBoss.setX(-700);  eBullet1ForBoss.setY(-700);  eBullet1ForBoss.setVisibility(View.INVISIBLE); }

        if(flagEBullet2ForBoss==1){ eBullet2ForBoss.setVisibility(View.VISIBLE); }
        else if(flagEBullet2ForBoss==0){ eBullet2ForBoss.setX(-700);  eBullet2ForBoss.setY(-700);  eBullet2ForBoss.setVisibility(View.INVISIBLE); }

        if(flagEBullet3ForBoss==1){ eBullet3ForBoss.setVisibility(View.VISIBLE); }
        else if(flagEBullet3ForBoss==0){ eBullet3ForBoss.setX(-700);  eBullet3ForBoss.setY(-700);  eBullet3ForBoss.setVisibility(View.INVISIBLE); }

        if(flagEBullet4ForBoss==1){ eBullet4ForBoss.setVisibility(View.VISIBLE); }
        else if(flagEBullet4ForBoss==0){ eBullet4ForBoss.setX(-700);  eBullet4ForBoss.setY(-700);  eBullet4ForBoss.setVisibility(View.INVISIBLE); }

        if(flagEBullet5ForBoss==1){ eBullet5ForBoss.setVisibility(View.VISIBLE); }
        else if(flagEBullet5ForBoss==0){ eBullet5ForBoss.setX(-700);  eBullet5ForBoss.setY(-700);  eBullet5ForBoss.setVisibility(View.INVISIBLE); }

        if(flagEBullet6ForBoss==1){ eBullet6ForBoss.setVisibility(View.VISIBLE); }
        else if(flagEBullet6ForBoss==0){ eBullet6ForBoss.setX(-700);  eBullet6ForBoss.setY(-700);  eBullet6ForBoss.setVisibility(View.INVISIBLE); }

        if(flagEBullet7ForBoss==1){ eBullet7ForBoss.setVisibility(View.VISIBLE); }
        else if(flagEBullet7ForBoss==0){ eBullet7ForBoss.setX(-700);  eBullet7ForBoss.setY(-700);  eBullet7ForBoss.setVisibility(View.INVISIBLE); }


    }


    public void test(View v)
    {
       // t++;
        enemyBulletVisibility();
        myBulletVisibility();
        enemyBulletVisibility();

        if(gameOverDetector==0 && move==1)
        {
            move=0;
            tempYBg1=yBg1;
            tempYBg2=yBg2;

            SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
            if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.pause();
           // if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.pause();
          //  if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.pause();

            pLayPauseButton.setText("PLAY");

        }
        else if(gameOverDetector==0 && move==0)
        {
            SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
            if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.start();
            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();

            pLayPauseButton.setText("PAUSE");

            yBg1=tempYBg1;
            yBg2=tempYBg2;
            move=1;

            //component_move();
            if(flagBossCame==0)component_move();
            else if(flagBossCame==1 && flagForContinueGameWhenBossCome==1)componentsMoveWhenAllEnemiesDestroyedExceptBoss();


        }


    }



    public float randomXPosition()
    {
        float number=-10+(float)(Math.random()*(screenWidth+10));
        return number;
    }


    public int randomEnemyShipSelectionForHorizontalMove()
    {
        int enemyShipNumber=0;

        enemyShipNumber=1+(int)(Math.random()*8);

        return enemyShipNumber;
    }


    public int randomEnemyBossShipMoveHorizontallyOrNot()
    {
        int randomNumber=(int)(Math.random()*1000);
        int yesOrNot=randomNumber%2;

        return yesOrNot;
    }


    public int randomEnemyShipLeftRightMoveSelector()
    {
        int randomNumber=(int)(Math.random()*1000);
        int leftOrRight=randomNumber%2;

        return leftOrRight;
    }



    public float enemyXPosition(float enemyShipNumber)
    {
        float xEnemyShip=randomXPosition();

        try {

            if (enemyShipNumber == 1) {
                //while ((xEnemyShip >= xEnemyShip7 - 20 && xEnemyShip <= xEnemyShip7 + 20) || (xEnemyShip >= xEnemyShip8 - 20 && xEnemyShip <= xEnemyShip8 + 20))
                {
                    xEnemyShip = randomXPosition();
                }
            }

            if (enemyShipNumber == 2) {
                //while ((xEnemyShip >= xEnemyShip1 - 20 && xEnemyShip <= xEnemyShip1 + 20) || (xEnemyShip >= xEnemyShip8 - 20 && xEnemyShip <= xEnemyShip8 + 20))
                {
                    xEnemyShip = randomXPosition();
                }
            }

            if (enemyShipNumber == 3) {
                //while ((xEnemyShip >= xEnemyShip1 - 20 && xEnemyShip <= xEnemyShip1 + 20) || (xEnemyShip >= xEnemyShip2 - 20 && xEnemyShip <= xEnemyShip2 + 20))
                {
                    xEnemyShip = randomXPosition();
                }
            }

            if (enemyShipNumber == 4) {
                //while ((xEnemyShip >= xEnemyShip2 - 20 && xEnemyShip <= xEnemyShip2 + 20) || (xEnemyShip >= xEnemyShip3 - 20 && xEnemyShip <= xEnemyShip3 + 20))
                {
                    xEnemyShip = randomXPosition();
                }
            }

            if (enemyShipNumber == 5) {
                //while ((xEnemyShip >= xEnemyShip3 - 20 && xEnemyShip <= xEnemyShip3 + 20) || (xEnemyShip >= xEnemyShip4 - 20 && xEnemyShip <= xEnemyShip4 + 20))
                {
                    xEnemyShip = randomXPosition();
                }
            }

            if (enemyShipNumber == 6) {
                //while ((xEnemyShip >= xEnemyShip4 - 20 && xEnemyShip <= xEnemyShip4 + 20) || (xEnemyShip >= xEnemyShip5 - 20 && xEnemyShip <= xEnemyShip5 + 20))
                {
                    xEnemyShip = randomXPosition();
                }
            }

            if (enemyShipNumber == 7) {
                //while ((xEnemyShip >= xEnemyShip5 - 20 && xEnemyShip <= xEnemyShip5 + 20) || (xEnemyShip >= xEnemyShip6 - 20 && xEnemyShip <= xEnemyShip6 + 20))
                {
                    xEnemyShip = randomXPosition();
                }
            }

            if (enemyShipNumber == 8) {
                //while ((xEnemyShip >= xEnemyShip6 - 20 && xEnemyShip <= xEnemyShip6 + 20) || (xEnemyShip >= xEnemyShip7 - 20 && xEnemyShip <= xEnemyShip8 + 20))
                {
                    xEnemyShip = randomXPosition();
                }
            }

        }catch(Exception e)
        {
            System.out.println("enemyXPosition"+"my : "+e);
            Toast.makeText(getApplicationContext(), "enemyXPosition", Toast.LENGTH_LONG).show();

        }



 /*       if(enemyShipNumber!=1 && xEnemyShip>=xEnemyShip1-20 && xEnemyShip<=xEnemyShip1+20 )xEnemyShip=randomXPosition();
        if(enemyShipNumber!=2 && xEnemyShip>=xEnemyShip2-20 && xEnemyShip<=xEnemyShip2+20 )xEnemyShip=randomXPosition();
        if(enemyShipNumber!=3 && xEnemyShip>=xEnemyShip3-20 && xEnemyShip<=xEnemyShip3+20 )xEnemyShip=randomXPosition();
        if(enemyShipNumber!=4 && xEnemyShip>=xEnemyShip4-20 && xEnemyShip<=xEnemyShip4+20 )xEnemyShip=randomXPosition();
        if(enemyShipNumber!=5 && xEnemyShip>=xEnemyShip5-20 && xEnemyShip<=xEnemyShip5+20 )xEnemyShip=randomXPosition();
        if(enemyShipNumber!=6 && xEnemyShip>=xEnemyShip6-20 && xEnemyShip<=xEnemyShip6+20 )xEnemyShip=randomXPosition();
        if(enemyShipNumber!=7 && xEnemyShip>=xEnemyShip7-20 && xEnemyShip<=xEnemyShip7+20 )xEnemyShip=randomXPosition();
        if(enemyShipNumber!=8 && xEnemyShip>=xEnemyShip8-20 && xEnemyShip<=xEnemyShip8+20 )xEnemyShip=randomXPosition();
*/
        System.out.println(" myposotion"+enemyShipNumber +":"+xEnemyShip+" width "+(screenWidth-50));
        return xEnemyShip;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(gameOverDetector==0 && backButtonInterruptionDetectorWhileGamingAndPauseNeedDetector ==0 && flagForContinueGameWhenBossCome==1)
        {
            float xTouch,yTouch;

            xTouch=event.getX();
            yTouch=event.getY();

            //xMyShip=xTouch-(myShip.getWidth())/2;
            //yMyShip=yTouch-myShip.getHeight();

            // Toast.makeText(getApplicationContext(), "Touch positon: x="+xMyShip+"y="+yMyShip , Toast.LENGTH_LONG).show();

        //    xMyBullet=xTouch-8;
        //    yMyBullet=yMyShip+15;

     /*   if(move==0)
        {
            yBg1=tempYBg1;
            yBg2=tempYBg2;

            move=1;
            component_move();
        }*/

           // myShip.setX(xMyShip);
           // myShip.setY(yMyShip);

            int action = event.getAction();
            if(action==MotionEvent.ACTION_DOWN){ touchDownOrUp=1; }
            if(action==MotionEvent.ACTION_MOVE) touchDownOrUp=1;
            if(action==MotionEvent.ACTION_UP)touchDownOrUp=0;

          /*  if(action==MotionEvent.ACTION_DOWN)
            {
                xDownTemp=event.getX();
                yDownTemp=event.getY();

                if(xDownTemp>=xMyShip-20 && xDownTemp<=xMyShip+20 && yDownTemp>=yMyShip-20 && yDownTemp<=yMyShip+20){
                    touchDownOrUp=1;
                    matchDownAndUP=1;
                }
                else{
                    touchDownOrUp=0;
                    matchDownAndUP=0;
                }
            }
            if(action==MotionEvent.ACTION_MOVE)
            {
                if(matchDownAndUP==1)
                {
                    touchDownOrUp=1;
                    xTouch=event.getX();
                    yTouch=event.getY();

                }
                else touchDownOrUp=0;

            }
            if(action==MotionEvent.ACTION_UP)
            {
                touchDownOrUp=0;
                xUpTemp=event.getX();
                yUpTemp=event.getY();

                xMyShip=xUpTemp-(myShip.getWidth())/2;
                yMyShip=yUpTemp-myShip.getHeight();
            }*/

            touchToStartGamePage.setVisibility(View.INVISIBLE);

            if(gameOverDetector==0 && touchDownOrUp==1 && move==0)
            {
                move=1;

                pLayPauseButton.setVisibility(View.VISIBLE);
                touchToStartGamePage.setVisibility(View.INVISIBLE);
                flagForGameStarted=1;


                SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
                if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.start();
               // if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
               // if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();

                pLayPauseButton.setText("PAUSE");
                if(flagBossCame==0)component_move();
                else if(flagBossCame==1 )componentsMoveWhenAllEnemiesDestroyedExceptBoss();
            }

            if(touchDownOrUp==1)
            {
                xMyShip=xTouch-(myShip.getWidth())/2;
                yMyShip=yTouch-myShip.getHeight();

                xMyBullet=xTouch-8;
                yMyBullet=yMyShip+15;

                myShip.setX(xMyShip);
                myShip.setY(yMyShip);
            }


        }


        return super.onTouchEvent(event);
    }


    public void buttonLeaveGameClickAction(View v)
    {
        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.stop();
        finish();
        Toast.makeText(getApplicationContext(), "Your scores is not saved", Toast.LENGTH_SHORT).show();

    }

    public void buttonResumeGameClickAction(View v)
    {
        pLayPauseButton.setVisibility(View.VISIBLE);
        backButtonInterruptionDetectorWhileGamingAndPauseNeedDetector=0;
        move=1;

        backButtonInterruptionPageWhileGamingFrameLayout.setVisibility(View.INVISIBLE);

        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
        if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.start();

        //component_move();
        if(flagBossCame==0)component_move();
        else if(flagBossCame==1)componentsMoveWhenAllEnemiesDestroyedExceptBoss();


    }

    public void doNotSaveScoreClickAction(View v)
    {
        finish();
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
      //  super.dispatchTouchEvent(event);


        return super.dispatchTouchEvent(event);
    }



    @Override
    public void onRestart(){

        super.onRestart();








    }

    @Override
    public void onResume(){
        super.onResume();

        yBg1=tempYBg1;
        yBg2=tempYBg2;

        xMyShip=xMyShipTemp;
        yMyShip=yMyShipTemp;

       // SettingsManager settingsManagerObject=dataBaseHandlerForSettingsManager.getAllSettingsData(1);





     /*   if(gameOverDetector==0 && move==1)
        {
            if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.start();
          //  if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.start();
          // if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
        }

        else if(flagForOnPause==1 && move==0)
        {
            yBg1=tempYBg1;
            yBg2=tempYBg2;
            move=1;

            flagForOnPause=0;

            if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.start();
        }*/

      /*  yBg1=tempYBg1;
        yBg2=tempYBg2;

        SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);

        if(flagForGameStarted==1 && flagForOnPause==1 && gameOverDetector==0)
        {
            touchToStartGamePage.setVisibility(View.INVISIBLE);
            pLayPauseButton.setText("PAUSE");

            backButtonInterruptionDetectorWhileGamingAndPauseNeedDetector = 1;
            move = 0;

            //if (settingsManagerObject.getBackgroundMusic() == 1) mediaPlayerBackMusic.pause();

            pLayPauseButton.setVisibility(View.INVISIBLE);

            backButtonInterruptionPageWhileGamingFrameLayout.setVisibility(View.VISIBLE);

            flagForOnPause=0;
        }

       // else if

        if(myScore/7>30)touchToStartGamePage.setVisibility(View.INVISIBLE);*/


      //  Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onPause(){
        super.onPause();

        flagForOnPause=1;
        SettingsManager settingsManagerObject=dataBaseHandlerForSettingsManager.getAllSettingsData(1);

        tempYBg1=yBg1;
        tempYBg2=yBg2;

        xMyShipTemp=xMyShip;
        yMyShipTemp=yMyShip;

        move=0;


        pLayPauseButton.setVisibility(View.INVISIBLE);

        if(gameOverDetector==1 || backButtonInterruptionDetectorWhileGamingAndPauseNeedDetector==1)touchToStartGamePage.setVisibility(View.INVISIBLE);
        else touchToStartGamePage.setVisibility(View.VISIBLE);


        if( settingsManagerObject.getBackgroundMusic()==1)
        {
            mediaPlayerBackMusic.start();
            mediaPlayerBackMusic.pause();
        }
        if(settingsManagerObject.getGamingSound()==1)
        {
            mediaPlayerExplosionEnemy.start();
            mediaPlayerExplosionEnemy.pause();
            mediaPlayerExplosionMyPlayer.start();
            mediaPlayerExplosionMyPlayer.pause();
        }

       // if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.pause();
       // if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.pause();
       // if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.pause();



       // Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_LONG).show();
        //  setContentView(R.layout.startpage_layout);
        // onResume();

    }

    @Override
    public void onStop(){
        super.onStop();
       // move=0;
   // Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();



       // if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionEnemy.stop();
       // if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.stop();

        if(backButtonInterruptionDetectorWhileGamingAndPauseNeedDetector==0 && gameOverDetector==0 && move==1)
        {
            move=0;
            SettingsManager settingsManagerObject =dataBaseHandlerForSettingsManager.getAllSettingsData(1);
            if(settingsManagerObject.getBackgroundMusic()==1)mediaPlayerBackMusic.pause();

            backButtonInterruptionDetectorWhileGamingAndPauseNeedDetector=1;

            pLayPauseButton.setVisibility(View.INVISIBLE);

            backButtonInterruptionPageWhileGamingFrameLayout.setVisibility(View.VISIBLE);

        }

        else if(gameOverDetector==1 && gameOverPageCalledOrNot==1 && move==0)
        {
            //backButtonClickCounter++;

            if(myNameEditText.getText().toString().trim().length()>0 && backButtonClickCounter<2)
            {
                Toast.makeText(getApplicationContext(),""+myNameEditText.getText()+", Press 'OK' to save your score", Toast.LENGTH_LONG).show();
            }

            else if(myNameEditText.getText().toString().trim().length()==0 && backButtonClickCounter<2)
            {
                Toast.makeText(getApplicationContext(),"Enter your Name and Press 'OK' to save your score", Toast.LENGTH_LONG).show();
            }


        }
        else move=0;


      /*  if(gameOverDetector==1 && myNameIsEnteredOrNo==1 && enterMyNameOkButtonClickCounter>0)
        {
           // Toast.makeText(getApplicationContext(), "Enter Your Name and Press 'OK'", Toast.LENGTH_LONG).show();
          //  gameOverPageActivity();
           // onPause();

            move=0;

            if(myNameEditText.getText().toString().trim().length()>0)
            {
                databaseHandlerForScoresManager.insertScoresData(new ScoresManager(myNameEditText.getText().toString(),
                        myScoreFinalAtGameOver,myScoreFinalAtGameOver));

                Toast.makeText(getApplicationContext(), ""+myNameEditText.getText()+", your score is saved", Toast.LENGTH_SHORT).show();
            }

            else if(myNameEditText.getText().toString().trim().length()==0)
            {
                databaseHandlerForScoresManager.insertScoresData(new ScoresManager("Default Player",myScoreFinalAtGameOver,myScoreFinalAtGameOver));

                Toast.makeText(getApplicationContext(),"Your score is saved for Named 'Default Player' ", Toast.LENGTH_SHORT).show();
            }

            Intent scores_intent=new Intent(this,ZzDoNotNeedScoresActivityTest.class);
            startActivity(scores_intent);
        }
        else Toast.makeText(getApplicationContext(), "Your scores is not saved", Toast.LENGTH_LONG).show();*/



    }

    @Override
    public void finish(){
        super.finish();
    }


    public void bossBulletHitWithMyShip()
    {
        SettingsManager settingsManagerObject=dataBaseHandlerForSettingsManager.getAllSettingsData(1);

        //Action when eBulletsForBoss hit myShip

        //Action when eBullet1ForBoss hit myShip
        if(flagEBullet1ForBoss==1
                && xEBullet1ForBoss>=( xMyShip-eBullet1ForBoss.getWidth() )+2 && xEBullet1ForBoss+2<=xMyShip+myShip.getWidth()-5
                && yEBullet1ForBoss>=yMyShip+2 && yEBullet1ForBoss<=yMyShip+5){

            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
            flagEBullet1ForBoss=0; eBullet1ForBoss.setX(-700);  eBullet1ForBoss.setY(-700);
            eBullet1ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

        myLifeTextView.setText(myLife+"");


        //Action when eBullet2ForBoss hit myShip
        if(flagEBullet2ForBoss==1
                && xEBullet2ForBoss>=( xMyShip-eBullet2ForBoss.getWidth() )+2 && xEBullet2ForBoss+2<=xMyShip+myShip.getWidth()-5
                && yEBullet2ForBoss>=yMyShip+2 && yEBullet2ForBoss<=yMyShip+5){

            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
            flagEBullet2ForBoss=0; eBullet2ForBoss.setX(-700);  eBullet2ForBoss.setY(-700);
            eBullet2ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

        myLifeTextView.setText(myLife+"");


        //Action when eBullet3ForBoss hit myShip
        if(flagEBullet3ForBoss==1
                && xEBullet3ForBoss>=( xMyShip-eBullet3ForBoss.getWidth() )+2 && xEBullet3ForBoss+2<=xMyShip+myShip.getWidth()-5
                && yEBullet3ForBoss>=yMyShip+2 && yEBullet3ForBoss<=yMyShip+5){

            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
            flagEBullet3ForBoss=0; eBullet3ForBoss.setX(-700);  eBullet3ForBoss.setY(-700);
            eBullet3ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

        myLifeTextView.setText(myLife+"");


        //Action when eBullet4ForBoss hit myShip
        if(flagEBullet4ForBoss==1
                && xEBullet4ForBoss>=( xMyShip-eBullet4ForBoss.getWidth() )+2 && xEBullet4ForBoss+2<=xMyShip+myShip.getWidth()-5
                && yEBullet4ForBoss>=yMyShip+2 && yEBullet4ForBoss<=yMyShip+5){

            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
            flagEBullet4ForBoss=0; eBullet4ForBoss.setX(-700);  eBullet4ForBoss.setY(-700);
            eBullet4ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

        myLifeTextView.setText(myLife+"");


        //Action when eBullet5ForBoss hit myShip
        if(flagEBullet5ForBoss==1
                && xEBullet5ForBoss>=( xMyShip-eBullet5ForBoss.getWidth() )+2 && xEBullet5ForBoss+2<=xMyShip+myShip.getWidth()-5
                && yEBullet5ForBoss>=yMyShip+2 && yEBullet5ForBoss<=yMyShip+5){

            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
            flagEBullet5ForBoss=0; eBullet5ForBoss.setX(-700);  eBullet5ForBoss.setY(-700);
            eBullet5ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

        myLifeTextView.setText(myLife+"");


        //Action when eBullet6ForBoss hit myShip
        if(flagEBullet6ForBoss==1
                && xEBullet6ForBoss>=( xMyShip-eBullet6ForBoss.getWidth() )+2 && xEBullet6ForBoss+2<=xMyShip+myShip.getWidth()-5
                && yEBullet6ForBoss>=yMyShip+2 && yEBullet6ForBoss<=yMyShip+5){

            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
            flagEBullet6ForBoss=0; eBullet6ForBoss.setX(-700);  eBullet6ForBoss.setY(-700);
            eBullet6ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

        myLifeTextView.setText(myLife+"");


        //Action when eBullet7ForBoss hit myShip
        if(flagEBullet7ForBoss==1
                && xEBullet7ForBoss>=( xMyShip-eBullet7ForBoss.getWidth() )+2 && xEBullet7ForBoss+2<=xMyShip+myShip.getWidth()-5
                && yEBullet7ForBoss>=yMyShip+2 && yEBullet7ForBoss<=yMyShip+5){

            if(settingsManagerObject.getGamingSound()==1)mediaPlayerExplosionMyPlayer.start();
            flagEBullet7ForBoss=0; eBullet7ForBoss.setX(-700);  eBullet7ForBoss.setY(-700);
            eBullet7ForBoss.setVisibility(View.INVISIBLE);  if(myLife>0) myLife--;  enemyBossBulletVisibility(); }

        myLifeTextView.setText(myLife+"");




    }



    @Override
    protected void onUserLeaveHint(){

        tempYBg1=yBg1;
        tempYBg2=yBg2;
       // move=0;
        super.onUserLeaveHint();
       // Toast.makeText(getApplicationContext(), "onUserLeaveHint", Toast.LENGTH_LONG).show();

    }















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
       /* if (id == R.id.settings_in_PlayPage_in_Menu_id) {
            // System.exit(0);
            Intent settings_intent_from_Play_Activity=new Intent(this,SettingsActivity.class);
            startActivity(settings_intent_from_Play_Activity);
        }

        else if (id == R.id.scores_in_PlayPage_in_Menu_id) {
            // System.exit(0);
            Intent scores_intent_from_Play_Activity=new Intent(this,ScoresActivity.class);
            startActivity(scores_intent_from_Play_Activity);
        }

        else if (id == R.id.startpage_in_PlayPage_in_Menu_id) {
            // System.exit(0);
            Intent startpage_intent_from_Play_Activity=new Intent(this,MainActivityStartPageActivity.class);
            startActivity(startpage_intent_from_Play_Activity);
        }

        else move=1;*/

        return super.onOptionsItemSelected(item);
    }
}
