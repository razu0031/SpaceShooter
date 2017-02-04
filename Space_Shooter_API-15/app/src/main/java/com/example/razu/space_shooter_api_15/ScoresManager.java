package com.example.razu.space_shooter_api_15;

/**
 * Created by rAZU on 26-Jan-15.
 */
public class ScoresManager {

    int _id;
    String _playerName="";
    int _playerScore=0;
    int _lastPlayedScore=0;

    public ScoresManager() {
        
        _playerName="";
        _playerScore=0;
        _lastPlayedScore=0;
    }

    public ScoresManager(int _playerScore) {
        this._playerScore = _playerScore;
    }

    public ScoresManager(String _playerName, int _playerScore) {
        this._playerName = _playerName;
        this._playerScore = _playerScore;

    }

    public ScoresManager(String _playerName, int _playerScore, int _lastPlayedScore) {

        this._playerName = _playerName;
        this._playerScore = _playerScore;
        this._lastPlayedScore=_playerScore;
    }

    public ScoresManager( int _id, String _playerName, int _playerScore, int _lastPlayedScore) {
        this._id = _id;
        this._playerName = _playerName;
        this._playerScore = _playerScore;
        this._lastPlayedScore = _lastPlayedScore;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getPlayerName() {
        return _playerName;
    }

    public void setPlayerName(String _playerName) {
        this._playerName = _playerName;
    }

    public int getPlayerScore() {
        return _playerScore;
    }

    public void setPlayerScore(int _playerScore) {
        this._playerScore = _playerScore;
    }

    public int getLastPlayedScore() {
        return _lastPlayedScore;
    }

    public void setLastPlayedScore(int _lastPlayedScore) {
        this._lastPlayedScore = _lastPlayedScore;
    }
}
