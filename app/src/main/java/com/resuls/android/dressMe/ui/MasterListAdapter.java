package com.resuls.android.dressMe.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;


// Custom adapter class that displays a list of DressMe images in a GridView
public class MasterListAdapter extends BaseAdapter
{

    // Keeps track of the context and list of images to display
    private Context context;
    private List<Integer> imageIds;

    /**
     * Constructor method
     *
     * @param imageIds The list of images to display
     */
    public MasterListAdapter(Context context, List<Integer> imageIds)
    {
        this.context = context;
        this.imageIds = imageIds;
    }

    /**
     * Returns the number of items the adapter will display
     */
    @Override
    public int getCount()
    {
        return imageIds.size();
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    /**
     * Creates a new ImageView for each item referenced by the adapter
     */
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null)
        {
            // If the view is not recycled, this creates a new ImageView to hold an image
            imageView = new ImageView(context);
            // Define the layout parameters
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        // Set the image resource and return the newly created ImageView
        imageView.setImageResource(imageIds.get(position));
        return imageView;
    }

}
