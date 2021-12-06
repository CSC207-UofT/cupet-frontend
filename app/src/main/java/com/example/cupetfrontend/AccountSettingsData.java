package com.example.cupetfrontend;

import org.json.JSONException;
import org.json.JSONObject;

public class AccountSettingsData {
    private String distance;

    public AccountSettingsData(String distance) {
        this.distance = distance;
    }

    ;

    public String getDistance() {
        return this.distance;
    }

    ;

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Distance", distance);
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    };

}



