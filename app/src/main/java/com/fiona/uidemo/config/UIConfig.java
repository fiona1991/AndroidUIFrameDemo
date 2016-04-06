package com.fiona.uidemo.config;

import android.content.Context;

/**
 * Created by chenfiona on 16/4/5.
 */
public class UIConfig {

    private static final String NAME = "UIConfig";
    private static final String XXX = "xxx";

    public static void saveXXX(Context context, String target){
        SaveConfig.saveSettings(context, NAME, XXX, target);

    }

    public static String getXXX(Context context){
        return SaveConfig.getSettingsString(context, NAME, XXX, "");
    }

}
