package com.whitelightstudios.fortuneteller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends Activity {

    Switch switchName;
    // private EditText editText_editTextName;

    protected FortuneApplicationClass app;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("SettingsActivity","On Create");
        setContentView(R.layout.activity_settings);

        app=(FortuneApplicationClass)getApplication();

        switchName=(Switch)findViewById(R.id.settings_switchName);
       // editText_editTextName=(EditText)findViewById(R.id.settings_editTextName);

        if(app.getCustomName_state()){
            switchName.setChecked(true);
        }else {
            switchName.setChecked(false);
        }
        switchName.setOnCheckedChangeListener(

                new CompoundButton.OnCheckedChangeListener()
                {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if(isChecked){
                            Toast.makeText(getApplicationContext(), "Custom name turned On", Toast.LENGTH_SHORT).show();
                            app.setCustomName_state(true);
                        }else {
                            Toast.makeText(getApplicationContext(), "Custom name turned Off", Toast.LENGTH_SHORT).show();
                            app.setCustomName_state(false);
                        }

                    }
                }
        );


    }


}