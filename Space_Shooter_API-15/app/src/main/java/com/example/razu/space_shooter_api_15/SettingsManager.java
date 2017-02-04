package com.example.razu.space_shooter_api_15;

/**
 * Created by rAZU on 31-Jan-15.
 */
public class SettingsManager {

    int _id;
    int _buttonSound=1;
    int _backgroundMusic=1;
    int _gamingSound=1;
    int _myShipNo=1;

    public SettingsManager() {
        this._id =1;
        this._buttonSound =1;
        this._backgroundMusic =1;
        this._gamingSound =1;
        this._myShipNo =1;
    }

    public SettingsManager(int _myShipNo) {
        this._myShipNo = _myShipNo;
    }

    public SettingsManager(int _id, int _myShipNo) {
        this._id = _id;
        this._myShipNo = _myShipNo;
    }

    public SettingsManager(int _buttonSound, int _backgroundMusic, int _gamingSound) {
        this._buttonSound = _buttonSound;
        this._backgroundMusic = _backgroundMusic;
        this._gamingSound = _gamingSound;
    }

    public SettingsManager(int _buttonSound, int _backgroundMusic, int _gamingSound, int _myShipNo) {
        this._buttonSound = _buttonSound;
        this._backgroundMusic = _backgroundMusic;
        this._gamingSound = _gamingSound;
        this._myShipNo = _myShipNo;
    }

    public SettingsManager(int _id, int _buttonSound,  int _backgroundMusic, int _gamingSound, int _myShipNo) {
        this._id = _id;
        this._buttonSound = _buttonSound;
        this._backgroundMusic = _backgroundMusic;
        this._gamingSound = _gamingSound;
        this._myShipNo = _myShipNo;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getButtonSound() {
        return _buttonSound;
    }

    public void setButtonSound(int _buttonSound) {
        this._buttonSound = _buttonSound;
    }

    public int getBackgroundMusic() {
        return _backgroundMusic;
    }

    public void setBackgroundMusic(int _backgroundMusic) {
        this._backgroundMusic = _backgroundMusic;
    }

    public int getGamingSound() {
        return _gamingSound;
    }

    public void setGamingSound(int _gamingSound) {
        this._gamingSound = _gamingSound;
    }

    public int getMyShipNo() {
        return _myShipNo;
    }

    public void setMyShipNo(int _myShipNo) {
        this._myShipNo = _myShipNo;
    }
}
