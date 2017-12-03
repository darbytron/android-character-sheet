package com.tylerdarby.charactersheet.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.Character;

/**
 * Created by tdarby on 11/26/17.
 */

public class CharacterItemAdapter extends ArrayAdapter<Character>{
    private int resourceId;

    public CharacterItemAdapter(Context context, int resourceId) {
        super(context, resourceId);
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Character character = getItem(position);
        View v;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(resourceId, null);
        } else {
            v = convertView;
        }

        TextView textView = v.findViewById(R.id.label);
        textView.setText(character.getName());
        //TODO: Make list prettier, add more character detail
        return v;
    }
}
