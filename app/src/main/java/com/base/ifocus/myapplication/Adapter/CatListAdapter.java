package com.base.ifocus.myapplication.Adapter;

/**
 * Created by iFocus on 11-09-2015.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.base.ifocus.myapplication.R;

import java.util.ArrayList;


/**
 * Created by iFocus on 08-09-2015.
 */
public class CatListAdapter extends RecyclerView.Adapter<CatListAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    private int[] iDrawable;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CatListAdapter(ArrayList<String> myDataset, int[] iDrawable, Context context) {
        mDataset = myDataset;
        this.iDrawable = iDrawable;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CatListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView v = (TextView) holder.mTextView.findViewById(R.id.info_text);
        v.setText(mDataset.get(position));

        ImageView i = (ImageView) holder.mTextView.findViewById(R.id.item_icon);
        i.setImageResource(iDrawable[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}