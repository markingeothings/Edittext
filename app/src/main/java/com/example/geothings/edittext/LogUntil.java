package com.example.geothings.edittext;

import android.util.Log;

/**
 * Created by GeoThings on 2016/10/6.
 */

public class LogUntil {
    private static final String APP_TAG = "aaa";
    public static int logString(String message){
        return Log.i(APP_TAG,message);
    }
}
