package com.tylerdarby.charactersheet.utils;

/**
 * Created by tdarby on 11/26/17.
 */

public class AppConstants {

    public static final String SHARED_PREF_KEY = "APP_PREFERENCES";
    public static final String USERNAME_KEY = "USER_NAME";
    public static final String BROADCAST_DM_UPDATE = "com.tylerdarby.charactersheet.utils.DataManager.UPDATE";
    public static final String CHARACTER_ID = "CHARACTER_ID";
    private AppConstants(){
        throw new AssertionError();
    }
}
