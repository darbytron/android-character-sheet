package com.tylerdarby.charactersheet.activities;

import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.fragments.CharacterListFragment;
import com.tylerdarby.charactersheet.utils.AppConstants;
import com.tylerdarby.charactersheet.utils.DataManager;


public class MainActivity extends AppCompatActivity{
    private DataManager dataManager;
    private DataReceiver dataReceiver;
    private final IntentFilter filter = new IntentFilter(AppConstants.BROADCAST_DM_UPDATE);

    private class DataReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateData();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.menu_settings:
                startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        super.onCreate(savedInstanceState);
        dataReceiver = new DataReceiver();
        if(pref.getString("themePref","").equals("Light")) {
            setTheme(R.style.AppTheme);
        }
        else if(pref.getString("themePref","").equals("Dark")){
            setTheme(R.style.AppThemeDark);
        }
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences(AppConstants.SHARED_PREF_KEY, Context.MODE_PRIVATE);
        String username = preferences.getString(AppConstants.USERNAME_KEY, "");
        dataManager = DataManager.getDataManager();
        if(username.isEmpty()) {
            startActivity(new Intent(getApplicationContext(), UserRegistration.class));
        } else {
            dataManager.getData(username);
        }
        updateData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(dataReceiver != null) {
            this.registerReceiver(dataReceiver, filter);
        }

    }

    @Override
    protected void onPause() {
        this.unregisterReceiver(dataReceiver);
        super.onPause();

    }

    private void updateData() {
        String username = dataManager.getUser().getUsername();
        TextView usernameView = (TextView) findViewById(R.id.usernameLabel);
        usernameView.setText(username);
        CharacterListFragment newFragment = new CharacterListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
