package com.resuls.android.dressMe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.resuls.android.dressMe.R;
import com.resuls.android.dressMe.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener
{
    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    private Button nextButton;

    private boolean twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.next_button);

        if (findViewById(R.id.tab_linear_layout) != null)
        {
            twoPane = true;

            nextButton.setVisibility(View.GONE);

            GridView gridView = findViewById(R.id.grid_view);
            gridView.setNumColumns(2);

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
        else twoPane = false;
    }

    @Override
    public void OnImageSelected(int position)
    {
        Toast.makeText(this, "Position clicked " + position, Toast.LENGTH_LONG).show();

        int index = position % 12;

        if (twoPane)
        {
            BodyPartFragment bodyPartFragment = new BodyPartFragment();

            switch (position / 12)
            {
                case 0:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    bodyPartFragment.setListIndex(index);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, bodyPartFragment)
                            .commit();
                    break;
                case 1:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
                    bodyPartFragment.setListIndex(index);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, bodyPartFragment)
                            .commit();
                    break;
                case 2:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getLegs());
                    bodyPartFragment.setListIndex(index);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, bodyPartFragment)
                            .commit();
                    break;
            }
        }
        else
        {
            switch (position / 12)
            {
                case 0:
                    headIndex = index;
                    break;
                case 1:
                    bodyIndex = index;
                    break;
                case 2:
                    legIndex = index;
                    break;
            }
        }

        Bundle bundle = new Bundle();
        bundle.putInt("headIndex", headIndex);
        bundle.putInt("bodyIndex", bodyIndex);
        bundle.putInt("legIndex", legIndex);

        final Intent intent = new Intent(this, DressMeActivity.class);
        intent.putExtras(bundle);

        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(intent);
            }
        });
    }
}
