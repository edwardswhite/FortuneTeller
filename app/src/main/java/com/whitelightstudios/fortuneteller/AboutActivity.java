package com.whitelightstudios.fortuneteller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Ed on 9/7/2017.
 */

public class AboutActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tv = (TextView)findViewById(R.id.textView_activity_about);


        String receivedAction = getIntent().getAction();

        if(receivedAction != null){
            //Action detected.
            //Must be incoming IMPLICIT intent from other app

            String receivedActionType = getIntent().getType();

            if(receivedActionType.startsWith("text/")){
                //tv.setText("Text ACTION detected! Arrived via IMPLICIT intent");
                String data = getIntent().getStringExtra(Intent.EXTRA_TEXT);
                tv.setText(data);
            }
        }else{
            //NO Action detected.
            //Explicit internal request from app

                //tv.setText("Explicit intent detected.");
            Bundle extras = getIntent().getExtras();
            tv.setText(extras.getString("Message"));
        }
    }
}
