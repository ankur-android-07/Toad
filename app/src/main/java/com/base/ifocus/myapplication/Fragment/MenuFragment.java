package com.base.ifocus.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.base.ifocus.myapplication.Adapter.BaseFragAdapter;
import com.base.ifocus.myapplication.Adapter.CategoryListAdapter;
import com.base.ifocus.myapplication.Adapter.TodaysSpecialAdapter;
import com.base.ifocus.myapplication.Network.Helper;
import com.base.ifocus.myapplication.Network.HttpConn;
import com.base.ifocus.myapplication.R;

/**
 * Created by iFocus on 10-09-2015.
 */
public class MenuFragment extends Fragment implements Response.Listener, Response.ErrorListener {
    private HttpConn menuConn;
    private Response.Listener responseString;
    private Response.ErrorListener errorListener;
    private ViewGroup view;
    private RecyclerView categoryList;
    private RecyclerView.Adapter mRecentAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        errorListener = this;
        responseString = this;
        menuConn = new HttpConn(Helper.getCompleteUrl(getString(R.string.allCategory), getActivity()), getActivity());
        menuConn.getAsyncJsonArrayData(getString(R.string.allcat), responseString, errorListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = (ViewGroup) inflater.inflate(R.layout.menu_frag, null);
        categoryList = (RecyclerView) view.findViewById(R.id.categoryList);
        return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("REsponse Error", error.toString());
    }

    @Override
    public void onResponse(Object response) {
        Log.e("Response ", response.toString());
        createAdapter(response);
    }

    private void createAdapter(Object response) {
        try {
            categoryList.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecentAdapter = new CategoryListAdapter(Helper.parseArray(response));
            categoryList.setAdapter(mRecentAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
