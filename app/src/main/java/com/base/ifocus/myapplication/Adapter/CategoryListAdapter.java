package com.base.ifocus.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.base.ifocus.myapplication.R;

import java.util.ArrayList;

/**
 * Created by iFocus on 10-09-2015.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    private String[] dataSet;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;

        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CategoryListAdapter(ArrayList<String> myDataset, Context context) {
        if (myDataset != null) {
            mDataset = myDataset;
        } else {
            dataSet = context.getResources().getStringArray(R.array.menuNames);
        }

    }

    // Create new views (invoked by the layout manager)
    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_card_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CategoryListAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        try {
            TextView v = (TextView) holder.mView.findViewById(R.id.info_text);
            if (mDataset != null) {
                v.setText(mDataset.get(position));
            } else {
                v.setText(dataSet[position]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}