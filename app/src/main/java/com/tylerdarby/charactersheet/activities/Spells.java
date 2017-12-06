package com.tylerdarby.charactersheet.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.Spell;
import com.tylerdarby.charactersheet.models.SpellListAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by savio_000 on 11/15/2017.
 */

public class Spells extends AppCompatActivity {
    List<Spell> spellList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_list_display);

        spellList = new ArrayList<>();
        spellList.add(new Spell("Magic Missile", "Evocation", "10", "FIres a missile of magic at target. Not fooled by reflections."));
        spellList.add(new Spell("Fire Ball", "Evocation", "10", "FIres a ball of fire at target. Can damage friendlies through splash damage."));
        spellList.add(new Spell("Summon Spirit", "Conjuration", "1", "Once per day summon a ghastly spirit that fights for you. Cannot be damaged by physical attacks."));

        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);

        // Build the recyclerview and its adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        SpellListAdapter spellListAdapter = new SpellListAdapter(spellList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(spellListAdapter);


    }
}