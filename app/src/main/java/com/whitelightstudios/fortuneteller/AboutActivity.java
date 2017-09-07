package com.whitelightstudios.fortuneteller;

import android.app.Activity;
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

        Bundle extras = getIntent().getExtras();

        TextView tv = (TextView)findViewById(R.id.textView_activity_about);
        tv.setText(extras.getString("Message"));
    }
}
