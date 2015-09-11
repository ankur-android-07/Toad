package com.base.ifocus.myapplication.Fragment;

/**
 * Created by iFocus on 10-09-2015.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.base.ifocus.myapplication.Adapter.BaseFragAdapter;
import com.base.ifocus.myapplication.Adapter.TodaysSpecialAdapter;
import com.base.ifocus.myapplication.Network.Helper;
import com.base.ifocus.myapplication.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceHolderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecentAdapter;
    private BaseFragAdapter mAdapter;
    private ViewPager mPager;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */


    public PlaceHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        mAdapter = new BaseFragAdapter(getActivity().getSupportFragmentManager());
        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        createAdapter(mRecyclerView);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void createAdapter(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecentAdapter = new TodaysSpecialAdapter(Helper.data, Helper.icons);
        recyclerView.setAdapter(mRecentAdapter);
    }

}

