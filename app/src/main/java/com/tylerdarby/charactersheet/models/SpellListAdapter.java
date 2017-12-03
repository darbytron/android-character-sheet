package com.tylerdarby.charactersheet.models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;

import java.util.List;

/**
 * Created by savio_000 on 11/8/2017.
 */

// Custom adapter for the recyclerview using our own xml layout
public class SpellListAdapter extends RecyclerView.Adapter<SpellListAdapter.MyViewHolder> {

    private List<Spell> spellList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView spellName;
        public TextView spellSchool;
        public TextView spellUses;
        public TextView spellDescription;

        public MyViewHolder(View view) {
            super(view);
            spellName = view.findViewById(R.id.spellName);
            spellSchool = view.findViewById(R.id.spellSchool);
            spellUses = view.findViewById(R.id.spellUses);
            spellDescription = view.findViewById(R.id.spellDescription);

        }
    }

    public SpellListAdapter(List<Spell> spellList) {

        this.spellList = spellList;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_spell_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        Spell spell = spellList.get(position);
        holder.spellName.setText("Name: " + spell.getName());
        holder.spellSchool.setText("School: " + spell.getSchool());
        holder.spellUses.setText("Uses: " + spell.getUses());
        holder.spellDescription.setText("Description: " + spell.getDescription());
    }

    public int getItemCount() {

        return spellList.size();
    }
}