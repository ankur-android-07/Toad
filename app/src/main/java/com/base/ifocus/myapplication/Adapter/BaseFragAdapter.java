package com.base.ifocus.myapplication.Adapter;

/**
 * Created by iFocus on 08-09-2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.base.ifocus.myapplication.Fragment.BaseFragment;
import com.base.ifocus.myapplication.R;

public class BaseFragAdapter extends FragmentPagerAdapter {
    private int[] offerImages = {
            R.drawable.nf3,
            R.drawable.sf1,
            R.drawable.nf2,
            R.drawable.sf2,
            R.drawable.nf5,
            R.drawable.sf3,
            R.drawable.nf4,
            R.drawable.sf4
    };

    private int mCount = offerImages.length;

    public BaseFragAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new BaseFragment(offerImages[position]);
    }


    @Override
    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }

}
