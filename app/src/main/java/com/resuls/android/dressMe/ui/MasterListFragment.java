package com.resuls.android.dressMe.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.resuls.android.dressMe.R;
import com.resuls.android.dressMe.data.AndroidImageAssets;

public class MasterListFragment extends Fragment
{
    OnImageClickListener callback;

    public MasterListFragment()
    {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = rootView.findViewById(R.id.grid_view);

        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                callback.OnImageSelected(position);
            }
        });

        return rootView;
    }

    public interface OnImageClickListener
    {
        void OnImageSelected(int position);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        try
        {
            callback = (OnImageClickListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "must implement OnImageClickListener");
        }
    }
}
