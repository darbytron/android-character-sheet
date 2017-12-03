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
public class SkillListAdapter extends RecyclerView.Adapter<SkillListAdapter.MyViewHolder> {

    private List<Skill> skillList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView skillModifier;
        public TextView skillName;
        public TextView skillDescription;
        public TextView skillPoints;

        public MyViewHolder(View view) {
            super(view);
            skillModifier = view.findViewById(R.id.skillModifier);
            skillName = view.findViewById(R.id.skillName);
            skillDescription = view.findViewById(R.id.skillDescription);
            skillPoints = view.findViewById(R.id.skillPoints);

        }
    }

    public SkillListAdapter(List<Skill> skillList) {

        this.skillList = skillList;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_skill_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        Skill skill = skillList.get(position);
        holder.skillModifier.setText("Modifier: " + skill.getModifierType());
        holder.skillName.setText("Name: " + skill.getName());
        holder.skillDescription.setText(skill.getDescription());
        holder.skillPoints.setText("Points: " + skill.getPoints());
    }

    public int getItemCount() {

        return skillList.size();
    }
}