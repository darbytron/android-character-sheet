package com.tylerdarby.charactersheet.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.activities.CharacterDisplayActivity;
import com.tylerdarby.charactersheet.activities.CharacterEditDisplayActivity;
import com.tylerdarby.charactersheet.activities.CharacterSelect;
import com.tylerdarby.charactersheet.activities.DiceRoller;
import com.tylerdarby.charactersheet.activities.MainActivity;
import com.tylerdarby.charactersheet.activities.UserRegistration;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;

/**
 * Created by tdarby on 11/26/17.
 */

public class BottomNavigationFragment extends Fragment{
    private Context context;
    private String theme;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        theme = pref.getString("themePref","Light");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bottom_navigation, container, false);
        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper viewHelper = new BottomNavigationViewHelper();
        viewHelper.disableShiftMode(bottomNavigationView);
        if(theme.equals("Light")) {
            bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
        }
        else if(theme.equals("Dark")){
            bottomNavigationView.setItemBackgroundResource(R.color.frenchPuce);
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_new_char:
                                startActivity(new Intent(context, CharacterDisplayActivity.class));
                                break;
                            case R.id.action_dice:
                                startActivity(new Intent(context, CharacterEditDisplayActivity.class));
                                break;
                            case R.id.action_home:
                                startActivity(new Intent(context, MainActivity.class));
                                break;
                            case R.id.action_new_user:
                                startActivity(new Intent(context, UserRegistration.class));
                                break;
                            case R.id.action_search:
                                //TODO: search activity
                                startActivity(new Intent(context, CharacterSelect.class));
                                break;
                        }
                        return false;
                    }
                });
        return v;
    }
}