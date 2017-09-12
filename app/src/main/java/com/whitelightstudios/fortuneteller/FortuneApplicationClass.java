package com.whitelightstudios.fortuneteller;

import android.app.Application;

/**
 * Created by Ed on 9/10/2017.
 */

public class FortuneApplicationClass extends Application {

    public Boolean getCustomName_state() {
        return customName_state;
    }

    public void setCustomName_state(Boolean customName_state) {
        this.customName_state = customName_state;
    }

    Boolean customName_state;

    public String getCustomName_string() {
        return customName_string;
    }

    public void setCustomName_string(String customName_string) {
        this.customName_string = customName_string;
    }

    String customName_string;

    @Override
    public void onCreate() {
        super.onCreate();

        setCustomName_state(false);
        setCustomName_string("Dave");
    }
}
