package com.example.razu.space_shooter_api_15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class AboutGameActivity extends Activity {

    DatabaseHandlerForScoresManager databaseHandlerForScoresManager=new DatabaseHandlerForScoresManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_game_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.instructions_in_About_GamePage_Menu_id) {

            finish();
            Intent instructions_intent_from_About_Game_Activity=new Intent(this,InstructionsActivity.class);
            startActivity(instructions_intent_from_About_Game_Activity);
        }

        else if (id == R.id.play_in_About_GamePage_in_Menu_id) {
            // onDestroy();
            finish();
            Intent play_intent_from_About_GameActivity=new Intent(this,PlayActivity.class);
            startActivity(play_intent_from_About_GameActivity);
        }

        else if (id == R.id.settings_in_About_GamePage_in_Menu_id) {
            // System.exit(0);
            finish();
            Intent settings_intent_from_About_GameActivity=new Intent(this,SettingsActivity.class);
            startActivity(settings_intent_from_About_GameActivity);
        }

        else if (id == R.id.scores_in_About_GamePage_in_Menu_id) {

            if(databaseHandlerForScoresManager.checkDatabaseIsEmptyOrNot()>0)
            {
                finish();
                Intent scores_intent=new Intent(this,ScoresActivity.class);
                startActivity(scores_intent);
            }
            else Toast.makeText(getApplicationContext(), "The game is not played yet", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.startpage_in_About_GamePage_in_Menu_id) {
            // System.exit(0);
            finish();
           // new MainActivityStartPageActivity().onRestart();
           // System.exit(0);
            //Intent startpage_intent_from_About_GameActivity=new Intent(this,MainActivityStartPageActivity.class);
            //startActivity(startpage_intent_from_About_GameActivity);
        }

        return super.onOptionsItemSelected(item);
    }
}
