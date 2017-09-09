package com.whitelightstudios.fortuneteller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends Activity {

    Switch sw_switchName;
    EditText et_editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sw_switchName=(Switch)findViewById(R.id.settings_switchName);
        et_editTextName=(EditText)findViewById(R.id.settings_editTextName);


    }

    public void onSwitchCustomClick(View view){
        Toast.makeText(getApplicationContext(), "Custom name switched", Toast.LENGTH_SHORT).show();
    }
}