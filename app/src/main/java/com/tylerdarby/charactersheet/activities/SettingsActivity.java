package com.tylerdarby.charactersheet.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import com.tylerdarby.charactersheet.R;


public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String KEY_PREF_THEME = "themePref";
    private SharedPreferences pref;
    private String prefTheme;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        if(pref.getString("themePref","").equals("Light")) {
            setTheme(R.style.AppTheme);
        }
        else if(pref.getString("themePref","").equals("Dark")){
            setTheme(R.style.AppThemeDark);
        }
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        pref.registerOnSharedPreferenceChangeListener(this);
    }
    @Override
    public void onResume(){
        super.onResume();
        pref.registerOnSharedPreferenceChangeListener(this);
        prefTheme = pref.getString(KEY_PREF_THEME, "");
    }
    @Override
    public void onPause(){
        super.onPause();
        pref.unregisterOnSharedPreferenceChangeListener(this);
    }
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(KEY_PREF_THEME)) {
            ListPreference themePreference = (ListPreference) findPreference(KEY_PREF_THEME);
            if(themePreference.getEntry().equals("Light")){
                setTheme(R.style.AppTheme);
                themePreference.setValue("Light");
                //Intent intent = new Intent(getApplicationContext(), class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                //startActivity(intent);
            }
            else if(themePreference.getEntry().equals("Dark")){
                setTheme(R.style.AppThemeDark);
                themePreference.setValue("Dark");
                //Intent intent = new Intent(getApplicationContext(), information_activity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                //startActivity(intent);
            }
        }
    }
}