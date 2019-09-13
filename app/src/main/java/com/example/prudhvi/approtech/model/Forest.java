package com.example.prudhvi.approtech.model;

import java.io.Serializable;

/**
 * Created by Prudhvi on 12-09-2019.
 */
public class Forest implements Serializable {

    String id;
    String description;
    String name;
    String weight;
    String url;

    String birthid;
    String lat;
    String lng;
    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public String getBirthid() {
        return birthid;
    }

    public void setBirthid(String birthid) {
        this.birthid = birthid;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}

