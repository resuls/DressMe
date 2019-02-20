package com.resuls.android.dressMe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.resuls.android.dressMe.R;
import com.resuls.android.dressMe.data.AndroidImageAssets;

public class DressMeActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_me);

        if (savedInstanceState == null)
        {
            BodyPartFragment headPart = new BodyPartFragment();
            BodyPartFragment bodyPart = new BodyPartFragment();
            BodyPartFragment legPart = new BodyPartFragment();

            headPart.setImageIds(AndroidImageAssets.getHeads());
            bodyPart.setImageIds(AndroidImageAssets.getBodies());
            legPart.setImageIds(AndroidImageAssets.getLegs());

            int headIndex = getIntent().getIntExtra("headIndex", 0);
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            int legIndex = getIntent().getIntExtra("legIndex", 0);

            headPart.setListIndex(headIndex);
            bodyPart.setListIndex(bodyIndex);
            legPart.setListIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headPart)
                    .add(R.id.body_container, bodyPart)
                    .add(R.id.leg_container, legPart)
                    .commit();
        }
    }
}