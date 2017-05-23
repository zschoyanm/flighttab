package com.example.martin.flight_tab_blue;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.util.Set;
import java.util.TimerTask;
import java.util.Timer;
import java.lang.Runnable;


public class MainActivity extends Activity {
    Button b1,b2,b3,b4,b5;


    Timer timer = new Timer();
    TimerTask tt_c;
    int k=1;

    BA_Kanadia BA_K_C = new BA_Kanadia();
    Bas_Can_Kanadia Bas_Can = new Bas_Can_Kanadia();
    BA_get_Var BgV = new BA_get_Var();
    Bas_Color BC = new Bas_Color();
    Bas_gettextview Bgtv = new Bas_gettextview(this);
    Bas_Sound BS = new Bas_Sound();



    android.os.Handler handler = new android.os.Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        BA_K_C.post_ba();
        Bas_Can.init_bas_can(getApplicationContext());

    }

    public void do_timer_task(){
        tt_c = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run () {

                        BgV.update_data();

                        Bgtv.get_textview_alt().setText(Float.toString(BgV.get_altitude()));
                        Bgtv.get_textview_speed().setText(Float.toString(BgV.get_speed()));
                        Bgtv.get_textview_poslat().setText(Float.toString(BgV.get_pos_Lat()));
                        Bgtv.get_textview_poslong().setText(Float.toString(BgV.get_pos_Long()));
                        Bgtv.get_textview_heading().setText(Float.toString(BgV.get_Heading()));
                        Bgtv.get_textview_gpsspeed().setText(Float.toString(BgV.get_gps_speed()));
                        Bgtv.get_textview_bodypitchr().setText(Float.toString(BgV.get_body_pitch_rate()));
                        Bgtv.get_textview_bodyrollr().setText(Float.toString(BgV.get_body_roll_rate()));
                        Bgtv.get_textview_bodyrolla().setText(Float.toString(BgV.get_body_roll_angle()));

                        BC.change_color();
                        BS.tone_warning();



                    }
                });
            }
        };
        timer.schedule(tt_c,500,100);

    }



    public void on(View v)throws IOException{
        int ret_sta = BA_K_C.start_ba();
        if (ret_sta==1) {

            Toast.makeText(getApplicationContext(), "Turned on",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
        }

    }

    public void off(View v) throws Exception {
    try {
        BA_K_C.stop_ba();
        Toast.makeText(getApplicationContext(), "Stop Bluetooth ",Toast.LENGTH_LONG).show();
    }
    catch (IOException | NullPointerException poff){
        Toast.makeText(getApplicationContext(), "Bluetooth deaktiviert",Toast.LENGTH_LONG).show();
    }
    }

    public void start (View v) throws Exception{
    try {
        BA_K_C.paired_dev();
        Toast.makeText(getApplicationContext(), "Start Bluetooth",Toast.LENGTH_LONG).show();
    }
    catch (IOException | NullPointerException p){
        Toast.makeText(getApplicationContext(), "Bluetooth nicht gefunden",Toast.LENGTH_LONG).show();
    }

    }
    public void show(View v) throws NullPointerException{
        do_timer_task();
        Toast.makeText(getApplicationContext(), "Start Update ",Toast.LENGTH_LONG).show();
    }
    public void visible(View v){
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
    }
    public void stop(View v){
       tt_c.cancel();
        Toast.makeText(getApplicationContext(), "Stop Update ",Toast.LENGTH_LONG).show();
    }
    public Context getcont(){
        return getApplicationContext();
    }

}