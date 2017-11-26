package com.tylerdarby.charactersheet.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.adapters.CharacterItemAdapter;

/**
 * Created by tdarby on 11/26/17.
 */

public class CharacterListFragment extends Fragment {

    private CharacterItemAdapter adapter;
    private String username;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_list, container, false);
        ListView listView = view.findViewById(R.id.characterList);
        listView.setAdapter(adapter);
        //TODO: get characters

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO: Load Character detail screen or favorite character
            }
        });

        return view;
    }

    private void getCharacters() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users/" + );
    }
}
