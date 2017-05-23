package com.example.martin.flight_tab_blue;

import android.media.AudioManager;
import android.media.ToneGenerator;

/**
 * Created by Martin on 10.04.2017.
 */

public class Bas_Sound {

    BA_get_Var BgV = new BA_get_Var();
    static ToneGenerator warning;


    public Bas_Sound(){
        warning = new ToneGenerator(AudioManager.STREAM_MUSIC,(int)(ToneGenerator.MAX_VOLUME * 0.8));
    }

    public void tone_warning(){

        if(BgV.get_speed() > 850)
        {
            warning.startTone(ToneGenerator.TONE_DTMF_2);
        }
        else
        {
            warning.stopTone();
        }


    }
}
