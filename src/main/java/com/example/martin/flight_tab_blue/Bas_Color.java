package com.example.martin.flight_tab_blue;
import android.app.Activity;
import android.graphics.Color;

import android.widget.TextView;

/**
 * Created by Martin on 08.05.2017.
 */

public class Bas_Color  {
    BA_get_Var BgV = new BA_get_Var();
    Bas_gettextview Bgtv = new Bas_gettextview();

    public void change_color(){
        if(BgV.get_altitude()>1500){
            Bgtv.get_textview_alt().setTextColor(Color.RED);
        }
        else{
            Bgtv.get_textview_alt().setTextColor(Color.GREEN);
        }

        if(BgV.get_speed()>400){
            Bgtv.get_textview_speed().setTextColor(Color.RED);
        }
        else{
            Bgtv.get_textview_speed().setTextColor(Color.GREEN);
        }

        if(BgV.get_gps_speed()>400){
            Bgtv.get_textview_gpsspeed().setTextColor(Color.RED);
        }else{
            Bgtv.get_textview_gpsspeed().setTextColor(Color.GREEN);
        }

    }


}
