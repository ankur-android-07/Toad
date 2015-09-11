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
    public static ArrayList<String> parsedArrayID;

    public static String getCompleteUrl(String concatUrl, Context context) {
        return context.getString(R.string.base_url) + concatUrl;
    }
    public static int[] icons = {R.drawable.nf1, R.drawable.nf2, R.drawable.sf5, R.drawable.sf3, R.drawable.sf1, R.drawable.nf5, R.drawable.sf4};
    public static String[] data = {"Mini Meals", "Aloo Paratha", "Plain Dosa", "South Meals", "Masala Dosa", "Poha", "Set Dosa"};


    public static ArrayList<String> parseMenuArray(Object response) {

        try {
            JSONArray jData = new JSONArray(response.toString());
            parsedArray = new ArrayList<String>(jData.length());
            parsedArrayID = new ArrayList<String>(jData.length());
            for (int i = 0; i < jData.length(); i++) {
                JSONObject response_data = new JSONObject(jData.getJSONObject(i).toString());
                parsedArray.add(response_data.get("category").toString());
                parsedArrayID.add(response_data.get("category_id").toString());
            }
            //  JsonArray arrayData = data.
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parsedArray;
    }

    public static ArrayList<String> parseEventsArray(Object response) {

        try {
            JSONArray jData = new JSONArray(response.toString());
            parsedArray = new ArrayList<String>(jData.length());
            for (int i = 0; i < jData.length(); i++) {
                JSONObject response_data = new JSONObject(jData.getJSONObject(i).toString());
                parsedArray.add(response_data.get("event").toString());
            }
            //  JsonArray arrayData = data.
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parsedArray;
    }

    public static ArrayList<String> parseCatListArray(Object response) {

        try {
            JSONArray jData = new JSONArray(response.toString());
            parsedArray = new ArrayList<String>(jData.length());
            for (int i = 0; i < jData.length(); i++) {
                JSONObject response_data = new JSONObject(jData.getJSONObject(i).toString());
                parsedArray.add(response_data.get("item_name").toString());
            }
            //  JsonArray arrayData = data.
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parsedArray;
    }
}
