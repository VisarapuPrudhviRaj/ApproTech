package com.example.prudhvi.approtech.presenter;

import android.content.Context;
import android.widget.TextView;

import com.example.prudhvi.approtech.ForestInterface;
import com.example.prudhvi.approtech.R;
import com.example.prudhvi.approtech.model.Forest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Prudhvi on 13-09-2019.
 */

public class ForestPresenter {
    Context context;
    List<Forest> list;
    private ForestInterface forestInterface;

    public ForestPresenter(Context context, List<Forest> list,ForestInterface forestInterface) {
        this.context = context;
        this.list = list;
        this.forestInterface = forestInterface;
    }

    public void setData(JSONObject jsonObject) {

        try {
            JSONArray wildArray = jsonObject.getJSONArray("wildAnimals");
            for (int i = 0; i < wildArray.length(); i++) {
                Forest forest = new Forest();

                JSONObject wildObj = wildArray.getJSONObject(i);
                forest.setId(wildObj.getString("id"));

                forest.setName(wildObj.getString("name"));
                forest.setDescription(wildObj.getString("description"));
                forest.setWeight(wildObj.getString("weight"));
                if (wildObj.has("birthId")) {
                    forest.setBirthid(wildObj.getString("birthId"));
                    JSONArray birthLocations = jsonObject.getJSONArray("birthLocations");

                    for (int j = 0; j < birthLocations.length(); j++) {

                        JSONObject birthLocationsObj = birthLocations.getJSONObject(j);
                        if (wildObj.getString("birthId").equals(birthLocationsObj.getString("id"))) {
                            forest.setBirthid(birthLocationsObj.getString("id"));
                            forest.setAddress(birthLocationsObj.getString("address"));

                            JSONObject locationObj = birthLocationsObj.getJSONObject("location");

                            forest.setLat(locationObj.getString("lat"));
                            forest.setLng(locationObj.getString("lng"));
                        }

                    }

                } else {
                    forest.setBirthid("");
                }
                forest.setUrl(wildObj.getString("url"));

                list.add(forest);
            }

            JSONArray nonwildArray = jsonObject.getJSONArray("nonWildAnimals");
            for (int i = 0; i < nonwildArray.length(); i++) {
                Forest forest = new Forest();

                JSONObject nonwildObj = nonwildArray.getJSONObject(i);
                forest.setId(nonwildObj.getString("id"));

                forest.setName(nonwildObj.getString("name"));
                forest.setDescription(nonwildObj.getString("description"));
                forest.setWeight(nonwildObj.getString("weight"));
                if (nonwildObj.has("birthId")) {
                    forest.setBirthid(nonwildObj.getString("birthId"));

                    JSONArray birthLocations = jsonObject.getJSONArray("birthLocations");

                    for (int j = 0; j < birthLocations.length(); j++) {

                        JSONObject birthLocationsObj = birthLocations.getJSONObject(j);
                        if (nonwildObj.getString("birthId").equals(birthLocationsObj.getString("id"))) {
                            forest.setBirthid(birthLocationsObj.getString("id"));
                            forest.setAddress(birthLocationsObj.getString("address"));

                            JSONObject locationObj = birthLocationsObj.getJSONObject("location");

                            forest.setLat(locationObj.getString("lat"));
                            forest.setLng(locationObj.getString("lng"));
                        }

                    }

                } else {
                    forest.setBirthid("");
                }
                forest.setUrl(nonwildObj.getString("url"));

                list.add(forest);
            }

            forestInterface.loadAdapter();



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
