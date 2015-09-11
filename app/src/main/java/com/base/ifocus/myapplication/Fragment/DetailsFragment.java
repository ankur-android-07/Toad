package com.base.ifocus.myapplication.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.base.ifocus.myapplication.Adapter.CatListAdapter;
import com.base.ifocus.myapplication.Adapter.CategoryListAdapter;
import com.base.ifocus.myapplication.ClickListener.RecyclerItemClickListener;
import com.base.ifocus.myapplication.Network.Helper;
import com.base.ifocus.myapplication.Network.HttpConn;
import com.base.ifocus.myapplication.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsFragment extends Fragment implements Response.Listener, Response.ErrorListener {

    private HttpConn menuConn;
    private Response.Listener responseString;
    private Response.ErrorListener errorListener;
    private ViewGroup view;
    private RecyclerView categoryList;
    private RecyclerView.Adapter mRecentAdapter;

    public DetailsFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        errorListener = this;
        responseString = this;
        menuConn = new HttpConn(Helper.getCompleteUrl(getString(R.string.listCategory), getActivity())+"?cid="+args.getString("menuName"), getActivity());
        menuConn.getAsyncJsonArrayData(getString(R.string.allcatlist), responseString, errorListener);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (ViewGroup) inflater.inflate(R.layout.fragment_details, container, false);
        categoryList = (RecyclerView) view.findViewById(R.id.categoryList);
        return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Response Error", error.toString());
    }

    @Override
    public void onResponse(Object response) {
        Log.e("Response ", response.toString());
        createAdapter(response);
    }

    private void createAdapter(Object response) {
        try {
            categoryList.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecentAdapter = new CatListAdapter(Helper.parseCatListArray(response), Helper.icons ,getActivity());
            categoryList.setAdapter(mRecentAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
