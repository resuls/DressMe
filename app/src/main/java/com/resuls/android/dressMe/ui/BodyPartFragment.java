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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartFragment extends Fragment
{
    private int listIndex;
    private List<Integer> imageIds;

    private static final String TAG = "BodyPartFragment";

    private static final String IMAGE_ID_LIST = "image_ids";
    private static final String LIST_INDEX = "list_index";

    public BodyPartFragment()
    {
        listIndex = 0;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        if (savedInstanceState != null)
        {
            imageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            listIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = rootView.findViewById(R.id.bodyPart);

        if (imageIds != null)
        {
            imageView.setImageResource(imageIds.get(listIndex));

            imageView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (listIndex < imageIds.size() - 1)
                    {
                        listIndex++;
                    }
                    else listIndex = 0;

                    imageView.setImageResource(imageIds.get(listIndex));
                }
            });
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) imageIds);
        outState.putInt(LIST_INDEX, listIndex);
    }
}
