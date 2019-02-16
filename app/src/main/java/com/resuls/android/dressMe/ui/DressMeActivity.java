package com.resuls.android.dressMe.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.resuls.android.dressMe.R;
import com.resuls.android.dressMe.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class DressMeActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_me);

        BodyPartFragment headPart = new BodyPartFragment();
        BodyPartFragment bodyPart = new BodyPartFragment();
        BodyPartFragment legPart = new BodyPartFragment();

        headPart.setImageIds(AndroidImageAssets.getHeads());
        bodyPart.setImageIds(AndroidImageAssets.getBodies());
        legPart.setImageIds(AndroidImageAssets.getLegs());


        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.head_container, headPart)
                .add(R.id.body_container, bodyPart)
                .add(R.id.leg_container, legPart)
                .commit();
    }
}