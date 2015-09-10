package com.base.ifocus.myapplication.Network;


import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.base.ifocus.myapplication.Application.ApplicationController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by iFocus on 10-09-2015.
 */
public class HttpConn {
    private String url = "";
    private HashMap<String, String> params;
    private Context context;

    public HttpConn(String url, Context context) {
        this.url = url;
        this.context = context;
    }

    public HttpConn(String url, Context context, HashMap<String, String> params) {
        this.url = url;
        this.context = context;
        this.params = params;
    }

    public void getAsyncJsonData(String tagRequest) {
        try {
            JsonObjectRequest req = new JsonObjectRequest(url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                VolleyLog.v("Response:%n %s", response.toString(4));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyErrorHelper.handleServerError(error, context);
                }
            });

// add the request object to the queue to be executed
            ApplicationController.getInstance().addToRequestQueue(req, tagRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void postAsyncJsonData(String tagRequest) {
        try {
            params.put("token", "AbCdEfGh123456");

            JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                VolleyLog.v("Response:%n %s", response.toString(4));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.e("Error: ", error.getMessage());
                    VolleyErrorHelper.handleServerError(error, context);
                }
            });

// add the request object to the queue to be executed
            ApplicationController.getInstance().addToRequestQueue(req, tagRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAsyncJsonArrayData(String tagRequest, final Response.Listener responseString, final Response.ErrorListener errorresponseString) {
        try {
            JsonArrayRequest req = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        VolleyLog.v("Response:%n %s", response.toString(4));
                        responseString.onResponse(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.e("Error: ", error.getMessage());
                    errorresponseString.onErrorResponse(error);
                    VolleyErrorHelper.handleServerError(error, context);
                }
            });

// add the request object to the queue to be executed

            ApplicationController.getInstance().addToRequestQueue(req, tagRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeStringRequest(String tagRequest) {
        try {
            StringRequest req = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    VolleyLog.v("Response:%n %s", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.e("Error: ", error.getMessage());
                    VolleyErrorHelper.handleServerError(error, context);
                }
            });

// add the request object to the queue to be executed
            ApplicationController.getInstance().addToRequestQueue(req, tagRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
