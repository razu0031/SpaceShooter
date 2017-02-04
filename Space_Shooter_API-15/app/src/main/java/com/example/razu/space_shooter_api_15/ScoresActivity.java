package com.example.razu.space_shooter_api_15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class ScoresActivity extends Activity {

    DatabaseHandlerForScoresManager databaseHandlerForScoresManager=new DatabaseHandlerForScoresManager(this);

    TextView topScore;
    TextView lastPlayedScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores_layout);

        
        topScore=(TextView)findViewById(R.id.topScoreId);
        lastPlayedScore=(TextView)findViewById(R.id.lastPlayedScoreId);

        addDataToListView();

    }
    
    public void addDataToListView()
    {
        int totalRow=databaseHandlerForScoresManager.checkDatabaseIsEmptyOrNot();

        String[] playerNameStringArray=databaseHandlerForScoresManager.getAllPlayerName();
        String[] playerScoresStringArray=databaseHandlerForScoresManager.getAllPlayerScore();

        ListView scoresDataListView = (ListView) findViewById(R.id.listViewId);

        topScore.setText(playerScoresStringArray[0]);
        lastPlayedScore.setText(""+databaseHandlerForScoresManager.getScoresDataById(totalRow).getPlayerScore());

        
        ArrayList< HashMap< String,String > > scoresDataArrayList=new ArrayList<HashMap<String, String>>();
        
        HashMap<String,String> scoresDataHashMap;
        
        for(int i=0; i<totalRow; i++)
        {
            scoresDataHashMap=new HashMap<String, String>();
            
            scoresDataHashMap.put("PLAYER_SERIAL_NO_KEY" , ""+(i+1)+"." );
            scoresDataHashMap.put("PLAYER_NAME_KEY" , playerNameStringArray[i]);
            scoresDataHashMap.put("PLAYER_SCORES_KEY", playerScoresStringArray[i]);
            
            scoresDataArrayList.add(scoresDataHashMap);
        }

        String[] allScoresDataSource=new String[]{"PLAYER_SERIAL_NO_KEY", "PLAYER_NAME_KEY", "PLAYER_SCORES_KEY"};
        int[] allScoresDataDestination=new int[]{R.id.playerSerialNoId, R.id.playerNameId, R.id.playerScoreId};
        int resourceLayout=R.layout.scores_row_layout;

        SimpleAdapter scoresDataSimpleAdapter=new SimpleAdapter(this, scoresDataArrayList, resourceLayout, allScoresDataSource, allScoresDataDestination);

        scoresDataListView.setAdapter(scoresDataSimpleAdapter);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.instructions_in_ScoresPage_in_Menu_id) {
            finish();
            Intent instructions_intent_from_Scores_Activity=new Intent(this,InstructionsActivity.class);
            startActivity(instructions_intent_from_Scores_Activity);
        }

        else if (id == R.id.about_Game_in_ScoresPage_in_Menu_id) {
            finish();
            Intent aboutGame_intent_from_Scores_Activity=new Intent(this,AboutGameActivity.class);
            startActivity(aboutGame_intent_from_Scores_Activity);
        }

        else if (id == R.id.play_in_ScoresPage_in_Menu_id) {
            finish();
            Intent play_intent_from_Scores_Activity=new Intent(this,PlayActivity.class);
            startActivity(play_intent_from_Scores_Activity);
        }

        else if (id == R.id.settings_in_ScoresPage_in_Menu_id) {
            finish();
            Intent settings_intent_from_Scores_Activity=new Intent(this,SettingsActivity.class);
            startActivity(settings_intent_from_Scores_Activity);
        }

        else if (id == R.id.startpage_in_ScoresPage_in_Menu_id) {
            finish();
         }


        return super.onOptionsItemSelected(item);
    }
}
