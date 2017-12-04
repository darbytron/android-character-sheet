package com.tylerdarby.charactersheet.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.Skill;
import com.tylerdarby.charactersheet.models.SkillListAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by savio_000 on 11/8/2017.
 */

public class FeatsAndStrengths extends AppCompatActivity {

    List<Skill> skillList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_list_display);

        skillList = new ArrayList<>();
        skillList.add(new Skill("Wis", "Requiescat", "Deliver a magic attack. Does more damage with higher mana. Increases healing and attack magic potency by 20%", 68 ));
        skillList.add(new Skill( "Wis", "Holy Spirit", "Deal a high damage magic attack that increases your shield gauge", 64));
        skillList.add(new Skill("Wis", "Divine Magic Mastery", "Halves total mp cost of all spells", 64));

        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);

        // Build the recyclerview and its adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        SkillListAdapter skillListAdapter = new SkillListAdapter(skillList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(skillListAdapter);



    }
}
