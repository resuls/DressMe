package com.resuls.android.dressMe.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.resuls.android.dressMe.R;
import com.resuls.android.dressMe.data.AndroidImageAssets;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartFragment extends Fragment
{
    private int listIndex;
    private List<Integer> imageIds;

    private static final String TAG = "BodyPartFragment";

    public BodyPartFragment()
    {
        listIndex = 0;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        ImageView imageView = rootView.findViewById(R.id.bodyPart);

        if (imageIds != null)
        {
            imageView.setImageResource(imageIds.get(listIndex));
        }
        else
        {
            Log.d(TAG, "null list of image IDs");
        }


        // Inflate the layout for this fragment
        return rootView;
    }

    public void setListIndex(int listIndex)
    {
        this.listIndex = listIndex;
    }

    public void setImageIds(List<Integer> imageIds)
    {
        this.imageIds = imageIds;
    }
}
