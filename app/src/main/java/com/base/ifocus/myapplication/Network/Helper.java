package com.base.ifocus.myapplication.Network;

import android.content.Context;

import com.base.ifocus.myapplication.R;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by iFocus on 10-09-2015.
 */
public class Helper {

    private static ArrayList<String> parsedArray;

    public static String getCompleteUrl(String concatUrl, Context context) {
        return context.getString(R.string.base_url) + concatUrl;
    }

    public static ArrayList<String> parseArray(Object response) {

        try {
            JSONArray jData = new JSONArray(response.toString());
            parsedArray = new ArrayList<String>(jData.length());
            for (int i = 0; i < jData.length(); i++) {
                JSONObject response_data = new JSONObject(jData.getJSONObject(i).toString());
                parsedArray.add(response_data.get("category").toString());
            }
            //  JsonArray arrayData = data.
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parsedArray;
    }
}
