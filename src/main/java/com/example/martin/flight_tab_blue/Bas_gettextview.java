package com.example.martin.flight_tab_blue;

import android.widget.TextView;
import android.app.Activity;
import org.w3c.dom.Text;

/**
 * Created by Martin on 17.05.2017.
 */

public class Bas_gettextview extends Activity {
    static Activity activity;
    public Bas_gettextview (){

    }
    public Bas_gettextview (Activity myact){
        this.activity = myact;
    }

    public TextView get_textview_alt(){

        return  (TextView) this.activity.findViewById(R.id.textaltitude);
    }

    public TextView get_textview_speed(){

        return  (TextView) this.activity.findViewById(R.id.textspeed);
    }

    public TextView get_textview_poslat(){

        return  (TextView) this.activity.findViewById(R.id.textposlat);
    }

    public TextView get_textview_poslong(){

        return  (TextView) this.activity.findViewById(R.id.textposlong);
    }

    public TextView get_textview_heading(){

        return  (TextView) this.activity.findViewById(R.id.textheading);
    }

    public TextView get_textview_gpsspeed(){

        return  (TextView) this.activity.findViewById(R.id.textgpsspeed);
    }

    public TextView get_textview_bodypitchr(){

        return  (TextView) this.activity.findViewById(R.id.textbodypitchrate);
    }

    public TextView get_textview_bodyrollr(){

        return  (TextView) this.activity.findViewById(R.id.textbodyrollrate);
    }

    public TextView get_textview_bodyrolla(){

        return  (TextView) this.activity.findViewById(R.id.textbodyrollangle);
    }
}
