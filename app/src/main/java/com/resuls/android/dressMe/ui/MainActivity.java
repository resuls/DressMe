package com.resuls.android.dressMe.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.resuls.android.dressMe.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void OnImageSelected(int position)
    {
        Toast.makeText(this, "Position clicked " + position, Toast.LENGTH_LONG).show();
    }
}
