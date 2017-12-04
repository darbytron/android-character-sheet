package com.tylerdarby.charactersheet.activities;

import android.app.Fragment;
import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Bulldog on 12/3/2017.
 */

public class DiceStats extends AppCompatActivity
{
    private TextView unmodD2row;
    private TextView unmodD4row;
    private TextView unmodD6row;
    private TextView unmodD8row;
    private TextView unmodD10row;
    private TextView unmodD12row;
    private TextView unmodD20row;
    private TextView unmodD100row;

    private TextView modD2row;
    private TextView modD4row;
    private TextView modD6row;
    private TextView modD8row;
    private TextView modD10row;
    private TextView modD12row;
    private TextView modD20row;
    private TextView modD100row;

    private int d2rolls;
    private int d4rolls;
    private int d6rolls;
    private int d8rolls;
    private int d10rolls;
    private int d12rolls;
    private int d20rolls;
    private int d100rolls;

    private double d2avg;
    private double d4avg;
    private double d6avg;
    private double d8avg;
    private double d10avg;
    private double d12avg;
    private double d20avg;
    private double d100avg;
    private double d2modavg;
    private double d4modavg;
    private double d6modavg;
    private double d8modavg;
    private double d10modavg;
    private double d12modavg;
    private double d20modavg;
    private double d100modavg;

    private int d2min;
    private int d4min;
    private int d6min;
    private int d8min;
    private int d10min;
    private int d12min;
    private int d20min;
    private int d100min;
    private int d2modmin;
    private int d4modmin;
    private int d6modmin;
    private int d8modmin;
    private int d10modmin;
    private int d12modmin;
    private int d20modmin;
    private int d100modmin;

    private int d2max;
    private int d4max;
    private int d6max;
    private int d8max;
    private int d10max;
    private int d12max;
    private int d20max;
    private int d100max;
    private int d2modmax;
    private int d4modmax;
    private int d6modmax;
    private int d8modmax;
    private int d10modmax;
    private int d12modmax;
    private int d20modmax;
    private int d100modmax;

    private int d2total;
    private int d4total;
    private int d6total;
    private int d8total;
    private int d10total;
    private int d12total;
    private int d20total;
    private int d100total;
    private int d2modtotal;
    private int d4modtotal;
    private int d6modtotal;
    private int d8modtotal;
    private int d10modtotal;
    private int d12modtotal;
    private int d20modtotal;
    private int d100modtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_stats);

        unmodD2row = (TextView)findViewById(R.id.unmodD2Row);
        unmodD4row = (TextView)findViewById(R.id.unmodD4Row);
        unmodD6row = (TextView)findViewById(R.id.unmodD6Row);
        unmodD8row = (TextView)findViewById(R.id.unmodD8Row);
        unmodD10row = (TextView)findViewById(R.id.unmodD10Row);
        unmodD12row = (TextView)findViewById(R.id.unmodD12Row);
        unmodD20row = (TextView)findViewById(R.id.unmodD20Row);
        unmodD100row = (TextView)findViewById(R.id.unmodD100Row);

        modD2row = (TextView)findViewById(R.id.modD2Row);
        modD4row = (TextView)findViewById(R.id.modD4Row);
        modD6row = (TextView)findViewById(R.id.modD6Row);
        modD8row = (TextView)findViewById(R.id.modD8Row);
        modD10row = (TextView)findViewById(R.id.modD10Row);
        modD12row = (TextView)findViewById(R.id.modD12Row);
        modD20row = (TextView)findViewById(R.id.modD20Row);
        modD100row = (TextView)findViewById(R.id.modD100Row);


        String d2unmodstats = d2avg + " " + d2max + " " + d2min + " " + d2total;
        String d4unmodstats = d4avg + " " + d4max + " " + d4min + " " + d4total;
        String d6unmodstats = d6avg + " " + d6max + " " + d6min + " " + d6total;
        String d8unmodstats = d8avg + " " + d8max + " " + d8min + " " + d8total;
        String d10unmodstats = d10avg + " " + d10max + " " + d10min + " " + d10total;
        String d12unmodstats = d12avg + " " + d12max + " " + d12min + " " + d12total;
        String d20unmodstats = d20avg + " " + d20max + " " + d20min + " " + d20total;
        String d100unmodstats = d100avg + " " + d100max + " " + d100min + " " + d100total;

        String d2modstats = d2modavg + " " + d2modmax + " " + d2modmin + " " + d2modtotal;
        String d4modstats = d4modavg + " " + d4modmax + " " + d4modmin + " " + d4modtotal;
        String d6modstats = d6modavg + " " + d6modmax + " " + d6modmin + " " + d6modtotal;
        String d8modstats = d8modavg + " " + d8modmax + " " + d8modmin + " " + d8modtotal;
        String d10modstats = d10modavg + " " + d10modmax + " " + d10modmin + " " + d10modtotal;
        String d12modstats = d12modavg + " " + d12modmax + " " + d12modmin + " " + d12modtotal;
        String d20modstats = d20modavg + " " + d20modmax + " " + d20modmin + " " + d20modtotal;
        String d100modstats = d100modavg + " " + d100modmax + " " + d100modmin + " " + d100modtotal;

        unmodD2row.setText(d2unmodstats);
        unmodD4row.setText(d4unmodstats);
        unmodD6row.setText(d6unmodstats);
        unmodD8row.setText(d8unmodstats);
        unmodD10row.setText(d10unmodstats);
        unmodD12row.setText(d12unmodstats);
        unmodD20row.setText(d20unmodstats);
        unmodD100row.setText(d100unmodstats);

        modD2row.setText(d2modstats);
        modD4row.setText(d4modstats);
        modD6row.setText(d6modstats);
        modD8row.setText(d8modstats);
        modD10row.setText(d10modstats);
        modD12row.setText(d12modstats);
        modD20row.setText(d20modstats);
        modD100row.setText(d100modstats);

    }

    public void updateStats(int roll, int sides, int mod)
    {
        int modRoll = roll+mod;

        if(sides==2)
        {
            d2rolls+=1;

            d2total+=roll;
            d2modtotal+=modRoll;

            d2avg = ((double)d2total)/d2rolls;
            d2modavg = ((double)d2modtotal)/d2rolls;

            if(roll < d2min)
            {
                d2min=roll;
            }
            if(roll > d2max)
            {
                d2max=roll;
            }

            if(modRoll < d2modmin)
            {
                d2modmin=modRoll;
            }
            if(modRoll > d2modmax)
            {
                d2modmax=modRoll;
            }

        }
        else if(sides==4)
        {
            d4rolls+=1;

            d4total+=roll;
            d4modtotal+=modRoll;

            d4avg = ((double)d4total)/d4rolls;
            d4modavg = ((double)d4modtotal)/d4rolls;

            if(roll < d4min)
            {
                d4min=roll;
            }
            if(roll > d4max)
            {
                d4max=roll;
            }

            if(modRoll < d4modmin)
            {
                d4modmin=modRoll;
            }
            if(modRoll > d4modmax)
            {
                d4modmax=modRoll;
            }
        }
        else if(sides==6)
        {
            d6rolls+=1;

            d6total+=roll;
            d6modtotal+=modRoll;

            d6avg = ((double)d6total)/d6rolls;
            d6modavg = ((double)d6modtotal)/d6rolls;

            if(roll < d6min)
            {
                d6min=roll;
            }
            if(roll > d6max)
            {
                d6max=roll;
            }

            if(modRoll < d6modmin)
            {
                d6modmin=modRoll;
            }
            if(modRoll > d6modmax)
            {
                d6modmax=modRoll;
            }
        }
        else if(sides==8)
        {
            d8rolls+=1;

            d8total+=roll;
            d8modtotal+=modRoll;

            d8avg = ((double)d8total)/d8rolls;
            d8modavg = ((double)d8modtotal)/d8rolls;

            if(roll < d8min)
            {
                d8min=roll;
            }
            if(roll > d8max)
            {
                d8max=roll;
            }

            if(modRoll < d8modmin)
            {
                d8modmin=modRoll;
            }
            if(modRoll > d8modmax)
            {
                d8modmax=modRoll;
            }
        }
        else if(sides==10)
        {
            d10rolls+=1;

            d10total+=roll;
            d10modtotal+=modRoll;

            d10avg = ((double)d10total)/d10rolls;
            d10modavg = ((double)d10modtotal)/d10rolls;

            if(roll < d10min)
            {
                d10min=roll;
            }
            if(roll > d10max)
            {
                d10max=roll;
            }

            if(modRoll < d10modmin)
            {
                d10modmin=modRoll;
            }
            if(modRoll > d10modmax)
            {
                d10modmax=modRoll;
            }
        }
        else if(sides==12)
        {
            d12rolls+=1;

            d12total+=roll;
            d12modtotal+=modRoll;

            d12avg = ((double)d12total)/d12rolls;
            d12modavg = ((double)d12modtotal)/d12rolls;

            if(roll < d12min)
            {
                d12min=roll;
            }
            if(roll > d12max)
            {
                d12max=roll;
            }

            if(modRoll < d12modmin)
            {
                d12modmin=modRoll;
            }
            if(modRoll > d12modmax)
            {
                d12modmax=modRoll;
            }
        }
        else if(sides==20)
        {
            d20rolls+=1;

            d20total+=roll;
            d20modtotal+=modRoll;

            d20avg = ((double)d20total)/d20rolls;
            d20modavg = ((double)d20modtotal)/d20rolls;

            if(roll < d20min)
            {
                d20min=roll;
            }
            if(roll > d20max)
            {
                d20max=roll;
            }

            if(modRoll < d20modmin)
            {
                d20modmin=modRoll;
            }
            if(modRoll > d20modmax)
            {
                d20modmax=modRoll;
            }
        }
        else if(sides==100)
        {
            d100rolls+=1;

            d100total+=roll;
            d100modtotal+=modRoll;

            d100avg = ((double)d100total)/d100rolls;
            d100modavg = ((double)d100modtotal)/d100rolls;

            if(roll < d100min)
            {
                d100min=roll;
            }
            if(roll > d100max)
            {
                d100max=roll;
            }

            if(modRoll < d100modmin)
            {
                d100modmin=modRoll;
            }
            if(modRoll > d100modmax)
            {
                d100modmax=modRoll;
            }
        }
    }



}
