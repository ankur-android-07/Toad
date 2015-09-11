package com.base.ifocus.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.base.ifocus.myapplication.R;

/**
 * Created by iFocus on 08-09-2015.
 */

public class BaseFragment extends Fragment {
    private static final String KEY_CONTENT = "TestFragment:Content";

    int imageSource;

    public BaseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        imageSource = args.getInt("image");
/*
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            imageSource = savedInstanceState.getInt(KEY_CONTENT);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.slider_layout, null);
        ImageView image = (ImageView)root.findViewById(R.id.slider_image);
        image.setImageResource(imageSource);
        setRetainInstance(true);
        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

