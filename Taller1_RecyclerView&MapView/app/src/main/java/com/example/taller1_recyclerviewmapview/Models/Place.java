package com.example.taller1_recyclerviewmapview.Models;

import java.io.Serializable;

public class Place implements Serializable {

    private int id;
    private String name;
    private String description;
    private String image_url;
    private float map_lat;
    private float map_long;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public float getMap_lat() {
        return map_lat;
    }

    public void setMap_lat(float map_lat) {
        this.map_lat = map_lat;
    }

    public float getMap_long() {
        return map_long;
    }

    public void setMap_long(float map_long) {
        this.map_long = map_long;
    }

}
